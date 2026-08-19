package days17;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author An
 * @date 2026. 6. 4. 오전 9:30:56 
 * @subject
 * @content 
 *
 */
public class Ex03_02 {

	public static void main(String[] args) {
		// 오늘 수업을 시작하고 현재 얼마의 시간이 흘렀는지 체크
		
		LocalTime st = LocalTime.of(9, 0, 0);
		LocalTime nt = LocalTime.now();
		
		Duration d = Duration.between(st, nt);
		
		int d_ns = d.getNano();
		// System.out.println(d_ns);
		
		long d_s = d.getSeconds();
		// System.out.println(d_s);
		
		int m = (int) d.getSeconds()/60;
		int s = (int) d.getSeconds()%60;
		System.out.println(m + "분 " + s + "초가 흘렀다.");
		
		// Duration 에 get 함수에는 SECONDS 랑 NANO 만 가져올 수 있다
		// X System.out.println(d.get(ChronoUnit.MINUTES));
		
		
		
	}

}
