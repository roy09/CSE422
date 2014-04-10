package geneticAlgoithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class test {
	public static void main(String[] args) {
		
		singlePop pop1 = new singlePop();
		singlePop pop2 = new singlePop();
		
		singlePop pop3 = new singlePop();
		copy(pop3, pop1);
		pop3.display();
	}
	
	public static void copy(singlePop to, singlePop from){
		for(int count = 0; count < 8; count++){
			for(int count1 = 0; count1 < 8; count1++){
				to.board[count][count1] = from.board[count][count1];
			}
		}
	}
}