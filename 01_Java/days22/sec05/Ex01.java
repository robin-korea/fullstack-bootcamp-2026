package days22.sec05;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

/**
 * @author An
 * @date 2026. 6. 11. 오전 10:48:34 
 * @subject 최종 처리 기능으로 요소들을 처리해서 
 * 			카운팅, 합계, 평균값, 최대값, 최소값 등 하나의 값으로 산출하는 것
 * 			count     sum    average max min, findFirst 등등
 *           long     int    OptionalXXX ~
 * @content 
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		
		int [] m = {1,2,3,4,5};
		
		// 짝수의 갯수
		long count = Arrays.stream(m).filter(n -> n%2 == 0).count();
		System.out.println("2의 배수의 갯수 : " + count);
		
		// 짝수의 총합
		long sum = Arrays.stream(m).filter(n -> n%2 == 0).sum();
		System.out.println("2의 배수의 갯수 : " + sum);
		
		// 짝수의 평균
		OptionalDouble avg = Arrays.stream(m).filter(n -> n%2 == 0).average();
		System.out.println("2의 배수의 평균 : " + avg.getAsDouble());
		
		// 짝수 최댓값
		OptionalInt max = Arrays.stream(m).filter(n -> n%2 == 0).max();
		System.out.println("2의 배수의 최대값 : " + max.getAsInt());
		
		// 짝수 중에 첫 번째 요소
		OptionalInt first = Arrays.stream(m).filter(n -> n%2 == 0).findFirst();
		System.out.println(first.getAsInt());
	}

}
