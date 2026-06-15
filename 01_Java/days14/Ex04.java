package days14;

public class Ex04 {

	// 필드
	//  ㄴ 인스턴스 변수
	// 필드에서 변수 선언시 기본값으로 초기화 되지만 상수는 초기화 해야된다
	public final double PI;

	// 클래스 변수 ( 생성자가 만들기 전에 올라가기때문에 명시적 초기화 혹은 static 초기화 블록에서 초기화해야된다)
	public static final double P;

	static {
		P = 3.1415;
	}

	// 생성자에서 공통적인 초기화 할것이 있을때 이 초기화 블록 사용

	//	{
	//		PI = 3.141592;
	//	}

	// 생성자에서 초기화
	public Ex04() {
		PI = 3.141592;
	}

	public static void test(final int n) {
		//							    ㄴ 매개변수도 지역변수이다 test 안에서 n 값을 바꾸지 못한다
	}

	public static void main(String[] args) {

		/*
		 * [final 키워드 설명]
		 * 1. final + 변수 : 상수
		 *          ㄴ 지역변수
		 *          ㄴ 인스턴스 변수
		 *          ㄴ 클래스 변수 
		 * 
		 * 2. final + 클래스         
		 *          ㄴ 최종 클래스 더이상 자식 클래스를 만들지 않겠다
		 *          
		 * 3. final + 메서드
		 *          ㄴ 더이상 자식이 오버라이딩 할 수 없다
		 */

		//변하지 않는 상수
		final double PI = 3.141592;

		test(100);
	}

}

// final class Parent{
// 오버라이딩 할때 부모의 접근지정자 범위보다 자식이 더 커야한다 
//                      public         protected (X)
//                      (defualt)      protected (O)
class Parent{

	public void test1() {
		System.out.println("> P.test1()...");
	}
//	public final void test2() { // 자식이 재 정의 할 수 없는 최종 매소드
	public void test2() {
		System.out.println("> P.test2()...");
	}
}

class Child extends Parent{
	
	@Override
	public void test1() {
		System.out.println("> C.test1()...");
	}
	
	@Override
	public void test2() {
		System.out.println("> C.test2()...");
	}
}








