package days15;

/**
 * @author An
 * @date 2026. 6. 1. 오전 10:35:09 
 * @subject
 * @content 
 *
 */
public class Ex04 {

	public static void main(String[] args) {
		/*
		 * [내부(inner) 클래스]
		 * 1. 사용빈도가 거의 없다. 개념정도만 이해하자.
		 * 
		 * 2. 중첩 클래스
		 * 
		 * 3. AWT, Swing 과 같은 GUI애플리케이션(윈도우 애플리케이션)에서 
		 *   이벤트 처리할 목적으로 자주 사용된다. 
		 * 
		 * 4. 내부 클래스의 종류와 특징 - (선언 위치)
		 *    1) 인스턴스 클래스 - 외부 클래스의 필드 위치에 선언.
		 *    2) 정적(static) 클래스  - 외부 클래스의 필드 위치에 선언. 
		 *    3) 지역(local) 클래스 - 외부 메서드 안, 초기화 블럭 안 선언.
		 *    *** 4) 익명==무명(Anonymous) 클래스 
		 *          - 클래스의 선언 + 객체 생성 합쳐진 이름없는 클래스 
		 *          - 일회용.
		 * */ 
	}

}

class Outer{ // 외부 클래스
	int iv = 0;        // 인스턴스 변수
	static int ic = 0; // 클래스 변수

	//1. 인스턴스 클래스
	class InstanceClass{
		// 외부 클래스의 인스턴스 멤버들과 관련된 작업을 더 쉽게 하기 위해서 인스턴스 클래스로 선언
	}

	//2. static 클래스
	static class StaticClass{
		// 외부 클래스의 static 멤버들과 관련된 작업을 더 쉽게 하기 위해서 static 클래스로 선언
	}

	{ // 인스턴스 초기화 블록 (여기 안에서만 사용 가능)
		// 3. 지역 클래스
		class LocalClass{
			
		}
	}
	
	//외부 클래스의 메소드 (이 메소드 안에서만 사용 가능)
	void disp() {
		// 3. 지역 클래스
		class LocalClass2{
			
		}
	}
}