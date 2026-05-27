package days03;

public class Ex03 {

	public static void main(String[] args) {
		
		double money = 1234567.9077;
		// 소수점 2자리 출력
		
		// 자동적으로 반올림 됨
		// > money = 1234567.91
		// System.out.printf("> money = %,.2f\n", money);
		
		String sMoney = String.format("%,.2f", money);
		System.out.println(sMoney);
		
		
		
	}// main

}// class
