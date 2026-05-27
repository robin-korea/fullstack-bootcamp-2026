package days02;

public class Ex06 {

	public static void main(String[] args) {
		// 변수 : 변하는 수
		// 상수 : 고정된 수
		
		String lastName = "홍", firstName = "길동";
		
		System.out.println(lastName + " " + firstName);
		System.out.println("이름은 \"" + lastName + " " + firstName + "\"입니다.");
		
		// printf 여기서 f 는 format 내가 원하는 형식으로 출력
		
		// s.o.printf(String "출력형식", 출력할값...)
		System.out.printf("이름은 \"%s %s\"입니다." , lastName , firstName);
	}//main

}//class
