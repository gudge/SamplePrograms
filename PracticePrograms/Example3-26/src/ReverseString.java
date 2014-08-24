
public class ReverseString {

	private String str;
	
	public ReverseString() {
		str = new String("My name is Chris");
	}
	public ReverseString(String str) {
		str = new String(str);
	}

	String reverse() {
		int noWords = 0;
		int index = 0;
		String dummy = new String(str);
		System.out.println(str);
		while (true) {
			noWords++;
			index = str.indexOf(' ', index);
			if (index == -1)
				break;
			index = index + 1;
		}
		System.out.println(noWords);
		return dummy;
	}
	void print() {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		ReverseString str = new ReverseString();
		//str.print();
		str.reverse();
	}
}