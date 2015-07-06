package program;

/**
 * Represents a Int type in SPROCKELL
 *
 */
public class Int extends Operand {
	private int value;
	public Int(int v) {
		super(Type.Int);
		value = v;
	}
	public Int(String text) {
		this(Integer.parseInt(text));
	}
	@Override
	public String toString() {
		return "" + value;
	}
	
}
