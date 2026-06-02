package days16;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author An
 * @date 2026. 6. 2. 오후 4:05:23 
 * @subject 날짜를 형식화하는 클래스 : SimpleDateFormat
 * @content   foramat()
 * 			  parse()
 *
 */
public class Ex13 {

	public static void main(String[] args) {
		// [2]
		Calendar c = Calendar.getInstance();
		// 출력형식)  2025/02/28 04:48:00 금요일
		String pattern = "yyyy/MM/dd a hh:mm:ss.SSS E요일";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		String strDate = sdf.format(c.getTime());
		System.out.println(strDate);
		
		/* [1]
		Date d = new Date();
		
		// 2026. 6. 2. 오후 4:06:27
		System.out.println(d.toLocaleString());
		// 2 Jun 2026 07:10:31 GMT
		System.out.println(d.toGMTString());
		
		// 출력형식)  2025/02/28 04:48:00 금요일
		String pattern = "yyyy/MM/dd a hh:mm:ss.SSS E요일";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String strDate = sdf.format(d);
		System.out.println(strDate);
		*/
	}

}
