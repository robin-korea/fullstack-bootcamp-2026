package days16;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

/**
 * @author An
 * @date 2026. 6. 2. 오후 4:33:39 
 * @subject
 * @content 
 *
 */
public class Ex14_02 {

	public static void main(String[] args) {
		
		// 1. now(), of() 로 객체 생성
		LocalDate d = LocalDate.now();
		System.out.println(d.toString()); // 2026-06-02
		System.out.println(d); // 2026-06-02
		
		// 년
		System.out.println(d.get(ChronoField.YEAR));
		System.out.println(d.getYear());
		// 월
		System.out.println(d.get(ChronoField.MONTH_OF_YEAR));
		System.out.println(d.getMonthValue());
		// 일
		System.out.println(d.get(ChronoField.DAY_OF_MONTH));
		System.out.println(d.getDayOfMonth());
		
		// 요일: 월(1) 화(2) .. 일(7)
		System.out.println(d.get(ChronoField.DAY_OF_WEEK));
		System.out.println(d.getDayOfWeek());
		
		// 윤년체크 메서드
		System.out.println(d.isLeapYear()); // false
		
	}

}
