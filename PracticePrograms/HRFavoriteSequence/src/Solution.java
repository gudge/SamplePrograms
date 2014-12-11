import java.util.ArrayList;
import java.util.Scanner;

// https://www.hackerrank.com/contests/w12/challenges/favourite-sequence

public class  Solution {
	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);
		String l = in.nextLine();
		final Integer M = Integer.parseInt(l);
		ArrayList<Integer> set = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			l = in.nextLine();
			final Integer K = Integer.parseInt(l);
			l = in.nextLine();
			String[] l2 = l.split(" ");
			for (int j = K-1; j >= 0; j--) {
				Integer v = Integer.parseInt(l2[j]);
				if (!set.contains(v)) {
					// add it in a way to maintain lexiographic order
					for (int m = v-1; i >= 0; i--) {
						if (set.contains(m)) {
							int p = set.indexOf(m);
							// Check for lenth of set
							set.add(m+1, v);
							break;
						}
					}
					if (!set.contains(v)) {
						set.add(v);
					}
				} else {
					// Question is where you will insert
					int p = set.indexOf(v);
					
				}
			}
		}
		in.close();
	}
}