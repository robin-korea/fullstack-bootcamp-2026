package days15;

/**
 * @author An
 * @date 2026. 6. 1. 오후 4:14:56 
 * @subject Object 클래스
 * @content   ㄴ 모든 클래스의 최상위 부모 클래스
 *
 */
public class Ex10 {

	public static void main(String[] args) {
		/*
		Data v1 = new Data(10);
		// 객체 자신의 고유한 코드값
		int hashCode = v1.hashCode();
		System.out.println(hashCode); // 1421795058
		
		Data v2 = new Data(10);
		hashCode = v2.hashCode();
		System.out.println(hashCode); // 1555009629
	
		Data v3 = v2; // 클래스 복사
		hashCode = v3.hashCode();
		System.out.println(hashCode); // 1555009629
		
		// 제네릭 <>
		// v1 객체의 클래스 정보를 반환하는 메서드: getClass()
		Class classInfo = v1.getClass();
		
		//패키지명.클래스명: fullName
		System.out.println(classInfo.getName());
		
		// 객체의 정보를 출력하는 메서드
		// fullName + @ + 1421795058 hashcode 의 16진수 값
		System.out.println(v1.toString());
		*/
	
		
		Data v1 = new Data(10);
		Data v2 = new Data(10);
		
		System.out.println(v1 == v2);
		// equals() 메소드 Object 로부터 상속받아서 오버라이딩.(재정의)
		
		// Object 의 equals 재정의 안하면 == 과 같아서 false 나옴
		System.out.println(v1.equals(v2));
		
		System.out.println(v1.toString());
	}
		

}

class Data extends Object{
	// 필드
	int value;
	
	// 생성자 1
	public Data(int value) {
		this.value = value;
	}

	// value 속성값이 같으면 true 반환하도록 재정의
	@Override
	public boolean equals(Object obj) {
		
		// 바로 다운캐스팅
		if(obj instanceof Data d) {
			// Data d = (Data) obj;
			return this.value == d.value;
		}
		return false; 
	}

	@Override
	public String toString() {
		return "Data [value=" + value + "]";
	}

//	@Override
//	public String toString() {
//		
//		return String.format("[value:%s]", this.value);
//	}
	
	
	
}

