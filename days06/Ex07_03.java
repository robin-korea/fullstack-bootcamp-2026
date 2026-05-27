package days06;

import java.util.Scanner;

public class Ex07_03 {

	public static void main(String[] args) {
		
		String specialCharacters  = "~!@#$%^&*()_-+=`'\":;/?.,<>\\|";
		
		char ch;
		Scanner sc = new Scanner(System.in);
		System.out.print("> 한 문자 입력: ");
		ch = sc.next().charAt(0);
		
		int index = specialCharacters.indexOf(ch);
		System.out.println(index);
		
		if(index == -1) {
			System.out.println("특수문자 X");
		}else {
			System.out.println("특수문자 O");
		}
		
		//람다 스트림 형식
		boolean isInclude = specialCharacters.chars().anyMatch(c -> c == ch);
		System.out.println(isInclude);
	}

}
