package days04;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author An
 * @date 2026. 5. 14. 오후 2:12:08 
 * @subject [if 조건문 연습 예제]
 * @content 
 *
 */
public class Ex08_03 {

	public static void main(String[] args) throws IOException{

		int n;
		
		Scanner sc = new Scanner(System.in);
		
		//F6
		System.out.print("> n 값을 입력하세요: "); // 중단점(breakpoint)
		n = sc.nextInt();
		
		if(n % 2 == 0) { // 짝수
			System.out.printf("> n=%d (짝수) \n",n);
			
		}//if
		
		if(n % 2 == 1) { // 홀수
			System.out.printf("> n=%d (홀수) \n",n);
			
		}//if
		
		System.out.println("END");
		

	}// main

}// class
