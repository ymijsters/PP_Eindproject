package program;

public abstract class Operand {
	public static enum Type {
		Int, Reg, Operator, MemAddr, Target
	}

	private Type type;
	public abstract String toString();
	public Operand(Type t) {
		type = t;
	}
}
