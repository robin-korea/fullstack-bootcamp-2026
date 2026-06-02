package days16;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * @author An
 * @date 2026. 6. 2. 오후 3:35:55 
 * @subject 숫자, 날짜, 문자열 -> 원하는 형식으로 출력, 표현 클래스
 * @content 형식화 클래스
 *           1) DecimalFormat    숫자
 *           2) SimpleDateFormat 날짜
 *           3) ChoiceFormat      X
 *           4) MessageFormat     X
 */
public class Ex12 {

	public static void main(String[] args) {
		//[2]
		String strMoney = "₩3,257,600.00";
		
		// System.out.println((int) Double.parseDouble (strMoney.substring(1).replaceAll(",", "")));
		
		String pattern = "\u00A4#,###.00";
		DecimalFormat df = new DecimalFormat(pattern);
		
		try {
			// Number 실수든 정수든 모든 숫자타입을 담을 수 있음
			Number n =  df.parse(strMoney);
			int money = n.intValue();
			System.out.println(money);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/* [1]
		int money = 3257600;
	      //        3,257,600
		String pattern = "\u00A4#,###.00";
		DecimalFormat df = new DecimalFormat(pattern);
		
		String strMoney = df.format(money);
		System.out.println(strMoney);
		*/
		
		
	}	

}
