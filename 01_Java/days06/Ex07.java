package days06;

import java.util.Scanner;

/**
 * @author An
 * @date 2026. 5. 18. 오후 4:11:18 
 * @subject 한 문자를 입력받아서 숫자, 알파벳, 한글, 대문자, 소문자, 특수문자 체크
 * @content 
 *
 */
public class Ex07 {

	public static void main(String[] args) {
		
		char ch;
		Scanner sc = new Scanner(System.in);
		System.out.print("> 한 문자 입력: ");
		ch = sc.next().charAt(0);
		
		System.out.printf("> 입력받은 한 문자: \'%c\'\n",ch);
	}

}
