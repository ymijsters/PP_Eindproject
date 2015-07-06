package program;

import java.util.Arrays;
import java.util.List;
/**
 * Represents a single SPROCKELL instruction
 *
 */
public class Instr {
	private final Opcode op;
	private final List<Operand> args;

	public Instr(Opcode o, Operand... os) {
		op = o;
		args = Arrays.asList(os);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(op.toString());
		for (Operand arg : args) {
			sb.append(" " + arg.toString());
		}
		return sb.toString();
	}
}
