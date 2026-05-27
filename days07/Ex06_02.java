package days07;

/**
 * @author An
 * @date 2026. 5. 19. 오후 3:43:41 
 * @subject 1이상의 정수라면 유효한값
 * @content  그 외에는 유효하지 않는 값이라고 체크.
 * 			(정규표현식 사용)
 *
 */
public class Ex06_02 {

	public static void main(String[] args) {
		
		String year = "80";
		
		if(year.matches("^[1-9][0-9]*$")) { // 1 이상만 체크하는 정규표현식
			System.out.println("유효한 값 O");
		}else {
			System.out.println("유효한 값 X");
		}
		
		
		
		
		
		
		
		
		
		
		/* 1번 풀이
		String one = "A";
		
		if( one.matches("[A-Z]")){  // 'A' <= ch && ch <= 'Z'
			System.out.println("대문자 O");
		}else {
			System.out.println("대문자 X");
		}
		*/
		
	}

}
