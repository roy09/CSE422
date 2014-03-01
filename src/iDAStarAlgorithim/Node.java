package iDAStarAlgorithim;

import java.util.HashMap;
import java.util.Map;

public class Node {
	String name = "";           //name of node
	int stDistance = 0;         //straight line distance
	int total = 0;				//total = f(n) + g(n)
 	boolean visited = false;    //to check if visited or not
	Node parent = null;         //to keep track of parent class
	
	//to hold the adjacent nodes
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
