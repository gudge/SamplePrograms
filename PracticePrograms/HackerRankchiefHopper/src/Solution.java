import java.util.Random;
import java.util.Scanner;

public class Solution {
	static Random rand = new Random();
	final static Integer getN(final int n) {
		int i;
		do {
			i = rand.nextInt(n);
		} while (i ==0 || i == 1);
		return i;
	}

    public static void main(String[] args) {
//    	Scanner in = new Scanner(System.in);
//    	String l = in.nextLine();
//    	final Integer N = Integer.parseInt(l);
//    	l = in.nextLine();
//    	String[] l2 = l.split(" ");
//    	int[] arr = new int[N];
//    	for (int i = 0; i < N; i ++) {
//    		arr[i] = Integer.parseInt(l2[i]);
//    	}
//    	if (N == 0) {
//    		System.out.println(0);
//    		in.close();
//    		return;
//    	} else if (N == 1) {
//    		System.out.println(arr[0]);
//    		in.close();
//    		return;
//    	}
//    	in.close();

//    	final int N = getN(100);
//    	int[] arr = new int[N];
//    	for (int i = 0; i < N; i++) {
//    		arr[i] = getN(100);
//    	}

    	String l = "68 19 32 87 23 54 82 82 70 5 11 16 42 36 62 86 4 15 91 42 61 82 53 2 92 27 36 92 83 16 94 23 74 45 24 92 64 52 83 27 4 35 30 49 44 97 38 38 27 48 44 39 91 17 46 66 9 74 79 33 74 95 87 58 53 73 47 10 59 94 33 62 91 68 39 42 29 49 33 15 38 62 59 31 22 5 96 8 29"; 
    	String[] l2 = l.split(" ");
    	final int N = l2.length;
    	int[] arr = new int[N];
    	for (int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(l2[i]);
    	}
    	l2 = null;
    	l = null;

    	long[] arr2 = new long[N];
    	long sum = (long) 0;
    	long j = 1;
    	sum = arr[N - 1];
    	arr2[N-1] = sum;
    	for (int i = N - 2; i >= 0; i--, j = 2 * j) {
    		if (i == 4) {
    			System.out.println(i);
    			int j3 = arr[i];
    			System.out.println(j3);
    		}
    		long k2 = (sum + arr[i])/2;
    		if ((sum + arr[i]) % 2 == 1)
    			k2 += 1;
    		sum = k2;
    		arr2[i] = k2;
    	}
    	System.out.println(sum);
    	
    	//print1(N, sum);
    	boolean ret2 = verify(arr, sum, N, arr2, true);
    	System.out.println(ret2);
    	if (ret2) {
    		boolean ret3 = verify(arr, sum-1, N, arr2, true);
    		if(!ret3) {
    			System.out.println("Good answer");
    		}
    	}
    	if (!ret2) {
    		print1(N, sum);
    		print2(arr, N);
    	}
    }

	private static boolean verify(int[] arr, long sum, int N, long[] arr2, boolean print) {
		System.out.println("Initial Value : " + sum);
		long sum2 = sum;
		for (int i = 0; i < N; i++) {
//			if (false && i == 31) {
//				System.out.println(i);
//				System.out.println(arr[i]);
//				System.out.println(cnt);
//			}
			long sum3 = arr2[i];
			long k2 = (long)arr[i];
			if (k2 > sum)
				sum -= k2 - sum;
			else {
				sum += sum - k2; 
			}
			sum2 = 2 * sum2 - k2;
			if (i != N-1) {
				long sum4 = arr2[i+1];
				if (sum != sum4) {
					System.out.println("Wrong\n");
				}
			}	
			if (print && sum < 0) {
				print3(i, N, arr[i], sum, sum2, sum3);
				return false;
			}
		}
		return true;
	}
	private static void print1(int n, long sum) {
		System.out.print(" n = cnt = ---> ");
    	System.out.print(n);
    	System.out.print(" ");
    	System.out.print(sum);
    	System.out.println();	
	}
	
	private static void print2(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			if (arr[i] < 10)
				System.out.print(' ');
			System.out.print(arr[i]);
			if (i % 10 == 0)
				System.out.println();
			System.out.print(' ');
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
	}
	
	private static void print3(int i, int N, int j, long cnt, long cnt2, long cnt3) {
		System.out.print(" ---> ");
		System.out.print(i);
		System.out.print(" ");
		System.out.print(N);
		System.out.print(" ");
		System.out.print(j);
		System.out.print(" ");
		System.out.print(cnt);
		System.out.print(" ");
		System.out.print(cnt2);
		System.out.print(" ");
		System.out.print(cnt3);
		if (cnt != cnt2) {
			System.out.println(" Count values not equal\n");
		}
		System.out.println();
	}
}


//84
//100
//58
//67
//-2794990855731921117
//false
//101
//99 10 99 56 99 67 64 35 75 20 17 49 42 50 31 11 23 88 23 31 39 28 55 52 8 19 30 31 71 59 5 27 91 44 54 20 84 67 75 86 75 12 47 58 33 2 25 45 85 59 78 41 48 54 98 66 32 85 67 29 53 50 18 74 9 54 2 95 78 56 43 21 61 69 84 7 38 28 34 99 77 81 48 96 