package days21.sec09;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex02 {

	public static void main(String[] args) {
		
		/* String[] -> Stream<String> 변환
		String [] arr = {"홍길동","조지훈","문규리","신창만"};
		
		Stream<String> stream = Arrays.stream(arr);
		stream.forEach(System.out::println);
		*/
		
		// int [] -> IntStream 변환
		int [] m = {1,2,3,4,5};
		IntStream is = IntStream.of(m);
		is.forEach(System.out::println);
		
		
	}

}
