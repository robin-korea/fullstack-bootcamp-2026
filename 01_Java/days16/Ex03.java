package days16;

import java.util.StringTokenizer;

/**
 * @author An
 * @date 2026. 6. 2. 오전 11:25:32 
 * @subject   4. StringTokenizer 클래스
 * @content 
 *
 */
public class Ex03 {

	public static void main(String[] args) {
		
		String group1 = "양인석,안정빈,신창만,이지훈,장미성";
		//               token,token,token,token,token
		// group1.split(",") 권장
		
		StringTokenizer tokenizer = new StringTokenizer(group1, ","); 
		
		System.out.println(tokenizer.countTokens());
		
		// hasMoreTokens() : tokenizer 객체 안에 토큰 아직 가지고 있니? true, false 반환
		while(tokenizer.hasMoreTokens()) {
			
			String name = tokenizer.nextToken();
			System.out.println(name);
		}
		
	}

}
