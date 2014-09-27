import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



class X {
	Integer[] s1;
	Integer[] s2;
	int n;
	int x;
	static final int nos = 10;
	static final Random rand = new Random();
	

	private int getN() {
		int i;
		do {
			i = rand.nextInt(nos);
		} while( i == 0 || i == 1);
		return i;
	}
	X() {
		n = getN();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++) {
			arr.add(i, getN());
		}
		Collections.sort(arr);
		s1 = arr.toArray(new Integer[n]);
		arr.clear();
		for (int i = 0; i < n; i++) {
			arr.add(i, getN());
		}
		Collections.sort(arr);
		s2 = arr.toArray(new Integer[n]);
		arr.clear();
		
		x = getN();
		System.out.println(x);
		print();
	}
	private void print() {
		for (int i = 0; i < n; i++) {
			System.out.print(s1[i]);
			System.out.print(' ');
		}
		System.out.println("");
		for (int i = 0; i < n; i++) {
			System.out.print(s2[i]);
			System.out.print(' ');
		}
		System.out.println("");
	}

	void find() {
		int[] d = new int[n];
		for (int i = 0; i < n; i++)
			d[i] = x - s1[i];
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for (int i = 0 ; i < n; i++)
			arr.add(i, d[i]);
		int pos1 = -1, pos2 = -1;
		for (int i = 0; i < n; i++) {
			if (arr.contains(s2[i])) {
				pos2 = i;
				pos1 = arr.indexOf(s2[i]);
				break;
			}
		}
		if (pos1 != -1) {
			System.out.println("x = " + x + " 1. " + pos1 + " " + s1[pos1] 
					+ " 2. " + pos2 + " "+ s2[pos2] + "\n");
		}
		
	}
	public static void main(String[] args) {
		X x = new X();
		x.find();
	}
}