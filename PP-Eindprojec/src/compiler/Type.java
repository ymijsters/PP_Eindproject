package compiler;

abstract public class Type {
	public static final Type BOOL = new Bool();
	public static final Type INT = new Int();
	private final TypeKind kind;

	public Type(TypeKind kind) {
		this.kind = kind;
	}

	public TypeKind getKind() {
		return this.kind;
	}

	/** returns the size (in bytes) of a value of this type. */
	abstract public int size();

	static public class Bool extends Type {
		private Bool() {
			super(TypeKind.BOOL);
		}

		@Override
		public int size() {
			return 1;
		}

		@Override
		public String toString() {
			return "Boolean";
		}
	}

	static public class Int extends Type {
		private Int() {
			super(TypeKind.INT);
		}

		@Override
		public int size() {
			return 1;
		}

		@Override
		public String toString() {
			return "Integer";
		}
	}

	static public class Array extends Type {
		private final int length;
		private final Type elemType;

		public Array(int l, Type elemType) {
			super(TypeKind.ARRAY);
			length = l;
			this.elemType = elemType;
		}

		public int getLength() {
			return this.length;
		}

		public Type getElemType() {
			return this.elemType;
		}

		@Override
		public int size() {
			return elemType.size() * length;
		}

		@Override
		public String toString() {
			return "Array [" + length + "] of "
					+ this.elemType;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + this.elemType.hashCode();
			result = prime * result + this.length;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Array)) {
				return false;
			}
			Array other = (Array) obj;
			if (!this.elemType.equals(other.elemType)) {
				return false;
			}
			if (this.length != other.length) {
				return false;
			}
			return true;
		}

	}
	static public class Pointer extends Type {
		private final Type type;
		public Type getType() {
			return type;
		}
		public Pointer(Type t) {
			super(TypeKind.POINTER);
			type = t;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Pointer)) {
				return false;
			}
			Pointer other = (Pointer) obj;
			if (!this.type.equals(other.type)) {
				return false;
			}
			return true;
		}
		@Override
		public int size() {
			return 1;
		}
		public String toString() {
			return "Pointer[" + type.toString() + "]";
		}
	}
}
