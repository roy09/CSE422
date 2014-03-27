package geneticAlgoithm;

public class main {
	public static void main(String[] args){
		singlePop[] sample = new singlePop[10];
		
		for(int i = 0; i < sample.length; i++){
			sample[i] = new singlePop();
		}
		
		for(int i = 0; i < 5; i++){
			System.out.println("Sample : " + i);
			sample[i].display();
		}
	}
	
}
