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
public class Ex_09_02 {

	public static void main(String[] args) {
		
		
//		String name = "홍길동";
//		byte korea = 89;
//		byte english = 87;
//		byte math = 56;
//		// Type mismatch: cannot convert from int to short
//		short sum = (short) (korea + english + math);
//		// double avg = sum / 3D;
//	    double avg = (double) sum / 3;
//		
//		System.out.printf("%s 국:%d, 영:%d, 수:%d, 총점:%d, 평균:%f",name,korea,english,math,sum,avg);
		
		
		String name = "홍길동";
		byte kor = 65;
		byte eng = 32;
		byte his = 45;
		short sum = (short) (kor + eng + his);
		double avg = (double) sum / 3;
		
		System.out.printf("%s 의 국어 점수:%d 수학 점수:%d, 역사 점수:%d, 총점:%d, 평균 %.2f", name, kor, eng, his, sum, avg);
		
		
	}//main

}//class
