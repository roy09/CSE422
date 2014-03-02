package iDAStarAlgorithim;

import java.util.Stack;

public class iDAStarSearch {
	
	public iDAStarSearch(Node source, Node dest, int limit) {
		AStarSearchedPath(source, dest, limit);
	}

	public void AStarSearchedPath(Node rootNode, Node goal, int limit) {

		Stack<Node> frontier = new Stack<Node>();
		frontier.push(rootNode);
		boolean pathFound = false;

		while (!frontier.isEmpty()) {
			Node n = (Node) frontier.pop();
			n.visited = true;

			// find the adjacent vertices and push to the stack
			for (Object key : n.adjacentNodes.keySet()) {
				Node newNode = (Node) key;
				if (newNode.visited == true) {
					continue;
				}
				newNode.parent = n;
				newNode.total = newNode.stDistance
						+ (int) newNode.adjacentNodes.get(n);

				frontier.push(newNode);
				//System.out.println("Pushing " + newNode.name + " " + n.name);
				if (newNode == goal) {
					System.out.println("We've reached");
					System.out.print("The path is : ");
					pathFound = true;
				}
			}
		}

		if (!pathFound) {
			System.out.println("The path wasn't found");
		} else {
			Stack<String> finalPath = new Stack<String>();
			Node temp = goal;
			while (temp != null) {
				finalPath.add(temp.name);
				temp = temp.parent;
			}

			while (!finalPath.isEmpty()) {
				System.out.print(finalPath.pop() + " ");
			}
		}

	}
}