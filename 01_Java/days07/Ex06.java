package days07;

import java.util.Scanner;

/**
 * @author An
 * @date 2026. 5. 19. 오후 3:05:12 
 * @subject 메소드 선언 + 제어문 예제
 * @content 년도를 입력받아서 윤년/평년 출력 코딩
 *             1) 년도를 입력받앙서 반환하는 메서드 : int getYear()
 *             2) 윤년/평년 체크하는 메서드       : boolean isLeapYear(입력받은년도)
 */

public class Ex06 {

	public static void main(String[] args) {
		
		int year = getYear();
		
		if(isLeapYear(year)) {
			System.out.println("윤년");
		}else {
			System.out.println("평년");
		}
		
	}

	public static boolean isLeapYear(int year) {
		
		if(year%4==0 && year%100!=0 || year % 400 == 0) { // 치윤법
			return true;
		}else {
			return false;
		}
	}

	public static int getYear() {
		// 유효한 년도는 1 이상의 정수...
		
		Scanner sc = new Scanner(System.in);
		int year;
		String sYear;
		do{
			System.out.print("> 년도 입력: ");
			sYear = sc.next();
		}while(!sYear.matches("^[1-9][0-9]*$"));
		
		year = Integer.parseInt(sYear);
		return year;
	}

}

