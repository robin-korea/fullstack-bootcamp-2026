package days04;

import java.util.Scanner;

public class Ex08_04 {

	public static void main(String[] args) {
		
		int n;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("> 정수(n) 입력: ");
		n = sc.nextInt();
		
		String result = "짝수";
		
		
		/* 1번 풀이
		String result = "짝수";
		if (n % 2 == 0) {
			result = "짝수";
			//System.out.println("짝수");
		} else {
			result = "홀수";
			//System.out.println("홀수");
		}
		
		System.out.println(result);
		
		*/
		
		if (n % 2 != 0) {
			result = "홀수";
		}
		
		System.out.println(result);
		
	}

}
