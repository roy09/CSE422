package aStarSearch;

import java.util.HashMap;
import java.util.Map;

public class Node {
	String name = "";
	int stDistance;
	boolean visited = false;
	Node parent = null;
	
	int total = 0;
	
	Map adjacentNodes = new HashMap();
	
	public Node(String name){
		this.name = name;
	}
	
	public void setDistance(int n){
		this.stDistance = n; 
	}
	
	public void addAdjacentNodes(Node n, int dist){
		n.adjacentNodes.put(this, dist);
		this.adjacentNodes.put(n, dist);
	}
	
	public void changeTotal(int n){
		this.total = n;
	}
	
	
}
