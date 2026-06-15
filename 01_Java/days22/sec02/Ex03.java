package days22.sec02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author An
 * @date 2026. 6. 11. 오전 9:32:59 
 * @subject
 * @content  [요소를 복수 개의 요소로 변환]
			 flatMapXxx() 메소드 
			     ㄴ 하나의 요소를 복수 개의 요소들로 변환한 새로운 스트림을 리턴

 *
 */
public class Ex03 {

	public static void main(String[] args) {

		//		List<String> list = new ArrayList<String>();
		//		
		//	     list.add("this is java");
		//	     list.add("i am a best developer");
		//	     
		//	     list.stream() // Stream<String>
		//	       .flatMap( s -> Arrays.stream(s.split(" ")))
		//	       .forEach(System.out::println);


		//	     String str = "this is java";
		//	     String [] strArr =  str.split(" ");
		//	     System.out.println(Arrays.toString(strArr));

		// "10" 스트림 생성 -> 변환 -> 10 스트림 변환 -> 최종처리
		List<String> list2 = Arrays.asList("10,20,30","40,50");

		list2.stream()   // Stream<String> -> IntStream 변환 
		.flatMapToInt(data -> {
			String [] strArr = data.split(",\\s*");
			int [] intArr = new int[strArr.length];
			for (int i = 0; i < strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i]);
			}
			return Arrays.stream(intArr);
		})
		.forEach(System.out::println);	
	}

}
