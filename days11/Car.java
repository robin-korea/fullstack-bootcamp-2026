package days11;

// main 함수가 없어서 실행이 안되는 클래스 : 라이브러리 클래스
// 신형 자동차 클래스 선언
public class Car {	
	
	// 멤버 == 클래스(객체)의 구성요소
	//  ㄴ 멤버변수(필드), 속성(특징)
	String name;          // 차 이름
	int speed;            // 속도
	int wheelCount;       // 바퀴수
	
	//  ㄴ 멤버함수(메서드), 동작(기능,일)
	public void dispCarInfo() {
		// int speed;  필드X, 지역변수
		System.out.printf("> 차이름:%s, 속도:%d\n",name,speed);
	}
	
}
