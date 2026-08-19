package days10;

import java.util.Date;
import java.util.Scanner;

import com.util.Graphic2D;

/**
 * @author An
 * @date 2026. 5. 22. 오후 3:26:24 
 * @subject 
 * @content 
 *
 */
public class Ex10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int year, month;
		
		System.out.print("> 년도, 월 입력: "); // 2000 5
		year = sc.nextInt();
		month = sc.nextInt(); // String regex = "^([1-9]|1[0-2])$"
		
		createCalendar(year, month);

	}

	public static void createCalendar(int year, int month) {
		// [1] 년도, 월의 1일 무슨 요일?
		int dayOfWeek = getDayOfWeek(year,month,1);
		
		// [2] 년도, 월의 몇일 까지 있는지?
		int lastDayOfMonth = getLastDayOfMonth(year,month);			
		
		// [3] 달력 출력
		System.out.printf("\t\t\t[%d년 %d월]\n", year, month );
	    Graphic2D.drawLine(60, '-');
	    String week = "일월화수목금토";
	    for(int i = 0; i < week.length(); i++) {
	    	System.out.printf("\t%c",week.charAt(i));
	    }
	    System.out.println();
	    Graphic2D.drawLine(60, '-');
	    
	    // 1위치를 잡기 위해 \t 해당 요일
	    for(int i = 0; i < dayOfWeek; i++) {
	    	System.out.print("\t");
	    }
	   
	    for(int i = 1; i <= lastDayOfMonth; i++) {
	    	System.out.printf("\t%s",isToday(year,month,i) ? "(" + i + ")" : i+"");
	    	if((i + dayOfWeek) % 7 == 0) {
	    		System.out.println();
	    	}
	    }
	    System.out.println();
	    Graphic2D.drawLine(60, '-');
	}

	public static boolean isToday(int year, int month, int date) {
		Date d = new Date(); // 현재 시스템의 날짜 + 시간 객체
		
		int currentYear = d.getYear() + 1900;
		int currentMonth = d.getMonth() + 1;
		int currentDate = d.getDate();
		
		if(currentYear == year && currentMonth == month && currentDate == date) {
			return true;
		}
		
		return false;
	}

	public static int getLastDayOfMonth(int year, int month) {
		
		int lastDayOfMonth = 0;
		Date d = new Date(year-1900, month-1 ,1);
		
		// 1) 한달 더하기 2026.06.01
		d.setMonth(d.getMonth()+1);

		// 2) 하루를 빼오기 2026.05.31
		d.setDate(d.getDate()-1);
		
		// 3) 날짜(일) 얻어오기
		return lastDayOfMonth = d.getDate();
	}
	
	public static int getDayOfWeek(int year, int month, int date) {
		
		Date d = new Date(year-1900, month-1 ,date);
		int dayOfWeek = d.getDay(); // 0(일) ~ 6(토)

		return dayOfWeek;
	}

}
