import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;



class Solutions {
	
	public static void main(String[] args) {
		HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10; i ++) {
			mp.put(i + 1,  i);
		}
		Set<Integer> set = mp.keySet();
		Iterator<Integer>it = set.iterator();
		while (it.hasNext()) {
			Integer i1 = (Integer)it.next();
			System.out.print(i1);
			System.out.print(' ');
			System.out.print(mp.get(i1));
			System.out.print(" - ");
		}
		System.out.println();
	}
}