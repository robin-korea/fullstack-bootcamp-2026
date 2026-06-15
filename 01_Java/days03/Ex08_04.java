package days03;

/**
 * @author An
 * @date 2026. 5. 13. 오후 4:43:31 
 * @subject 논리연산자
 * @content (우선순위 암기) ! > && > ||
 *
 */
public class Ex08_04 {

	public static void main(String[] args) {

		// 단축키 목록: Ctrl + shift + L

		/*
		 * 1. 일반 논리 연산자:   !   &&   ||
		 * 
		 *    1) !  부정(Not)연산자
		 *       ㄴ    참(true) 부정하면   거짓
		 *       ㄴ    거짓(false) 부정하면 참(true)
		 * 
		 * 2. 비트 논리 연산자:   ~   &    |    ^(XOR)   X
		 * */
		
//		효율적 연산 (short circuit evaluation) :앞쪽 결과에 의해 뒤에 실행 x
//		|| : 일반 논리 OR 연산자, 논리합
//		참  1 || 참   1 -> 참
//		참  1 || 거짓  0 -> 참
//		거짓 0 || 참  1 -> 참
//		거짓 0 || 거짓 1 -> 거짓
		
		System.out.println(3 < 5 || 10 <= 7);
		
		//		&& : 일반 논리 AND 연산자, 논리곱
//		참  1 && 참   1 -> 참
//		참  1 && 거짓  0 -> 거짓
//		거짓 0 && 참  1 -> 거짓
//		거짓 0 && 거짓 1 -> 거짓
		
		// 비교 > 논리
		System.out.println(3 > 5 && 10 <= 7);
		
		
		
		System.out.println("-".repeat(50));
		
		boolean flag = false;
		System.out.println(flag);
		flag = !flag;
		System.out.println(flag);
		

	}//main

}//class
