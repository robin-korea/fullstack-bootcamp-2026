package days03;

/**
 * @author An
 * @date 2026. 5. 13. 오후 5:15:48 
 * @subject 대입연산자 : =
 * @content 복합대입연산자 : +=  -=  *=  /= 등등
 *
 */
public class Ex08_05 {

	public static void main(String[] args) {
		
		 int n = 10; // =  대입연산자      
	      System.out.printf("> n=%d\n", n);      
	      // n = n + 5; // 10 + 5
	      n += 5;
	      System.out.printf("> n=%d\n", n); // 15      
	      // n = n - 3;
	      n -= 3;
	      System.out.printf("> n=%d\n", n); // 12      
	      // n = n * 2;
	      n *= 2;
	      System.out.printf("> n=%d\n", n);
		
		
	}//main

}//class
