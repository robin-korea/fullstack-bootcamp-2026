package days12;

/**
 * @author An
 * @date 2026. 5. 27. 오전 11:27:58 
 * @subject [생성자(constructor)]
 * @content 위치를 나타낼 때 x좌표, y좌표가 필요하다
 *          -> 위치를 나타내는 속성 + 메소드를 구현하는 클래스 선언 : Point
 *             1) 일종의 메소드이다.
 *             2) 리턴자료형 X(리턴값 자체가 없다), 생성자명 == 클래스명 
 *             3) 매개변수가 없는 생성자: Default 생성자
 *             4) 생성자는 인위적으로 호출 할 수 없다
 *                 ㄴ 언제 호출되는가? 객체 생성될 때 자동으로 호출된다 (new Point();)
 *             5) 생성자의 역할: 필드를 초기화
 *             6) 생성자도 오버로딩 가능
 *             7) 생성자는 상속되지 않는다
 *             8) 생성자가 하나도 없는 클래스인 경우 컴파일러가 컴파일할때 자동으로 default 생성자를 만들어 넣어준다
 *             9) 
 *          
 */
public class Ex04 {

	public static void main(String[] args) {
		
		// 1. Point 객체 선언: p1
		Point p1 = new Point();
		
		/*
		 *  힙                                 스택
		 * [0][0][dispPoint()0x200번지]        [0x100번지]
		 * 0x100번지                             p1   
		 * 인스턴스                               객체
		 * 
		 * Method area
		 * [Point.dispPoint() 0x200번지] // 이건 한번만 만들어진다 첫번째 객체 만들때만 만들어진다
		 */
		
		p1.dispPoint();
		
		
		Point p2 = new Point(3,4);
		
		p2.dispPoint();
		
		

	}

}
