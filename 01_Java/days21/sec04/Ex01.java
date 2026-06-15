package days21.sec04;

/**
 * @author An
 * @date 2026. 6. 10. 오전 10:09:33 
 * @subject 리턴값이 있는 람다식
 * @content 
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		
		Person p = new Person();
		
		// p.action((x,y) -> {return x + y;});
		p.action((x,y) -> x + y);
		
//		p.action((x,y) -> {
//			return sum(x,y);
//		});
		
		p.action((x,y) -> sum(x,y));
		
	}	
	
	public static double sum(double x, double y) {
		return x + y;
	}
}


