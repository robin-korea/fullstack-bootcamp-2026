package days16;

import static java.lang.Math.*;

/**
 * @author An
 * @date 2026. 6. 2. 오전 11:33:13 
 * @subject Math 클래스
 * @content 
 *
 */
public class Ex04 {
	
	public static void main(String[] args) {
		
		/*
		System.out.println(PI);
		System.out.println(E);
		
		System.out.println(random());
		System.out.println(max(1,3));
		System.out.println(min(1,3));
		System.out.println(abs(-3));
		
		double d = 3.141592;
		// 소수점 3자리에서 반올림한 결과 출력 -> 3.14
		
		// return 타입 기억
		// 소수점 1 자리에서 절삭, 절상, 반올림된다
		System.out.println(ceil(45.179)); // 올림 46.0 return 타입 double
		System.out.println(ceil(45.979)); // 올림 46.0
		
		System.out.println(round(45.179)); // 반올림 45 return 타입 long
		System.out.println(round(45.979)); // 올림 46

		System.out.println(floor(45.179)); // 내림 45 return 타입 double
		System.out.println(floor(45.979)); // 내림 45
		*/
		
		// 소수점 3자리에서 반올림한 결과 출력 -> 3.14
		double d = 3.141592;
		System.out.println(round(d));
		double result = round(d*100.0)/100.0;
		System.out.println(result); 
		
	}
}
