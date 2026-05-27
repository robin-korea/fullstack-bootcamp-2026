package days03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author An
 * @date 2026. 5. 13. 오후 3:24:03 
 * @subject 이름, 국, 영, 수 키보드로 부터 입력 -> 각각의 변수 저장한 후 
 * @content 총점, 평균 작업에 출력
 *
 */
public class Ex07_02 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int kor = 0, eng = 0, math = 0;
		int sum = 0;
		double avg = 0;

		// 이름 입력 받는 부분
		System.out.printf("> 이름을 입력하세요: ");
        String name = br.readLine();
        
        System.out.printf("> 국어 점수 입력: ");
		kor = Integer.parseInt(br.readLine());
		
		System.out.printf("> 영어 점수 입력: ");
		eng = Integer.parseInt(br.readLine());
		
		System.out.printf("> 수학 점수 입력: ");
		math = Integer.parseInt(br.readLine());
		
		sum = kor + eng + math;
		
		avg = sum / 3.0;
		

		System.out.printf("\n이름: %s \n국어: %d \n영어: %d \n수학: %d \n총점: %d \n평균: %.2f",
				name, kor, eng, math, sum, avg);
		
	}//main

}//class
