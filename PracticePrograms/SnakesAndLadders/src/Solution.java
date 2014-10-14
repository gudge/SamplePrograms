import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class X {
	
}


public class Solution {

    public static void main(String[] args) {
    	//
    	// 4,9
//    	8,52 6,80 26,42 2,72
//    	51,19 39,11 37,29 81,3 59,5 79,23 53,7 43,33 77,21
    	final int BOX = 100;
    	final int Y = -1;
    	int[] values = new int[BOX];
    	int[] steps = new int[BOX];
    	for (int i = 0; i < BOX; i++) {
    		values[i] = Y;
    	}
    	values[8] = 52;
    	values[6] = 80;
    	values[26] = 42;
    	values[2] = 72;
    	values[51] = 19;
    	values[39] = 11;
    	values[37] = 29;
    	values[81] = 3;
    	values[59] = 5;
    	values[79] = 23;
    	values[53] = 7;
    	values[43] = 33;
    	values[77] = 21;
    	
    }
}