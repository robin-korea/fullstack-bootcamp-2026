package days05;

public class Ex07_03 {

	public static void main(String[] args) {

		//1
		int lottoNumber1;
		lottoNumber1 = (int) (Math.random()*45)+1;

		//2
		int lottoNumber2;
		do {
			lottoNumber2= (int) (Math.random()*45)+1;
		} while (lottoNumber1 == lottoNumber2);

		// 3
		int lottoNumber3;
		do {
			lottoNumber3 = (int)(Math.random() * 45) + 1;
		} while (lottoNumber1 == lottoNumber3 || lottoNumber2 == lottoNumber3);
		
		// 4
		int lottoNumber4;
		do {
			lottoNumber4 = (int)(Math.random() * 45) + 1;
		} while (lottoNumber1 == lottoNumber4 || lottoNumber2 == lottoNumber4 || lottoNumber3 == lottoNumber4);
		
		// 4
		int lottoNumber5;
		do {
			lottoNumber5 = (int)(Math.random() * 45) + 1;
		} while (lottoNumber1 == lottoNumber5 || lottoNumber2 == lottoNumber5 || lottoNumber3 == lottoNumber5 || lottoNumber4 == lottoNumber5);
		// 4
		
		int lottoNumber6;
		do {
			lottoNumber6 = (int)(Math.random() * 45) + 1;
		} while (lottoNumber1 == lottoNumber6 || lottoNumber2 == lottoNumber6 || lottoNumber3 == lottoNumber6 || lottoNumber4 == lottoNumber6 || lottoNumber5 == lottoNumber6);

		
		
		System.out.println(lottoNumber1);
		System.out.println(lottoNumber2);
		System.out.println(lottoNumber3);
		System.out.println(lottoNumber4);
		System.out.println(lottoNumber5);
		System.out.println(lottoNumber6);
		
	}

}
