import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class X {
	Integer [] a;
	int n;
	final static int nos = 100;
	final static Random rand = new Random();
	int x;

	int getN() {
		int i;
		do {
			i = rand.nextInt(nos);
		} while (i == 0 || i == 1);
		return i;
	}
	X() {
		n = getN();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++) {
			arr.add(i, getN());
		}
		Collections.sort(arr);
		a = arr.toArray(new Integer[n]);
		arr.clear();
		x = getN();
		System.out.println(x);
		print(a);
	}

	void find() {
		int pos = 0;
		int m = x / 2;
		for (int i = 0; i < n; i++) {
			if (m - a[i] < 0) {
				break;
			} else {
				pos = i;
			}
		}
//		System.out.println(pos);
		if (pos == n - 1)
			return;
		int pos1 = -1, pos2 = -1;
		for (int i = pos - 1, j = pos + 1; i >= 0 && j < n;) {
			int sum = a[i] + a[j];
			if (sum == x) {
				pos1 = i;
				pos2 = j;
				break;
			} else if (sum < x) {
				j++;		
			} else {
				i--;
			}
		}
		if (pos == -1 || pos2 == -1)
			return;
		System.out.println("pos1 = " + pos1 + " pos2 = " + pos2 + 
				" a[pos1] = " + a[pos1] + " a[pos2] = " + a[pos2]);
	}
	private void print(Integer[] a) {
		for (int i = 0; i < n; i++) {
			System.out.print(a[i]);
			System.out.print(' ');
		}
		System.out.println("");
	}



	public static void main(String[] args) {
		X x = new X();
		x.find();
	}
}