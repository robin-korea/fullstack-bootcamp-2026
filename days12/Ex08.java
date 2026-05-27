package days12;

/**
 * @author An
 * @date 2026. 5. 27. 오후 4:23:07 
 * @subject 
 * @content 
 *
 */
public class Ex08 {

	public static void main(String[] args) {

		/*
		 * 1. this 정의 
		 *     ㄴ 현재 객체 자기 자신을 가리키는 참조변수
		 * 
		 * 2. this의 용도 3가지
		 *   1) 멤버를 가리킬 때의 this
		 *   2)
		 *   3) 
		 */
		
		Employee emp1 = new Employee();
		emp1.setName("홍길동");
		String name = emp1.getName();
		
		Employee emp2 = new Employee();
		emp2.dispName();
	}
	
	
}

class Employee{
	private String name;
	
	// setter 
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void dispName() {
		System.out.println(this.name);
	}
}
