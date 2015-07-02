package compiler;

import grammar.GrammarBaseListener;
import grammar.GrammarParser.AndExprContext;
import grammar.GrammarParser.ArithExprContext;
import grammar.GrammarParser.AssignStatContext;
import grammar.GrammarParser.BlockStatContext;
import grammar.GrammarParser.BreakStatContext;
import grammar.GrammarParser.CompExprContext;
import grammar.GrammarParser.ContStatContext;
import grammar.GrammarParser.DeclContext;
import grammar.GrammarParser.ForStatContext;
import grammar.GrammarParser.IdExprContext;
import grammar.GrammarParser.IdTargetContext;
import grammar.GrammarParser.IfStatContext;
import grammar.GrammarParser.NotExprContext;
import grammar.GrammarParser.OrExprContext;
import grammar.GrammarParser.PostAddContext;
import grammar.GrammarParser.PreAddContext;
import grammar.GrammarParser.PrintStatContext;
import grammar.GrammarParser.ProgramContext;
import grammar.GrammarParser.TypeContext;
import grammar.GrammarParser.VarExprContext;
import grammar.GrammarParser.WhileStatContext;
import grammar.ParseException;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Checker extends GrammarBaseListener {
	private Result result;
	private Scope scope;
	private List<String> errors;
	private ParseTreeProperty<Type> types;

	public Result check(ParseTree tree) throws ParseException {
		this.scope = new Scope();
		this.result = new Result();
		this.errors = new ArrayList<>();
		this.types = new ParseTreeProperty<Type>();
		new ParseTreeWalker().walk(this, tree);
		if (hasErrors()) {
			throw new ParseException(getErrors());
		}
		return this.result;
	}

	/** Indicates if any errors were encountered in this tree listener. */
	public boolean hasErrors() {
		return !getErrors().isEmpty();
	}

	@Override
	public void exitPreAdd(PreAddContext ctx) {
		// TODO Auto-generated method stub
		super.exitPreAdd(ctx);
	}

	@Override
	public void exitPostAdd(PostAddContext ctx) {
		// TODO Auto-generated method stub
		super.exitPostAdd(ctx);
	}

	/** Returns the list of errors collected in this tree listener. */
	public List<String> getErrors() {
		return this.errors;
	}

	@Override
	public void exitProgram(ProgramContext ctx) {
		// TODO Auto-generated method stub
		super.exitProgram(ctx);
	}

	
	@Override
	public void exitDecl(DeclContext ctx) {
		String id = ctx.ID().getText();
		if (scope.contains(id)) {
			errors.add(ctx.toString() + " : " + id + " already declared");
		} else {
			Type type = getType(ctx.type());
			types.put(ctx, type);
			scope.put(id, type);
			result.setType(ctx, type);
			result.setOffset(ctx, scope.offset(id));
			
			if (ctx.expr() != null) {
				if(type != result.getType(ctx.expr())) {
					errors.add(ctx.expr().getText() + " doesn't have type " + type);
				}
			}
		}
	}

	private Type getType(TypeContext tc) {
		switch (tc.getText()) {
		case "int":
			return Type.INT;
		case "boolean":
			return Type.BOOL;
		}
		return null;
	}

	@Override
	public void exitAssignStat(AssignStatContext ctx) {
		// TODO Auto-generated method stub
		super.exitAssignStat(ctx);
	}

	@Override
	public void exitIfStat(IfStatContext ctx) {
		// TODO Auto-generated method stub
		super.exitIfStat(ctx);
	}

	@Override
	public void exitWhileStat(WhileStatContext ctx) {
		// TODO Auto-generated method stub
		super.exitWhileStat(ctx);
	}

	@Override
	public void exitForStat(ForStatContext ctx) {
		// TODO Auto-generated method stub
		super.exitForStat(ctx);
	}

	@Override
	public void exitBlockStat(BlockStatContext ctx) {
		// TODO Auto-generated method stub
		super.exitBlockStat(ctx);
	}

	@Override
	public void exitPrintStat(PrintStatContext ctx) {
		// TODO Auto-generated method stub
		super.exitPrintStat(ctx);
	}

	@Override
	public void exitBreakStat(BreakStatContext ctx) {
		// TODO Auto-generated method stub
		super.exitBreakStat(ctx);
	}

	@Override
	public void exitContStat(ContStatContext ctx) {
		// TODO Auto-generated method stub
		super.exitContStat(ctx);
	}

	@Override
	public void exitIdTarget(IdTargetContext ctx) {
		// TODO Auto-generated method stub
		super.exitIdTarget(ctx);
	}

	@Override
	public void exitAndExpr(AndExprContext ctx) {
		// TODO Auto-generated method stub
		super.exitAndExpr(ctx);
	}

	@Override
	public void exitIdExpr(IdExprContext ctx) {
		// TODO Auto-generated method stub
		super.exitIdExpr(ctx);
	}

	@Override
	public void exitVarExpr(VarExprContext ctx) {
		// TODO Auto-generated method stub
		super.exitVarExpr(ctx);
	}

	@Override
	public void exitArithExpr(ArithExprContext ctx) {
		// TODO Auto-generated method stub
		super.exitArithExpr(ctx);
	}

	@Override
	public void exitCompExpr(CompExprContext ctx) {
		// TODO Auto-generated method stub
		super.exitCompExpr(ctx);
	}

	@Override
	public void exitOrExpr(OrExprContext ctx) {
		// TODO Auto-generated method stub
		super.exitOrExpr(ctx);
	}

	@Override
	public void exitNotExpr(NotExprContext ctx) {
		// TODO Auto-generated method stub
		super.exitNotExpr(ctx);
	}

	@Override
	public void exitType(TypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitType(ctx);
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		super.exitEveryRule(ctx);
	}

}
