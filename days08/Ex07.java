package days08;

public class Ex07 {

	public static void main(String[] args) {

		int money = 125760;
		int share,rest;
		
		int [] unit = {50000,10000,5000,1000,500,100,50,10,5,1};
		String [] sUnit =  { "5만원","1만원","5천원", "1천원", "5백원", "1백원","5십원","1십원","5원","1원" };;
		
		for(int i = 0; i < unit.length; i++) {
			share = money / unit[i];
			System.out.printf("%s : %d 개\n",sUnit[i], share);
			rest = money % unit[i];
			money = rest;
		}
		
		
		/* 아래 코딩을 반복문으로 처리...
		share = money / 50000;
		System.out.printf("5만원 : %d 개\n", share);
		rest = money % 50000;
		money = rest;

		share = money / 10000;
		System.out.printf("1만원 : %d 개\n", share);
		rest = money % 10000;
		money = rest;

		share = money / 5000;
		System.out.printf("5천원 : %d 개\n", share);
		rest = money % 5000;
		money = rest;

		share = money / 1000;
		System.out.printf("1천원 : %d 개\n", share);
		rest = money % 1000;
		money = rest;

		share = money / 500;
		System.out.printf("5백원 : %d 개\n", share);
		rest = money % 500;
		money = rest;

		share = money / 100;
		System.out.printf("1백원 : %d 개\n", share);
		rest = money % 100;
		money = rest;

		share = money / 50;
		System.out.printf("5십원 : %d 개\n", share);
		rest = money % 50;
		money = rest;

		share = money / 10;
		System.out.printf("1십원 : %d 개\n", share);
		rest = money % 10;
		money = rest;
		
		share = money / 5;
		System.out.printf("5원 : %d 개\n", share);
		rest = money % 5;
		money = rest;
		
		share = money / 1;
		System.out.printf("1원 : %d 개\n", share);
		rest = money % 1;
		money = rest;
		*/

	}



}
