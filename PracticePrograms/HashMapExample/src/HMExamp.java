import java.util.HashMap;
import java.util.ListIterator;


class HMExamp {
	public static void main(String[] args) {
		X x = new X();
		x.foo3();
	}
}

class E extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	E() {
		System.out.println("E");
	}
	
}

class E1 extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	E1() {
		System.out.println("E1");
	}
}

class Y {
	void foo() {}
}

class X {
	void foo () throws E {
		throw new E();
	}
	
	void bar() {
		try {
			foo();
		} catch (E e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void foo3() {
		foo2();
	}
	
	void foo2 ()  {
		throw new E1();
	}
}