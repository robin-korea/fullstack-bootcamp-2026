package days17;

import java.util.HashSet;

/**
 * @author An
 * @date 2026. 6. 4. 오후 3:49:44 
 * @subject 
 * @content  로또 게임
 *			 1) int [] lotto 로또 한 게임
 *			 2) int [][] lottos 로또 여러 게임..
 *				HashSet 사용.
 */
public class Ex11_02 {

	public static void main(String[] args) {

		HashSet lottoSet = new HashSet(6);
		
		createLottoNumbers(lottoSet);
		
		displayLottoNumbers(lottoSet);
		
	}

	// HashSet 로또를 채우는 함수, 로또 번호 한 게임 발생..
	public static void createLottoNumbers(HashSet lottoSet) {
		int lottoNumber;
		
		while (lottoSet.size() < 6) {
			lottoNumber = (int) (Math.random()*45)+1;
			// System.out.println(lottoNumber);
			lottoSet.add(lottoNumber);

		}
	}

	// 한 게임 출력하는 메소드
	public static void displayLottoNumbers(HashSet lottoSet) {
		System.out.println(lottoSet);
	}
}
