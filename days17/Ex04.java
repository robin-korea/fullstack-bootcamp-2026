package days17;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author An
 * @date 2026. 6. 4. 오전 9:43:23 
 * @subject
 * @content 형식화 클래스 : 값을 보기 좋은 형태로 바꾸거나(포맷), 문자열을 다시 값으로 파싱하는 클래스
 * 						 SimpleDataFormat, DecimalFormat
 * 			
 * 			j.t.format 패키지
 * 
 *                    ㄴ DataTimeFormatter 형식화 클래스
 */
public class Ex04 {

	public static void main(String[] args) {

		// [2] 시간정보 X, 날짜정보 O 
		//     s -> LocalDate 변환
		String s = "2025년 02월 17일 (월)";
		
		String pattern = "yyyy년 MM월 dd일 (월)";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		LocalDate d = LocalDate.parse(s,dtf);
		System.out.println(d);
		
		/* [B풀이]
		String regex = "(\\d{4})년 (\\d{2})월 (\\d{2})일";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher =  pattern.matcher(s);
		
		int year, month, date;
		year = month = date = 0;
		
		if(matcher.find()) {
//			System.out.printf("%s: %s-%s-%s \n",matcher.group()
//					,matcher.group(1)
//					,matcher.group(2)
//					,matcher.group(3));
			year = Integer.parseInt(matcher.group(1));
			month = Integer.parseInt(matcher.group(2));
			date = Integer.parseInt(matcher.group(3));
		}
		LocalDate d = LocalDate.of(year, month, month);
		System.out.println(d);
		*/
		
		/* [A풀이]
		int year;
		int month;
		int date;

		year = Integer.parseInt(s.substring(0, 4));
		month = Integer.parseInt(s.substring(6, 8));
		date = Integer.parseInt(s.substring(10, 12));

		LocalDate d = LocalDate.of(year, month, date);
		System.out.println(d);
		 */

		/* [1]
		LocalDateTime dt = LocalDateTime.now();
		// 2026-06-04T10:03:50.962277900
		System.out.println(dt);

		// 2026-06-04
		System.out.println(dt.format(DateTimeFormatter.ISO_LOCAL_DATE));

		// 20260604
		System.out.println(dt.format(DateTimeFormatter.BASIC_ISO_DATE));

		// [2025/03/04 화요일 15:16:45.123]
		String pattern = "yyyy/MM/dd E요일 HH:mm:ss.SSS";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		String s = dtf.format(dt);

		// 2026/06/04 목요일 10:10:15.809
		System.out.println(s);
		*/
		}

	}
