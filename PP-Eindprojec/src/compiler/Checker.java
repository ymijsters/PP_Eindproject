package compiler;

import grammar.GrammarBaseListener;
import grammar.GrammarParser.AddressExprContext;
import grammar.GrammarParser.AndExprContext;
import grammar.GrammarParser.ArithExprContext;
import grammar.GrammarParser.ArrayDeclContext;
import grammar.GrammarParser.ArrayElemAssignStatContext;
import grammar.GrammarParser.ArrayElemExprContext;
import grammar.GrammarParser.ArrayLengthContext;
import grammar.GrammarParser.AssignExprContext;
import grammar.GrammarParser.BreakStatContext;
import grammar.GrammarParser.CompExprContext;
import grammar.GrammarParser.ContStatContext;
import grammar.GrammarParser.DeclContext;
import grammar.GrammarParser.DereferenceExprContext;
import grammar.GrammarParser.ExprContext;
import grammar.GrammarParser.ForStatContext;
import grammar.GrammarParser.IdExprContext;
import grammar.GrammarParser.IdTargetContext;
import grammar.GrammarParser.IfStatContext;
import grammar.GrammarParser.NegExprContext;
import grammar.GrammarParser.NotExprContext;
import grammar.GrammarParser.OrExprContext;
import grammar.GrammarParser.ParExprContext;
import grammar.GrammarParser.PointerAssignExprContext;
import grammar.GrammarParser.PointerDeclContext;
import grammar.GrammarParser.PostEditContext;
import grammar.GrammarParser.PreEditContext;
import grammar.GrammarParser.PrintStatContext;
import grammar.GrammarParser.TernaryExprContext;
import grammar.GrammarParser.TypeContext;
import grammar.GrammarParser.VarExprContext;
import grammar.GrammarParser.WhileStatContext;
import grammar.ParseException;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import compiler.Type.Array;
import compiler.Type.Pointer;

/**
 * Checks for contextual errors and determines variable offsets.
 */
public class Checker extends GrammarBaseListener {

	private Result result;
	private Scope scope;
	private List<String> errors;

	private boolean inLoop = false;

	public Result check(ParseTree tree) throws ParseException {
		this.scope = new Scope();
		this.result = new Result();
		this.errors = new ArrayList<>();
		try {
			new ParseTreeWalker().walk(this, tree);
		} catch (Exception e) {
			errors.add(e.toString());
		}
		if (hasErrors()) {
			throw new ParseException(getErrors());
		}
		return this.result;
	}

	@Override
	public void exitNegExpr(NegExprContext ctx) {
		typeCheck(ctx.expr(), Type.INT);
		result.setType(ctx, Type.INT);
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		errors.add(node.getText());
	}

	@Override
	public void exitTernaryExpr(TernaryExprContext ctx) {
		typeCheck(ctx.expr(0), Type.BOOL);
		typeCheck(ctx.expr(1), ctx.expr(2));
		result.setType(ctx, result.getType(ctx.expr(1)));

	}

	/** Indicates if any errors were encountered in this tree listener. */
	public boolean hasErrors() {
		return !getErrors().isEmpty();
	}

	@Override
	public void exitPreEdit(PreEditContext ctx) {
		typeCheck(ctx.target(), Type.INT);
		result.setType(ctx, Type.INT);

	}

	@Override
	public void exitPostEdit(PostEditContext ctx) {
		typeCheck(ctx.target(), Type.INT);
		result.setType(ctx, Type.INT);
	}

	/** Returns the list of errors collected in this tree listener. */
	public List<String> getErrors() {
		return this.errors;
	}

	@Override
	public void exitDecl(DeclContext ctx) {
		String id = ctx.ID().getText();
		if (scope.contains(id)) {
			errors.add(ctx.toString() + " : " + id + " already declared");
		} else {
			Type type = result.getType(ctx.type());
			scope.put(id, type);
			result.setType(ctx.ID(), type);
			result.setOffset(ctx.ID(), scope.offset(id));

			if (ctx.expr() != null) {
				typeCheck(ctx.expr(), type);
			}
		}
	}

	@Override
	public void exitPointerDecl(PointerDeclContext ctx) {
		String id = ctx.ID().getText();
		if (scope.contains(id)) {
			errors.add(ctx.toString() + " : " + id + " already declared");
		} else {
			Type pointedType = result.getType(ctx.type());
			Type type = new Pointer(pointedType);
			scope.put(id, type);
			result.setType(ctx.ID(), type);
			result.setOffset(ctx.ID(), scope.offset(id));

			if (ctx.expr() != null) {
				typeCheck(ctx.expr(), type);
			}
		}
	}

