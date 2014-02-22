package bfs_dfs_adj_list;

public class Main {
	public static void main(String[] args) {

		Node frankfurt = new Node("frankfurt");
		Node mannheim = new Node("mannheim");
		Node wurzburg = new Node("wurzburg");
		Node stuttgard = new Node("stuttgard");
		Node kassel = new Node("kassel");
		Node karlsruhe = new Node("karlsruhe");
		Node erfurt = new Node("erfurt");
		Node numberg = new Node("numberg");
		Node augsburg = new Node("augsburg");
		Node munchen = new Node("munchen");

		Graph g = new Graph();

		g.nodes.add(frankfurt);
		g.nodes.add(mannheim);
		g.nodes.add(wurzburg);
		g.nodes.add(stuttgard);
		g.nodes.add(kassel);
		g.nodes.add(karlsruhe);
		g.nodes.add(erfurt);
		g.nodes.add(numberg);
		g.nodes.add(augsburg);
		g.nodes.add(munchen);

		frankfurt.addAdjacentNode(mannheim);
		frankfurt.addAdjacentNode(wurzburg);
		frankfurt.addAdjacentNode(kassel);

		mannheim.addAdjacentNode(karlsruhe);

		karlsruhe.addAdjacentNode(augsburg);

		augsburg.addAdjacentNode(munchen);

		munchen.addAdjacentNode(kassel);
		munchen.addAdjacentNode(numberg);

		wurzburg.addAdjacentNode(erfurt);
		wurzburg.addAdjacentNode(numberg);

		numberg.addAdjacentNode(stuttgard);
		
		//System.out.println("Breadth First Traversed Path: ");
		//g.breadthFirstTraversal(frankfurt);
		System.out.println("Depth First Traversed Path: ");
		g.depthFirstTraversal(frankfurt);
	}
}
