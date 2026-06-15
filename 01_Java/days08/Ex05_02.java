package days08;

import java.util.Random;
import java.util.Scanner;

/**
 * @author An
 * @date 2026. 5. 20. 오전 11:48:32 
 * @subject 배열 + 제어문
 * @content   ㄴ 한 학생의 [이름, 국,영,수], 총, 평 출력
 *            ㄴ 한 반에 30명의 학생들의 + 등수 입력, 출력
 *            
 *            메소드 작성
 *            	ㄴ 등수 처리
 */
public class Ex05_02 {


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		final int STUDENT_COUNT = 30;

		int index = 0;

		String [] names = new String[STUDENT_COUNT];
		int [] korArr = new int[STUDENT_COUNT];
		int [] engArr = new int[STUDENT_COUNT];
		int [] mathArr = new int[STUDENT_COUNT];
		int [] sumArr = new int[STUDENT_COUNT];
		double [] avgArr = new double[STUDENT_COUNT];
		int [] ranks = new int[STUDENT_COUNT];

		index = inputStudentInfo(names,korArr,engArr,mathArr,sumArr,avgArr,index,sc);
		//등수처리

		processStudentRank(sumArr, ranks, index);


		//학생들 성적 정보 출력
		printStudentInfo(names,korArr,engArr,mathArr,sumArr,avgArr,ranks,index);
		// index == 입력받은 학생수

	}


	private static int inputStudentInfo(String[] names, int[] korArr, int[] engArr, int[] mathArr, int[] sumArr,
			double[] avgArr, int index, Scanner sc) {
		String name;
		int kor, eng, math,sum;
		double avg;
		char con = 'y';
		do {

			System.out.printf("%d번 이름, 국어, 영어, 수학 입력: ",index+	1);

			name = generateRandomName();
			kor = generateRandomScore();
			eng = generateRandomScore();
			math = generateRandomScore();

			sum = kor + eng + math;
			avg = sum /3.0;

			names[index] = name;
			korArr[index] = kor;
			engArr[index] = eng;
			mathArr[index] = math;
			sumArr[index] = sum;
			avgArr[index] = avg;

			index++;

			System.out.print("\t 입력 계속? ");
			con = sc.next().charAt(0);
		} while (Character.toUpperCase(con) == 'Y');
		
		return index;

	}
	


	public static void printStudentInfo(String[] names, int[] korArr, int[] engArr, int[] mathArr, int[] sumArr,
			double[] avgArr, int[] ranks, int index) {

		System.out.printf("\n입력받은 학생수: %d명\n\n",index);

		for(int i = 0; i < index; i++) {
			System.out.printf("> %d번 이름: %s 국어:%d, 영어:%d, 수학:%d 총점:%d, 평균:%.2f, 등수:%d\n"
					,i+1, names[i],korArr[i],engArr[i],mathArr[i],sumArr[i],avgArr[i],ranks[i]);
		}

	}

	public static String generateRandomName() {

		char [] nameArr = new char[3];

		Random rnd = new Random();
		char nameChar;
		for(int i = 0; i< nameArr.length; i++) {
			nameChar = (char) rnd.nextInt('가','힣');
			nameArr[i] = nameChar;
		}
		//		String name = new String(nameArr);
		String name = String.valueOf(nameArr);
		return name;
	}

	public static int generateRandomScore() {
		Random rnd = new Random();
		int score = rnd.nextInt(0,101);

		return score;
	}

	public static void processStudentRank(int[] sumArr, int[] ranks, int index) {
		for (int i = 0; i < index; i++) {
			ranks[i] = 1;
			for (int j = 0; j < index; j++) {
				if(sumArr[i] < sumArr[j]) ranks[i]++;
			}
		}

	}

}
