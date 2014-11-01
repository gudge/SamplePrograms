public class Solution {

	private static void print(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(a[i]);
			System.out.print(' ');
		}
		System.out.println();
	}
	
    public static void main(String[] args) {
        final int n = 3;
        final int[] a =  {-1, -1, 2};
        int cnt = 0; // No of -1
        for (int i = 0, len = a.length; i < len; i++) {
        	if (a[i] == -1)
        		cnt++;
        }
        for (int i = 0, len = a.length; i < len; i++) {
        	if (a[i] != -1) {
        		a[i] -= cnt;
        	}
        }
        print(a, n);
    }
}