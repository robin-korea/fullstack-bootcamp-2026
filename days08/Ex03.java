package days08;

/**
 * @author An
 * @date 2026. 5. 20. 오전 10:11:53 
 * @subject 재귀 함수
 * @content   ㄴ 함수 안에서 자기 자신을 다시 호출하는 함수
 *
 */
public class Ex03 {

	public static void main(String[] args) {
		
		disp();
		
		
	}

	// 재귀 함수
	public static void disp() {
		System.out.println("> 실행문...");
		System.out.println("> 실행문...");
		disp(); // 다시 자기자신을 호출
		System.out.println("> 실행문...");
		
	}

}
