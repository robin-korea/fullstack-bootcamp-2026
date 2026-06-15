package days03;

/**
 * @author An
 * @date 2026. 5. 13. 오전 11:38:50 
 * @subject 음수 표현 방법 : (2의 보수법)
 * @content 
 *
 */
public class Ex01_04 {

	public static void main(String[] args) {
		
		byte i = -10;
	      // 10  [0][0][0][0][1][0][1][0]
	      // -10 [1][1][1][1][0][1][1][0]
		
		  // STEP 1 절대값을 구한다 ㅣ-10ㅣ -> 10 -> 00001010
		  // STEP 2 1의 보수를 취한다               11110101
		  // STEP 3 +1을 한다                     11110110
		
		
		 // 10101010 -> 10101001 -> 01010110 -> -86
		
	}//main

}//class
