package days22.sec04;

import java.util.Arrays;

/**
 * @author An
 * @date 2026. 6. 11. 오전 10:41:26 
 * @subject 요소들이 특정 조건에 만족하는지 여불르 조사하는 최종 처리 기능
 * @content allMatch(), anyMatch(), noneMatch() 메서드
 *
 */
public class Ex03 {

	public static void main(String[] args) {
		
		int [] m  = {1,2,3,4,5};
		
		// 1) m 배열의 모든 정수값이 짝수인지를 체크 -> 
		boolean result = Arrays.stream(m)
							.allMatch( n -> n%2 == 0);
		
		if(result) {
			System.out.println("모두 짝수이다.");
		}else {
			System.out.println("모두 짝수가 아니다.");
		}
		
		result = Arrays.stream(m)
				.anyMatch( n -> n%2 == 0);
		
		if(result) {
			System.out.println("최소 한개의 짝수 존재.");
		}else {
			System.out.println("모두 짝수가 아니다.");
		}
		
		// 모두 짝수가 아닌 경우에만 true 값을 반환한다
		result = Arrays.stream(m)
				.noneMatch( n -> n%2 == 0);
		
		
	}

}
