package days06;

public class Ex01 {

	public static void main(String[] args) {

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
			
			for(int i = 0; i < index ; i++) {
				if(lottoNumbers[i] == lottoNumber) {
					isFlag = true;
					break;
				}
				
			}
			if(isFlag == false) {
				lottoNumbers[index++] = lottoNumber;
			}
		}
		for(int i = 0; i <= lottoNumbers.length - 1; i++) {
			System.out.printf("[%d]",lottoNumbers[i]);
		}
	}
}

