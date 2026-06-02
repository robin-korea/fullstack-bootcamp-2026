package days16;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author An
 * @date 2026. 6. 2. 오후 3:16:23 
 * @subject Calendar 추상클래스
 * @content 
 *
 */
public class Ex10_02 {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		
		// GregorianCalendar Calendar 클래스의 자식
		// Calendar c = new GregorianCalendar();
		
		System.out.println(c.get(Calendar.YEAR)); // 2026
		
		System.out.println(c.get(Calendar.MONTH)+1);
		System.out.println(c.get(Calendar.DATE));
		System.out.println(c.get(Calendar.DAY_OF_YEAR));   // 2
		System.out.println(c.get(Calendar.DAY_OF_MONTH));  // 153
		
		
		System.out.println(c.get(Calendar.HOUR));        // 3
		System.out.println(c.get(Calendar.HOUR_OF_DAY)); // 15
		System.out.println(c.get(Calendar.MINUTE));
		System.out.println(c.get(Calendar.SECOND));
		System.out.println(c.get(Calendar.MILLISECOND));
		
		// Date     일(0) 월(1) ~ 토(6)
		// Calendar 일(1) 월(2) ~ 토(7)
		System.out.println(c.get(Calendar.DAY_OF_WEEK)); // 화(3)
		
		
		// c 객체의 그 달의 마지막 날짜가 몇 일까지?
		int lastDate = c.getActualMaximum(Calendar.DATE);
		System.out.println(lastDate);
		
		
		
	}

}
