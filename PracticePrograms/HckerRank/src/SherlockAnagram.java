class Y2 {
	String str = "abba";
	//String str = "abcd";
	boolean anagram(final String str, final String str2) {
		final int M = 26;
		final int[] c1 = new int[M];
		final int[] c2 = new int[M];
		
		if (str.length() != str2.length())
			return false;
		if (str.compareTo(str2) == 0)
			return true;
		for (int i = 0, l = str.length(); i < l; i++) {
			c1[str.charAt(i)-'a']++;
			c2[str2.charAt(i)-'a']++;
		}
		for (int i = 0; i < M; i++) {
			if (c1[i] != c2[i])
				return false;
		}
		//System.out.println("->" + str + " " + str2);
		return true;
	}
	void foo() {
		int n = str.length();
		int cnt = 0;
		for (int i = 0; i < n-1; i++) {
			int m = n - i - 1;
			for(int j = 0; j <= m; j++) {
				String str2 = str.substring(j, j + i + 1);
				for (int k = j+1 ; k <= m; k++) {
					String str3;
					str3 = str.substring(k, k + i + 1);
					if (anagram(str2, str3))
						cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}

class SherlovkAnagram {
	public static void main(String[] args) {
		Y2 y = new Y2();
		y.foo();
	}
}	
