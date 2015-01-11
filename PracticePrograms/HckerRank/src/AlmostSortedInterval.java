import java.util.Random;


// https://www.hackerrank.com/challenges/almost-sorted-interval

class Y {
	final static int MAX = 20;
	final static Random rand = new Random();
	int[] a = new int[MAX];

	void print() {
		System.out.print("{");
		for (int i = 0, l = a.length; i < l; i++) {
			System.out.print(a[i]);
			if (i != l-1)
				System.out.print(", ");
		}
		System.out.print("}");
		System.out.println();
	}

	void init() {
		a = new int[] {3, 1, 2, 5, 4};
	}
	void foo() {
		for (int i = 0, l = a.length; i < l; i++)
			a[i] = rand.nextInt(MAX);
		init();
		print();
		if (a.length == 0) {
			System.out.print(0);
			return;
		} else if (a.length == 1) {
			System.out.print(1);
			return;
		}
		int c = a.length;
		
		System.out.print(c);
	}

}

class AlmostSortedInterval {
	public static void main(String[] args) {
		Y y = new Y();
		y.foo();
	}
}