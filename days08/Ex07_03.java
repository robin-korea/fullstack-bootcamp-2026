package days08;

public class Ex07_03 {

	public static void main(String[] args) {
		int sum = 0;
		boolean sw = false;

		for(int i = 1; i <= 10 ;i++) {
			if(sw) {
				System.out.printf("%d+",i);
				sum -= i;
			}else {
				System.out.printf("%d-",i);
				sum += i;
			}
			sw = !sw;
		}
		System.out.printf("=%d\n",sum);
	}

}
