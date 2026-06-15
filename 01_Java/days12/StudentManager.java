package days12;

import java.util.Scanner;

public class StudentManager {

	final int STUDENT_COUNT = 30;
	
	// 결합력이 높은 코딩은 좋은 코딩이 아니다
	// public Student [] students = new Student[STUDENT_COUNT];
	public Student [] students = null;

	char con = 'y';
	int index = 0;  // 입력 받은 학생 수


	public StudentManager() {
		students = new Student[STUDENT_COUNT];
	}
	public StudentManager(int length) {
		students = new Student[length];
	}

	// 1. 클래스 배열에 학생 입력 후 저장
	private void addStudent(Student student) {
		if(index >= students.length) {
			System.out.println("> 30명 입력이 완료!!");
			return;
		}

		students[index++] = student;

	}

	// 2. 입력받은 모든 학생들 등수 처리
	public void processRank() {
		for(int i = 0; i < index; i++) {
			// students[i].rank = 1;
			int rank = 1;
			for(int j = 0; j < index ; j++) {
				if (students[i].tot < students[j].tot) {
					// students[i].rank++;
					rank ++;
				}
			}
			students[i].rank = rank;
		}
	}

	// 3. 모든 학생들 정보 출력
	public void printStudents() {
		System.out.printf("> 입력받은 학생수: %d명\n",index);
		for (int i = 0; i < index; i++) {
			System.out.println(students[i].getInfo());;
		}
	}

	public void inputStudents() {

		// 한명 씩 학생 정보 입력받아서 Student student 객체 생성후
		// manager.addStudent(student) 메서드 호출해서
		// students 클래스 배열에 추가

		Scanner scanner = new Scanner(System.in);

		String name;
		int kor, eng, mat, tot;
		double avg;
		int no;

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

			Student student = new Student();

			student.no = no;
			student.name = name; 
			student.kor = kor;
			student.eng = eng;
			student.mat = mat;
			student.tot = tot;
			student.avg = avg;

			addStudent(student);

			System.out.print("\t 입력 계속? ");
			con = scanner.next().charAt(0);
		} while ( Character.toUpperCase(con) == 'Y' );

	}


}
