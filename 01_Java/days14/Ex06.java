package days14;

/**
 * @author An
 * @date 2026. 5. 29. 오후 3:07:04 
 * @subject 추상화
 * @content  ㄴ 추상 메서드, 추상 클래스
 *           ㄴ 공통적인 부분(멤버)만을 미리 선언한 클래스  
 */
public class Ex06 {

	public static void main(String[] args) {
		
		// Employee 를 추상클래스로 만들어서 객체 생성 불가
		// Employee emp1 = new Employee("오수빈","서울 강남구","010-1234-1234","2026-10-25");
		
		Employee emp1 = new Regular("이시연", "서울 영등포구","010-3214-4567","2026-10-15", 3000000);
		emp1.getPay();
	}

}
