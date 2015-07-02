package compiler;

import static program.Opcode.Compute;
import static program.Opcode.Const;
import static program.Opcode.EndProg;
import static program.Opcode.Load;
import static program.Opcode.Pop;
import static program.Opcode.Push;
import static program.Opcode.Store;
import static program.Opcode.Write;
import static program.Operator.Op.Add;
import static program.Operator.Op.Div;
import static program.Operator.Op.Mul;
import static program.Operator.Op.Sub;
import grammar.GrammarBaseVisitor;
import grammar.GrammarParser.AndExprContext;
import grammar.GrammarParser.ArithExprContext;
import grammar.GrammarParser.AssignExprContext;
import grammar.GrammarParser.CompExprContext;
import grammar.GrammarParser.DeclContext;
import grammar.GrammarParser.ExprStatContext;
import grammar.GrammarParser.ForStatContext;
import grammar.GrammarParser.IdExprContext;
import grammar.GrammarParser.IfStatContext;
import grammar.GrammarParser.NegExprContext;
import grammar.GrammarParser.NotExprContext;
import grammar.GrammarParser.OrExprContext;
import grammar.GrammarParser.PostEditContext;
import grammar.GrammarParser.PreEditContext;
import grammar.GrammarParser.PrintStatContext;
import grammar.GrammarParser.ProgramContext;
import grammar.GrammarParser.TernaryExprContext;
import grammar.GrammarParser.VarExprContext;
import grammar.GrammarParser.WhileStatContext;

import org.antlr.v4.runtime.tree.ParseTree;

import program.Instr;
import program.Int;
import program.MemAddr;
import program.Opcode;
import program.Operand;
import program.Operator;
import program.Operator.Op;
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
	public MemAddr visitAndExpr(AndExprContext ctx) {
		visit(ctx.expr(0));
		visit(ctx.expr(1));
		prog.removeLast();
		append(Pop, regB);
		append(Compute, new Operator(Op.And), regA, regB, regA);
		append(Push, regA);
		return null;
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
			append(Const, new Int(0x1), regA);
			append(Push, regA);
		} else {
			append(Const, new Int(0), regA);
			append(Push, regA);
		}
		return null;
	}

	@Override
	public MemAddr visitNegExpr(NegExprContext ctx) {
		visit(ctx.expr());
		prog.removeLast();
		append(Compute, new Operator(Sub), zero, regA, regA);
		append(Push, regA);
		return null;
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
	public MemAddr visitTernaryExpr(TernaryExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTernaryExpr(ctx);
	}

	@Override
	public MemAddr visitPreEdit(PreEditContext ctx) {
		MemAddr mem = getMem(ctx.target());
		append(Load, mem, regA);
		append(Const, new Int(1), regB);
		Op o = ctx.DECR() == null ? Add : Sub;
		append(Compute, new Operator(o), regA,regB,regA);
		append(Store, regA, mem);
		append(Push, regA);
		return null;
	}

	@Override
	public MemAddr visitPostEdit(PostEditContext ctx) {
		MemAddr mem = getMem(ctx.target());
		append(Load, mem, regA);
		append(Const, new Int(1), regB);
		Op o = ctx.DECR() == null ? Add : Sub;
		append(Compute, new Operator(o), regA,regB,regB);
		append(Store, regB, mem);
		append(Push, regA);
		return null;
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
		visit(ctx.expr(0));
		visit(ctx.expr(1));
		prog.removeLast();
		append(Pop, regB);
		append(Compute, new Operator(Op.Equal), regA, regB, regA);
		append(Push, regA);
		return null;
	}

	@Override
	public MemAddr visitOrExpr(OrExprContext ctx) {
		visit(ctx.expr(0));
		visit(ctx.expr(1));
		prog.removeLast();
		append(Pop, regB);
		append(Compute, new Operator(Op.Or), regA, regB, regA);
		append(Push, regA);
		return null;
	}

	@Override
	public MemAddr visitNotExpr(NotExprContext ctx) {
		visit(ctx.expr());
		prog.removeLast();
		append(Compute, new Operator(Op.Equal), regA, zero, regA);
		append(Push, regA);
		return null;
	}
	private Instr append(Opcode o, Operand... os) {
		Instr i  = new Instr(o, os);
		prog.addInstr(i);
		return i;
	}
}
