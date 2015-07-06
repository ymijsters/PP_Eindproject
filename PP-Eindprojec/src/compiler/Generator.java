package compiler;

import static program.Opcode.Branch;
import static program.Opcode.Compute;
import static program.Opcode.Const;
import static program.Opcode.EndProg;
import static program.Opcode.Jump;
import static program.Opcode.Load;
import static program.Opcode.Pop;
import static program.Opcode.Push;
import static program.Opcode.Store;
import static program.Opcode.Write;
import static program.Operator.Op.Add;
import static program.Operator.Op.Div;
import static program.Operator.Op.Mul;
import static program.Operator.Op.Mod;
import static program.Operator.Op.Sub;

import java.util.Stack;

import grammar.GrammarBaseVisitor;
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
import grammar.GrammarParser.ExprStatContext;
import grammar.GrammarParser.ForStatContext;
import grammar.GrammarParser.IdExprContext;
import grammar.GrammarParser.IfStatContext;
import grammar.GrammarParser.NegExprContext;
import grammar.GrammarParser.NotExprContext;
import grammar.GrammarParser.OrExprContext;
import grammar.GrammarParser.PointerAssignExprContext;
import grammar.GrammarParser.PointerDeclContext;
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
import program.Target;
import compiler.Type.Array;

/** Class to generate SPROCKELL code. */
public class Generator extends GrammarBaseVisitor<MemAddr> {

	/** The outcome of the checker phase. */
	private Result result;
	/** The program being built. */
	private Program prog;
	private Stack<Target> contTarget = new Stack<Target>();
	private Stack<Target> breakTarget = new Stack<Target>();
	private final Reg zero = new Reg(Register.Zero);
	private final Reg regA = new Reg(Register.RegA);
	private final Reg regB = new Reg(Register.RegB);
	private final Reg regC = new Reg(Register.RegC);
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
		if (ctx.expr() == null) {
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
		if(ctx.stat(1) == null) {
			visit(ctx.expr());
			prog.removeLast();
			Target endTarget = new Target(-1);
			Target ifTarget = new Target(-1);
			append(Branch, regA, ifTarget);
			append(Jump, endTarget);
			ifTarget.setIndex(prog.size());
			visit(ctx.stat(0));
			endTarget.setIndex(prog.size());
			return null;
		} else {
			visit(ctx.expr());
			prog.removeLast();
			Target endTarget = new Target(-1);
			Target ifTarget = new Target(-1);
			Target elseTarget = new Target(-1);
			append(Branch, regA, ifTarget);
			append(Jump, elseTarget);
			ifTarget.setIndex(prog.size());
			visit(ctx.stat(0));
			append(Jump, endTarget);
			elseTarget.setIndex(prog.size());
			visit(ctx.stat(1));
			endTarget.setIndex(prog.size());
			return null;
		}
	}

	@Override
	public MemAddr visitWhileStat(WhileStatContext ctx) {
		contTarget.push(new Target(prog.size()));
		breakTarget.push(new Target(-1));
		Target stat = new Target(-1);
		visit(ctx.expr());
		prog.removeLast();
		append(Branch, regA, stat);
		append(Jump, breakTarget.peek());
		stat.setIndex(prog.size());
		visit(ctx.stat());
		append(Jump, contTarget.peek());
		breakTarget.peek().setIndex(prog.size());
		breakTarget.pop();
		contTarget.pop();
		return null;
	}

	@Override
	public MemAddr visitForStat(ForStatContext ctx) {
		MemAddr mem = getMem(ctx.ID(0));
		visit(ctx.expr(0));
		prog.removeLast();
		append(Store, regA, mem);
		Target cond = new Target(prog.size());
		breakTarget.push(new Target(-1));
		Target statTarget = new Target(-1);
		contTarget.push(new Target(-1));
		visit(ctx.expr(1));
		prog.removeLast();
		append(Branch, regA, statTarget);
		append(Jump, breakTarget.peek());
		statTarget.setIndex(prog.size());
		visit(ctx.stat());
		contTarget.peek().setIndex(prog.size());
		mem = getMem(ctx.ID(1));
		visit(ctx.expr(2));
		prog.removeLast();
		append(Store, regA, mem);
		append(Jump, cond);
		breakTarget.peek().setIndex(prog.size());
		breakTarget.pop();
		contTarget.pop();
		return null;
	}

	@Override
	public MemAddr visitPrintStat(PrintStatContext ctx) {
		visit(ctx.expr());
		prog.removeLast();
		append(Const, new Int(48), regB);
		append(Compute, new Operator(Add), regA, regB, regA);
		append(Write, regA, ioAddr);
		append(Const, new Int('\n'), regA);
		append(Write, regA, ioAddr);
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
		if (result.getType(ctx).getKind() == TypeKind.ARRAY) {
			append(Const, new Int(result.getOffset(ctx)), regA);
			append(Push, regA);
		} else {
			append(Load, mem, regA);
			append(Push, regA);
		}
		return null;
	}

	private MemAddr getMem(ParseTree tree) {
		return new MemAddr(result.getOffset(tree));
	}

	private MemAddr getArrayMem(ParseTree tree, int i) {
		return new MemAddr(result.getOffset(tree) + i);
	}

