package program;
/**
 * Represents a jump/branch target
 *
 */
public class Target extends Operand {
	private int index;

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Target(int i) {
		super(Type.Target);
		index = i;
	}
	public String toString() {
		return "(Abs " + index + ")";
	}
}
