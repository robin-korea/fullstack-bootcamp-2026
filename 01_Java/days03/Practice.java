package days03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name;
		int kor = 0;
		int eng = 0;
		int math = 0;
		int sum = 0;
		double avg = 0;
		
		System.out.printf(">이름을 입력하세요: ");
		name = br.readLine();
		
		System.out.printf("국어 점수를 입력하세요: ");
		kor = Integer.parseInt(br.readLine());
		
		System.out.printf("영어 점수를 입력하세요: ");
		eng = Integer.parseInt(br.readLine());
		
		System.out.printf("수학 점수를 입력하세요: ");
		math = Integer.parseInt(br.readLine());
		
		sum = kor + eng + math;
		avg = sum / 3.0;
		
		System.out.printf("\n이름: %s\n국어점수: %d\n영어점수: %d\n수학점수: %d\n총합: %d \n평균: %.2f\n",
				name, kor, eng, math, sum, avg);	
		
		
		
	
	}

}
