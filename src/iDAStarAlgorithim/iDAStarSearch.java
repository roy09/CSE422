package iDAStarAlgorithim;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class iDAStarSearch {
	
	public iDAStarSearch(Node source, Node dest, int limit){
		AStarSearchedPath(source, dest, limit);
	}
	
	public void AStarSearchedPath(Node rootNode, Node goal, int limit){
		
		Queue<Node> frontier = new PriorityQueue<Node>(10, comp);
		frontier.add(rootNode);
		
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
				//System.out.println(newNode.name + " - " + n.name + " " + "Straight Dist: " + newNode.stDistance 
				//		+ " inter dist: " + (int)newNode.adjacentNodes.get(n) + " total " + newNode.total);
				frontier.add(newNode);
				
				if(newNode == goal){
					System.out.println("We've reached");
					System.out.print("The path is : ");
				}
			}		
		}
		
		Stack<String> finalPath = new Stack<String>();
		Node temp = goal;
		while(temp != null){
			finalPath.add(temp.name);
			temp = temp.parent;
		}
		
		while(!finalPath.isEmpty()){
			System.out.print(finalPath.pop() + " ");
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