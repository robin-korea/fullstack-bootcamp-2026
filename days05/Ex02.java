package days05;

import java.util.stream.IntStream;

public class Ex02 {

	public static void main(String[] args) {
		
//		int sum = 0;
//		for (int i = 0; i <= 10; i++) {
//			System.out.printf("%d+",i);
//			sum += i;
//		}
//		System.out.printf("=%d",sum);
		
		
//		int sum = 0;
//		int i = 10;
//		
//		while (i > 0) {
//			System.out.printf("%d+",i);
//			sum += i;
//			i--;
//		}
//		System.out.printf("=%d",sum);
//		
//		람다와 스트림
		
		int sum = IntStream.rangeClosed(1, 10).sum();
		System.out.println(sum);
		
		
	}

}
