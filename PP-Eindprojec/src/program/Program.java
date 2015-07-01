package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {
	private final List<Instr> instructions;
	public Program() {
		instructions = new ArrayList<Instr>();
	}
	public void addInstr(Instr i) {
		instructions.add(i);
	}
	public String toString() {
		return "import Sprockell.System\n"
				+ "prog :: [Instruction]\n"
				+ "prog = " + Arrays.toString(instructions.toArray())
				+ "main = run 1 prog";
	}
}
