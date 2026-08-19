package days22.sec05;
import java.util.Arrays;
import java.util.function.IntBinaryOperator;

/**
 * @author An
 * @date 2026. 6. 11. 오전 11:26:52 
 * @subject 스트림은 기본 집계 메소드인 sum(), average(), count(), max(), min()을 제공하지만, 
 * 			다양한 집계 결과물을 만들 수 있도록 reduce() 메소드도 제공
 * @content 
 *
 */
public class Ex03 {

	public static void main(String[] args) {
		
		int [] m = {1,2,3,4,5};
		
		// 총합 출력
		int sum = Arrays.stream(m).sum();
		System.out.println(sum);
		
		// reduce() 요소를 줄여나가면서 => 집계
		sum = Arrays.stream(m).reduce(0,(left, right) -> left + right);
		System.out.println(sum);
	}

}
