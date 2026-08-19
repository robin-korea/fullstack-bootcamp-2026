package days06;

import java.util.Scanner;

/**
 * @author An
 * @date 2026. 5. 18. 오후 12:32:26 
 * @subject 
 * @content switch 문 사용해보기
 *
 */
public class Ex02_02 {

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

		/*
		switch ( kor / 10 ) {
		case 10:
		case 9:
			System.out.println("수");
			break;
		case 8:
			System.out.println("우");
			break;
		case 7:
			System.out.println("미");
			break;
		case 6:
			System.out.println("양");
			break;
		default:
			System.out.println("가");
			break;
		}
		*/
		
		switch (kor / 10) {
	    case 10, 9 -> System.out.println("수");
	    case 8 -> System.out.println("우");
	    case 7 -> System.out.println("미");
	    case 6 -> System.out.println("양");
	    default -> System.out.println("가");
	}
		
		

	}

}
