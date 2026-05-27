package days09;

import java.util.Scanner;
import java.util.stream.IntStream;

import days08.Ex05_02;

/**
 * @author An
 * @date 2026. 5. 21. 오후 4:11:53 
 * @subject 3학년 * 10반 * 30명
 * @content 
 *
 */
public class Ex08 {

	public static void main(String[] args) {
		
		// 행: 반  열: 번호
		String [][] names = new String[3][30];
		
		// 열: 0국, 1영, 2수, 3총, 4등, 5전등
		// 행: 학생수
		// 면: 반
		int [][][] infos = new int[3][30][6];
		
		// 행: 반  열: 번호
		double [][] avgs = new double[3][30];
		
		// indexes[0] : 1반 입력받은 학생수 == 입력할 위치
		// indexes[1] : 2반 입력받은 학생수 == 입력할 위치
		// indexes[2] : 3반 입력받은 학생수 == 입력할 위치
		int [] indexes = new int[3];
		
		char con = 'y';
		
		//1. 입력
		String name;
		int kor,eng,math,tot;
		double avg;
		int rank, wrank;
		int classNo; // 반 번호
		
		Scanner sc = new Scanner(System.in);

		do {
			// 1) 반 입력 - 1,2,3
			System.out.print("> 1. 반 입력: ");
			classNo = sc.nextInt();
			
			// 2) 반 번 이/국/영/수 입력
			System.out.printf("> 2. %d반 [%d번] 학생 이름,국어,영어,수학 입력: ",classNo,indexes[classNo-1]+1);
			
			name = Ex05_02.generateRandomName();
			kor = Ex05_02.generateRandomScore();
			eng = Ex05_02.generateRandomScore();
			math = Ex05_02.generateRandomScore();
			
			tot = kor + eng + math;
			avg = tot/3.0;
			
			names[classNo-1][indexes[classNo-1]] = name;
			infos[classNo-1][indexes[classNo-1]][0] = kor;
			infos[classNo-1][indexes[classNo-1]][1] = eng;
			infos[classNo-1][indexes[classNo-1]][2] = math;
			infos[classNo-1][indexes[classNo-1]][3] = tot;
			avgs[classNo-1][indexes[classNo-1]] = avg;
			
			
			indexes[classNo-1]++;
			sc.nextLine();
			System.out.print("\t 입력 계속? ");
			con = sc.next().charAt(0);
		}while(Character.toUpperCase(con) == 'Y');
		
		//2. 등수, 전교등수
		
		
		
		
		//3. 출력
		int totalCount = IntStream.of(indexes).sum();
		System.out.printf("\n[전체 학생 수 : %d명]\n",totalCount);
		for (int i = 0; i < indexes.length; i++) {
			System.out.printf("[%d]반 학생수 : %d명\n",i+1,indexes[i]);
			for (int j = 0; j < indexes[i]; j++) {
				System.out.printf("> %d번 이름: %s 국어:%d, 영어:%d, 수학:%d 총점:%d, 평균:%.2f, 등수:%d\n"
						,j+1, names[i][j], infos[i][j][0], infos[i][j][1], infos[i][j][2], infos[i][j][3], avgs[i][j], infos[i][j][4]);
				
			}
			
		}
		
	}

}
