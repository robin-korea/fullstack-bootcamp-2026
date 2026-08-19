package days12;

public class Point {
	
	// 필드
	public int x;
	public int y;
	
	// 디폴트 생성자
	public Point() {
		x = y = 100;
		System.out.println("> Point 디폴트 생성자 호출됨");
	}
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
		System.out.println("> Point 2 생성자 호출됨");
	}

	// 메소드
	public void dispPoint() {
		System.out.printf("> x=%d, y=%d\n",x,y);
	}
	
	public void offsetPoint(int value) {  // int value 기본형 매개변수
		x += value;
		y += value;
	}
	
	public void plusPoint(Point a, Point b) {  // 참조형 매개변수
		x = a.x + b.x;
		y = a.y + b.y;
		
	}
	
//	public void plusPoint(Point p) {  
//		x = x + p.x;
//		y = y + p.y;
//		
//	}
	
	public Point plusPoint(Point p) {  
		return new Point (x + p.x , y + p.y);
	}
}
