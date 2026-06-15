package days16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author An
 * @date 2026. 6. 2. 오후 2:08:03 
 * @subject
 * @content [정규표현식(Regular Expression)] regex
 * 				ㄴ 문자열 속에 원한느 패턴과 일치하는 문자열을 찾기
 *				위에 사용하는 식
 *				ㄴ 미리 정의된 기호와 식  \\s  [A-Z] * + ? 등등
 *				ㄴ 자바 java.util.regex 패키지
 *							ㄴ Pattern 클래스 - 정규식을 정의
 *							ㄴ Matcher 클래스 - 데이터와 정규식(pattern 객체)을 비교하는 클래스
 *
 *				
 */
public class Ex09 {

	public static void main(String[] args) {

		String[] data = { "bat", "baby", "bonus", "cA", "ca"
				, "co", "c.", "c0", "car", "combat", "count", "date",
				"disc", "fx" , "c"};

//		String regex = "c[a-z]*";
//		String regex = "c[a-z]";
//		String regex = "c[a-zA-Z0-9]";
//		String regex = "c\\w";      // \w == [a-zA-Z0-9]    \W == [^a-zA-Z0-9]

// 		String regex = ".*";          		  // 모든 문자열
// 		String regex = "c.";		  		  // c로 시작하고 뒤에 한문자
// 		String regex = "c\\.";		 		  // 문자 그대로 c. 
// 		String regex = "c[0-9]";	  		  // c 뒤에 숫자 1개
// 		String regex = "c.*t";		  		  // c 로 시작해서 t 로 끝나는 문자열
// 		String regex = "[b|c]";       		  // b 또는 c 또는 | 문자 1개
// 		String regex = "[bc]";        		  // b 또는 c 문자 1개
// 		String regex = "[b-c].*";     		  // b 또는 c 로 시작하는 문자열
// 		String regex = "[^bc].*";     		  // b,c가 아닌 문자로 시작하는 문자열
// 		String regex = ".*a.*";       		  // a를 포함하는 문자열
// 		String regex = "[^bcd].*";    		  // b,c,d 가 아닌 문자로 시작하는 문자열

// 		String regex = "[a-zA-Z].*";  		  // 영문자로 시작하는 문자열
// 		String regex = "[ae-zA-Z].*"; 		  // b,c,d 를 제외한 문자로 시작하는 문자열
 		String regex = "[a-zA-Z&&[^b-d]].*";  // 영문자 중 b, c, d를 제외한 문자로 시작하는 문자열



//      String regex = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*_])[A-Za-z\\d!@#$%^&*_]{8,15}";
 		
 		
		Pattern pattern = Pattern.compile(regex);

		for (int i = 0; i < data.length; i++) {

			Matcher matcher = pattern.matcher(data[i]);
			if(matcher.matches()) {
				System.out.println(data[i]);
			}
		}


		/*String.matches(String regex) 사용 예제
		for (int i = 0; i < data.length; i++) {
			if(data[i].matches(regex)) { 
				System.out.println(data[i]);
			}

		}
		 */
	}

}
