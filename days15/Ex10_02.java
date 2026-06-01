package days15;

/**
 * @author An
 * @date 2026. 6. 1. 오후 4:47:35 
 * @subject 
 * @content  
 *
 */
public class Ex10_02 {

	public static void main(String[] args) {

		Point p1 = new Point(1,2);
		
		// 복제
		try {
			Point p1Clone = (Point) p1.clone();
			System.out.println(p1Clone);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("END");
		
	}

}

class Point extends Object implements Cloneable{

	int x;
	int y;

	public Point() {}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj != null && obj instanceof Point) {
			Point p = (Point)obj;
			return this.x == p.x && this.y == p.y;
		} // if

		return false;
	}

	@Override
	public String toString() {
		return String.format("(x=%d,y=%d)", this.x, this.y);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// return super.clone();
		Object obj = null;
		obj = super.clone();
		return obj;
	}
	
}
