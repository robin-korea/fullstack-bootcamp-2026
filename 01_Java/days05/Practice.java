package days05;

import java.util.stream.IntStream;

public class Practice {

	public static void main(String[] args) {
		
		// 목표: 1부터 10까지의 숫자 중에서 5보다 큰 수(6, 7, 8, 9, 10)만 걸러내서 다 더하고 싶습니다.
		
		int result = IntStream.rangeClosed(1, 10).filter(i -> i > 5).sum();
		
		System.out.println(result);
		
		// 목표: 1부터 5까지의 숫자가 들어오면, 각각의 숫자에 5를 더해서(i + 5) 출력하고 싶습니다. (결과: 6, 7, 8, 9, 10 출력)
		
		
		
	}

}
