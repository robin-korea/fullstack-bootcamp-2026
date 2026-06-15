package days02;

/**
 * @author An
 * @date 2026. 5. 12. 오후 4:22:59 
 * @subject 기본형 > 숫자형 > 정수형 설명
 * @content 
 *		byte(1)	 
 *		short(2)
 *		int(4)
 *		long(8)
 *		 +
 *		문자타입 : char(유니코드 2)
 */
public class Ex_09 {

	public static void main(String[] args) {
		
		  // 이름 변수
	      // 국어,영어,수학 변수
	      // 총점
	      // 평균
	      // 출력형식:  홍길동 국:89, 영:87, 수:56, 총점:???, 평균:???
		
		String name = "홍길동";
		int korea = 89;
		int english = 87;
		int math = 56;
		int sum = korea + english + math;
	    float avg = sum / 3;
		
		System.out.printf("%s 국:%d, 영:%d, 수:%d, 총점:%d, 평균:%.2f",name,korea,english,math,sum,avg);
		
		
	}//main

}//class
