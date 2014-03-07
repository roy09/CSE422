package iDAStarAlgorithim;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		
		//Romania City Nodes
		Node Arad = new Node("Arad");
		Node Bucharest = new Node("Bucharest");
		Node Cralova = new Node("Cralova");
		Node Dobreta = new Node("Dobreta");
		Node Fagaras = new Node("Fagaras");
		Node Glurgue = new Node("Glurgue");
		Node Lugoj = new Node("Lugoj");
		Node Mehadia = new Node("Mehadia");
		Node Oradea = new Node("Oradea");
		Node Pitesti = new Node("Pitesti");
		Node RimnicuVilcea = new Node("RimnicuVilcea");
		Node Sibiu = new Node("Sibiu");
		Node Timisoara = new Node("Timisoara");
		Node Zerind = new Node("Zerind");
		
		//Declaring the straight distance
		Arad.setDistance(366);
		Bucharest.setDistance(0);
		Cralova.setDistance(160);
		Dobreta.setDistance(242);
		Fagaras.setDistance(176);
		Glurgue.setDistance(176);
		Lugoj.setDistance(244);
		Mehadia.setDistance(241);
		Oradea.setDistance(380);
		Pitesti.setDistance(10);
		RimnicuVilcea.setDistance(193);
		Sibiu.setDistance(253);
		Timisoara.setDistance(329);
		Zerind.setDistance(374);
		
		//Declaring adjacent nodes
		Arad.addAdjacentNodes(Timisoara, 118);
		Arad.addAdjacentNodes(Zerind, 75);
		Arad.addAdjacentNodes(Sibiu, 140);
		
		Zerind.addAdjacentNodes(Oradea, 71);
		Oradea.addAdjacentNodes(Sibiu, 151);
		Sibiu.addAdjacentNodes(Fagaras, 99);
		Sibiu.addAdjacentNodes(RimnicuVilcea, 80);
		RimnicuVilcea.addAdjacentNodes(Pitesti, 97);
		RimnicuVilcea.addAdjacentNodes(Cralova, 146);
		Cralova.addAdjacentNodes(Pitesti, 138);
				
		Bucharest.addAdjacentNodes(Glurgue, 90);
		Bucharest.addAdjacentNodes(Fagaras, 211);
		Bucharest.addAdjacentNodes(Pitesti, 101);

		Timisoara.addAdjacentNodes(Lugoj, 111);
		Lugoj.addAdjacentNodes(Mehadia, 70);
		Mehadia.addAdjacentNodes(Dobreta, 75);
		Dobreta.addAdjacentNodes(Cralova, 120);
		
		Scanner in = new Scanner(System.in);
		int limit = in.nextInt();
		
		
		int increment = 10;
		
		//setting the first offset
		limit -= increment;
		
		for(int count = 0; count < 10; count++){
			iDAStarSearch test = new iDAStarSearch();
			if (!test.iDAStarSearchedPath(Arad, Bucharest, limit + increment)){
				if (count == 4){
					increment = 100;
				}
				increment += increment;
			} else {
				break;
			}
			
		}
		
		
	}
}
