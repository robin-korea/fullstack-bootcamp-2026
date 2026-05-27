package days09;

import java.util.Random;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {

		final int STUDNET_COUNT = 30;

		String [] names = new String[STUDNET_COUNT];
		int [] tots = new int [STUDNET_COUNT];
		double [] avgs = new double [STUDNET_COUNT];
		int [] ranks = new int [STUDNET_COUNT];

		int index = 0;

		// 6. 반복적으로  이름, 총점(0~300) 입력받아서  평균 계산 : inputStudentInfo
		// 7. 등수 처리 : processStudentRank
		// 8. 모든 학생들 출력. : printStudentInfo

		Scanner sc = new Scanner(System.in);

		index = inputStudentInfo(names,tots,avgs,sc);
		
		processStudentRank(tots,ranks,index);
		
		printStudentInfo(names,tots,avgs,ranks,index);

	}

	public static void processStudentRank(int[] tots, int[] ranks, int index) {

		for(int i = 0; i < index; i++) {
			ranks[i] = 1;
			for(int j = 0; j < index; j++) {
				if(tots[i] < tots[j]) {
					ranks[i]++;
				}
			}
		}

	}

	public static void printStudentInfo(String[] names, int[] tots, double[] avgs, int[] ranks, int index) {

		System.out.printf("\n 입력받은 학생수: %d명\n\n",index);
		for(int i = 0; i < index; i++) {
			System.out.printf("%d번 학생: %s 총점:%d, 평균:%.2f, 등수:%d\n",i+1,names[i],tots[i],avgs[i],ranks[i]);			
		}
	}

	public static int inputStudentInfo(String[] names, int[] tots, double[] avgs, Scanner sc) {

		String name;
		int tot;
		int index = 0;
		double avg;
		char con = 'y';

		do {
			System.out.printf("> [%d]번 학생 이름, 총점 입력: ",index+1);

			name = sc.next();
			tot = getRandomTot();
			avg = tot / 3.0;

			names[index] = name;
			tots[index] = tot;
			avgs[index] = avg;

			index ++;

			sc.nextLine(); // 남아있는거 모두 제거

			System.out.print("\t 입력 계속? ");
			con = sc.next().charAt(0);
		}while(Character.toUpperCase(con) == 'Y');

		return index;

	}

	public static int getRandomTot() {
		Random rnd = new Random();
		int total = rnd.nextInt(0,301);
		return total;
	}

}
