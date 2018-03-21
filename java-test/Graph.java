package javaOne;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import javaOne.Bag;

public class Graph {

	private int numVertices;
	private Bag[] adj;
	private boolean[] visited;
	private int[] edgeTo;
	
	Graph(int inVertices) {
		
		numVertices = inVertices;
		adj = new Bag[numVertices];
		for(int v = 0; v < numVertices; ++v)
			adj[v] = new Bag();
		
		visited = new boolean[numVertices];
		edgeTo = new int[numVertices];
	}
	
	void insert(int v, int w)  {
		adj[v].insert(w);
		adj[w].insert(v);
	}
	
	void display() {
		for (int i = 0; i < numVertices; ++i) {
			Iterator<Integer> it = adj[i].iterate();
			while(it.hasNext()) {
				int j = it.next();
				if(i < j)
					System.out.println(i + " - " + j);
			}
		}
	}
	
	void resetDfs() {
		
		for(int v = 0; v < numVertices; ++v) {
			visited[v] = false;
			edgeTo[v] = 0;
		}

	}
	void dfs(int inNode) {

		System.out.print(inNode + "_");
		visited[inNode] = true;
		
		Iterator<Integer> it = adj[inNode].iterate();
		while(it.hasNext()) {
			int j = it.next();
			if (false == visited[j]) {
				//System.out.print(j + "_");
				edgeTo[j] = inNode;
				dfs(j);
			}
		}
		System.out.println("");
		
	}
	
	int[] dfsPath() {
		return edgeTo;
	}
	
	void bfs(int root) {
		boolean[] visited = new boolean [numVertices];
		//int[] fromV = new int [numVertices];
		Queue<Integer> searchPath = new LinkedList<>();
						
		searchPath.add(root);
		searchPath.add(null);

		while(false == searchPath.isEmpty()) {
			Integer next = searchPath.poll();
			//if (searchPath.peek() == null ) {
			if (next == null ) {
				System.out.println("");
				//searchPath.poll();
			}
			else
			{
				int i = next.intValue();
				visited[i] = true;
				System.out.print(i + "_");
				Iterator<Integer> it = adj[i].iterate();
				boolean addedElem = false;
				while(it.hasNext()) {
					int j = it.next();
					if(false == visited[j]) {
						if(false == searchPath.contains(j)) {
							searchPath.add(j);
							addedElem = true;
						}
					}
				}
				if (addedElem)
					searchPath.add(null);
			}
		}		
		
	}
	
	
}


