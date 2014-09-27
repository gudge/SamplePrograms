import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



class X {
	
	ArrayList<Integer> a;
	int n;
	static final int nos = 10;
	Random rand;

	X() {
		rand = new Random();
		n = getNum();
		a = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++)
			a.add(i, getNum());
		Collections.sort(a);
	}

	private void print() {
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i));
			System.out.print(' ');
		}
		System.out.println("");
	}
	private int getNum() {
		int x;
		do {
			x = rand.nextInt(nos);
		} while (x == 0 || x == 1);
		return x;
	}

	int binarysearch(int s, int l, int h) {
		if (l > h) return -1;
		if (l == a.size()) return -1;
		int m = l + (h - l) /2;
		if (a.get(m) == s) return m;
		if (a.get(m) > s)
			return binarysearch(s, l, m - 1);
		return binarysearch(s, m + 1, h);
	}
	void search() {
		int s = getNum();
		int k = binarysearch(s, 0, a.size());
		boolean found = false;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) == s) {
				found = true;
				break;
			}
		}
		boolean found2 = k == -1 ? false : true;
		if (found != found2) {
			System.out.println("Something went wrong\n");
		}		
		if (found2 == false) {
			System.out.println("search item: " + s);
			print();
		}
	}
	void count() {
		System.out.println("Count");
		int s = rand.nextInt(nos);
		int c = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) == s)
				c++;
		}
		//2 2 4 4 4 5 5 7 9
		//a.clear();
		int left = countOccurences2(s, 0, a.size(), 0);
		int right = countOccurences2(s, 0, a.size(), 1);
		if (left != right) {
			if (left == -1 || right == -1) {
				System.out.println("Something went wrong\n");
			}
		}
		//System.out.println("s = " + s + " right = " + right + " left = " + left);
		System.out.println("s = " + s);
		print();

		if (left != -1) {
			if (right - left + 1 != c)
				System.out.println("Something went wrong\n");
		}
		System.out.println("Count = " + c);
	}
	
	private int countOccurences2(int s, int l, int h, int dir) {
		if (l > h) return -1;
		if (l == a.size()) return -1;
		int m = l + (h - l)/2;
		if (a.get(m) == s) {
			int c = -1;
			if (dir == 0) {
				c = countOccurences2(s, l, m - 1, 0);
			} else {
				c = countOccurences2(s, m + 1, h, 0);
			}
			if (c == -1)
				return m;
			else
				return c;
		}
		if (l > 0 && a.get(l - 1) == s)
			return -1;
		if (h == n - 1 && a.get(h + 1) == s)
			return -1;
		if (a.get(m) > s)
			return countOccurences2(s, l, m - 1, dir);
		return countOccurences2(s, m + 1, h, dir);
	}

	public static void main(String[] args) {
		X x = new X();
		x.search();
		x.count();
	}
}