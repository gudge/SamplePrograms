import java.util.Random;


class X {
	int[] a;
	int n;
	final static int nos = 10;
	
	X() {
		Random rand = new Random();
		do {
			n = rand.nextInt(nos);
		} while (n == 0 || n == 1);
		
		a = new int[n];
		for (int i = 0; i < n; i++) {
			do {
				a[i] = rand.nextInt(nos);
			} while (a[i] == 0);
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(a[i]);
			System.out.print(' ');
		}
	}
	
	void sort() {

		quicksort(0, n - 1);

		System.out.println("");
		for (int i = 0; i < n; i++) {
			System.out.print(a[i]);
			System.out.print(' ');
		}
		
		for (int i = 0; i < n - 1; i++) {
			if (a[i] > a[i+1]) {
				System.out.println("Wrong\n");
				break;
			}
		}
	}
	
	void swap(int i, int j) {
		if (i == j)
			return;
		int s = a[i];
		a[i] = a[j];
		a[j] = s;
	}
	
	void quicksort(int l, int h) {
		if (h < l)
			return;
		int p = part(l , h);
		quicksort(l, p - 1);
		quicksort(p + 1, h);
	}

	int part(int l, int h) {
		int x = a[l + (h - l ) / 2];
		int i = l + ( h - l) / 2 - 1;
		int j = h;
		for (;;) {
			for (;j >= 0; j--) {
				if (a[j] > x)
					break;
			}
			for (;i < n; i++) {
				if (a[i] < x)
					break;
			}
			if (i < j)
				swap(i, j);
			else
				return j;
		}
	}

	public static void main(String[] args) {
		X x = new X();
		x.sort();
	}
}