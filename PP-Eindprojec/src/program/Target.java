package program;

public class Target extends Operand {
	private int index;

	public Target(int i) {
		super(Type.Target);
		index = i;
	}
	public String toString() {
		return "(Abs " + index + ")";
	}
}
