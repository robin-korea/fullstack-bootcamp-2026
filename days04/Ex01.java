package days04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author An
 * @date 2026. 5. 14. 오전 9:02:52 
 * @subject
 * @content 
 *
 */
public class Ex01 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String name;
		int age = 0;
		String email;
		String num;
		String address;
		boolean gender;
		char grade;

		System.out.printf("이름을 입력하세요: ");
		name = br.readLine();

		System.out.printf("나이를 입력하세요: ");
		age = Integer.parseInt(br.readLine());

		System.out.printf("이메일을 입력하세요: ");
		email = br.readLine();

		System.out.printf("휴대폰 번호를 입력하세요: ");
		num = br.readLine();

		System.out.printf("주소를 입력하세요: ");
		address = br.readLine();

		System.out.printf("성별을 입력하세요 (true=남성, false=여성): ");
		gender = Boolean.parseBoolean(br.readLine());
		
		System.out.printf("등급을 입력하세요 (A, B, C, D, F): ");
		grade = br.readLine().charAt(0); 


		System.out.printf("\n%s 입력한 개인정보 %s\n이름: \"%s\"\n나이: %d\n이메일: %s\n휴대폰 번호: %s\n주소: %s\n성별: %b\n등급: '%c'\n",
				"=".repeat(5),"=".repeat(5), name, age, email, num, address, gender, grade);
	}

}

/*
 * 1. 입력형식
   이름을 입력하세요: 홍길동
   나이를 입력하세요: 25
   이메일을 입력하세요: test@example.com
   휴대폰 번호를 입력하세요: 010-1234-5678
   주소를 입력하세요: 서울특별시 강남구
   성별을 입력하세요 (true=남성, false=여성): true
   등급을 입력하세요 (A, B, C, D, F): A 

 * 2. 출력형식
   ===== 입력한 개인정보 =====
   이름: "홍길동"
   나이: 25
   이메일: test@example.com
   휴대폰 번호: 010-1234-5678
   주소: 서울특별시 강남구
   성별: true
   등급: 'A'
 */