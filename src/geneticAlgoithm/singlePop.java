/**
 * 
 */
package geneticAlgoithm;

import java.util.Random;

/**
 * @author roy
 * 
 */
public class singlePop {
	int[][] board;
	int[] collisiontable = { 0, 1, 3, 6, 10, 15, 21 };

	public singlePop() {
		board = new int[8][8];
		this.putRandomQueens();
	}

	public void putRandomQueens() {
		Random randomGenerator = new Random();
		for (int i = 0; i < 8; i++) {
			int index = (int) (Math.random() * 7);
			board[i][index] = 1;
		}
	}

	public void display() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println("Collisions :" + this.collisions());
	}

	public int collisions() {
		int collisions = 0;

		int temp = -1;
		// find in the same row
		for (int i = 0; i < 8; i++) {
			temp = -1;
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == 1) {
					temp++;
				}
			}
			if (temp != -1) {
				collisions += collisiontable[temp];
			}
		}

		// find in the same column
		for (int i = 0; i < 8; i++) {
			temp = -1;
			for (int j = 0; j < 8; j++) {
				if (board[j][i] == 1) {
					temp++;
					// System.out.println("temp increased to " + temp + "for " +
					// i + "" + j);

				}
			}
			if (temp != -1) {
				collisions += collisiontable[temp];
				// System.out.println(collisions);
			}
		}
		int prev = collisions;
		
		// //find diagonally
		for (int i = 0; i < board.length; i++) {
			int firstIndex = i;
			int secondIndex = 0;
			temp = -1;
			for (int count = 0; count < 8; count++) {
				try {
					// System.out.print(board[firstIndex][secondIndex]);
					if (board[firstIndex][secondIndex] == 1) {
						temp++;
						// System.out.println("wow" + firstIndex + "" +
						// secondIndex);
					}
				} catch (Exception e) {
					break;
				}
				firstIndex++;
				secondIndex++;

			}
			if (temp != -1) {
				collisions += collisiontable[temp];
				// System.out.println();
				// System.out.println("Collision increased to " + collisions);
			}
			// System.out.println();
			// System.out.println(temp);
		}
		// System.out.println("col " + collisions);
		// System.out.println("bakigulo");
		for (int i = 1; i < board.length; i++) {
			int firstIndex = 0;
			int secondIndex = i;
			temp = -1;
			for (int count = 0; count < 8; count++) {
				try {
					// System.out.print(board[firstIndex][secondIndex]);
					if (board[firstIndex][secondIndex] == 1) {
						temp++;
					}
				} catch (Exception e) {
					break;
				}
				firstIndex++;
				secondIndex++;

			}
			if (temp != -1) {
				collisions += collisiontable[temp];
			}
			// System.out.println();
			// System.out.println(temp);

		}

		// ================================================

		for (int i = 0; i < 8; i++) {
			int firstIndex = i;
			int secondIndex = 7;
			temp = -1;
			for (int count = 0; count < 8; count++) {
				try {
//					System.out.print(board[firstIndex][secondIndex]);
					// System.out.print(firstIndex + "" + secondIndex + " ");
					if (board[firstIndex][secondIndex] == 1) {
						temp++;
						// System.out.println("wow" + firstIndex + "" +
						// secondIndex);
					}
				} catch (Exception e) {
					break;
				}
				firstIndex++;
				secondIndex--;

			}
			if (temp != -1) {
				collisions += collisiontable[temp];
//				System.out.println("Collision increased to " + collisions);
			}
//			System.out.println();
			// System.out.println("Collision increased to " +
			// collisions);

		}
//		System.out.println();
		// System.out.println(temp);
//		System.out.println("=======================");

		for (int i = 6; i >= 0; i--) {
			int firstIndex = 0;
			int secondIndex = i;
			temp = -1;
			for (int count = 0; count < 8; count++) {
				try {
//					System.out.print(board[firstIndex][secondIndex]);
					// System.out.print(firstIndex + "" + secondIndex + " ");
					if (board[firstIndex][secondIndex] == 1) {
						temp++;
						// System.out.println("wow" + firstIndex + "" +
						// secondIndex);
					}
				} catch (Exception e) {
					break;
				}
				firstIndex++;
				secondIndex--;

			}
			if (temp != -1) {
				collisions += collisiontable[temp];
			}
			// System.out.println();

		}
		// System.out.println();

//		System.out.println(collisions - prev);

		return collisions;

	}
}
