package days03;

public class Ex04 {

	public static void main(String[] args) {
		
		System.out.printf("\'%c'(%d)\n", 'A',(int)'A');
		System.out.printf("\'%c'(%d)\n", 'Z',(int)'Z');
		System.out.printf("\'%c'(%d)\n", 'a',(int)'a');
		System.out.printf("\'%c'(%d)\n", 'z',(int)'z');
		System.out.printf("\'%c'(%d)\n", '0',(int)'0');
		System.out.printf("\'%c'(%d)\n", '9',(int)'9');
		
		//대문자 + 32 = 소문자 변환
		//소문자 - 32 = 대문자 변환
		System.out.println('A' - 'a');
		System.out.println('a' - 'A');
		
		
	}//main

}//class
