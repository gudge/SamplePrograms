import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


class X {
	Integer[] a;
	int n;
	final static int nos = 10;
	final static Random rand = new Random();
	private int getN() {
		int i;
		do {
			i = rand.nextInt(nos);
		} while (i == 0 || i == 1);
		return i;
	}
	private void print() {
		for (int i = 0; i < n; i++) {
			System.out.print(a[i]);
			System.out.print(' ');
		}
		System.out.println("\n");
	}
	X() {
		n = getN();
		n = 2 * n;
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++) {
			arr.add(getN());
		}
		Collections.sort(arr);
		a = arr.toArray(new Integer[n]);
		// x1, y1   x2, y2    x3, y3 ...
		// x1+y1, x2+y2, x3+y3, ...
		// z1, z2 = max(x1+y1, x2+y2, x3+y3, ...)
		// z3 = min(z1, z2)
		// pairs with min(z3)
		print();
		// pairs
		int max = 0;
		for (int i = 0; i < n; i++) {
			System.out.print('(');
			System.out.print(a[i]);
			System.out.print(",");
			System.out.print(a[n - i - 1]);
			System.out.print(")  ");
		}
		for (int i = 0; i < n; i++) {
			if (a[i] + a[n - i - 1] > max)
				max = a[i] + a[n - i - 1];
		}
		System.out.println("");
		System.out.print(max);
		System.out.println("\n");
	}
	public static void main(String[] args) {
		X x = new X();
		
	}
}