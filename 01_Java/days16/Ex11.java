package days16;

import java.util.Calendar;
import java.util.Date;

public class Ex11 {

	public static void main(String[] args) {
		
		// 1. Calendar -> Date 반환
		Calendar c = Calendar.getInstance();
		Date d = c.getTime(); // 리턴 자료형이 Date
		
		// 2. Date     -> Calendar 반환
		c.setTime(d);
		
	}

}
