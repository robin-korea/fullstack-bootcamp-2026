package days02;

public class Ex05 {

	public static void main(String[] args) {
		// 성, 이름을 따로 저장할 변수를 선언하고
		// 그 변수에 본인의 성과 이름을 할당하고
		// 출력하는 코딩을 하세요
		
		/*
		String firstName = "안";
		String lastName = "정빈";
		
		System.out.println(firstName + lastName);
		*/
		
		String name;
		name = "안정빈";
		// The local variable name may not have been initialized
		// 지역변수는 반드시 초기화가 필요하다
		// 초기화 : 변수를 선언하고 반드시 한번 값을 할당하는 작업
		System.out.println(name);
		
		// 성 -> 출력
	    name = "이";
	    System.out.println(name);
	      
	    // 이름 -> 출력
	    // Duplicate local variable name
	    //String name;
	    name = "창익";
	      
	}//main

}//class
