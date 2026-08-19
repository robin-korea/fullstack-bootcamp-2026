package days17;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author An
 * @date 2026. 6. 4. 오전 9:01:38 
 * @subject 날짜 + 시간
 * @content Date, Calendar + 형식화 클래스
 *          j.t 핵심클래스
 *          LocalDate
 *          LocalTime
 *          LocalDateTime 클래스 = LocalDate + LocalTime
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		
		LocalDateTime dt = LocalDateTime.now();
		// 2026-06-04T09:03:54.071080300
		System.out.println(dt);
		
		// dt 시간 정보를 절삭
		dt = dt.truncatedTo(ChronoUnit.DAYS);
		// 2026-06-04T00:00
		System.out.println(dt);
		
		LocalDate d = dt.toLocalDate();
		// 2026-06-04
		System.out.println(d);
		
		LocalTime t = dt.toLocalTime();
		//09:06:07.538343300
		System.out.println(t);
	}

}
