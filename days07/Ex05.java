package days07;

/**
 * @author An
 * @date 2026. 5. 19. 오후 2:30:25 
 * @subject 메서드 + 제어문 + 배열
 * @content 로또번호 발생시키는 코딩   days05.Ex07_06.java
 * 			1) 로또번호 발생시키는 함수:    createLottoNumbers()
 * 			2) 중복 체크:                boolean isDuplicateLottoNumber() 중복이 되면 true 중복이 안되면 false
 * 			3) 로또번호 6개 -> 출력 함수 :  displayLottoNumbers()
 *
 */
public class Ex05 {

	public static void main(String[] args) {

		int [] lottoNumbers = new int[6];

		createLottoNumbers(lottoNumbers);
		
		displayLottoNumbers(lottoNumbers);

		

	}

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

	public static void displayLottoNumbers(int[] lottoNumbers) {
		for( int i = 0 ; i < lottoNumbers.length; i++) {
			System.out.printf("[%d]" ,lottoNumbers[i]);
		}
		System.out.println();
	}

}
