import java.util.Collections;
import java.util.Random;



class X {
	int[] a;
	int n;
	static final int  nos = 10;
	static final Random rand = new Random();
	int f;
	int cnt;

	int getN() {
		int i = 0;
		do {
			i = rand.nextInt(nos);
		} while (i == 0 || i == 1);
		return i;
	}
	X() {
		n = 2* getN();
		a = new int[n];
		for (int i = 0; i < n / 2; i++) {
			a[i] = getN();
		}
		f = 0;
		while (true) {
			f = getN();
			int i = 0;
			for (i = 0; i < n / 2 && f != a[i]; i++);
			if (i != n/2)
				break;
		};
		for (int i = n/2 ; i < n; i++)
			a[i] = f;
		for (int i = 0; i < n/2; i++) {
			if (a[i] == f)
				cnt++;
		}
		cnt = cnt + n/2;
		System.out.println(n);
		print();
		System.out.println("f = " + f + " cnt = " + cnt);
	}
	private void print() {
		for (int i = 0; i < n; i++) {
			System.out.print(a[i]);
			System.out.print(' ');		
		}
		System.out.println();
	}
	void find() {
		// There can only be one element.
		int c = 1, t = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] == t) {
				c++;
			} else {
				if (c == 1) {
					t = a[i];
				} else {
					c--;
				}
			}
		}
		System.out.println("t = " + t + " c = " + c);
	}
	public static void main(String[] args) {
		X x = new X();
		x.find();
	}

}