package days05;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		int n;
		String result;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수(n)을 입력해 주세요 : ");
		n = sc.nextInt();
	
		if(n % 2 == 0) {
			result = "짝수";
		}
		else {
			result = "홀수";
		}
		
		System.out.printf("%d는 %s 입니다.\n",n, result);
		
		switch (n % 2) {
		case 0: 
			result = "짝수";
			break;
		
		default:
			result = "홀수";
			break;
		}
		
		System.out.printf("%d는 %s 입니다.\n",n, result);
		
	}//main

}//class


/*
* 1. 정수(n)을 입력받아서 홀수/짝수 출력하는 코딩.
*   1) if문 사용해서 풀기
*   2) switch문 사용해서 풀기
*   
*   
*/