package days21.sec09;

import java.util.stream.IntStream;

/**
 * @author An
 * @date 2026. 6. 10. 오후 12:17:28 
 * @subject 
 * @content 숫자 범위로부터 스트림 읽기
 *          IntStream 또는 LongStream 의 정적 메소드인
 *          range(), rangeClosed() 메소드로
 *          특정 범위의 정수 스트림을 얻을 수 있음
 */

public class Ex03 {
	
	static int sum = 0;
	
	public static void main(String[] args) {
		
		/*
		// IntStream.rangeClosed(1, 10);
		IntStream stream = IntStream.range(1, 11);
		stream.forEach(System.out::println);
	
		stream.forEach(n -> sum += n);
		System.out.println("총합:" + sum);
	}
	*/
		
		IntStream stream = IntStream.range(1, 11);
		int total = stream.sum();
		System.out.println(total);
	}

}
