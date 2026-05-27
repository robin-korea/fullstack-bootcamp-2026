package days08;

import java.util.Scanner;

/**
 * @author An
 * @date 2026. 5. 20. 오전 11:48:32 
 * @subject 배열 + 제어문
 * @content   ㄴ 한 학생의 [이름, 국,영,수], 총, 평 출력
 *            ㄴ 한 반에 30명의 학생들의 + 등수 입력, 출력
 */
public class Ex05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final int STUDENT_COUNT = 30;
		
		char con = 'y';
		int index = 0;
		
		String [] names = new String[STUDENT_COUNT];
		String name;
		
		int [] korArr = new int[STUDENT_COUNT];
		int kor;
		int [] engArr = new int[STUDENT_COUNT];
		int eng;
		int [] mathArr = new int[STUDENT_COUNT];
		int math;
		
		int [] sumArr = new int[STUDENT_COUNT];
		
		double [] avgArr = new double[STUDENT_COUNT];
		
		
		do {
			System.out.printf("%d번 이름, 국어, 영어, 수학 입력: ",index+1);
			name = sc.next();
			names[index] = name;
			
			kor = sc.nextInt();
			korArr[index] = kor;
			
			eng = sc.nextInt();
			engArr[index] = eng;
			
			math = sc.nextInt();
			mathArr[index] = math;
			
			int sum = kor + eng + math;
			double avg = sum /3.0;
			
			sumArr[index] = sum;
			
			avgArr[index] = avg;
			
			index++;
			
			System.out.print("\t 입력 계속? ");
			con = sc.next().charAt(0);
		} while (Character.toUpperCase(con) == 'Y');
		
		// index == 입력받은 학생수
		System.out.printf("\n입력받은 학생수: %d명\n\n",index);
		
		for(int i = 0; i < index; i++) {
			System.out.printf("> %d번 이름: %s, 국어:%d, 영어:%d, 수학:%d 총점:%d, 평균:%.2f\n"
					,i+1, names[i],korArr[i],engArr[i],mathArr[i],sumArr[i],avgArr[i]);
		}
		
		
	}

}
