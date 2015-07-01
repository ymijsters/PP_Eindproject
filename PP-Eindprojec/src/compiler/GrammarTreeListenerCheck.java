package compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import grammar.ErrorListener;
import grammar.GrammarBaseListener;
import grammar.GrammarLexer;
import grammar.GrammarParser;
import grammar.ParseException;
import grammar.GrammarParser.*;

public class GrammarTreeListenerCheck extends GrammarBaseListener {
	private ParseTreeProperty<Type> types = new ParseTreeProperty<>();
	private ArrayList<String> errors = new ArrayList<>();
	private Map<String, Type> vars = new HashMap<>();
	public void exitProgram(ProgramContext ctx){
		setType(ctx.stat(0),Type.INT);
	}
	public void exitDeclStat(DeclContext ctx){
		System.out.println("Entered");
		if(ctx.getChildCount()>3){
			checkType(ctx.expr(),getType(ctx.type().getText()));
			vars.put(ctx.ID().getText(), getType(ctx.type().getText()));
		}else{
			vars.put(ctx.ID().getText(), getType(ctx.type().getText()));
		}
	}
	@Override
	public void exitArithExpr(ArithExprContext ctx) {
		// Check what the middle child is and do that arithmetic to the first
		// and third expr.
//		checkType(ctx.expr(0), Type.INT);
//		checkType(ctx.expr(1), Type.INT);
		setType(ctx, Type.INT);
	}
	@Override
	public void exitAndExpr(AndExprContext ctx) {
		// if expr1 and expr 2 then add true as result else false
		checkType(ctx.expr(0),Type.BOOL);
		checkType(ctx.expr(1),Type.BOOL);
		setType(ctx,Type.BOOL);
	}
	@Override
	public void exitOrExpr(OrExprContext ctx) {
		// if expr1 or/and expr 2 then add true as result else false
		checkType(ctx.expr(0),Type.BOOL);
		checkType(ctx.expr(1),Type.BOOL);
		setType(ctx, Type.BOOL);
	}
	@Override
	public void exitCompExpr(CompExprContext ctx) {
		// add compare between 2 expr(ints) and result the boolean
		checkType(ctx.expr(0),Type.INT);
		checkType(ctx.expr(1),Type.INT);
		setType(ctx, Type.BOOL);
	}
	@Override
	public void exitVarExpr(VarExprContext ctx) {
		System.out.println("hallo?");
		if(ctx.getText()!="true"||ctx.getText()!="false"){
			setType(ctx, Type.INT);
		}else{
			setType(ctx,Type.BOOL);
		}
	}
	@Override
	public void exitIdExpr(IdExprContext ctx) {
		// result the value
		System.out.println(ctx.ID().getText());
		setType(ctx,vars.get(ctx.ID().getText()));
	}
	@Override
	public void exitNotExpr(NotExprContext ctx) {
		// if expr true result = false else result is true.
		checkType(ctx.expr(),Type.BOOL);
		setType(ctx, Type.BOOL);
	}
	
	public void setType(ParseTree ctx, Type type) {
		//System.out.println(ctx.getText() + " " + type.name());
		types.put(ctx, type);
	}

	public void checkType(ParseTree ctx, Type expected) {
		if (!types.get(ctx).equals(expected)) {
			errors.add("Type error at " + ctx.getText() + "Expected: "
					+ expected.name() + "Actual: " + types.get(ctx).name());
		}
	}
	public Type getType(String type){
		if(type.equals("int")){
			return Type.INT;
		}else if(type.equals("boolean")){
			return Type.BOOL;
		}else{
			errors.add("Illegal Type Added: " + type);
			return null;
		}
	}

	public ParseTree parse(CharStream chars) throws ParseException {
		ErrorListener listener = new ErrorListener();
		GrammarLexer lexer = new GrammarLexer(chars);
		lexer.removeErrorListeners();
		lexer.addErrorListener(listener);
		TokenStream tokens = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(listener);
		ParseTree result = parser.program();
		return result;
	}
	public ParseTreeProperty<Type> check(ParseTree tree){
		this.errors = new ArrayList<>();
		this.types = new ParseTreeProperty<Type>();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(this, tree);
		for(String s : errors) {
			System.out.println(s);
		}
		return this.types;
	}
}
