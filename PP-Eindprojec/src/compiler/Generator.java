package compiler;

import static program.Opcode.*;
import static program.Operator.Op.*;
import grammar.GrammarBaseVisitor;
import grammar.GrammarParser.AndExprContext;
import grammar.GrammarParser.ArithExprContext;
import grammar.GrammarParser.AssignExprContext;
import grammar.GrammarParser.BlockStatContext;
import grammar.GrammarParser.CompExprContext;
import grammar.GrammarParser.DeclContext;
import grammar.GrammarParser.ExprStatContext;
import grammar.GrammarParser.ForStatContext;
import grammar.GrammarParser.IdExprContext;
import grammar.GrammarParser.IdTargetContext;
import grammar.GrammarParser.IfStatContext;
import grammar.GrammarParser.NegExprContext;
import grammar.GrammarParser.NotExprContext;
import grammar.GrammarParser.OrExprContext;
import grammar.GrammarParser.ParExprContext;
import grammar.GrammarParser.PostAddContext;
import grammar.GrammarParser.PreAddContext;
import grammar.GrammarParser.PrintStatContext;
import grammar.GrammarParser.ProgramContext;
import grammar.GrammarParser.TypeContext;
import grammar.GrammarParser.VarExprContext;
import grammar.GrammarParser.WhileStatContext;

import org.antlr.v4.runtime.tree.ParseTree;

import com.sun.org.glassfish.external.probe.provider.PluginPoint;

import program.Instr;
import program.Int;
import program.MemAddr;
import program.Opcode;
import program.Operand;
import program.Operator;
import program.Program;
import program.Reg;
import program.Reg.Register;


/** Class to generate ILOC code for Simple Pascal. */
public class Generator extends GrammarBaseVisitor<MemAddr> {
	/** The outcome of the checker phase. */
	private Result result;
	/** The program being built. */
	private Program prog;
	private final Reg zero = new Reg(Register.Zero);
	private final Reg regA = new Reg(Register.RegA);
	private final Reg regB = new Reg(Register.RegB);
	private final Reg regC = new Reg(Register.RegC);
	private final Reg regD = new Reg(Register.RegD);
	private final Reg regE = new Reg(Register.RegE);
	private final int IO = 0x1000000;
	private final Operand ioAddr = new MemAddr(IO);

	public Program generate(ParseTree tree, Result checkResult) {
		this.prog = new Program();
		result = checkResult;
		tree.accept(this);
		return this.prog;
	}

	@Override
	public MemAddr visitProgram(ProgramContext ctx) {
		visitChildren(ctx);
		append(EndProg);
		return null;
	}

	@Override
	public MemAddr visitDecl(DeclContext ctx) {
		MemAddr mem = getMem(ctx.ID());
		if(ctx.expr() == null) {
			append(Store, zero, mem);
		} else {
			visit(ctx.expr());
			prog.removeLast();
			append(Store, regA, mem);
		}
		return null;
	}

	@Override
	public MemAddr visitIfStat(IfStatContext ctx) {
		System.err.println(ctx.getText());//TODO Auto-generated method stub
		return super.visitIfStat(ctx);
	}

	@Override
	public MemAddr visitWhileStat(WhileStatContext ctx) {
		System.err.println(ctx.getText());//TODO Auto-generated method stub
		return super.visitWhileStat(ctx);
	}

	@Override
	public MemAddr visitForStat(ForStatContext ctx) {
		System.err.println(ctx.getText());//TODO Auto-generated method stub
		return super.visitForStat(ctx);
	}

	@Override
	public MemAddr visitBlockStat(BlockStatContext ctx) {
		System.err.println(ctx.getText());//TODO Auto-generated method stub
		return super.visitBlockStat(ctx);
	}

	@Override
	public MemAddr visitPrintStat(PrintStatContext ctx) {
		visit(ctx.expr());
		prog.removeLast();
		append(Const, new Int(48), regB);
		append(Compute, new Operator(Add), regA, regB, regA);
		append(Write, regA, new MemAddr(IO));
		append(Const, new Int('\n'), regA);
		append(Write, regA, new MemAddr(IO));
		return null;
	}

