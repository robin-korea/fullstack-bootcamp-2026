package days16;

import java.util.Date;

/**
 * @author An
 * @date 2026. 6. 2. 오후 2:44:14 
 * @subject 날짜 + 시간 다루는 클래스
 * @content jdk 1.0: Date
 * 			jdk 1.1: Calendar
 * 			jdk 1.8: java.time 패키지 안에 다양한 패키지와 클래스 추가
 *
 */
public class Ex10 {

	public static void main(String[] args) {
		
		Date d = new Date();
		
		/*
		System.out.println(d.toLocaleString());
		System.out.println(d.getYear() + 1900);
		System.out.println(d.getMonth() + 1);
		System.out.println(d.getDate());
		System.out.println(d.getHours());
		System.out.println(d.getMinutes());
		System.out.println(d.getSeconds());
		
		// 1780379274798
		System.out.println(d.getTime()); // long 1970.1.1 0:0:0 ~ ms
		
		System.out.println( "일월화수목금토".charAt( d.getDay() ));
		
		*/
		
		// 개강일로부터 오늘날짜가 몇일이 지났는지?
		// 26.5.11
		// 26.6.2
		
		Date startDate = new Date(2026-1900, 5-1, 11,9,0,0);
		System.out.println(startDate.toLocaleString());
		
		Date today = new Date(); 
		System.out.println(today.toLocaleString());
		
		long diff = today.getTime() - startDate.getTime();
		
		System.out.println(diff + "ms");
		System.out.println(diff/1000 + "s");
		System.out.println(diff/1000/60 + "m");
		System.out.println(diff/1000/60/60 + "h");
		System.out.println(diff/(1000*60*60*24) + "d");
		
		// startDate ~ today 까지 for문 돌리면서 요일을 가져와 요일이 토,일 이면 count++ 해서 마지막 day 에서 빼준다
		// 휴일 등록한 날짜 배열
		Date [] holidays = {
				new Date(2026-1900, 5-1, 25),
				new Date(2026-1900, 6-1, 3),
		};
	}

}
