package days07;

public class Ex01_03 {                                   

	public static void main(String[] args) {
		
		
		for(int k = 1; k <= 3; k++) {
			for(int i = 1; i<10; i++) {
				for(int dan = 3*k-1; dan <= 3*k+1 && dan <= 9; dan++) {
		
					System.out.printf("%d*%d=%d\t",dan,i,dan*i);
				}
				System.out.println();
			}
			

			System.out.println();
		}
	}
}