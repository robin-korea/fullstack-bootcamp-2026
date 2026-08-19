package days04;

import java.util.Scanner;

/**
 * @author An
 * @date 2026. 5. 14. 오후 3:20:10 
 * @subject 분기문: switch문
 * @content 
 *
 */
public class Ex09 {

	public static void main(String[] args) {

		int n;

		Scanner sc = new Scanner(System.in);

		System.out.print("> 정수(n) 입력: ");
		n = sc.nextInt();
		
		/* 1 
		switch (n % 2) {
		case 0:
			System.out.println("짝수");
			break;

		default:
			System.out.println("홀수");
			break;
		}
		*/
		
		
		/* 2
		String result;
		
		switch (n % 2) {
		case 0:
			result = "짝수";
			break;

		default:
			result = "홀수";
			break;
		}
		
		System.out.println(result);
		System.out.println("END");
		*/
		
		// 3 JDK 14 이상 추가된 내용
		/*
		switch (n % 2) {
		case 0 ->
			System.out.println("짝수");
		
		
		default ->
			System.out.println("홀수");
		}
		*/
		
		//4
		String result = switch (n % 2) {
			case 0 -> "짝수";
			default -> "홀수";
		};
		System.out.println(result);

	}

}
