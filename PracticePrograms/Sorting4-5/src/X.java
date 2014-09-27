import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class X {
	Integer[] a;
	int n;
	final static int nos = 10;
	final static Random rand = new Random();
	private int getN() {
		int x;
		do {
			x = rand.nextInt(nos);
		} while (x == 0 || x == 1);
		return x;
	}
	private void print() {
		for (int i = 0; i < n; i++) {
			System.out.print(a[i]);
			System.out.print(' ');
		}
		System.out.println("");
	}
	X() {
		n = getN();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++) {
			arr.add(i, getN());
		}
		Collections.sort(arr);
		a = arr.toArray(new Integer[n]);
		print();
	}
	void mode() {
		int max = 1, max2 = 1, x = a[0], mode = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] == x) {
				max += 1;
			}	
			else {
				if (max > max2) {
					max2 = max;
					mode = x;
				}
				x = a[i];
				max = 1;
			}
		}
		if (max > max2) {
			mode = x;
			max2 = max;
		}
		System.out.println("Mode = " + mode + " Count = " + max2);
	}
	
	public static void main(String[] args) {
		X x  = new X();
		x.mode();
	}
}