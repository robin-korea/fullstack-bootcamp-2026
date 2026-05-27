package days10;

import java.util.Scanner;

/**
 * @author An
 * @date 2026. 5. 22. 오전 10:22:37 
 * @subject days07.Ex05.java
 * @content days06.Ex01_02.java
 * 			다차원 배열은 배열의 배열이다 
 *
 */
public class Ex03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		final int LOTTO_PRICE = 1000;
		int gameCount;

		System.out.print("> 게임 횟수 입력: ");
		gameCount = sc.nextInt();

		int [][] lottoNumbers = new int [gameCount][6];

		createLottoNumbers(lottoNumbers);

		displayLottoNumbers(lottoNumbers);


	}

	public static void displayLottoNumbers(int[][] lottoNumbers) {
		for(int i = 0; i < lottoNumbers.length; i++) {
			displayLottoNumbers(lottoNumbers[i]);
		}

	}

	public static void createLottoNumbers(int[][] lottoNumbers) {
		for(int i = 0; i < lottoNumbers.length; i++) {
			createLottoNumbers(lottoNumbers[i]);
		}
		
	}
	
	// 로또 번호 한게임 무작위 출력
	public static void createLottoNumbers(int[] lottoNumbers) {

		int lottoNumber;
		int index = 0;
		boolean isFlag = false;

		while (index < lottoNumbers.length) {
			lottoNumber = (int) (Math.random()*45)+1;
			isFlag = false;

			if( !isDuplicateLottoNumber(lottoNumbers, lottoNumber, index)) {
				lottoNumbers[index] = lottoNumber;
				index ++;
			}
		}

	}
	// 한 게임 로또 번호 중복체크
	public static boolean isDuplicateLottoNumber(int[] lottoNumbers, int lottoNumber, int index) {

		boolean isFlag = false;
		for(int i = 0; i < index; i++) {
			if(lottoNumbers[i] == lottoNumber) {
				isFlag = true;
				break;
			}
		}
		return isFlag;
	}
	
	// 한 게임 출력하는 메소드
	public static void displayLottoNumbers(int[] lottoNumbers) {
		for( int i = 0 ; i < lottoNumbers.length; i++) {
			System.out.printf("[%d]" ,lottoNumbers[i]);
		}
		System.out.println();
	}

}
