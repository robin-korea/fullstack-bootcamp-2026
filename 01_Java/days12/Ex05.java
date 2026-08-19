package days12;

/**
 * @author An
 * @date 2026. 5. 27. 오후 2:15:27 
 * @subject 1. 기본형 매개변수와 참조형 매개변수
 * @content 2. 기본형 리턴자료형과 참조형 리턴자료형
 *             Point 클래스 사용
 */
public class Ex05 {

	public static void main(String[] args) {
		
		// 1. 기본형 매개변수와 참조형 매개변수
		//        ㄴ 기본형 매개변수 설명
		//        ㄴ 메소드 추가: x,y 좌표값을 매개변수 만큼 이동시키는 메소드
		
		//        ㄴ 참조형 매개변수
		//        ㄴ 메소드 추가: p1, p2 두 좌표값을 합하는 메소드
		
		Point p1 = new Point(5, 10);
//		p1.dispPoint();
//		p1.offsetPoint(50);
		p1.dispPoint();
		
		
		
		
		Point p2 = new Point(2, 3);
		p2.dispPoint();
		
		
	}

}
