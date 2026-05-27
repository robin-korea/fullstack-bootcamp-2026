package days11;

/**
 * @author An
 * @date 2026. 5. 26. 오전 10:43:21 
 * @subject 
 * @content 
 *
 */
public class Ex02 {

	public static void main(String[] args) {
		
		int i = 0; // 변수, 지역변수
		int [] m = new int [3]; // 변수, 지역변수, 참조변수(그 기억공간안에 실제 값이 아닌 주소값을 가지고 있는것), 배열명
		
		// 배열의 각 요소를 사용하려면 : 배열명[인덱스값]
		m[0] = 100;
		System.out.println(m[0]);
		
		// 변수 선언 형식
		// 객체: 클래스를 자료형으로 선언된 참조변수
		// 클래스 : 객체의 설계도
		// 인스턴스 : 생성된 객체
		Car myCar; // 변수, 지역변수, 참조변수, 객체
		myCar = new Car(); // 객체 생성, 인스턴스화
		
		
		//             힙                                              스택
		// [name][speed][wheelCount][dCI주소참조]                [0x200번지] myCar
		
		// [dispCarInfo()] 코드
		
		// 필드, 메서드를 사용하려면:  객체명.필드명 또는 객체명.메소드명()
		
		myCar.name = "K9";
		System.out.println(myCar.name);
		myCar.dispCarInfo();
		
		Car bCar = new Car();
		bCar.name = "K5";
		bCar.dispCarInfo();
		
		
	}

}
