import java.util.Random;

class X {
	int n;
	final static int nos = 10;
	int []a;
	int [][]s;
	int []s2;

	X() {
		Random random = new Random();
		do {
			n = random.nextInt(nos);
		} while (n == 0 || n == 1);

		a = new int[n];
		for (int i = 0; i < n; i++) {
			do {
				a[i] = random.nextInt(nos);
			} while (a[i] == 0 || a[i] == 1);	
		}

		s = new int[n][];
		for (int i = 0; i < n; i++)
			s[i] = new int[n];

		for (int i = 0; i < n; i++) {
			s[i][i] = a[i];
			int small = a[i];
			for (int j = i + 1; j < n; j++) {
				if (a[j] < small) {
					small = a[j];
				}
				s[i][j] = small;
			}
		}

		s2 = new int[n];
		for (int i = 0; i < n;i++) {
			
		}
	}

	void print() {
		System.out.print(' ');
		for (int i = 0; i < n; i++) {
			System.out.print(a[i]);
			System.out.print(' ');
		}
	}

	void print2() {
		System.out.println();
		for (int i = 0; i < n;i++) {
			for (int j = 0; j < i; j++)
				System.out.print("  ");
			for (int j = i; j < n; j++) {
				System.out.print(s[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		X x = new X();
		x.print();
		x.print2();
	}
}