	@Override
	public MemAddr visitExprStat(ExprStatContext ctx) {
		visit(ctx.expr());
		prog.removeLast();
		return null;
	}

	@Override
	public MemAddr visitIdTarget(IdTargetContext ctx) {
		System.err.println(ctx.getText());//TODO Auto-generated method stub
		return super.visitIdTarget(ctx);
	}

	@Override
	public MemAddr visitParExpr(ParExprContext ctx) {
		System.err.println(ctx.getText());//TODO Auto-generated method stub
		return super.visitParExpr(ctx);
	}

	@Override
	public MemAddr visitAndExpr(AndExprContext ctx) {
		System.err.println(ctx.getText());//TODO Auto-generated method stub
		return super.visitAndExpr(ctx);
	}

	@Override
	public MemAddr visitIdExpr(IdExprContext ctx) {
		MemAddr mem = getMem(ctx.ID());
		append(Load, mem, regA);
		append(Push, regA);
		return null;
	}
	private MemAddr getMem(ParseTree tree) {
		return new MemAddr(result.getOffset(tree));
	}
	@Override
	public MemAddr visitVarExpr(VarExprContext ctx) {
		if(ctx.NUM() != null) {
			append(Const, new Int(ctx.getText()), regA);
			append(Push, regA);
		} else if (ctx.TRUE() != null) {
			append(Const, new Int(1), regA);
			append(Push, regA);
		} else {
			append(Const, new Int(0), regA);
			append(Push, regA);
		}
		return null;
	}

	@Override
	public MemAddr visitNegExpr(NegExprContext ctx) {
		System.err.println(ctx.getText());//TODO Auto-generated method stub
		return super.visitNegExpr(ctx);
	}

	@Override
	public MemAddr visitAssignExpr(AssignExprContext ctx) {
		MemAddr mem = getMem(ctx.target());
		visit(ctx.expr());
		prog.removeLast();
		append(Store, regA, mem);
		append(Push, regA);
		return null;
	}

	@Override
	public MemAddr visitPreAdd(PreAddContext ctx) {
		System.err.println(ctx.getText());//TODO Auto-generated method stub
		return super.visitPreAdd(ctx);
	}

	@Override
	public MemAddr visitPostAdd(PostAddContext ctx) {
		System.err.println(ctx.getText());//TODO Auto-generated method stub
		return super.visitPostAdd(ctx);
	}

	@Override
	public MemAddr visitArithExpr(ArithExprContext ctx) {
		visit(ctx.expr(0));
		visit(ctx.expr(1));
		prog.removeLast();
		append(Pop, regB);
		if(ctx.PLUS() != null) {
			append(Compute, new Operator(Add), regA, regB, regA);
		} else if(ctx.MINUS() != null) {
			append(Compute, new Operator(Sub), regA, regB, regA);
		} else if(ctx.TIMES() != null) {
			append(Compute, new Operator(Mul), regA, regB, regA);
		} else if(ctx.DIVIDE() != null) {
			append(Compute, new Operator(Div), regA, regB, regA);
		}
		append(Push,regA);
		return null;
	}

	@Override
	public MemAddr visitCompExpr(CompExprContext ctx) {
		System.err.println(ctx.getText());//TODO Auto-generated method stub
		return super.visitCompExpr(ctx);
	}

	@Override
	public MemAddr visitOrExpr(OrExprContext ctx) {
		System.err.println(ctx.getText());//TODO Auto-generated method stub
		return super.visitOrExpr(ctx);
	}

	@Override
	public MemAddr visitNotExpr(NotExprContext ctx) {
		System.err.println(ctx.getText());//TODO Auto-generated method stub
		return super.visitNotExpr(ctx);
	}

	@Override
	public MemAddr visitType(TypeContext ctx) {
		System.err.println(ctx.getText());//TODO Auto-generated method stub
		return super.visitType(ctx);
	}
	private Instr append(Opcode o, Operand... os) {
		Instr i  = new Instr(o, os);
		prog.addInstr(i);
		return i;
	}
}
