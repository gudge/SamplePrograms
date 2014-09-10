import java.util.Random;

class X {
	private int[] a;
	private int n; // largest integer
	private int[] b;
	private int m; // size of table;
	public int[] arr;
	private static int filler = 0; 
	private final static int nos = 10;
	X() {
		Random random = new Random();
		do {
			m = random.nextInt(nos);
		} while (m == 0 || m == 1);
		System.out.println(m);
		
		arr = new int[m];
		for (int i = 0; i < m; i++) {
			do {
				arr[i] = random.nextInt(nos);
			} while (arr[i] == 0 || arr[i] == 1);	
		}

		for (int i = 0; i < m; i++) {
			System.out.println(arr[i]);
		}
		
		n = nos;
		b = new int[m];
		a = new int[n];
	}
	
	//             
	//  a    |5|4|1| | | | | | | |
	//             ^
	//            n = 3
	//  b    | |2| | |1|0| | | | |
	//        0 1 2 3 4 5 6 7 8 9
	public void insert(int i) {
		if (filler >= m || i >= n)
			return;
		a[filler] = i;
		b[i] = filler;
		filler++;
	}

	public void delete(int i) {
		if (!search(i))
			return;
		int j = a[filler - 1]; 
		a[b[i]] = j; 
		b[j] = b[i];
		filler--;
	}

	public boolean search(int i) {
		if (filler <= 0 || i >= n) // no elements
			return false;
		return a[i] < n && a[b[i]] == i;
	}
	public static void main(String[] args) {
		X x = new X();
	}
}