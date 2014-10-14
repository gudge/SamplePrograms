import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	private static int getN(final Random rand, final int N) {
		int i;
		do {
			i = rand.nextInt(N);
		} while (i == 0 || i == 1);
		return i;
	}
	private static void print(ArrayList<Integer> arr, int N2) {
		for (int i = 0; i < N2; i++) {
    		System.out.print(arr.get(i));
    		System.out.print(' ');
    	}
		System.out.println("");
	}
	private static void printV(int i, int j) {
		System.out.print(i);
		System.out.print(',');
		System.out.print(j);
		System.out.print(' ');
	}
	private static void printV2(int i, int j) {
		System.out.println();
		printV(i, j);
	}
	private static int getMinDiff (ArrayList<Integer> a, int val) {
		int diff = Math.abs(val - a.get(0));
		for (int i = 1; i < a.size(); i++) {
			int diff2 = Math.abs(val - a.get(i));
			if (diff > diff2) {
				diff = diff2;
			}
		}
		return diff;
	}
	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	
    	final int N = 100;
    	int m;
//    	final int A = (int) Math.pow(10, 9);
//    	final int P = (int) Math.pow(10,  9);
//    	final int Q = (int) Math.pow(10,  9);

    	final Random rand = new Random();
    	int N2 = getN(rand, N);
    	N2 = 10;
    	ArrayList<Integer> arr = new ArrayList<Integer>(N2);
    	for (int i = 0; i < N2; i++) {
    		arr.add(getN(rand, N));
    	}
    	ArrayList<Integer> copy = new ArrayList<>(arr);
//    	final int P2 = getN(rand, N);
//    	final int Q2 = getN(rand, N) + P2;
    	
    	int[] a2 = {4, 8, 17, 43, 53, 54, 58, 77, 80, 99};
    	N2 = a2.length;
    	final int P2 = 63;
    	final int Q2 = 84;
    	for (int i = 0; i < N2; i++) {
    		arr.set(i, a2[i]);
    	}
    	copy = new ArrayList<>(arr);

    	Collections.sort(arr);
    	print(arr, N2);
    	System.out.println(P2);
    	System.out.println(Q2);
    	print(copy, N2);
    	int val = 0;
    	for (int i = P2, max = 0; i <= Q2; i++) {
    		int diff = getMinDiff(arr, i);
    		if (max < diff) {
    			max = diff;
    			val = i;
    		}
			printV(i, max);
    	}

    	int diff3 = getMinDiff(arr, val);
    	printV2(val, diff3);
    	System.out.println();

    	// Trick is find the median.
    	int pos = 0;
    	if (arr.size() > 0) {
    		int diff = 0;
    		for (int i = 0; i < N2 - 1; i++) {
    			int diff2 = arr.get(i+1) - arr.get(i);
    			if (diff2 > diff) {
    				diff = diff2;
    				pos = i;
    			}
    			printV(i, diff);
    		}
    		int x1 = arr.get(pos+1), x2 = arr.get(pos), val1, val2, diff2;
    		printV2(x1, x2);
    		if ((x1 - x2) % 2 == 1) {
    			val1 = (x1 - x2)/2 + arr.get(pos);
    			val2 = val1 + 1;
    		} else {
    			val2 = val1 = (x1 - x2)/2 + arr.get(pos);
    		}
    		printV2(pos, pos+1);
    		printV2(val1, val2);
    		diff = getMinDiff (arr, val1);
    		diff2 = getMinDiff (arr, val2);
    		val = diff < diff2 ? val2 : val1;
    		printV2(diff, diff2);
    	} else {
    		int abs1 = Math.abs(arr.get(0) - P2);
    		int abs2 = Math.abs(arr.get(0 - Q2));
    		val = abs1 > abs2 ? P2 : Q2;
    	}
    	printV2(val, pos);
    }
    // Each diff wants to contributes maximum value.
}