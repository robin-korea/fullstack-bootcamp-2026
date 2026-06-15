package days11;

/**
 * @author An
 * @date 2026. 5. 26. 오후 2:18:08 
 * @subject
 * @content 
 *
 */
public class Ex06 {
	
	// 중첩클래스 선언할때 : protected, private 사용 가능
	protected class InnerEx06{
		
		
	}

	public static void main(String[] args) {

		/*
		 * 1. 클래스 앞에 사용하는 접근지정자
		 *  1) public     활성화 
		 *       ㄴ 패키지 내/외부에서 사용(참조, 상속) 가능
		 *
		 *  days11.Sample, days11.Ex06 패키지 내부
		 *  */
	
		Sample s = new Sample();
		
		/*
		 *  2) (default)  활성화
		 *        ㄴ 같은 패키지 내부에서만 사용(참조, 상속) 가능
		 *  
		 *  중첩(내부 inner)클래스를 선언할 때만 사용할 수 있다
		 *  3) protected  비활성화
		 *  4) private    비활성화
		 * 
		 * 
		 * 2. 필드, 메서드 앞에 사용하는 접근지정자
		 *  1) public     : 패키지 내/외부 어디서나 접근 가능하다
		 *  2) (default)  : 패키지 내부에서만 접근 가능하다
		 *  3) protected  : default + 상속
		 *  4) private    : 같은 클래스 내에서만 접근 가능하다
		 * 
		 *  Time.java
		 */

		// Time 객체를 생성(같은 패키지니 public 이나 default 둘다 사용 가능)
		
		Time t1 = new Time();
		
		// 싱글톤
		// getter/setter
	}

}
