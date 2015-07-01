package program;

import java.util.List;

public class Instr {
	private final Opcode op;
	private final List<Operand> args;
	public Instr(Opcode o, List<Operand> os) {
		op = o;
		args = os;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(op.toString());
		for(Operand arg : args) {
			sb.append(" " + arg.toString());
		}
		return sb.toString();
	}
}
