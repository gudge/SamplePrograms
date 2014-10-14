import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


// Graph:
// 10 9
//2 1
//3 1
//4 3
//5 2
//6 1
//7 2
//8 6
//9 8
//10 8


public class Solution {
	
	private static void printEdge(int s, int d) {
		if (true)
			return;
		System.out.print('(');
		System.out.print(s);
		System.out.print(',');
		System.out.print(d);
		System.out.print(')');
		System.out.print(' ');
	}
	private static void printNonLeaf(ArrayList<Integer> nonLeafEdges) {
		if (true)
			return;
		System.out.println("");
    	System.out.print("Non leaf edges : ");
    	for (int i = 0; i < nonLeafEdges.size(); i += 2) {
    		int s = nonLeafEdges.get(i);
    		int d = nonLeafEdges.get(i+1);
    		printEdge(s, d);
    	}
	}

	static ArrayList<Integer> bFS(int s, int w,
			ArrayList<ArrayList<Integer>> graph, int noVertices) {
		if (graph.get(s).size() == 0)
			return null;
		ArrayList<Integer> bfsSource = new ArrayList<Integer>(noVertices - 2); 
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		boolean[] discovered = new boolean[noVertices + 1];
		for (int i = 0; i < noVertices + 1; i++) {
			discovered[i] = false;
		}
		discovered[s] = true;
		discovered[w] = true;
		while (!queue.isEmpty()) {
			if (bfsSource.size() == noVertices - 1)
				break;
			int v = queue.remove();
			if (v != s && v != w && !bfsSource.contains(v)) {
				bfsSource.add(v);
			}
			ArrayList<Integer> edges = graph.get(v);
			for (int i = 0; i < edges.size(); i++) {
				int j = edges.get(i);
				if (discovered[j] == false) {
					queue.add(j);
					discovered[j] = true;
				}
			}
		}
		if (bfsSource.size() > noVertices - 2) {
			System.out.println("Something Went wrong\n");
		}
		return bfsSource;
	}
	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	// Build up.

    	// Undirected
    	// I am reading vertices from 1 to 10.
    	
//    	int[] edges = null;
//    	Scanner sc = new Scanner(System.in);
//    	if (sc.hasNextLine()) {
//    		String l = sc.nextLine();
//    		String[] l2 = l.split(" ");
//    		int n = Integer.parseInt(l2[0]);
//    		int m = Integer.parseInt(l2[1]);
//    		edges = new int[2*m + 2];
//    		edges[0] = n;
//    		edges[1] = m;
//    	}
//    	int c = 2;
//    	while(sc.hasNextLine()) {
//    		String l = sc.nextLine();
//    		String[] l2 = l.split(" ");
//    		int n = Integer.parseInt(l2[0]);
//    		int m = Integer.parseInt(l2[1]);
//    		edges[c++] = n;
//    		edges[c++] = m;
//    	}
//
//    	sc.close();
   	final int[] edges = new int[] {10, 9, 2, 1, 3, 1, 4, 3, 5, 2, 6, 1, 7, 2, 8, 6
    			,9, 8, 10, 8};

    	
    	final int vertices = edges[0];
    	
    	ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    	for (int i = 0; i < vertices + 1; i++) {
    		graph.add(new ArrayList<Integer>());
    	}
    	for (int i = 2; i < edges.length; i += 2) {
    		int s = edges[i];
    		int d = edges[i+1];
    		graph.get(s).add(d);
    		graph.get(d).add(s);
    	}
    	//System.out.print(noEdges);
    	//System.out.print(" : ");
    	for (int i = 0; i < vertices + 1; i++) {
    		for (int j = 0; j < graph.get(i).size(); j++) {
    			int d = graph.get(i).get(j);
    			if (i < d)
    				continue;
    			printEdge(i, d);
    		}
    	}
    	
    	// Edges which you cannot remove	
    	ArrayList<Integer> nonLeafEdges = new ArrayList<Integer>(edges.length - 2);
    	for (int i = 2; i < edges.length; i += 2) {
    		int s = edges[i];
    		int d = edges[i+1];
//    		if (s < d)
//    			continue;
    		if (graph.get(s).size() < 2)
    			continue;
    		nonLeafEdges.add(s);
    		nonLeafEdges.add(d);
    	}
    	printNonLeaf(nonLeafEdges);
    	ArrayList<Integer> nonLeafEdges2 = new ArrayList<Integer>(edges.length - 2);
    	for (int i = 0; i < nonLeafEdges.size(); i += 2) {
    		int s = nonLeafEdges.get(i);
    		int d = nonLeafEdges.get(i+1);
    		ArrayList<Integer> bfs = bFS(s, d, graph, vertices);
    		if (bfs.size() % 2 == 1) {
    			nonLeafEdges2.add(s);
    			nonLeafEdges2.add(d);
    		}
    	}
    	nonLeafEdges = nonLeafEdges2;
    	printNonLeaf(nonLeafEdges);
    	System.out.print(nonLeafEdges.size()/2);
    }
}