package days09;

/**
 * @author An
 * @date 2026. 5. 21. 오전 11:05:12 
 * @subject
 * @content 
 *
 */
public class Ex03 {

	public static void main(String[] args) {

		String rrn = "830412-2700001";
		// 1. 생년월일 출력 "1983년 4월 12일"

		String birthday = getBirthday(rrn);
		System.out.println(birthday);

	}

	public static String getBirthday(String rrn) {

		int centry = getCentry(rrn);

		int year = centry + Integer.parseInt(rrn.substring(0, 2)); // "83"
		int month =  Integer.parseInt(rrn.substring(2, 4)); // "04"
		int day =  Integer.parseInt(rrn.substring(4, 6)); // "12"

		return String.format("%d년 %d월 %d일",year,month,day);
	}

	private static int getCentry(String rrn) {

		// 1 1900(남) 2 1900(여)
		// 3 2000(남) 4 2000(여)
		// 5 1900(내외국인 남) 6 1900(내외국인 여)
		// 7 2000(내외국인 남) 8 2000(내외국인 여)
		// 9 1800(남) 0 1800(여)

		/* [1] 풀이
		int centry;

		switch (rrn.charAt(7) - '0') { // '2' - '0' = 50 - 48 = 2
			case 1, 2, 5, 6 -> {
				centry = 1900;
			}
			case 3, 4, 7, 8 -> {
				centry = 2000;
			}
			default -> {
				centry = 1800;
			}
		}
		 */

		int centry = switch (rrn.charAt(7)) {
						case '1','2','5','6' -> 1900;
						case '3','4','7','8' -> 2000;
						default -> 1800;
					};
		return centry;
	}

}
