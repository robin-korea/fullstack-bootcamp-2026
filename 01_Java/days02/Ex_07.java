package days02;

public class Ex_07 {

	public static void main(String[] args) {
		// 이름을 저장할 변수를 선언하고 본인이름 초기화
		String name = "홍길동";
		
		// 나이를 저장할 변수를 선언하고 본인 나이로 초기화
		// byte, short, int ,long
		byte age = 20; 
		
		// 학점 : A B C D E F 
		char grade = 'D';
		
		// 성별을 저장하는 변수를 선언
		// String gender = "남자";	
		
		//참, 거짓
		boolean gender = true;
		
		// 출력형식: 이름은 "이창익"이고, 나이는 '20'살이고, 학점은 'D'이고, 성별은 true입니다.
		// %s : 문자열 
		// %d : 정수값 
		// %c : 문자
		// %b : boolean
		System.out.printf("이름은 \"%s\"이고, 나이는 '%d'살이고, 학점은 '%c'이고, 성별은 %b입니다.", name, age, grade, gender);
	}//main

}//class
