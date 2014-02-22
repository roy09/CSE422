package last_try;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStarSearch {
	
	public void AStarSearchedPath(Node rootNode, Node goal){
		
		Queue<Node> frontier = new PriorityQueue<Node>(10, comp);
		
		frontier.add(rootNode);
		
		boolean path = false;
		
		while(!frontier.isEmpty()){
			Node n = (Node)frontier.remove();
			n.visited = true;
			
			//find the adjacent vertices and push to the stack
			for (Object key : n.adjacentNodes.keySet()){
				Node newNode = (Node)key;
				if (newNode.visited == true){
					continue;
				}
				newNode.parent = n;
				newNode.total = newNode.stDistance + (int)newNode.adjacentNodes.get(n);
				System.out.println(newNode.name + " - " + n.name + " " + "Straight Dist: " + newNode.stDistance 
						+ " inter dist: " + (int)newNode.adjacentNodes.get(n) + " total " + newNode.total);
				frontier.add(newNode);
				
				if(newNode == goal){
					System.out.println("We've reached");
				}
			}		
		}
		
		Node temp = goal;
		while(temp != null){
			System.out.println(temp.name);
			temp = temp.parent;
		}
	}
	
	public static Comparator<Node> comp = new Comparator<Node>() {
		public int compare (Node one, Node two){
			if(one.total > two.total){
				
				return 1;
			} else {
				return -1;
			}
			
		}
	};
}
