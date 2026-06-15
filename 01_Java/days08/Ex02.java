package days08;

import java.util.Date;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
//		System.out.println(getYear());
//		System.out.println(toLowerCase("sjeAfewD"));
		
		Date d = new Date();
		int currentYear = d.getYear() + 1900;
		System.out.println(isLeapYear(currentYear));
	}

	
	public static String toLowerCase(String s) {
		
		char [] charArr = s.toCharArray();
		String result = "";
		char ch;
		
		for(int i = 0; i < charArr.length; i++) {
			ch = charArr[i];
			if(Character.isUpperCase(ch)) {
				ch = Character.toLowerCase(ch);
			}
			result += ch;
		}
		return result;
		
	}
	
	public static int getYear() {
		
		int year = 0;
		Scanner sc = new Scanner(System.in);
		String sYear;
		
		do{
			System.out.print("년도를 입력해주세요");
			sYear = sc.next();
			
		}while(!sYear.matches("^[1-9][0-9]*$"));
		
		year = Integer.parseInt(sYear);
		return year;
	}
	
	public static boolean isLeapYear(int year) {
		
		if(year%4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		}else {
			return false;
		}
	}
}


/*
 * [ 메소드 선언하는 문제. ]
 * 
 * 1. 문자열을 매개변수로 받아서 소문자로 변환해서 반환하는 메서드를 선언하세요.
 *   메소드명: toLowerCase
 * 2. 1이상의 정수 년도만을 입력받아서 반환하는 getYear 라는 메소드를 선언하세요.
 * 3. 윤년/평년을 체크해서 boolean 으로 반환하는 isLeapYear 라는 메소드를 선언하세요.
 *    
 * */