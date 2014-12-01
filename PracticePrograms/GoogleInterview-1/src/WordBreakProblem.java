import java.util.HashMap;
import java.util.HashSet;
// http://thenoisychannel.com/2011/08/08/retiring-a-great-interview-problem
// Great problem

class WordBreakProblem {

	static HashSet<String> dict = new HashSet<String>();
	static void  createDict() {
		dict.add("t");
		dict.add("this");
		dict.add("his");
		dict.add("s");
		dict.add("hi");
		dict.add("is");
		dict.add("awe");
		dict.add("some");
		dict.add("awesome");
	}

	static String substring(String input) {
		if (dict.contains(input))
			return input;
		for (int i = 1, len = input.length(); i < len; i++) {
			String prefix = input.substring(0, i);
			if (dict.contains(prefix)) {
				String suffix = substring(input.substring(i, len));
				if (suffix != null) {
					return prefix + " " + suffix;
				}
			}
		}
		return null;
	}

	static void foo() {
		String t = "thisisawesome";
		System.out.println(t);
		createDict();
		String str = substring(t);
		System.out.println(str);
	}

	public static void main(String[] args) {
		foo();
	}
}