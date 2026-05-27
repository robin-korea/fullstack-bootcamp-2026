package days07;

public class Ex01 {

	public static void main(String[] args) {
		
		System.out.println("[구구단 가로출력]");
		for(int dan = 2; dan < 10; dan++) {
			for ( int i = 1; i < 10; i++) {
				System.out.printf("%d*%d=%d\t",dan,i,dan*i);
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("[구구단 세로출력]");
		for(int i = 1; i<10; i++) {
			for(int dan = 2; dan < 10; dan++) {
				System.out.printf("%d*%d=%d\t",dan,i,dan*i);
			}
			System.out.println();
		}

	
	}

}
