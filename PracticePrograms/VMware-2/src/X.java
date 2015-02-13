import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;



class X {

	public static void main2(String[] args) {
		//		int[] a = new int[100001];
		//		int[] b = new int[200002];
		//		int M = 100001;
		int[] a = new int[3];
		a[0] = 1; a[1] = 5; a[2] = 6;
		int[] b = Arrays.copyOf(a, 3);
		System.out.println(b[1]);
		b[1] = 10;
		System.out.println(a[1]);
		System.out.println(b[1]);

		//mergeArray(a, b, M);
	}

	static void mergeArray(int []a, int []b, int M ) {
		int i, j, k;
//		int[] c = Arrays.copyOf(b, M);
//		for (i = 0, j = 0, k = 0; i < M && j < M; k++) b[k] = a[i] <= c[j] ? a[i++] : c[j++];
//		for (; i < M; i++, k++) b[k] = a[i];
//		for (; j < M; j++, k++) b[k] = c[j];
		
		
		
		// If I do a reverse copy is the allocation needed.
	}

	public static void main(String[] args) {
		String str = "He had had quite enough of this nonsense.";
		//		String regex = "[ | ]";
		//		String[] str2 = str.split(regex);
		System.out.println(firstRepeatedWord(str) +  "\nXXXXX");
		System.out.println(firstRepeatedWord("") + "\nXXXX");
		System.out.println(firstRepeatedWord(". .") + "\nXXXX");
		System.out.println(firstRepeatedWord(".") + "\nXXXX");
		System.out.println(firstRepeatedWord("..") + "\nXXXX");

	}

	private static String firstRepeatedWord(String s) {
		ArrayList<String> str2 = new ArrayList<String>();
		for (int i = 0, start = 0, l = s.length(); i < l; i++) {
			char c = s.charAt(i);
			if (c == ' ' || c == '\t' || c == ',' 
					|| c == ':' || c == ';' || c == '-'
					|| c == '.') {
				if (start == i) {
					continue;
				} else if (start + 1 == i) {
					start = i;
					continue;
				} else {
					str2.add(s.substring(start, i));
					start = i + 1; 
				}
			}
			if (i == l -1) {
				if (start < i)
					str2.add(s.substring(start, i+1));
			}
		}
		//		for (int i = 0, l = str2.size(); i < l; i++) {
		//			System.out.println(str2.get(i));
		//		}
		HashSet<String> cnt = new HashSet<String>();
		for (int i = 0, l = str2.size(); i < l; i++) {
			String s2 = str2.get(i);
			if (cnt.contains(s2))
				return s2;
			else
				cnt.add(s2);
		}
		return null;
	}
}