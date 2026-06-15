package days22.sec02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author An
 * @date 2026. 6. 11. 오전 9:17:16 
 * @subject 스트림의 요소를 다른 요소로 변환하는 중간 처리 기능
 * @content [1,2,3] -> 각 요소 *2 -> [2,4,6]
 *  		S[n,s]  -> IntStream score 변환 
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("홍길동", 85));
		list.add(new Student("홍길동", 92));
		list.add(new Student("홍길동", 87));
		
		// Student(T) 요소 -> score IntStream 변환
		// Stream<Student> IntStream
		list.stream().mapToInt(s -> s.getScore())
		.forEach(System.out::println);
		
	}

}
