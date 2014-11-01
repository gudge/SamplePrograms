import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
		graph.get(vertex.get('D')).add('B');
		graph.get(vertex.get('D')).add('F');
		graph.get(vertex.get('F')).add('E');

		dfs(graph, vertex);
	}

	private static void dfs(ArrayList<ArrayList<Character>> graph, HashMap<Character, Integer> vertex) {
		Stack<Character> dfs = new Stack<Character>();
		ArrayList<Character> al = new ArrayList<Character>(graph.size());
		HashSet<Character> noIncomingNodes = new HashSet<Character>(graph.size());
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
	}
}