import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /* Head ends here */
    static int stringSimilarity(String a) {
    	System.out.println();
    	System.out.println(a);
    	
    	int[] table = new int[a.length()];
    	for (int i = 0, len = a.length(); i <len; i++) {
    		table[i] = 0;
    	}
    	if (a.charAt(a.length() - 1) == a.charAt(0)) {
    		table[0] = 1;
    	}
    	for (int i = 1, j = 0, len = a.length(); i <len; i++) {
    		if (a.charAt(i) == a.charAt(j))
    			table[]
    	}
        return 0;
    }
    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _t_cases = Integer.parseInt(in.nextLine());
        for (int _t_i = 0; _t_i<_t_cases; _t_i++) {
            String _a = in.nextLine();
            res = stringSimilarity(_a);
            System.out.println(res);
            break;
        }
        in.close();
    }
}