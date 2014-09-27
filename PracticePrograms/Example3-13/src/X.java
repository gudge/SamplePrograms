import java.util.Random;


// Hint: add and sum in log n.
// There must be a tree implementation.

class X {
	private int n;
	int A[];
	int arr[];
	final static int nos = 10;
	
	X() {
		Random random = new Random();
		do {
			n = random.nextInt(nos);
		} while (n == 0);
		
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = random.nextInt(nos);
		}
		arr = new int[n];
	}
	
	void print() {
		System.out.println(n);
		System.out.println("XX");
		for (int i = 0; i < n; i++) {
			System.out.println(A[i]);
		}
	}

	void add(int i, int y) {
		if (i >= n)
			return;
		A[i] += y;
	}
	void sum(int i) {
		if (i >= n)
			return;
		int sum = 0;
		for (int j = 0; j <= i; j++) {
			sum += A[j];
		}
		System.out.println("Sum = " + sum);
	}
	// If Partial sum is to be done in O(log n) time
	// we will have to store some data.
	// Tree updation should also take O(log n ) time.
	void sum2(int i) {
		if (i >= n)
			return;
		
	}
 	public static void main(String[] args) {
		X x = new X();
		x.add(3, 5);
		x.print();
		x.sum(2);
		x.sum2(2);
	}
}