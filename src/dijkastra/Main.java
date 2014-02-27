package dijkastra;

public class Main {
	public static void main(String[] args){
		
		//Declaring the Nodes
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		Node F = new Node("F");
		Node G = new Node("G");
		Node H = new Node("H");
		
		//Adjacent Nodes
		A.addAdjacentNodes(B, 20);
		A.addAdjacentNodes(G, 90);
		A.addAdjacentNodes(D, 80);		
		B.addAdjacentNodes(F, 10);
		C.addAdjacentNodes(H, 20);
		C.addAdjacentNodes(F, 50);
		C.addAdjacentNodes(D, 10);
		D.addAdjacentNodes(G, 20);
		D.addAdjacentNodes(C, 10);
		E.addAdjacentNodes(B, 50);
		E.addAdjacentNodes(G, 30);
		F.addAdjacentNodes(C, 10);
		F.addAdjacentNodes(D, 40);
		
		Node[] list = {A, B, C, D, E, F, G, H};
		Dijkstra test = new Dijkstra(list, A);
		
	}
}
