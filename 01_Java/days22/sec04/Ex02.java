package days22.sec04;

import java.util.Arrays;

/**
 * @author An
 * @date 2026. 6. 11. 오전 10:30:52 
 * @subject 루핑 
 * @content  ㄴ 스트림에서 요소를 하나씩 반복해서 가져와 처리하는 것
 *           ㄴ forEach(), peek()
 *                XXX Consumer.accept()
 *
 */
public class Ex02 {

	public static void main(String[] args) {
		
		int [] m = {1,2,3,4,5};
		
		// 배열 -> 스트림
		
		Arrays.stream(m) //IntStream 변환
			.peek(System.out::println)      // 중간 처리 메서드
			.filter(n -> n%2 == 0)          // 중간 처리 메서드
			.forEach(System.out::println);  // 최종 처리 메서드
		
		int total = Arrays.stream(m)
						.filter(n -> n%2 == 0)
						.peek(System.out::println)
						.sum();            // 최종 메서드
		System.out.println("총 짝수 합: " + total);
	}

}
