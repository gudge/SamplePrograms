// http://www.careercup.com/page?pid=linkedin-interview-questions
// http://stackoverflow.com/questions/26426577/find-number-of-numbers-made-with-1-2-3-4-such-that-same-digits-never-lie-togethe
// http://www.geeksforgeeks.org/linkedin-online-coding-questions-campus-placement/
// http://www.geeksforgeeks.org/linkedin-interview-experience-set-3-campus/

class Y1 {
//	There is a particular sequence that only uses numbers 1, 2, 3, 4 and no two adjacent numbers are the same. 
//	Write a program that given n1 1s, n2 2s, n3 3s, n4 4s will output the number of such sequences using all these numbers. 
//	Output your answer modulo 1000000007 (10^9 + 7).
	
	
	void foo() {
		//bar(10, 10, 10, 10);
		System.out.println(bar2(8));
		
		//2. There are "n" ticket windows in the railway station. 
		// ith window has ai tickets available. 
		//Price of a ticket is equal to the number of tickets remaining in that window at that time. 
		// When "m" tickets have been sold, what's the maximum amount of money the railway station can earn?
		//exa. n=2, m=4
		//in 2 window available tickets are : 2 , 5
		//2nd window sold 4 tickets so 5+4+3+2=14.
		//System.out.println(bar3(2, 4));
		urlshortening();
	}

	private void urlshortening() {
		// The number of characters in the URL is 6.
		
		final String longURL = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		final String shortURL;
		
		
	}

	private char[] bar3(int n, int m) {
		
		return null;
	}

	private void bar(int n1, int n2, int n3, int n4) {
		
		
	}

	private int bar2(int n) {
		if (n == 0)
			return 1;
		int n2 = n, cnt;
		for (cnt = 0; n != 0; cnt += 1, n=n/2);
		n = n2;
		boolean[] a = new boolean[cnt];
		for (int i = 0; i < cnt; i++) {
			if (n % 2 == 1) a[i] = true;
			n = n/2;
		}
		print2(a);
		n = 0;
		for (int i = cnt - 1; i >= 0; i--)
			if (!a[i]) n += Math.pow(2, i);
		return n;
	}

	private void print2(boolean[] a) {
		for (int i = a.length-1; i >= 0; i--) {
			System.out.print(a[i] == true ? 1 : 0);
			System.out.print(' ');
		}
		System.out.println();
	}
}

public class X {
	public static void main(String[] args) {
		Y1 y1 = new Y1();
		y1.foo();
	}
}