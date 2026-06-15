package days05;

public class Ex07_02 {

	public static void main(String[] args) {
		
		// 중복되지 않는 6개의 로또번호 발생
		int lottoNumber;
		
		for(int i = 0; i <=5; i++) {
			lottoNumber = (int) (Math.random()*45)+1;
			System.out.println(lottoNumber);
		}
		
		
	}

}
