package days22.sec06;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author An
 * @date 2026. 6. 11. 오후 12:19:57 
 * @subject
 * @content 
 *
 */
public class Ex04 {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		List<Integer> scores = new ArrayList<>();
	      for(int i=0; i<100000000; i++) {  // 1억 번 반복
	         scores.add(random.nextInt(101));
	      }
	      
	      // 스트림 사용해서 평균 출력
	      long start = System.nanoTime();
	      double avg = scores.stream() // Stream<Integer>
	      		// .mapToInt( i -> i.intValue()) // IntStream
	      		.mapToInt(Integer::intValue)
	      		.average()
	      		.getAsDouble();
	      long end = System.nanoTime();
	      long time = end - start;
	      
	      System.out.println("avg: " + avg + ", 일반 스트림 처리 시간: " + time + "ns");
	      
	      start = System.nanoTime();
	      avg = scores.parallelStream() // Stream<Integer>
	      		// .mapToInt( i -> i.intValue()) // IntStream
	      		.mapToInt(Integer::intValue)
	      		.average()
	      		.getAsDouble();
	      end = System.nanoTime();
	      time = end - start;
	      
	      System.out.println("avg: " + avg + ", 일반 스트림 처리 시간: " + time + "ns");
	      
	}

}
