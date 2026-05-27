package days06;

import java.util.Scanner;

/**
 * @author An
 * @date 2026. 5. 18. 오전 10:15:02 
 * @subject 로또 자동 발생 코딩
 * @content 고객으로 부터 돈 입금받고
 * 			게임 횟수, 거스름돈, 로또번호 출력
 *
 */
public class Ex01_02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//변하지 않기 때문에 상수로 선언 (대문자)
		final int LOTTO_PRICE = 1000;

		int money;
		int gameCount;

		System.out.print("> 게임 고객 머니, 게임 횟수 입력: ");
		money = sc.nextInt();
		gameCount = sc.nextInt();


		int possibleGames = money / LOTTO_PRICE;

		int playCount = Math.min(gameCount, possibleGames);

		int usedMoney = playCount * LOTTO_PRICE;
		int change = money - usedMoney;

		System.out.printf("> 고객 머니: %,d원\n", money);
		System.out.printf("> 게임 횟수: %d게임\n", playCount);
		System.out.printf("> 거스름돈: %,d원\n", change);

		for(int i = 1; i <= gameCount; i++) {
			// 인덱스번호
			// 0: 아랫첨자값 LowerBound 
			// 5 : 윗첨자값 UpperBound  lottoNumbers.length-1

			// 지역변수는 반드시 초기화를 해야하지만
			// 배열은 초기화하지 않아도 그 자료형의 초기값으로 초기화된다
			int [] lottoNumbers = new int[6];
			int lottoNumber;

			boolean isFlag = false;
			int index = 0;

			// 로또 번호 발생시켜서 배열에 채우기
			lottoNumber = (int)(Math.random()*45)+1;
			lottoNumbers[index++] = lottoNumber;

			// 로또번호 발생 
			while(index <= lottoNumbers.length - 1) {
				lottoNumber = (int)(Math.random()*45)+1;
				// 로또번호들과 중복체크

				isFlag = false;

				for(int j = 0; j < index ; j++) {
					if(lottoNumbers[j] == lottoNumber) {
						isFlag = true;
						break;
					}

				}
				if(isFlag == false) {
					lottoNumbers[index++] = lottoNumber;
				}
			}
			System.out.printf("%d 로또번호: ",i);
			for(int j = 0; j <= lottoNumbers.length - 1; j++) {
				System.out.printf("[%02d]",lottoNumbers[j]);
			}
			System.out.println();
		}
	}
}

