package days09;

import java.util.Date;

/**
 * @author An
 * @date 2026. 5. 21. 오전 11:35:41 
 * @subject 주민등록번호로 부터 나이 계산 -> 출력
 * @content 한국(세는)나이, 만나이
 *
 *
 *  한국나이 : 올해년도 - 태어난년도 + 1
 *	만나이 : 올해년도 - 태어난년도  생일이 지나지 않은경에는 한살을 더 뺀다
 *
 */
public class Ex03_02 {

	public static void main(String[] args) {
		
		String rrn = "830412-2700001";
		int age = getCountingAge(rrn); // 한국나이
		System.out.println(age);
		age = getAmericanAge(rrn); // 한국나이
		System.out.println(age);


	}

	public static int getAmericanAge(String rrn) {
		
		int americanAge = getCountingAge(rrn) -1;
		
		Date d = new Date();
		
		int bMonth =  Integer.parseInt(rrn.substring(2, 4)); // "04"
		int bDay =  Integer.parseInt(rrn.substring(4, 6)); // "12"
		
		int cMonth = d.getMonth()+1;
		int cDay = d.getDate();
		// 생일 지났는지 확인 (먼저 월부터 확인)
		if(bMonth < cMonth || (bMonth == cMonth && bDay < cDay)) {
			americanAge--;
		}
	
		return americanAge;
	}

	public static int getCountingAge(String rrn) {
		
		Date d = new Date();
		int currentYear = d.getYear()+1900;
		
		String birthday = Ex03.getBirthday(rrn);
		int birthYear = Integer.parseInt(birthday.substring(0,4));
		
		return currentYear - birthYear + 1;
	}

}
