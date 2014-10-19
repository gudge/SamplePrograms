import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    	//
    	// 4,9
//    	8,52 6,80 26,42 2,72
//    	51,19 39,11 37,29 81,3 59,5 79,23 53,7 43,33 77,21
 //   	final int BOX = 100;
    	
//    	HashMap<Integer, Integer> jump = new HashMap<Integer, Integer>();
 
//    	jump.put(8, 52);
//    	jump.put(6, 80);
//    	jump.put(26, 42);
//    	jump.put(2, 72);
//    	jump.put(51, 19);
//    	jump.put(39, 11);
//    	jump.put(37, 29);
//    	jump.put(81, 3);
//    	jump.put(59, 5);
//    	jump.put(79, 23);
//    	jump.put(53, 7);
//    	jump.put(43, 33);
//    	jump.put(77, 21);
    	
    	Scanner sc = new Scanner(System.in);
    	final int testcases = Integer.parseInt(sc.nextLine().split(" ")[0]);
    	for (int t = 0; t < testcases; t++) {
    		sc.nextLine();
    		HashMap<Integer, Integer> jump = new HashMap<Integer, Integer>();
    		for (int t2 = 0; t2 < 2; t2++) {
    			String[] l = sc.nextLine().split(" ");
    			for (int t3 = 0; t3 < l.length; t3++) {
    				String[] l2 = l[t3].split(",");
    				jump.put(Integer.parseInt(l2[0]), Integer.parseInt(l2[1]));
    			}
    		}
    		int nsteps;
    		final int finalPos = 100;
    		HashSet<Integer> positions = new HashSet<Integer>();
    		positions.add(1);
    		for (nsteps = 0; !positions.contains(finalPos); nsteps++) {
    			HashSet<Integer> oldPos = positions;
    			positions = new HashSet<Integer>();
    			Iterator<Integer> it = oldPos.iterator();
    			while (it.hasNext()) {
    				Integer i = it.next();
    				for (int j = 1; j < 7; j++) {
    					int k = i + j;
    					if (jump.containsKey(k))
    						positions.add(jump.get(k));
    					else
    						positions.add(k);
    				}
    			}
    		}
    		System.out.println(nsteps);
    	}
    	sc.close();
    }
}