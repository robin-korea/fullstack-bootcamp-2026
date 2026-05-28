package days13;

/**
 * @author An
 * @date 2026. 5. 28. 오전 10:32:55 
 * @subject
 * @content 리턴값을 this
 *
 */
public class Ex01_03 {

	public static void main(String[] args) {
		
		Point p1 = new Point(1,2);
		Point p2 = new Point(10,20);
		
		p1.dispPoint();
		p2.dispPoint();
		
		p1.plusPoint(p2).dispPoint(); //plusPoint() 함수에 this 를 return 하면 메서드 체이닝 사용 가능 
	}

}

class Point{
	// 필드
	private int x;
	private int y;

	// 디폴트 생성자
	public Point() {
//		super();
		System.out.println("> Point 디폴트 생성자 호출됨..");
	}
	
	// 생성자 2개
	public Point(int x, int y) {
//		super();
		this.x = x;
		this.y = y;
		System.out.println("> Point 생성자 2 호출됨..");
	}

	// getter, setter
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	// 메소드 : 두 좌표를 더하는 메소드0
	
	public Point plusPoint(Point p) {
		this.x += p.x;
		this.y += p.y;
		return this;
	}
	// 메소드 : 좌표를 출력하는 메소드
	public void dispPoint() {
		System.out.printf("> x=%d, y=%d\n",this.x,this.y);
	}
}