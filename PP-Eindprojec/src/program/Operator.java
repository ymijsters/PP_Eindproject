package program;

public class Operator extends Operand {
	private Op op;

	public Operator(Op o) {
		super(Type.Operator);
		op = o;
	}

	public static enum Op {
		Add, Sub, Mul, Div, Mod, Equal, NEq, Gt, GtE, Lt, LtE, And, Or, Xor, LShift, RShift
	}

	@Override
	public String toString() {
		return op.toString();
	}
}
