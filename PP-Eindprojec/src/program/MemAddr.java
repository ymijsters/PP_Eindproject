package program;

public class MemAddr extends Operand {
	private int address;
	public MemAddr(int a) {
		super(Type.MemAddr);
		address = a;
	}
	@Override
	public String toString() {
		return "(Addr " + address + ")";
	}
}
