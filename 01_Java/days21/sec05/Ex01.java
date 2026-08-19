package days21.sec05;

/**
 * @author An
 * @date 2026. 6. 10. 오전 10:19:35 
 * @subject 메서드 참조
 * @content  ㄴ 메소드를 참조해서 매개변수의 정보 및 리턴 타입을 알아내
 *              람다식에서 불필요한 매개변수를 제거하는 것을 목적으로 한다
 *           ㄴ 정적 메서드, 인스턴스 메서드 참조
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		
		Person p = new Person();
		
		Computer c = new Computer();
		// [1]
//		p.action((x,y) -> {
//			return c.instanceMethod(x, y);
//		});
		 
		// [2]
		// p.action((x,y) -> c.instanceMethod(x, y));
		
		// [3] 메서드 참조
		p.action(c :: instanceMethod);
		
		
		
		
		/*
		//[1]
//		p.action((x,y) -> {
//			return Computer.staticMethod(x, y);
//		});
		
		//[2]
		p.action((x,y) -> Computer.staticMethod(x, y));
		
		// [3] 메소드 참조
		// 클래스명 :: 메소드명
		p.action(Computer :: staticMethod);
		*/
		

	}

}
