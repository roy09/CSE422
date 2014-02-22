package adj_matrix;

import java.util.Scanner;

class Diamond {
	public static void main(String[] args) {

		Scanner ns = new Scanner(System.in);
		System.out.println("input hight");
		int a = ns.nextInt();

		int hight = a * 2;

		for (int i = 0; i < a; i++) {

			for (int j = 0; j < hight; j++) {
				if (j <= a + i && j >= a - i) {
					System.out.print("*");
				}

				else {
					System.out.print(".");
				}
			}

			System.out.println();
		}
	}
}
