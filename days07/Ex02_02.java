package days07;

/**
 * @author An
 * @date 2026. 5. 19. 오전 10:40:16 
 * @subject 기본형을 사용하기 편리한 기능을 구현한 물건
 * @content  ㄴ 래퍼(wrapper)클래스
 * 
 * 
 * 			 int -> Integer
 * 			char -> Character
 * 			long -> Long
 * 
 * 
 *
 */
public class Ex02_02 {

	public static void main(String[] args) {
		
		System.out.println(Integer.toBinaryString(10)); // String "1010"
		System.out.println(Integer.toOctalString(10));
		System.out.println(Integer.toHexString(10));
		
		System.out.println(Integer.MAX_VALUE);
		
		int z = Integer.parseInt("100");
		
		
		
	}

}
