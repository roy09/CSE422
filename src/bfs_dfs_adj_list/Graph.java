package bfs_dfs_adj_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	
	List nodes = new ArrayList();
	
	public void breadthFirstTraversal(Node rootNode){
		Queue q = new LinkedList();
		q.add(rootNode);
		rootNode.visited = true;
		while(!q.isEmpty()){
			Node n = (Node) q.poll();
			System.out.println(n.data);
			
			while(!n.adjacentNodes.isEmpty()){
				Node adj = (Node)n.adjacentNodes.remove(0);
				if(!adj.visited){
					adj.visited = true;
					q.add(adj);
				}
			}
		}
	}
	
	public void depthFirstTraversal(Node rootNode){
		
		Stack s = new Stack();
		s.add(rootNode);
		rootNode.visited = true;
		
		while(!s.isEmpty()){
			Node n = (Node)s.pop();
			System.out.println(n.data);
			
			while(!n.adjacentNodes.isEmpty()){
				Node adj = (Node)n.adjacentNodes.remove(0);
				if(!adj.visited){
					adj.visited = true;
					s.push(adj);
				}
			}
		}
	}
}
