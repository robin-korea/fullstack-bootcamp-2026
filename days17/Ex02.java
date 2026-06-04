package days17;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @author An
 * @date 2026. 6. 4. 오전 9:08:38 
 * @subject [Temporal + Adjusters 클래스]
 * @content   시간상의      조정자   클래스
 * 
 * 			날짜 시간 조정: 수정 plus(), plusXXX(), minus(), minusXXX()
 * 							 with(), withXXX()
 *
 */
public class Ex02 {

	public static void main(String[] args) {
		
		LocalDate d = LocalDate.now();
		System.out.println(d); // 2026-06-04
		
		// [1] 이번 달의 첫 번째 월요일? 6/1(월)
		d.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		
		d.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));
		
		


	}

}
