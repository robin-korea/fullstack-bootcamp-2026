package days05;

import java.util.Scanner;

/**
 * 
 * @author An
 * @date 2026. 5. 15. 오전 11:50:40 
 * @subject
 * @content 
 *
 */
public class Ex06_02 {

	public static void main(String[] args) {
		
		int no = 1;
		int maxCount = 3;
		char con = 'y';
		String name;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.printf("\n> [%d] 이름 입력: ", no);
			name = sc.next();
			System.out.printf("이름: %s\n",name);
			
			if(no == maxCount) {
				System.out.print("최대 3번 까지만 입력 가능합니다.\n");
				break;
			}
			
			System.out.print("\n> 이름 입력 계속할래? ");
			con = sc.next().charAt(0);
			no++;
			
		} while (con == 'y' || con == 'Y');
		
		System.out.print("END");
		
		
	}

}
