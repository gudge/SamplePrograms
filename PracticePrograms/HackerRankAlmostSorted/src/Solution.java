import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	private static int getN(Random rand, int n) {
		int i;
		do {
			i = rand.nextInt(n);
		} while (i == 0 || i == 1);
		return i;
	}
	
	private static void printArr(int[] a, int l, int h) {
		System.out.print(l);
		System.out.print(' ');
		System.out.print(h);
		System.out.print(' ');
		System.out.print(" :  ");
		for (int i = l; i <= h; i++) {
			System.out.print(a[i]);
			System.out.print(' ');
		}
		System.out.println();
	}
	
	private static int[] getDiff(int[] a, int l , int h) {
		int[] diffVal = new int[h - l];
		for (int i = l; i <= h - 1; i++) {
			int x = i == 0 ? 0 : diffVal[i - 1];
			diffVal[i] = a[i+1] - a[i] + x;
		}
		return diffVal;
	}
	
    public static void main(String[] args) {
        final Random rand = new Random();
        //final int MAX = (int)Math.pow(10, 6);
        final int n = getN(rand, 10);
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
        	arr[i] = getN(rand, 10);
        }
        printArr(arr, 0, n - 1);
        int c = arr.length;
        System.out.println(c);
        for (int i = 0; i < n - 1; i++) {
        	printArr(arr, i, i);
        }
        // N^2 is no allowed.
        // N or NlogN
        int[] diffVal = getDiff(arr, 0, n - 1);
        printArr(diffVal, 0, n - 2);
        for (int i = 0; i <= n - 2; i++) {
        	for (int j = i + 1; j <= n - 1; j++) {
        		int[] diffVal2 = getDiff(arr, i, j);
        	}
        }
    }
}