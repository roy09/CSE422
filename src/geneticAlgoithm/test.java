package geneticAlgoithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class test {
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
		//we need the pos of two mins
		int min1Val = array[0];
		int min2Val = array[0];
		int min1Pos = 0;
		int min2Pos = 0;
		
		for(int count = 0; count < 10; count++){
			if(min1Val > array[count]){
				min1Val = array[count];
				min1Pos = count;
			}
		}
		
		for(int count = 0; count < 10; count++){
			if(min1Pos == count){
				continue;
			}
			if(min2Val > array[count]){
				min2Val = array[count];
				min2Pos = count;
			}
			
		}
		
		System.out.println(min1Pos + " " + min1Val);
		System.out.println(min2Pos + " " + min2Val);
	}

}