package days22.sec05;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

/**
 * @author An
 * @date 2026. 6. 11. 오전 11 :11:37 
 * @subject OptionalXXX 클래스
 * @content   1) 집계값만 저장 X
 * 			  2) 집계값이 유무 -> 처리
 *
 */
public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 제네릭 T 기본형 사용 X
		List<Integer> list = new ArrayList<>();
		
		
		list.stream()
			.mapToInt(Integer::intValue)
			.average()
			// .orElse(0) 최종 메서드여서 중간에 못쓰인다.
			.ifPresent(System.out::println);
		
		// [3]
//		double avg = list.stream()
//				.mapToInt(Integer::intValue)
//				.average()
//				.orElse(0);  // 집계값이 존재하지 않으면 0으로 초기화
			
		
		
		
		// [2]
//		OptionalDouble opAvg = list.stream()
//				.mapToInt(Integer::intValue)
//				.average();
//		
//		if(opAvg.isPresent()) { // 집계한 평균값이 존재 true/false
//			System.out.println(opAvg.getAsDouble());
//		}else {
//			System.out.println("0.0");
//		}
		
		// [1]
//		if(!list.isEmpty()) {
//			double avg = list.stream()
//					.mapToInt(Integer::intValue) // IntStream 클래스명::정적메서드
//					.average()
//					.getAsDouble();
//			
//			System.out.println(avg);			
//		}
		
	}

}
