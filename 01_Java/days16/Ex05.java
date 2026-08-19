package days16;

public class Ex05 {

	public static void main(String[] args) {
		
		// [Wrapper 클래스]
		// 기본형 -> 기능을 구현한 클래스
		// [오토 박싱/ 오토 언박싱] 용어 이해
		
		int i = 100;
		Integer j = i; // 오토박싱: 기본형 -> 래퍼클래스 객체로 변환
		
		int k = j;    // 오토언박싱: 래퍼클래스 객체 -> 기본형 변환
		
		disp(10);
		//                      String            Object...args
		System.out.printf("%s %d %.2f %c %b","이름",20,3.14,'A',true);
	}
	
	static void disp(Object obj) { // 10(int) -> Intiger -> Object
		System.out.println(obj);
	}
}
