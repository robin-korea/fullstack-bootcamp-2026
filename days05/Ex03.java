package days05;

import java.util.stream.IntStream;

public class Ex03 {

	public static void main(String[] args) {

		// 홀수 합 출력
//		int sum = 0;
//		for (int i = 1; i <= 10; i++) {
//			if(i % 2 == 0) {
//				continue;
//			}
//			System.out.printf("%d+",i);
//			sum += i;
//		}
//		System.out.printf("=%d",sum);
		
//		int sum = 0;
//		for (int i = 1; i <= 10; i+=2) {
//			System.out.printf("%d+",i);
//			sum += i;
//		}
//		System.out.printf("=%d",sum);
		
		// 1 부터 10 가지 개행으로 출력
		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		
		//람다식을 사용하여 홀수들의 합만 출력
		int sum = IntStream.rangeClosed(1, 10).filter(i -> i%2==1).sum();
		System.out.println(sum);
		
	}
}
