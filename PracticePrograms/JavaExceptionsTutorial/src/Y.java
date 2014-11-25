
class E1 extends RuntimeException {
	E1() {
		System.out.println("E1");
	}
}

class E2 extends Exception {
	E2() {
		System.out.println("E2");
	}
}

class Z {
	void foo() {
		try {
			throw new  E1();
		} catch (RuntimeException e) {
			throw new E1();
		} finally {
			throw new E1();
			
		}
	}
	
	void foo2() {
		try {
			int i = 10 / 0;
			System.out.println(i);
		} catch (ArithmeticException e) {
			int i = 10/ 0;
			System.out.println(i);
			System.out.println("Caught arithmetic exception");
		} finally {
			int i = 10/ 0;
			System.out.println(i);
			System.out.println("Finally block");
		}
	}
	
	void foo3() throws E2 {
		throw new E2();
	}
}

public class Y {
	public static void main(String[] args) {
		Z z = new Z();
		try {
			z.foo3();
		} catch (E2 e) {
			e.printStackTrace();
		}
	}
}