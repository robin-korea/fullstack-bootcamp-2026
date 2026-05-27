package days11;

public class Ex07_03 {

	public static void main(String[] args) {

		Point p1 = new Point();

		System.out.printf("> x=%d, y=%d\n", p1.x, p1.y);

		// Call By Reference : 매개변수가 배열, 클래스 객체
		swapXY( p1 );

		System.out.printf("> x=%d, y=%d\n", p1.x, p1.y);
	}

	private static void swapXY( Point p) { // Point p = p1 클래스 복사
		System.out.printf(">>> x=%d, y=%d\n", p.x, p.y);
		int temp = p.x;
		p.x = p.y;
		p.y = temp;
		System.out.printf(">>> x=%d, y=%d\n",  p.x, p.y);
	}

}

class Point{
	int x = 10;
	int y = 20;

	public void printPoint() {
		System.out.printf("> x=%d, y=%d\n", x, y);
	}
}

