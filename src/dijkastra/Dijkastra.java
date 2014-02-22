package dijkastra;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkastra {

	boolean complete = false;
	Queue<Node> paths = new PriorityQueue<>(10, comp);
	
	public Dijkastra(Node n) {
		DijkastraResult(n);
	}

	public void DijkastraResult(Node rootNode) {
		
		Node n = rootNode;
		while (!complete) {
			for (Object key : n.adjacentNodes.keySet()) {
				Node newNode = (Node) key;
				//System.out.print("Now checking " + newNode.name + " " + n.adjacentNodes.);
				if (!paths.contains(newNode)) {
					paths.add(newNode);
					System.out.print("added: " + newNode.name);
					System.out.println();
				} else {
					DijkastraResult(newNode);
				}
			}
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
