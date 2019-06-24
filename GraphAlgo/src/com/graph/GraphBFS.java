package com.graph;

import java.util.LinkedList;

public class GraphBFS {
	private int V;   // No. of vertices 
    private LinkedList<Integer> adj[]; //Adjacency Lists 
    
    GraphBFS(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
    void addEdge(int v,int w) 
    { 
        adj[v].add(w); 
    } 
    

	public static void main(String[] args) {

		GraphBFS g = new GraphBFS(4);
		
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        
        g.bfs(2);
		
	}
	private void bfs(int i) {

		
	}

}
