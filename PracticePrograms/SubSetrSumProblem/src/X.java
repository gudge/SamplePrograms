import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

class X {
	static Random rand = new Random();
	static int MAX = 30;
	static int N = rand.nextInt(MAX);
	static int[] randarray() {
		if (N == 0)
			N += 20;
		int[] set = new int[N];
		for (int i = 0; i < N; i++) {
			set[i] = rand.nextInt(N);
		}
		return set;
	}
	static int randval() {
		return rand.nextInt(N);
	}
	
	private static void printsetsum(int[] set, int sum) {
		System.out.print("Arr : ");
		for (int i = 0, len = set.length; i < len; i++) {
			System.out.print(set[i]);
			if (i != set.length - 1)
				System.out.print(',');
			System.out.print(' ');
		}
		System.out.println();
		System.out.print("Sum : ");
		System.out.print(sum);
		System.out.println();
	}
	
	public static void main(String[] args) {
		int []a;
		int sum;
		
		// Sample testing

//		a = new int[]{3, 34, 4, 12, 5, 2};
//		sum = 9; // true

//		a = new int[] {2,3,6};
//		sum = 7; //false

//		a = new int[] {20, 30, 45, 60, 70};
//		sum = 75; // true
		
//		a = new int[] {4, 12, 7, 0, 13, 20, 21, 7, 9, 14, 0, 22, 11, 14, 21, 13, 10, 1, 20, 17, 9, 17, 19};
//		sum = 100; // true
		
//		a = new int[] {6, 5, 3, 6, 5, 5, 8, 0, 5};
//		sum = 4; // false

		// Please uncomment out to test random values. 
		
		a = randarray();
		sum = randval();

		printsetsum(a, sum);
		
		a = sorted(a, sum);
		HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
				
		boolean found = foo(a, sum, -1, cache);
		System.out.println(found);
		System.exit(0);
		System.out.println("Hello");
	}

	private static int[] sorted(int[] set, int sum) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0, len = set.length; i < len; i++) {
			if (set[i] <= sum)
				a.add(set[i]);
		}
		Collections.sort(a);
		set = new int[a.size()];
		for (int i = 0, len = a.size(); i < len; i++) {
			set[i] = a.get(i);
		}
		return set;
	}

	private static boolean foo(int[] set, int sum, int leave, HashMap<Integer, Integer>cache) {
		if (cache.containsKey(sum)) {
			int k = cache.get(sum);
			if (k >= leave + 1) {
				return true;
			}
		}
		for (int i = leave + 1, length = set.length; i < length; i++) {
			int j = set[i];
			if (sum < j) {
				continue;
			} else if (sum == j) {
				cache.put(sum, i);
				return true;
			} else {
				boolean val = foo(set, sum-j, i, cache);
				if (val) {
					if (cache.containsKey(sum)) {
						Integer k = cache.get(sum);
						if (i < k) {
							cache.put(sum, i);
						}
					}
					return true;
				}	
			}
		}
		return false;
	}

}