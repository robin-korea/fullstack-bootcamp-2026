package days06;

import java.util.Scanner;

/**
 * @author An
 * @date 2026. 5. 18. 오전 10:47:45 
 * @subject 제어문 + 배열
 * @content 	ㄴ if 문 사용
 * 				ㄴ 국어점수 입력 + 유효성 검사
 * 				ㄴ 수/우/미/양/가 출력
 *
 */
public class Ex02 {

	public static void main(String[] args) {

		int kor;
		Scanner sc = new Scanner(System.in);

		boolean isValid = true;

		do {
			System.out.printf("> 국어(kor) 입력: ");
			kor = sc.nextInt();
			
			isValid = true;
			
			if(kor < 0 || kor > 100) {
				System.out.println("0~100 사이의 숫자를 입력해주세요");
				isValid = false;
			}
		} while (!isValid);

		// 0<= kor <=100 -> 수~가
		if ( 90 <= kor) {  // 100
			System.out.println("수");
		}else if ( 80 <= kor) {
			System.out.println("우");
		}else if ( 70 <= kor) {
			System.out.println("미");
		}else if ( 60 <= kor) {
			System.out.println("양");
		}else{
			System.out.println("가");
		}
	}

}
