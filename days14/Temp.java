package days14;

public class Temp extends Employee{

	// 필드 : name, addr, tel, hiredate
	private int days;      // 근무 일수
	private int payOfDay;  // 하루 일당

	public Temp() {
		super();
		System.out.println("> Temp 디폴트 생성자 호출됨.");
	}
	public Temp(String name, String addr, String tel, String hiredate, int days, int payOfDay) {
		super(name, addr, tel, hiredate);
		this.days = days;
		this.payOfDay = payOfDay;
		System.out.println("> Temp 6 생성자 호출됨.");
	}

	@Override
	public void dispEmpInfo() {
		super.dispEmpInfo();
		System.out.printf("근무일수:%d, 하루일당:%d",days,payOfDay);
	}

	// 급여 계산해서 반환하는 메서드 
	@Override
	public int getPay() {
		return this.days * this.payOfDay;		
	}

}
