package days18;

/**
 * @author An
 * @date 2026. 6. 5. 오후 3:42:06 
 * @subject 열거형(enum)
 * @content    ㄴ jdk 1.5 새로 추가
 * 			   ㄴ 서로 관련있는 상수들의 집합을 클래스로 선언한 것. 
 *             ㄴ 정의
 *             [접지] enum 열거형이름{
 *             		상수명,
 *             		상수명,
 *             		상수명,
 *             	      :
 *             }
 *             ㄴ 사용방법
 *                열거형이름. 상수명
 *
 */
public class Ex14 {

	public static void main(String[] args) {
		
		Card card = Card.HEART;
		
		System.out.println(Card.CLOVER); // CLOVER
		System.out.println(Card.CLOVER.name()); // "CLOVER" 문자열
		System.out.println(Card.CLOVER.ordinal()); // 0 (순번)
	
		
	}

}