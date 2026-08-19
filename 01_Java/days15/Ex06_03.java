package days15;

import java.util.Arrays;
import java.util.Random;

public class Ex06_03 {

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
			}  catch (ArrayIndexOutOfBoundsException e) {  // 다중 catch문 (상속 관계 이면 부모 클래스 조건이 아래로 가야함)
				//Unreachable catch block for ArrayIndexOutOfBoundsException. It is already handled by the catch block for Exception
				System.out.println("> 배열 m의 다 채워졌습니다");
				// break;
				
				m = Arrays.copyOf(m, m.length + 5);
				
			} catch (ArithmeticException e) {
				// System.out.println(e.toString());
				i--;
			}
			catch (Exception e) {    
				
			}
		} // for

	}

}
