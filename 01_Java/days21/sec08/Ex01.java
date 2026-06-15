package days21.sec08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.ToIntFunction;

/**
 * @author An
 * @date 2026. 6. 10. 오전 11:28:54 
 * @subject 중간처리, 최종라인
 * @content 파이프라인
 *
 */
public class Ex01 {

	public static void main(String[] args) {

		/*
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("조지훈",90));
		list.add(new Student("문규리",87));
		list.add(new Student("오수빈",95));
		list.add(new Student("신창만",65));
		list.add(new Student("양인석",45));
		 */
		List<Student> list = Arrays.asList(
				new Student("조지훈",90),
				new Student("문규리",87),
				new Student("오수빈",95),
				new Student("신창만",65),
				new Student("양인석",45)
				);
		
		// Stream<Student> IntStream 
//		list.stream().mapToInt(new ToIntFunction<Student>() {
//
//			@Override
//			public int applyAsInt(Student s) {
//				return s.getScore();
//			}
//		});
		
		// Stream<Student> IntStream           OptionalDouble
		OptionalDouble avg = list.stream().mapToInt(s -> s.getScore()).average();
		
		System.out.println(avg.getAsDouble()); // double 자료형
	}

}
