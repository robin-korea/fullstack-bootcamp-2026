package days06;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * @author An
 * @date 2026. 5. 18. 오후 3:05:32 
 * @subject 배열에서 가장 큰값, 작은값
 * @content (람다와 스트림)
 *
 */
public class Ex05_02 {

	public static void main(String[] args) {
		
		OptionalInt oiMax = new Random().ints(1,100).limit(10).max();		
		System.out.println("> 가장 큰 값: " + oiMax.getAsInt());
		
		
		
		// 1번  index : 0~9
//		int [] m = IntStream.rangeClosed(0,10).map(i->ThreadLocalRandom.current().nextInt(1,100)).toArray();
//		System.out.println(Arrays.toString(m));
//		
//		// 가장 큰 값, 작은 값
//		// int [] -> Stream 객체 변환 + max(), min() 메서드를 사용 할 수 있다.
//		OptionalInt oiMax = IntStream.of(m).max();
//		System.out.println("> 가장 큰 값: " + oiMax.getAsInt());
	}

}
