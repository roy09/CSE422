package bfs_dfs_adj_list;

import java.util.List;
import java.util.LinkedList;

public class Node {
	
	public String data;
	public boolean visited = false;
	public List adjacentNodes = new LinkedList();
	
	public Node(String data){
		this.data = data;
	}
	
	public void addAdjacentNode(final Node node){
		adjacentNodes.add(node);
		node.adjacentNodes.add(this);
	}
}
