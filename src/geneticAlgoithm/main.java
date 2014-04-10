package geneticAlgoithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class main {
	public static void main(String[] args) {
		singlePop[] sample = new singlePop[10];

		// generate the population
		for (int i = 0; i < sample.length; i++) {
			sample[i] = new singlePop();
		}

		int[] array = new int[sample.length];
		for (int count = 0; count < sample.length; count++) {
			array[count] = sample[count].collisions();
		}

		// Initial population and collision
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();

		// create the next generation with another sample space of 10
		singlePop solution = generationGenerator(sample);
		solution.display();
		System.out.println("Solution has " + solution.collisions()
				+ " collisions");

		// test what's wrong
		// sample[5].display();
		// System.out.println("arekta");
		// sample[6].display();
		//
		// System.out.println();
		// crossOver(sample[5], sample[6]);
		// sample[5].display();
		// System.out.println("onno ta");
		// sample[6].display();

	}

	public static void makeConsistent(singlePop pop) {

		int[][] board = pop.board;
		// System.out.println("here");
		int nQueens = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1) {
					nQueens++;
				}
			}
		}

		boolean valid = false;
		// System.out.println(nQueens);
		while (nQueens > 8) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == 1) {
						board[i][j] = 0;
						// System.out.println("Komalam :/");
						nQueens--;
						if (nQueens == 8) {
							// System.out.println("ok :/");
							valid = true;
							break;
						}
					}
				}

				if (valid) {
					break;
				}

			}

			if (valid) {
				break;
			}
		}
		// System.out.println("out");

		while (nQueens < 8) {
			int random1 = (int) (Math.random() * 8);
			int random2 = (int) (Math.random() * 8);

			if (board[random1][random2] == 0) {
				board[random1][random2] = 1;
				nQueens++;
			}
		}

	}
	
	public static void copy(singlePop to, singlePop from){
		for(int count = 0; count < 8; count++){
			for(int count1 = 0; count1 < 8; count1++){
				to.board[count][count1] = from.board[count][count1];
			}
		}
	}

	public static singlePop generationGenerator(singlePop[] sample) {
		int genCounter = 0;
		boolean solutionFound = false;
		
		
		int a = (int) (Math.random() * 10);
		int b = (int) (Math.random() * 10);
		
		singlePop toReturn = new singlePop();
		singlePop pop1 = sample[a];
		singlePop pop2 = sample[b];
		copy(toReturn, pop1);
		
		System.out.println(toReturn.collisions());
		System.out.println(pop1.collisions());
		System.out.println(pop2.collisions());
		while (genCounter != 100 && !solutionFound) {
			crossOver(pop1, pop2);
			makeConsistent(pop1);
			makeConsistent(pop2);
			// check for the solution
			if (pop1.collisions() == 0) {
				return pop1;
			}
			if (pop2.collisions() == 0) {
				return pop2;
			}
			// check for the minimal
			if (toReturn.collisions() > pop1.collisions()){
				System.out.println("in cause " + toReturn.collisions() + " " + pop1.collisions());
				copy(toReturn, pop1);
			}
			if (toReturn.collisions() > pop2.collisions()) {
				System.out.println("in cause " + toReturn.collisions() + " " + pop1.collisions());

				copy(toReturn, pop2);
			}
			pop1.mutation();
			pop2.mutation();
			makeConsistent(pop1);
			makeConsistent(pop2);
			if (pop1.collisions() == 0) {
				return pop1;
			}
			if (pop2.collisions() == 0) {
				return pop2;
			}
			if (toReturn.collisions() > pop1.collisions()){
				System.out.println("in cause " + toReturn.collisions() + " " + pop1.collisions());
				copy(toReturn, pop1);
			}
			if (toReturn.collisions() > pop2.collisions()) {
				System.out.println("in cause " + toReturn.collisions() + " " + pop1.collisions());

				copy(toReturn, pop2);
			}
			System.out.println("Generation: " + genCounter);
			System.out.println(pop1.collisions() + " " + toReturn.collisions());
			System.out.println(pop2.collisions() + " " + toReturn.collisions());

			genCounter++;
		}

		return toReturn;
	}

	public static void crossOver(singlePop pop1, singlePop pop2) {

		int[][] board1 = pop1.board;
		int[][] board2 = pop2.board;
		// storing the to be lost values in temp array
		int[][] temp = new int[8][8];
		for (int count = 0; count < 8; count++) {
			for (int count1 = 0; count1 < 8; count1++) {
				temp[count][count1] = board1[count][count1];
			}
		}

		int firstIndex = 0;
		for (int count = 0; count < board1.length; count++) {
			int secondIndex = 4;
			int a = 1;
			for (int count1 = 0; count1 < board1[0].length / 2; count1++) {
				// board1[count][count1] = board2[firstIndex][secondIndex++];
				board1[count][count1] = board2[count][count1];
			}
			firstIndex++;
		}

		firstIndex = 0;
		for (int count = 0; count < board1.length; count++) {
			int secondIndex = 4;
			for (int count1 = 0; count1 < board1[0].length / 2; count1++) {
				board2[count][count1] = temp[count][count1];
				// board2[count][count1] = 8;
			}
			firstIndex++;
		}

	}

}

//
// //Mapping the array
// Map map = new HashMap();
// for(int count = 0; count < array.length; count++){
// map.put(array[count], count);
// }
//
// //Sorting the array
// Arrays.sort(array);
//
// //Getting the indexes of the best 4
// for(int count = 0; count < 4; count++){
// System.out.print(map.get(array[count]) + " ");
// }