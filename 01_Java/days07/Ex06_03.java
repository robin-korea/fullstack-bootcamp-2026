package days07;

import java.util.Date;

/**
 * @author An
 * @date 2026. 5. 19. 오후 4:36:22 
 * @subject 1년 ~ 2026년 까지 총 몇번의 윤년이 있었는지 계산
 * @content 
 *
 */
public class Ex06_03 {

	public static void main(String[] args) {
		
		Date d = new Date();
		int currentYear = d.getYear()+1900;
		
		int count = currentYear/4 - currentYear/100 + currentYear/400;
		
		

		
		/* 1번 풀이
		int count = 0;
		for (int i = 1; i <= currentYear; i++) {
			if(Ex06.isLeapYear(i)) {
			 count++;
			}
		}
		System.out.printf("%d번",count);
		*/
	}
}
