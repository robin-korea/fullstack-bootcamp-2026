package days13;

/**
 * @author An
 * @date 2026. 5. 28. 오후 2:01:51 
 * @subject
 * @content 
 *		[변수의 종류]
 *		 1. 지역변수
 *		 2. 인스턴스 변수
 *		 3. 클래스 변수
 *
 *      [변수의 초기화]
 *         ㄴ 변수를 선언하고 처음으로 값을 할당하는 것
 *      
 *      [필드의 초기화 방법]
 *        1) 명시적 초기화    : 필드에서 선언할때 값을 초기화 하는것
 *        2) 생성자 초기화
 *        3) 초기화 블럭 사용
 *      
 */
public class Ex06 {

	public static void main(String[] args) {
		// [초기화 순서] 명시적 초기화 > 초기화블럭 > 생성자 초기화
		
		Member m1 = new Member("서영학");
		System.out.println(m1.name);
		
		Member m2 = new Member("정창기");
		System.out.println(m2.name);
		
		Member m3 = new Member("박세인");
		System.out.println(m3.name);
		

	}

}

class Member{
	// 필드
	//  ㄴ 인스턴스 변수
	String name = "홍길동";       // 1) 명시적 초기화 
	int age = 20;
	int count;
	int serialNumber;
	//  ㄴ 클래스 변수
	static double rate = 0.04;  // 1) 명시적 초기화
	
	// 생성자가 오버로딩되어 있을 대 중복 코딩이 있다면 초기화 블록 사용
	
	static{   // 일괄적으로 클래스 변수를 초기화하기 위한 목적으로 사용되는 블록
		rate = 0.08;
		System.out.println("> 클래스 블록 초기화 실행됨...");
	}
	
	{  // 인스턴스 초기화 블록
		count++;
		serialNumber = count;
		System.out.println("> 인스턴스 초기화 블럭 실행됨..");
	}
	
	// 생성자
	Member(){     // 2) 생성자 초기화
//		count++;
//		serialNumber = count;
		name = "무명";
		System.out.println("> 디폴트 생성자 실행됨..");
	}
	Member(String name){  // 2) 생성자 초기화
//		count++;
//		serialNumber = count;
		this.name = name;
		System.out.println("> 매개변수 한개 생성자 실행됨..");
	}
	// 메서드
	
}

