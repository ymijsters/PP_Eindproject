package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
