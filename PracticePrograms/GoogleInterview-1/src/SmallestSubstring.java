import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

// http://stackoverflow.com/questions/2459653/how-to-find-smallest-substring-which-contains-all-characters-from-a-given-string

class SmallestSubstring {
	public static void main(String[] args) {
		String str = "this is a test string";
		String str2 = "tist";
		ArrayList<Character> arr = new ArrayList<Character>();
		for (int i = 0, len = str2.length(); i < len; i++) {
			arr.add(str2.charAt(i));
		}
		ArrayList<Character> copy = new ArrayList<Character>(arr);
		int bestlength = 0, start = 0;
		for (int i = 0, len = str.length(); i < len;) {			
			Character c = str.charAt(0);
			if (arr.remove(c)) {
				if (arr.size() == 0)
			}
				
		}
		
		print1(copy);
	}

	private static void print1(ArrayList<Character> a) {
		for (int i = 0, len = a.size(); i < len; i++)
			System.out.print(a.get(i));
		System.out.println();
	}
}