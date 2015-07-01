// Generated from Grammar.g4 by ANTLR 4.5
package grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decl}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDecl(GrammarParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decl}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDecl(GrammarParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(GrammarParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(GrammarParser.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(GrammarParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(GrammarParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(GrammarParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(GrammarParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterForStat(GrammarParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitForStat(GrammarParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(GrammarParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(GrammarParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(GrammarParser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(GrammarParser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBreakStat(GrammarParser.BreakStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBreakStat(GrammarParser.BreakStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code contStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterContStat(GrammarParser.ContStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code contStat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitContStat(GrammarParser.ContStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link GrammarParser#target}.
	 * @param ctx the parse tree
	 */
	void enterIdTarget(GrammarParser.IdTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link GrammarParser#target}.
	 * @param ctx the parse tree
	 */
	void exitIdTarget(GrammarParser.IdTargetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayTarget}
	 * labeled alternative in {@link GrammarParser#target}.
	 * @param ctx the parse tree
	 */
	void enterArrayTarget(GrammarParser.ArrayTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayTarget}
	 * labeled alternative in {@link GrammarParser#target}.
	 * @param ctx the parse tree
	 */
	void exitArrayTarget(GrammarParser.ArrayTargetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(GrammarParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(GrammarParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(GrammarParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(GrammarParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(GrammarParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(GrammarParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArithExpr(GrammarParser.ArithExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArithExpr(GrammarParser.ArithExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(GrammarParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(GrammarParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(GrammarParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(GrammarParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(GrammarParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(GrammarParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GrammarParser.TypeContext ctx);
}