package days07;

public class Ex01_02 {

	public static void main(String[] args) {

		for(int k = 1; k <= 2; k++) {
			for(int i = 1; i<10; i++) {
				for(int dan = 4*k-2; dan <= 4*k+1; dan++) {
					System.out.printf("%d*%d=%d\t",dan,i,dan*i);
				}
				System.out.println();
			}

			System.out.println();
		}


		/*
		System.out.println("[구구단 세로출력]");
		for(int i = 1; i<10; i++) {
			for(int dan = 2; dan < 6; dan++) {
				System.out.printf("%d*%d=%d\t",dan,i,dan*i);
			}
			System.out.println();
		}

		System.out.println();

		for(int i = 1; i<10; i++) {
			for(int dan = 6; dan < 10; dan++) {
				System.out.printf("%d*%d=%d\t",dan,i,dan*i);
			}
			System.out.println();
		}
		 */
	}
}
