package days16;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class Ex04_03 {

	public static void main(String[] args) {
		
		// 시간 정보를 출력
		LocalTime t = LocalTime.now(); 
		// LocalTime t = LocalTime.of(h, m, s);
		
		
		System.out.println(t);

		// 시간
		System.out.println(t.get(ChronoField.HOUR_OF_AMPM));
		System.out.println(t.getHour());
		System.out.println(t.get(ChronoField.HOUR_OF_DAY));
		// 분
		System.out.println(t.getMinute());
		System.out.println(t.get(ChronoField.MINUTE_OF_HOUR));
		// 초
		System.out.println(t.getSecond());
		System.out.println(t.get(ChronoField.SECOND_OF_MINUTE));
		// 밀리초
		System.out.println(t.get(ChronoField.MILLI_OF_SECOND));
		// 나노초
		System.out.println(t.getNano());
		System.out.println(t.get(ChronoField.NANO_OF_SECOND));
	}

}
