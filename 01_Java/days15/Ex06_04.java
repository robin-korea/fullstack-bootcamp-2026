package days15;

import java.util.Arrays;
import java.util.Random;

public class Ex06_04 {

	public static void main(String[] args) {

		int number = 100;
		int result = 0;

		Random rnd = new Random();
		int n = -1;
		
		int [] m = new int[5];
		
		for (int i = 0; i < 10 ; i++) {
			try {
				n = rnd.nextInt(5);  
				result = number / n ;
				m[i] = result;
				System.out.println(result);
			}  catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {  
				// 멀티 catch 블럭
				e.printStackTrace();
			} 
			catch (Exception e) {   
				
				
				
				
				
				
				
			}
		} // for

	}

}
