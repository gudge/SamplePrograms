import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

import javax.naming.NoInitialContextException;

class Solutions {
	public static void main(String[] args) {
		// G -> H
		// A -> H
		// A -> B -> C -> E
		// D-> B
		// D -> F
		// F -> E
		// I
		
		final int noNodes = 9;
		ArrayList<ArrayList<Character>> graph = new ArrayList<ArrayList<Character>>(noNodes);
		for (int i = 0; i < noNodes; i++) {
			graph.add(i, new ArrayList<Character>(noNodes - 1));
		}
		HashMap<Character, Integer> vertex = new HashMap<Character, Integer>(noNodes);
		vertex.put('A', 0);vertex.put('B', 1);vertex.put('C', 2);vertex.put('D', 3);
		vertex.put('E', 4);vertex.put('F', 5);vertex.put('G', 6);vertex.put('H', 7);
		vertex.put('I', 8);
		graph.get(vertex.get('A')).add('H');
		graph.get(vertex.get('G')).add('H');
		graph.get(vertex.get('A')).add('B');
		graph.get(vertex.get('B')).add('C');
		graph.get(vertex.get('C')).add('E');
		graph.get(vertex.get('C')).add('H');
		graph.get(vertex.get('D')).add('B');
		graph.get(vertex.get('D')).add('F');
		graph.get(vertex.get('F')).add('E');

		dfs(graph, vertex, noNodes);
	}

	private static void printCharacterarray(ArrayList<Character> arr) {
		for (Iterator<Character> it = arr.iterator(); it.hasNext();) {
			System.out.print(it.next());
			System.out.print(' ');
		}
		System.out.println();
	}
	
	private static void dfs(final ArrayList<ArrayList<Character>> graph, 
			final HashMap<Character, Integer> vertex, final int noNodes) {
		ArrayList<Character> noIncomingNodes = new ArrayList<Character>(graph.size());
		noIncomingNodes.add('A');noIncomingNodes.add('B');noIncomingNodes.add('C');
		noIncomingNodes.add('D');noIncomingNodes.add('E');noIncomingNodes.add('F');
		noIncomingNodes.add('G');noIncomingNodes.add('H');noIncomingNodes.add('I');
		for (int i = 0; i < graph.size(); i++) {
			ArrayList<Character> x = graph.get(i);
			for (int j = 0; j < x.size(); j++) {
				Character c = x.get(j);
				if (noIncomingNodes.contains(c))
					noIncomingNodes.remove(c);
			}
		}
		Collections.reverse(noIncomingNodes);
		printCharacterarray(noIncomingNodes);
		if (noIncomingNodes.size() == 0)
			return;
		LinkedList<Character> dfs = new LinkedList<Character>();
		for (Iterator<Character> it = noIncomingNodes.iterator(); it.hasNext();) {
			dfs.add(it.next());
		}
	
		for (int i = 0;i < noNodes; i++) {
			Character n = dfs.get(i);
			ArrayList<Character> j = graph.get(vertex.get(n));
			for (int k = 0; k < j.size(); k++) {
				Character l = j.get(k);
				if (!dfs.contains(l)) {
					dfs.add(l);
				} else {
					int m1 = dfs.indexOf(n);
					int m2 = dfs.indexOf(l);
					if (m2 < m1) {
						if (m1 < dfs.size() - 1)
							dfs.add(m1 + 1, l);
						else
							dfs.add(l);
						dfs.remove(l);
					}
				}
			}
		}
		System.out.println("Done");
	}

	
}