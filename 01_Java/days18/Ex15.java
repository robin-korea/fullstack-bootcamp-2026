package days18;

/**
 * @author An
 * @date 2026. 6. 5. 오후 4:07:10 
 * @subject chapter 13 제네릭 (Generic)
 * @content    ㄴ jdk 1.5 제네릭 추가 개념
 *             ㄴ jdk 1.8 람다식 개념
 *             ㄴ 정의 ?
 *             ㄴ 결정되지 않은 타입을 파라미터로 처리하고
 *                실제 사용할 때
 *                파라미터를 구체적인 타입으로 대체시키는 기능(기술)
 *             ㄴ 장점 ? 타입의 안정성을 제공, 코드를 재사용
 *             ㄴ 적용 : 메서드, 클래스, 인터페이스
 *
 */
public class Ex15 {

	public static void main(String[] args) {
		
		Box<Integer> box1 = new Box<>();
		box1.setItem(100);
		int n = box1.getItem();
		System.out.println(n);
		
		Box<Student> box2 = new Box<>();
		box2.setItem(null);
	}

}

/*
// int 쓰기/읽기 
class Box{
	
	private int item;

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}
	
}

class BoxDouble{
	
	private double item;

	public double getItem() {
		return item;
	}

	public void setItem(double item) {
		this.item = item;
	}
	
}

class Boxchar{
	
	private char item;

	public char getItem() {
		return item;
	}

	public void setItem(char item) {
		this.item = item;
	}
	
}
*/
/*
	  제네릭 클래스로 선언
      ㄴ 클래스명 뒤에 <T>를 붙이면 된다.
      ㄴ T 를 타입변수 또는 타입 매개변수라 부른다
      ㄴ Box 원시타입
      ㄴ Box<T> 제네릭 클래스, T의 Box, T Box 라고 읽으면 된다.
*/
class Box<T>{
	
	private T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

}

      
