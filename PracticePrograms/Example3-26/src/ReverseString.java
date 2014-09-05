public class ReverseString {

	private String str;
	private String[] words;
	private int noWords;
	private String reverse;

	public ReverseString() {
		str = new String("My name is Chris");
	}
	public ReverseString(String str) {
		this.str = new String(str);
		performOp();
	}

	String reverse() {
		int index;
		for(index = 0, noWords = 0;;index++, noWords++) {
			index = str.indexOf(' ', index);
			if (index == -1)
				break;
		}	
		noWords++;
		words = new String[noWords];
		index = 0;
		for (int i = 0; i < noWords - 1; i++, index++) {
			words[i] = str.substring(index, str.indexOf(' ', index));
			index = str.indexOf(' ', index);
		}
		words[noWords - 1] = str.substring(index);
		StringBuilder reverse2 = new StringBuilder();
		for (int i = noWords - 1; i > 0; i--) {
			reverse2.append(words[i]);
			reverse2.append(' ');
		}
		reverse2.append(words[0]);
		reverse = reverse2.toString();
		return reverse;
	}
	void print() {
		System.out.println(str);
	}

	void check() {
		int index = 0;
		for (int i = 0, oldindex = 0; i < noWords - 1; i++, index++) {
			int rightIndex;
			oldindex = index;
			index = str.indexOf(' ', index);
			String left = str.substring(oldindex, index);
			rightIndex = str.length() - index;
			String right = reverse.substring(rightIndex,  rightIndex + left.length());
			if (left.compareTo(right) != 0)
				new Exception();				
		}

		String left = str.substring(index);
		String right = reverse.substring(0, left.length());
		if (left.compareTo(right) != 0) {
			new Exception();
		}

		System.out.println('X' + reverse + 'X');
	}

	void performOp() {
		reverse();
		check();
	}

	public static void main(String[] args) {
		new ReverseString("My name is Chris");
		new ReverseString("");
		new ReverseString(" ");
		new ReverseString("  ");
		new ReverseString("My name is Chris ");
		new ReverseString(" My name is Chris ");
		new ReverseString(" My name is Chris");
		new ReverseString("My name is    Chris");
	}
}