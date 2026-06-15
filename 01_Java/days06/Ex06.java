package days06;

import java.util.Scanner;

/**
 * @author An
 * @date 2026. 5. 18. 오후 3:17:20 
 * @subject 제어문 + 배열
 * @content 
 *
 */
public class Ex06 {

	public static void main(String[] args) {
		
		/*
		for(int i = 0; i < 256; i++) {
			System.out.printf("\'%c\'(%d)",(char)i,i);
		}
		*/
		Scanner sc = new Scanner(System.in);
		for(int i = 0, lineNumber = 1; i < 256; i++) {
			if(i % 10 == 0) {
				System.out.printf("%d: ",lineNumber);
			}
			
			System.out.printf("\'%c\'(%d)",(char)i,i);
			
			if(i % 10 == 9) {
				System.out.println();
				if(lineNumber % 10 == 0) {
					System.out.println("\t 계속하려면 엔터치세요...");
					sc.nextLine();
				}
				
				lineNumber++;
			}
		}
		

	}

}
