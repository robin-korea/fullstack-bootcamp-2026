package days14;

/**
 * @author An
 * @date 2026. 5. 29. 오전 10:05:35 
 * @subject
 * @content 
 * 
 *		1. 사원클래스(Employee): 사원이라면 공통적으로 가지고 있는 멤버들을 구현한 클래스
 *		2. 정규직클래스(Regular)
 *		3. 영업직클래스(SalesMan)
 *		4. 임시직클래스(Temp)
 *
 *           [ 상속 계층도 ]

               Object            모든 클래스의 최상위 부모 클래스이다. 
                 ↑                
              Employee           
          ↑                  ↑
        Regular             Temp
          ↑
       SalesMan

       1. 상속성 정리
       2. 다형성 / 인터페이스
       3. 업캐스팅/ 다운캐스팅
       4. 오버로딩(중복 함수)/ 오버라이딩(재정의 함수)
       5. 추상화(추상메소드, 추상클래스)
       6. this, super 키워드 설명
       7. final 키워드 설명.
       등등
 *
 *
 *
 */
public class Ex02 {

	public static void main(String[] args) {
		
	
		/*
		// 1. Employee emp1 생성
		Employee emp1 = new Employee("오수빈","서울 강남구","010-1234-1234","2026-10-25");
		emp1.dispEmpInfo();
		*/
		
		/*
		// 2. Regular emp2 생성
		Regular emp2 = new Regular("이시연", "서울 영등포구","010-3214-4567","2026-10-15", 3000000);
		emp2.dispEmpInfo();
		*/
		
		// [클래스 간의 형변환]: UpCasting(자동), DownCasting(강제)
		// Employee     Regular
		// 부모클래스 <=참조= 자식객체를 생성 (자동 업캐스팅)
		// 정규직(Regular)은 사원(Employee)이다 (O)
		//           상속(is-a) 관계
		/*
		Employee emp1 = new Regular("이시연", "서울 영등포구","010-3214-4567","2026-10-15", 3000000);
		// 문제점 : emp1.getPay(); 
		
		emp1.dispEmpInfo();
		// emp1.dispEmpInfo() -> 실제 자기객체의 dispEmpInfo() 메소드가 호출된다
		
		//[클래스 간의 형변환]
		// 다운캐스팅(DownCasting) (강제 형변환)
		Regular emp2 = (Regular) emp1;
		emp2.getPay();
		*/
		
		// Point 클래스와 Employee 클래스가 형변환 : 상속 관계
//		Point p = new Employee();
//		
//		Object o1 = new Point();
//		Object o2 = new Employee();
		
		// 업 캐스팅이 된 상태의 객체만 다운 캐스팅이 가능
//		Employee emp1 = new Employee();
//		Regular emp2 = (Regular) emp1;
	}

}