	@Override
	public MemAddr visitVarExpr(VarExprContext ctx) {
		if (ctx.NUM() != null) {
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
		visit(ctx.expr(0));
		prog.removeLast();
		Target elseTarget = new Target(-1);
		append(Branch, regA, elseTarget);
		visit(ctx.expr(2));
		prog.removeLast();
		Target endTarget = new Target(-1);
		append(Jump, endTarget);
		elseTarget.setIndex(prog.size());
		visit(ctx.expr(1));
		endTarget.setIndex(prog.size() - 1);// the push command in ctx.expr(2)
		return null;
	}

	@Override
	public MemAddr visitPreEdit(PreEditContext ctx) {
		MemAddr mem = getMem(ctx.target());
		append(Load, mem, regA);
		append(Const, new Int(1), regB);
		Op o = ctx.DECR() == null ? Add : Sub;
		append(Compute, new Operator(o), regA, regB, regA);
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
		append(Compute, new Operator(o), regA, regB, regB);
		append(Store, regB, mem);
		append(Push, regA);
		return null;
	}

	@Override
	public MemAddr visitArrayDecl(ArrayDeclContext ctx) {
		int length = ((Array) result.getType(ctx.ID())).getLength();
		if (ctx.expr().size() == 0) {
			for (int i = 0; i < length; i++) {
				append(Store, zero, getArrayMem(ctx.ID(), i));
			}
		} else {
			for (int i = 0; i < length; i++) {
				visit(ctx.expr(i));
				prog.removeLast();
				append(Store, regA, getArrayMem(ctx.ID(), i));
			}
		}
		return null;
	}

	@Override
	public MemAddr visitArrayElemAssignStat(ArrayElemAssignStatContext ctx) {
		visit(ctx.expr(0));
		visit(ctx.expr(1));
		prog.removeLast();
		append(Pop, regC);
		append(Const, new Int(result.getOffset(ctx.target())), regB);
		append(Compute, new Operator(Add), regC, regB, regC);
		append(Store, regA, new MemAddr(regC));
		return null;
	}

	@Override
	public MemAddr visitArrayLength(ArrayLengthContext ctx) {
		append(Const,
				new Int(((Array) result.getType(ctx.target())).getLength()),
				regA);
		append(Push, regA);
		return null;
	}

	@Override
	public MemAddr visitArrayElemExpr(ArrayElemExprContext ctx) {
		visit(ctx.expr());
		prog.removeLast();
		append(Const, new Int(result.getOffset(ctx.target())), regB);
		append(Compute, new Operator(Add), regA, regB, regA);
		append(Load, new MemAddr(regA), regA);
		append(Push, regA);
		return null;
	}

	@Override
	public MemAddr visitPointerDecl(PointerDeclContext ctx) {
		MemAddr mem = getMem(ctx.ID());
		if (ctx.expr() == null) {
			append(Store, zero, mem);
		} else {
			visit(ctx.expr());
			prog.removeLast();
			append(Store, regA, mem);
		}
		return null;
	}

	@Override
	public MemAddr visitDereferenceExpr(DereferenceExprContext ctx) {
		append(Load, getMem(ctx.target()), regA);
		append(Load, new MemAddr(regA), regA);
		append(Push, regA);
		return null;
	}

	@Override
	public MemAddr visitAddressExpr(AddressExprContext ctx) {
		append(Const, new Int(result.getOffset(ctx.target())), regA);
		append(Push, regA);
		return null;
	}

	@Override
	public MemAddr visitPointerAssignExpr(PointerAssignExprContext ctx) {
		visit(ctx.expr());
		prog.removeLast();
		append(Load, getMem(ctx.target()), regB);
		append(Store, regA, new MemAddr(regB));
		append(Push, regA);
		return null;
	}

	@Override
	public MemAddr visitArithExpr(ArithExprContext ctx) {
		visit(ctx.expr(0));
		visit(ctx.expr(1));
		prog.removeLast();
		append(Pop, regB);
		if (ctx.PLUS() != null) {
			append(Compute, new Operator(Add), regB, regA, regA);
		} else if (ctx.MINUS() != null) {
			append(Compute, new Operator(Sub), regB, regA, regA);
		} else if (ctx.TIMES() != null) {
			append(Compute, new Operator(Mul), regB, regA, regA);
		} else if (ctx.DIVIDE() != null) {
			append(Compute, new Operator(Div), regB, regA, regA);
		} else if (ctx.MOD() != null) {
			append(Compute, new Operator(Mod), regB, regA, regA);
		}
		append(Push, regA);
		return null;
	}

	@Override
	public MemAddr visitBreakStat(BreakStatContext ctx) {
		append(Jump, breakTarget.peek());
		return null;
	}

	@Override
	public MemAddr visitContStat(ContStatContext ctx) {
		append(Jump, contTarget.peek());
		return null;
	}

	@Override
	public MemAddr visitCompExpr(CompExprContext ctx) {
		visit(ctx.expr(0));
		visit(ctx.expr(1));
		prog.removeLast();
		append(Pop, regB);
		Op op = null;
		if (ctx.EQ() != null) {
			op = Op.Equal;
		} else if (ctx.NE() != null) {
			op = Op.NEq;
		} else if (ctx.GT() != null) {
			op = Op.Gt;
		} else if (ctx.GE() != null) {
			op = Op.GtE;
		} else if (ctx.LT() != null) {
			op = Op.Lt;
		} else if (ctx.LE() != null) {
			op = Op.LtE;
		}
		append(Compute, new Operator(op), regB, regA, regA);
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
		Instr i = new Instr(o, os);
		prog.addInstr(i);
		return i;
	}
}
