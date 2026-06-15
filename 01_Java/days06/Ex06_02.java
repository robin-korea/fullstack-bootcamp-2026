package days06;

import java.util.Scanner;

public class Ex06_02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0, numberLine = 1; i < 256; i++) {
			if(i % 10 == 0) {
				System.out.printf("%d: ",numberLine);
			}
			System.out.printf("\'%c\'(%d)",(char)i,i);
			
			if(i % 10 == 9) {
				System.out.println();
				if(numberLine % 10 == 0) {
					System.out.println("\t 계속하려면 엔터치세요...");
					sc.nextLine();
				}
				numberLine++;
			}
		}

	}

}
