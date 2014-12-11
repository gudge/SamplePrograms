//// http://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings-set-2/
//
//
//class InterleavedString {
//	
//	
//	public static void main(String[] args) {
//		String str = "XXY";
//		String str2 = "XXZ";
//		String str3 = "XXZXXXY";
//		boolean v[][] = new boolean[str.length()+1][str2.length()+1];
//		for (int i = 0, len1 = str.length() + 1; i < len1; i++) {
//			for (int j = 0, len2 = str2.length() + 1; j < len2; j++) {
//				v[i][j] = false;
//			}
//		}
//		if (str3.length() != str.length() + str2.length()) {
//			return;
//		}
//		for (int i = 0, len1 = str.length() + 1; i < len1; i++) {
//			for (int j = 0, len2 = str2.length() + 1; j < len2; j++) {
//				if (i == 0 && j == 0) {
//					v[i][j] = true;
//				}
//				if (i == 0) {
//					if (v[0][j-1] == false) continue;
//					if (str3.charAt(j) == str2.charAt(j))
//						v[0][j] = true;
//				} else if (j == 0) {
//					if (v[i-1][0] == false) continue;
//					if (str3.charAt(i) == str.charAt(i))
//						v[0][j] = true;
////				} else if 
//		//	}
//	//	}
//	//}
////}