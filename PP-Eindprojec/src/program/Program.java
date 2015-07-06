package program;

import java.util.Arrays;
import java.util.LinkedList;
/**
 * Represents a SPROCKELL program.
 *
 */
public class Program {
	private final LinkedList<Instr> instructions;

	public int size() {
		return instructions.size();
	}

	public Program() {
		instructions = new LinkedList<Instr>();
	}

	public void addInstr(Instr i) {
		instructions.add(i);
	}
	/**
	 * Can be used for optimalisations
	 */
	public void removeLast() {
		instructions.pollLast();
	}

	public String toString() {
		return "import Sprockell.System\n"
				+ "prog :: [Instruction]\n"
				+ "prog = "
				+ Arrays.toString(instructions.toArray()).replaceAll(", ",
						", \n\t") + "\n" + "main = run 1 prog";
	}
}
