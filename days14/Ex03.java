package days14;

public class Ex03 {

	public static void main(String[] args) {
		
//		SalesMan emp3 = new SalesMan("조지훈","서울 성북구", "010-4567-8970", "2026-10-11", 1000000, 20, 150000);
		
		
		Employee emp3 = new SalesMan("조지훈","서울 성북구", "010-4567-8970", "2026-10-11", 1000000, 20, 150000);
		
		// SalesMan 꺼의 dispEmpInfo 가 출력되는거
		// emp3.dispEmpInfo();
		
		
		Employee emp4 = new Temp("문규리","서울 강북", "010-1548-8540", "2026-10-11", 15,200000);
		
		emp4.dispEmpInfo();
	}

}
