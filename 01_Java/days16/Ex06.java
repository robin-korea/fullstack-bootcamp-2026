package days16;

import java.util.Random;

public class Ex06 {

	public static void main(String[] args) {
		
		// java.util 패키지 안에는 자주 사용되는 유용한 클래스들 있는 패키지이다
		// Arrays 클래스
		//  ㄴ Arrays.toString(배열)
		//  ㄴ Arrays.tobinarySearch(null,0)
		//	ㄴ Arrays.sort(null)
		//	ㄴ Arrays.fill(null, false)
		
		// Random 클래스
		
		Random rnd = new Random();
		System.out.println(rnd.nextBoolean());
		System.out.println(rnd.nextInt());
		System.out.println(rnd.nextDouble());
		System.out.println(rnd.nextInt(1,10)); // 1<= 정수 <10
		
		
	}

}
