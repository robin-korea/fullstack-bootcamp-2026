package days03;

public class Ex01 {

	public static void main(String[] args) {
		System.out.println("java 3일차 수업");
		
		/*
		 * 자바의 타입
		 * 		기본형
		 * 			숫자형
		 * 				정수형 : byte(1), short(2), int(4), long(8)
		 * 					     -문자형 : char(2)
		 * 				실수형 : float(4), double(8)
		 * 			논리형 : boolean(1)
		 * 		참조형 : 배열, 클래스(String), 인터페이스
		 */
		
		String name = "홍길동";
		byte kor = 90;
		byte eng = 87;
		byte math = 56;
		short sum = (short) (kor + eng + math);
		double avg = (double) sum / 3;
		
		System.out.printf("이름: \"%s\" \n국어: %d \n영어: %d \n수학: %d \n총점: %d \n평균: %.2f",
				name, kor, eng, math, sum, avg);
		
			
		
	}//main

}//class

/*
 * [복습문제]
 * 1. 자바의 타입(Type,자료형) 정리
 * 2. 이름, 국,영,수, 총점, 평균
 *    1) 각각의 변수 선언
 *    2) 초기값 설정
 *    3) 출력형식:
 *       이름: "홍길동"
 *       국어: 90
 *       영어: 87
 *       수학: 56
 *       총점: ???
 *       평균: ??.??
 * 
 * */