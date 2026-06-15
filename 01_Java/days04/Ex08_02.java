package days04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author An
 * @date 2026. 5. 14. 오후 2:12:08 
 * @subject [if 조건문 연습 예제]
 * @content 
 *
 */
public class Ex08_02 {

	public static void main(String[] args) throws IOException{

		int n;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("> n 값을 입력하세요: ");
		n = Integer.parseInt(br.readLine());
		
		System.out.printf("> n=%d\n",n);
		
		System.out.println("END");
		
		
		
	}// main

}// class
