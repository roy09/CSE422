package Assignments;

import java.util.Scanner;

/*Make an executable file that asks some questions about Madagaskar 
 * understanding the context
 */
public class task0 {
	
	public static void main(String[] args){
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Have you heard about Madagaskar? Oh answer in either in 'YES' or 'NO'");
		String answer = keyboard.nextLine();
		
		if (answer.equals("yes")){
			System.out.println("Where is it?");
			answer = keyboard.nextLine();
			
			System.out.println("Well, I personally have no idea");
			System.out.println("But I hear it's some island. And when I think about islands, I think of a nice shiney weather. What about you?");
			answer = keyboard.next();
			questionAsked(answer);
			
			System.out.println("Ah, wait. My batter is dying. Wish I could talk more. But now I really goota go");
			answer = keyboard.next();
			
			questionAsked(answer);
			
			answer = keyboard.next();
			System.out.println("Bye");
			
		} else if (answer.equals("no")){
			System.out.println("Well, if you don't know about anything, I don't want to talk about anything");
		} else {
			System.out.println("Well, did I not say to answer in yes or no? Learn to be presice. Then try to talk with me.");
		}
		
		
		
	}
	
	public static void questionAsked(String line){
		for(int count = 0; count < line.length(); count++){
			if (line.charAt(count) == '?'){
				System.out.println("You ask a lot of questions. Unfortunately I'm not in the mood to answer today");
			}
		}
	}
}
