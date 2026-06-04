package days17;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @author An
 * @date 2026. 6. 4. 오전 9:21:05 
 * @subject 날짜-날짜 간격: Period 클래스
 * @content 시간-시간 간격: Duration 클래스
 *
 */
public class Ex03 {

	public static void main(String[] args) {
		// 개강일로 부터 오늘까지 몇 일이 지났는지 일수 파악
		LocalDate od = LocalDate.of(2026, 5, 11);
		LocalDate td = LocalDate.now();
		// System.out.println(od); // 2026-05-11
		
		// between() 메소드를 통해서 날짜 간의 간격차를 Period 객체로 얻어온다
		//                       od<=  <td
		Period p = Period.between(od, td);
		System.out.println(p.getYears());    // 0
		System.out.println(p.getMonths());   // 0
		System.out.println(p.getDays());     // 24
		
		System.out.println(p.get(ChronoUnit.YEARS));
		System.out.println(p.get(ChronoUnit.MONTHS));
		System.out.println(p.get(ChronoUnit.DAYS));
	}

}
