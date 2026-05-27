package days11;

/**
 * @author An
 * @date 2026. 5. 26. 오후 3:41:28 
 * @subject 클래스 복제
 * @content 
 *
 */
public class Ex07_04 {

	public static void main(String[] args) {
		
		Point p1 = new Point();
		p1.x = 1;
		p1.y = 2;
		
		Point p2 = new Point();
		p2.x = p1.x ;
		p2.y = p1.y ;

	}

}
