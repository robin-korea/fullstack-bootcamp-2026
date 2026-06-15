package days14;

// 사원이라면 "공통적으로 가지고 있는 멤버들"을 선언한 클래스
public abstract class Employee extends Object{

	private String name;      // 사원명
	private String addr;      // 주소
	private String tel;		  // 연락처
	private String hiredate;  // 입사일자


	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	// 생성자
	public Employee() {
		super();
		System.out.println("> Employee 디폴트 생성자 호출됨.");
	}

	public Employee(String name, String addr, String tel, String hiredate) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = tel;
		this.hiredate = hiredate;
		System.out.println("> Employee 4 생성자 호출됨.");
	}

	public void dispEmpInfo() {
		System.out.printf("사원명:%s, 주소:%s, 연락처:%s, 입사일자:%s\n",this.name,this.addr,this.tel,this.hiredate);
	}
	
//  추상 메서드 : 몸체가 구현이 안된 불완전한 메서드
//			    물려받는 자식클래스에서 오버라이딩 하라는 의미
	public abstract int getPay();
}
