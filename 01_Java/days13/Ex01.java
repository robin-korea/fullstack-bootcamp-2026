package days13;

import days12.Point;

public class Ex01 {

	public static void main(String[] args) {
		
		/* this 의 3가지 용도 
		 *  1) 멤버를 가리킬 때의 this 용도
		 *  2) 생성자에서 또 다른 생성자를 호출 할 때의 this 용도
		 *  3) 단독 (홀로) 사용 될때의 this 용도
		 *  	- 매개변수: dispPoint(this)
		 *  	- 리턴값   return this;
		 */
		
		Point p = new Point(10);
		p.dispPoint();
		

	}

}
