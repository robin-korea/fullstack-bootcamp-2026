package days14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// 사원이라면 "공통적으로 가지고 있는 멤버들"을 선언한 클래스
public class Employee2 extends Object{
	
	private String name;      // 사원명
	private String addr;      // 주소
	private String tel;		  // 연락처
	private String hiredate;  // 입사일자
	
	
}
