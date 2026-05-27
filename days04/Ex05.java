package days04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex05 {

	public static void main(String[] args) throws IOException {
		
		
		String s1 = "홍길동";
		String s2;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("> s2 입력: ");
		s2 = br.readLine();
		System.out.printf("[%s]\n",s2);
		System.out.println(s1 == s2 ? "같다" : "다르다");
		System.out.println(s1.equals(s2) ? "같다" : "다르다");
		
	}//main

}//class
