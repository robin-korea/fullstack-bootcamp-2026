package days12;

import java.util.Scanner;

/**
 * @author An
 * @date 2026. 5. 27. 오전 9:01:29 
 * @subject
 * @content days08.Ex05.java 참조
 * 			Student.java 클래스 선언 + 필드/메서드
 * 
 * 			클래스 설계
 * 			1) Student : 한 학생의 정보만을 처리하는 멤버
 * 						 필드 + 메서드
 *			2) StudentManager : 전체 학생들의 리스트를 관리하는 클래스
 *                               리스트 관리 필드 + 메서드
 *                               학생 입력/ 출력/ 수정/ 삭제 (CRUD)
 */
public class Ex01 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		final int STUDENT_COUNT = 30;

		// 클래스 배열 선언...
		Student [] students = new Student[STUDENT_COUNT];

		String name;
		int kor, eng, mat, tot;
		double avg;
		int no;

		char con = 'y';
		int index = 0;

		do {
			no = index + 1;
			System.out.printf("%d번 이름 국어 영어 수학 입력: ", no );
			name = scanner.next();   
			kor = scanner.nextInt();
			eng = scanner.nextInt();
			mat = scanner.nextInt();
			//
			tot = kor + eng + mat;
			avg = (double)tot/3;

			students[index] = new Student();

			students[index].no = no;
			students[index].name = name; 
			students[index].kor = kor;
			students[index].eng = eng;
			students[index].mat = mat;
			students[index].tot = tot;
			students[index].avg = avg;

			index++;

			System.out.print("\t 입력 계속? ");
			con = scanner.next().charAt(0);
		} while ( Character.toUpperCase(con) == 'Y' ); 

		// index: 입력받은 학생수
		System.out.printf("\n 입력받은 학생수: %d명\n", index);
		for (int i = 0; i < index; i++) {
			System.out.print( students[i].getInfo() );
		}

	}

}
