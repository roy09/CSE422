package dijkstra;

import java.util.HashMap;
import java.util.Map;

public class Node {
	String name = "";
	Map adjacentNodes = new HashMap();
	int pathCost = 0;
	
	public Node(String name){
		this.name = name;
	}
	
	public void addAdjacentNodes(Node n, int dist){
		this.adjacentNodes.put(n, dist);
	}	
	
}
