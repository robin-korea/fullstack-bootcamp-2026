package days18;

public class Ex15_02 {

	public static void main(String[] args) {
		
		/*
		 * [제네릭의 제한]
		 * 
		 * 1. 객체별로 다른 타입으로 지정해서 동작하도록 만든 기술이기 때문에
		 *    static 필드는 선언할 수 없다
		 * 
		 * 2. static 메소드의 매개변수 타입도 T를 사용할 수 없다
		 * 
		 * 3. T 타입의 배열은 선언할 수 있다
		 * 
		 */

	}

}

class Box2<T>{
	
	// static T item; // 생성 불가    static은 프로그램 시작과 동시에 MA 영역에 올라간다

	
	// static int compare (T t1, T t2) {
	//	return 0;
	
}