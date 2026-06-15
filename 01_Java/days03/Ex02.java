package days03;

/**
 * @author An
 * @date 2026. 5. 13. 오후 12:25:51 
 * @subject 지역변수(local variable) 설명
 * @content  
 *
 */
public class Ex02 {
	
	String address; // 인스턴스 변수 (전역 변수 X)
	static double pi; // 클래스 변수
	
	//함수의 매개변수도 지연변수다	
	public static void main(String[] args) {
		
		String name = null;
		
		// {} 영역(범위) 연산자
		{
			int age = 0;
		}
		
		// The local variable name may not have been initialized
		// age cannot be resolved to a variable
		System.out.printf("> name: %s, age: %d\n", name);

	}//main

}//class

//Ctrl + A
// Ctrl + I (들여쓰기)