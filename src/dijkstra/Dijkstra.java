package dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Dijkstra {

//	boolean complete = false;
	int size = 0;
	ArrayList<Node> paths = new ArrayList<Node>();
	ArrayList<Node> visited = new ArrayList<Node>();
	Queue<Node> pathTable;
	
	public Dijkstra(Node[] paths, Node start) {
		//adding nodes to the unvisited array
		for(Node path: paths){
			this.paths.add(path);
		}
		pathTable = new PriorityQueue<Node>(paths.length, comp);
		
		//calling with Dijkstra with the source
		DijkstraPath(start);
	}
	
	public void DijkstraPath(Node source){
		this.paths.remove(source);
		visited.add(source);
		
		Node n = source;
		//Check the adjacent nodes and move forward
		int count = 0;
		while(count != paths.size()){
			//find the adjacent nodes
			for(Object key: n.adjacentNodes.keySet()){
				Node currentNode = (Node) key;
				
				//if visited don't go through it
				if(visited.contains(currentNode)){
					//System.out.println("zOMG " + currentNode.name);
					continue;
				}
				int newPathCost = n.pathCost + (int)n.adjacentNodes.get(currentNode);  
				if (currentNode.pathCost == 0){
					currentNode.pathCost = newPathCost; 
				} else if (currentNode.pathCost < newPathCost){
					
				} else {
					//System.out.println("Ekhane " + currentNode.name);
					currentNode.pathCost = newPathCost;
				}
				//System.out.println(currentNode.name + " " + currentNode.pathCost);
				
				//now try printing the lowest Node
				if (pathTable.contains(currentNode)){
					pathTable.remove(currentNode);
					pathTable.add(currentNode);
					//System.out.println("Err: adding " + currentNode.name);
				} else {
					pathTable.add(currentNode);
				}
			
			}
			//give n a new value go through it <the lowest path cost data
			//System.out.print("Started " + n.name);

			//System.out.println();
			Node temp = (Node) pathTable.poll();
			n = temp;
			visited.add(temp);
			count++;
			
		}
		
		//printing the final output
		System.out.println("Shortest path distance from source: " + source.name);
		for(Object iter: paths.toArray()){
			Node temp = (Node) iter;
			String cost = Integer.toString(temp.pathCost);
					
			if(!visited.contains(temp)){
				cost = "Infinity";
			}
			System.out.println(temp.name + " " + cost);
		}
	}
	
	public static Comparator<Node> comp = new Comparator<Node>() {
		public int compare (Node one, Node two){
			if(one.pathCost > two.pathCost){
				return 1;
			} else {
				return -1;
			}
			
		}
	};
	
	
}