	@Override
	public void exitDereferenceExpr(DereferenceExprContext ctx) {
		typeKindCheck(ctx.target(), TypeKind.POINTER);
		Pointer type = (Pointer) result.getType(ctx.target());
		result.setType(ctx, type.getType());
	}

	@Override
	public void exitAddressExpr(AddressExprContext ctx) {
		result.setType(ctx, new Pointer(result.getType(ctx.target())));
	}

	@Override
	public void exitPointerAssignExpr(PointerAssignExprContext ctx) {
		typeKindCheck(ctx.target(), TypeKind.POINTER);
		Type pointedType = getPointedType(result.getType(ctx.target()));
		typeCheck(ctx.expr(), pointedType);
	}

	public Type getPointedType(Type t) {
		if (t instanceof Array) {
			return ((Array) t).getElemType();
		}
		if (t instanceof Pointer) {
			return ((Pointer) t).getType();
		}
		return null;
	}

	public void typeCheck(RuleContext ctx, Type expected) {
		Type type = result.getType(ctx);
		// identifier of an array can be cast to an pointer pointing to the
		// first element in the array
		// pointers can also be treated as integers and vice versa
		if (type instanceof Array) {
			Array aType = (Array) type;
			if (expected.getKind() == TypeKind.POINTER
					&& aType.getElemType().equals(
							((Pointer) expected).getType())) {
				return;
			}
		}
		if (((expected.getKind() == TypeKind.POINTER || expected.getKind() == TypeKind.ARRAY) && type == Type.INT)
				|| ((type.getKind() == TypeKind.POINTER || type.getKind() == TypeKind.ARRAY) && expected == Type.INT)) {
			return;
		}
		if (!expected.equals(type)) {
			errors.add(ctx.getText() + " doesn't have type " + expected);
		}
	}

	public void typeKindCheck(RuleContext ctx, TypeKind expected) {
		TypeKind typeKind = result.getType(ctx).getKind();
		// identifier of an array can be cast to an pointer pointing to the
		// first element in the array
		// pointers can also be treated as integers and vice versa
		if (expected != typeKind
				&& !(expected == TypeKind.POINTER && (typeKind == TypeKind.ARRAY || typeKind == TypeKind.INT))) {
			errors.add(ctx.getText() + " doesn't have typekind " + expected);
		}
	}

	public void typeCheck(RuleContext ctx, RuleContext expected) {
		typeCheck(ctx, result.getType(expected));
	}

	@Override
	public void exitAssignExpr(AssignExprContext ctx) {
		Type type = result.getType(ctx.target());
		typeCheck(ctx.expr(), type);
		result.setType(ctx, type);
	}

	@Override
	public void exitIfStat(IfStatContext ctx) {
		typeCheck(ctx.expr(), Type.BOOL);
	}

	@Override
	public void exitWhileStat(WhileStatContext ctx) {
		inLoop = false;
		typeCheck(ctx.expr(), Type.BOOL);
	}

	@Override
	public void exitForStat(ForStatContext ctx) {
		inLoop = false;
		Type t1 = scope.type(ctx.ID(0).getText());
		typeCheck(ctx.expr(0), t1);
		typeCheck(ctx.expr(1), Type.BOOL);
		Type t2 = scope.type(ctx.ID(1).getText());
		typeCheck(ctx.expr(2), t2);
		result.setOffset(ctx.ID(0), scope.offset(ctx.ID(0).getText()));
		result.setOffset(ctx.ID(1), scope.offset(ctx.ID(1).getText()));
	}

	@Override
	public void exitParExpr(ParExprContext ctx) {
		result.setType(ctx, result.getType(ctx.expr()));
	}

	@Override
	public void exitIdTarget(IdTargetContext ctx) {
		Type t = scope.type(ctx.getText());
		if (t == null) {
			errors.add(ctx.getText() + " not defined");
		} else {
			result.setType(ctx, t);
		}
		result.setOffset(ctx, scope.offset(ctx.getText()));
		result.setOffset(ctx.ID(), scope.offset(ctx.getText()));
	}

