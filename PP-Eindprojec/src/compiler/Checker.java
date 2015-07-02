package compiler;

import grammar.GrammarBaseListener;
import grammar.GrammarParser.AndExprContext;
import grammar.GrammarParser.ArithExprContext;
import grammar.GrammarParser.AssignExprContext;
import grammar.GrammarParser.CompExprContext;
import grammar.GrammarParser.DeclContext;
import grammar.GrammarParser.ForStatContext;
import grammar.GrammarParser.IdExprContext;
import grammar.GrammarParser.IdTargetContext;
import grammar.GrammarParser.IfStatContext;
import grammar.GrammarParser.NegExprContext;
import grammar.GrammarParser.NotExprContext;
import grammar.GrammarParser.OrExprContext;
import grammar.GrammarParser.ParExprContext;
import grammar.GrammarParser.PostEditContext;
import grammar.GrammarParser.PreEditContext;
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

public class Checker extends GrammarBaseListener {
	private Result result;
	private Scope scope;
	private List<String> errors;

	public Result check(ParseTree tree) throws ParseException {
		this.scope = new Scope();
		this.result = new Result();
		this.errors = new ArrayList<>();
		new ParseTreeWalker().walk(this, tree);
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
			result.setType(ctx, type);
			result.setOffset(ctx.ID(), scope.offset(id));

			if (ctx.expr() != null) {
				typeCheck(ctx.expr(), type);
			}
		}
	}

	public void typeCheck(RuleContext ctx, Type expected) {
		if (expected != result.getType(ctx)) {
			errors.add(ctx.getText() + " doesn't have type " + expected);
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
		typeCheck(ctx.expr(), Type.BOOL);
	}

	@Override
	public void exitForStat(ForStatContext ctx) {
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
		} else {
			result.setType(ctx, t);
		}
		result.setOffset(ctx.ID(), scope.offset(ctx.getText()));
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
	public void exitCompExpr(CompExprContext ctx) {
		if(ctx.EQ() == ctx.NE()) {//only when both are null
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
	public void exitType(TypeContext ctx) {
		Type t = null;
		if (ctx.BOOL() != null) {
			t = Type.BOOL;
		} else if (ctx.INT() != null) {
			t = Type.INT;
		}
		result.setType(ctx, t);
	}
}
