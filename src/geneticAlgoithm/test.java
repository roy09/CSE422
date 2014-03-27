package geneticAlgoithm;

public class test {
	public static void main(String[] args) {
		int[][] board = new int[8][8];
		board[0][7] = 1;
		board[7][0] = 1;
		board[7][1] = 3;
		board[0][2] = 4;
		board[3][2] = 4;
		board[1][6] = 1;
		board[2][5] = 1;

		display(board);
		int temp = -1;
		int collisions = 0;
		int[] collisiontable = { 0, 1, 3, 6, 10, 15, 21 };

		// //find diagonally

		for (int i = 0; i < 8; i++) {
			int firstIndex = i;
			int secondIndex = 7;
			temp = -1;
			for (int count = 0; count < 8; count++) {
				try {
					System.out.print(board[firstIndex][secondIndex]);
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
				System.out.println("Collision increased to " + collisions);
			}
			System.out.println();
			// System.out.println("Collision increased to " +
			// collisions);

		}
		System.out.println();
		// System.out.println(temp);
		System.out.println("=======================");

		for (int i = 6; i >= 0; i--) {
			int firstIndex = 0;
			int secondIndex = i;
			temp = -1;
			for (int count = 0; count < 8; count++) {
				try {
					System.out.print(board[firstIndex][secondIndex]);
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
			System.out.println();

		}
		System.out.println();

	}

	public static void display(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				// System.out.print(i + "" + j + " ");
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
