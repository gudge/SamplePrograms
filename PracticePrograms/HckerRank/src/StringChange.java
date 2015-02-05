// http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
public class StringChange {
	public static void strchange(String str, String str2) {
		int[] T = new int[str2.length()+1];
		for (int i = 0, l = str2.length(); i <= l; i++) T[i] = i;
		for (int i = 1, l = str.length(); i <= l; i++) {
			int[] T2 = new int[str2.length()+1];
			T[0] = i-1; T2[0] = i;
			Character c = str.charAt(i-1);
			for (int j = 1, l2 = str2.length(); j <= l2; j++) {	
				int insertdelete = T2[j-1] < T[j] ? T2[j-1] + 1 : T[j] + 1;
				int matchreplace = c == str2.charAt(j-1) ? T[j-1] : T[j-1] + 1;
				T2[j] = insertdelete < matchreplace ? insertdelete : matchreplace;
			}
			T = T2; T2 = null;
		}
		System.out.println(str + " -> " + str2 + " : " + T[str2.length()]);
	}
	public static void main(String[] args) {	
		strchange("SUNDAY", "SATURDAY");
		strchange("thou shalt not", "you should not");
		strchange("cot", "coat");
		strchange("coat", "cot");
		strchange("coat", "cost");
	}
}