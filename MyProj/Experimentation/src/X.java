
enum Y {
	E1,
	E2;
}

class Z {
	void foo() {
		System.out.println(Y.values().length);
	}
}

public class X {
	public static void main(String[] args) {
		Z z = new Z();
		z.foo();
	}
}