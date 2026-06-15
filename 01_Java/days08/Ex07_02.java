package days08;


public class Ex07_02 {

	public static void main(String[] args) {

		int money = 125760;
		int unit = 50000;
		boolean sw = false;
		int num = 0;
		while(unit >= 1) {
			// System.out.println(unit);
			num = money / unit;
			System.out.printf("%d원: %d 개\n",unit,num);
			money %= unit;
			unit /= sw ? 2 : 5;
			sw = !sw;
		}

	}

}
