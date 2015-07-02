package program;

public class Int extends Operand {
	private int value;
	public Int(int v) {
		super(Type.Int);
		value = v;
	}
	@Override
	public String toString() {
		return "" + value;
	}
	
}
