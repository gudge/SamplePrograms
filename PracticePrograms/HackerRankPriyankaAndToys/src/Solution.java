import java.util.*;
public class Solution {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String l = sc.nextLine();
//        int N = Integer.parseInt(l);
//        if (N == 0) {
//        	System.out.println(0);
//        	sc.close();
//        	return;
//        }
//        if (N == 1) {
//        	System.out.println(1);
//        	sc.close();
//        	return;
//        }
//        l = sc.nextLine();
//        String [] l2 = l.split(" ");
//        ArrayList<Integer> arr = new ArrayList<Integer>(N);
//        for (int i = 0; i < N; i++) {
//        	arr.add(Integer.parseInt(l2[i]));
//        }
//        sc.close(); l2 = null;l = null;
//    	
    	int MAX = 100;
    	Random rand = new Random();
    	int N = rand.nextInt(MAX);
    	if (N == 0) {
    		System.out.println(0);
    		return;
    	}
    	ArrayList<Integer> arr = new ArrayList<Integer>(N);
    	for (int i = 0; i < N; i++) {
    		int j = rand.nextInt(N);
    		if (j == 0)
    			j += 5;
    		arr.add(j);
    	}
    	//arr = setA();
    	N = arr.size();
    	printarr(arr);
        Collections.sort(arr);
        ArrayList<Integer> arr2 = new ArrayList<Integer>(arr);
        for (int i = 0; i < N - 1; i ++) {
        	arr.set(i, arr.get(i+1) - arr.get(i));
        }
        arr.remove(N-1);
        //printarr(arr);
        int cnt = 1;
        for (int i = 0, d = 0, W = 4, len = arr.size(); i < len; i++) {
        	int k = arr.get(i);
        	if (k == 0) {
        		continue;
        	}
        	if (k + d <= W) {
        		d += k;
        	} else {
        		d = 0;
        		cnt += 1;
        	}
        }
        System.out.println(cnt);
        check(arr2, cnt);
    }

	private static void printarr(ArrayList<Integer> arr) {
		for (int i = 0, len = arr.size(); i < len; i++) {
    		if (i != 0)
    			System.out.print(", ");
    		if (arr.get(i) < 10)
    			System.out.print(' ');
    		System.out.print(arr.get(i));
    	}
		System.out.println();
	}

	private static ArrayList<Integer> setA() {
		//int[] arr2 = new int[] {46, 45, 25, 75, 22, 60, 62, 76, 52, 58, 46, 72, 27, 3, 55, 19, 15, 35, 77, 48, 5, 21, 26, 48, 11, 75, 18, 37, 35, 13, 10, 54, 67, 8, 55, 67, 2, 19, 18, 1, 30, 72, 41, 17, 21, 38, 32, 29, 34, 30, 21, 26, 22, 81, 62, 16, 1, 41, 9, 48, 40, 2, 1, 22, 29, 75, 2, 16, 15, 13, 47, 2, 27, 9, 21, 59, 43, 79, 80, 26, 54, 45, 36};
		//int [] arr2 = new int[] {1, 2, 2, 2, 4, 5, 6, 7, 9, 9, 9, 11, 11};
		//int[] arr2 = new int[] {17, 14, 25, 2, 16, 17, 6, 27, 19, 23, 24, 26, 18, 21, 5, 16, 8, 2, 8, 12, 28, 9, 23, 8, 12, 10, 24, 25, 24, 15};
		int[] arr2 = new int[] {13, 80, 56, 61, 76,  9, 25, 27, 51, 28,  4, 52, 38, 56, 13, 55, 43, 32, 18, 67, 65,  5, 77, 32, 67, 18,  2, 35,  5, 76, 53, 34, 62, 24, 48, 62,  9,  7, 48, 48, 14, 54, 45, 44, 78,  4, 42,  3, 28, 20, 76, 54, 20, 71,  1, 60, 48, 79, 54, 77, 69,  5, 20, 81,  9, 35, 21, 30, 50, 34, 19, 63, 74, 66, 48, 25, 36, 68, 65, 32, 71, 26, 53};
		ArrayList<Integer> arr = new ArrayList<>(arr2.length);
		for (int i = 0, len = arr2.length; i < len; i++) 
			arr.add(arr2[i]);
		return arr;
	}

	private static void check(ArrayList<Integer> arr, int cnt) {
		int cnt2;
		int min = arr.get(0);
		int max = arr.get(arr.size()-1);
		boolean[] arr3 = new boolean[max-min+1];
		for (int i = 0, len = arr3.length; i < len; i++) {
			arr3[i] = false;
		}
		for (int i = 0, len = arr.size(); i < len; i++) {
			if (!arr3[arr.get(i) - min])
				arr3[arr.get(i) - min] = true;
		}
//		for (int i = 0, len = arr3.length; i < len; i++) {
//			if (!arr3[i])
//				continue;
//			if (i != 0)
//				System.out.print(", ");
//    		System.out.print(min+i);
//		}
//		System.out.println();
		cnt2 = 0;
		for (int i = 0, len = arr3.length; i < len;) {
			if (arr3[i]) {
				cnt2 += 1;
				i += 5;
			} else {
				i++;
			}
		}
		System.out.println(cnt2);
	}
}