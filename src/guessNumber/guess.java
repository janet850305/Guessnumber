package guessNumber;

import java.util.Scanner;

public class guess {
	public int count_A;
	public int count_B;
	public String str;
	public String guess(int number,int guess) {

		
		System.out.println(number);
		do {
		    count_A = 0;
			count_B= 0;
			int inputnumber = guess;
			int new_setnumber1[] = new int[4];
			int new_inputnumber[] = new int[4];

			
			for(int i=0; i<4; i++) {
			 new_setnumber1[i] = (int)((number / Math.pow(10.0, i)) % 10);
			 new_inputnumber[i] = (int)((inputnumber / Math.pow(10.0, i) % 10));
			 if(new_setnumber1[i] == new_inputnumber[i]) {
				 count_A++;
			 }
			}
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(new_setnumber1[i] == new_inputnumber[j] && i != j) {
						count_B++;
					}
				}
			}
			str=count_A + "A" + count_B + "B";
			return str;
			
		}while(count_A != 4);
	
	}

}