	@Override
	public void exitAndExpr(AndExprContext ctx) {
		typeCheck(ctx.expr(0), Type.BOOL);
		typeCheck(ctx.expr(1), Type.BOOL);
		result.setType(ctx, Type.BOOL);
	}

	@Override
	public void exitIdExpr(IdExprContext ctx) {
		Type t = scope.type(ctx.getText());
		if (t == null) {
			errors.add(ctx.getText() + " not defined");
			return;
		} else {
			result.setType(ctx, t);
		}
		result.setOffset(ctx.ID(), scope.offset(ctx.getText()));
		result.setOffset(ctx, scope.offset(ctx.getText()));
	}

	@Override
	public void exitVarExpr(VarExprContext ctx) {
		result.setType(ctx, ctx.NUM() == null ? Type.BOOL : Type.INT);
	}

	@Override
	public void exitArithExpr(ArithExprContext ctx) {
		typeCheck(ctx.expr(0), Type.INT);
		typeCheck(ctx.expr(1), Type.INT);
		result.setType(ctx, Type.INT);
	}

	@Override
	public void enterWhileStat(WhileStatContext ctx) {
		inLoop = true;
	}

	@Override
	public void enterForStat(ForStatContext ctx) {
		inLoop = true;
	}

	@Override
	public void exitBreakStat(BreakStatContext ctx) {
		if (!inLoop) {
			errors.add("cannot break: not in loop");
		}
	}

	@Override
	public void exitContStat(ContStatContext ctx) {
		if (!inLoop) {
			errors.add("cannot break: not in loop");
		}
	}

	@Override
	public void exitCompExpr(CompExprContext ctx) {
		if (ctx.EQ() == ctx.NE()) {// only when both are null
			typeCheck(ctx.expr(0), Type.INT);
			typeCheck(ctx.expr(1), Type.INT);
		} else {
			typeCheck(ctx.expr(0), ctx.expr(1));
		}
		result.setType(ctx, Type.BOOL);
	}

	@Override
	public void exitOrExpr(OrExprContext ctx) {
		typeCheck(ctx.expr(0), Type.BOOL);
		typeCheck(ctx.expr(1), Type.BOOL);
		result.setType(ctx, Type.BOOL);
	}

	@Override
	public void exitNotExpr(NotExprContext ctx) {
		typeCheck(ctx.expr(), Type.BOOL);
		result.setType(ctx, Type.BOOL);
	}

	@Override
	public void exitArrayDecl(ArrayDeclContext ctx) {
		String id = ctx.ID().getText();
		if (scope.contains(id)) {
			errors.add(ctx.toString() + " : " + id + " already declared");
		} else {
			Type elemType = result.getType(ctx.type());
			int num = Integer.parseInt(ctx.NUM().getText());
			Type type = new Array(num, elemType);
			scope.put(id, type);
			result.setType(ctx.ID(), type);
			result.setOffset(ctx.ID(), scope.offset(id));

			for (ExprContext expr : ctx.expr()) {
				typeCheck(expr, elemType);
			}
		}
	}

	@Override
	public void exitArrayElemAssignStat(ArrayElemAssignStatContext ctx) {
		typeKindCheck(ctx.target(), TypeKind.ARRAY);
		Array type = (Array) result.getType(ctx.target());
		typeCheck(ctx.expr(1), type.getElemType());
		typeCheck(ctx.expr(0), Type.INT);
	}

	@Override
	public void exitArrayElemExpr(ArrayElemExprContext ctx) {
		typeCheck(ctx.expr(), Type.INT);
		typeKindCheck(ctx.target(), TypeKind.ARRAY);
		Array type = (Array) result.getType(ctx.target());
		result.setType(ctx, type.getElemType());
	}

	@Override
	public void exitPrintStat(PrintStatContext ctx) {
		if (result.getType(ctx.expr()).getKind().equals(TypeKind.ARRAY)) {
			errors.add("Cannot print arrays(sorry)");
		}
	}

	@Override
	public void exitType(TypeContext ctx) {
		Type t = null;
		if (ctx.BOOL() != null) {
			t = Type.BOOL;
		} else if (ctx.INT() != null) {
			t = Type.INT;
		}
		result.setType(ctx, t);
	}

	@Override
	public void exitArrayLength(ArrayLengthContext ctx) {
		typeKindCheck(ctx.target(), TypeKind.ARRAY);
		result.setType(ctx, Type.INT);
	}
}
