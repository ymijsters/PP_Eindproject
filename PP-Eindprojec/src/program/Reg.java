package program;

/**
 * Represents a register
 *
 */
public class Reg extends Operand {
	private Register reg;
	public Reg(Register r) {
		super(Type.Reg);
		reg = r;
	}

	public static enum Register {
		Zero,
		PC,
		SP,
		SPID,
		RegA,
		RegB,
		RegC,
		RegD,
		RegE
	}

	@Override
	public String toString() {
		return reg.toString();
	}
}
