package Assignments;

import java.util.Scanner;

public class task1 {
	public static void main(String[] args) {
		boolean flag0 = false, flag1 = false, flag2 = false;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the number");
		String input = in.nextLine();

		for (int count = 0; count < input.length(); count++) {
			int deal = Character.getNumericValue(input.charAt(count));
			
			// dealing with first zero
			if (!flag0 && deal == 0) {
				flag0 = true;
				continue;
			}

			// dealing with second zero
			if (flag0 && deal == 0 && !flag1) {
				flag1 = true;
				continue;
			}
			
			// dealing with final one
			if (flag0 && flag1 && !flag2 && deal == 1){
				flag2 = true;
				break;
			}
			

		}
		
		if(flag2){
			System.out.println("Final state is reached");
		} else {
			System.out.println("Number is rejected");
		}

	}
}
