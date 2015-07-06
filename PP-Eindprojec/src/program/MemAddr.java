package program;

public class MemAddr extends Operand {
	private int address;
	private Reg reg;
	public MemAddr(int a) {
		super(Type.MemAddr);
		address = a;
	}
	public MemAddr(Reg r) {
		super(Type.MemAddr);
		reg = r;
	}
	@Override
	public String toString() {
		return reg == null ? "(Addr " + address + ")"
						   : "(Deref " + reg.toString() + ")";
	}
}
