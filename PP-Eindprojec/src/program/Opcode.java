package program;
/**
 * Represents a instruction type
 *
 */
public enum Opcode {
	Const,
	Compute,
	Load,
	Store,
	Branch,
	Jump,
	Push,
	Pop,
	Nop,
	EndProg,
	Read,
	Receive,
	Write,
	TestAndSet
}
