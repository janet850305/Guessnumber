package guessNumber;
import java.util.Random;
import java.lang.Math;
public class randomNumberset extends guessNumber{
	public int Numberset;
	public boolean boo;

	public randomNumberset(){
		Random ran = new Random();

		do {
		this.Numberset = ran.nextInt(10000);
		}while(testsimilar(boo) == true);
		
	}
	
	public boolean testsimilar(boolean boo){
		int array[] = new int[4];
		
		for(int i=0; i<4; i++) {
			array[i] = (int)((Numberset / Math.pow(10.0, i)) % 10);
		}
		
		for(int i=0; i<4; i++) {
			for(int j=i+1; j<4; j++) {
				if(array[i] == array[j]) {
					return true;
				}
			}
		}
			return false;
		
	}
}
