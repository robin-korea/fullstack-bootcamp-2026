package days06;

public class Ex08_03 {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 9 ; i++) {
	         // System.out.printf("[ %d]단\n", dan); // 2~9 
	         for (int dan = 2; dan <= 9; dan++) {
	            System.out.printf("%d*%d=%02d ", dan, i, dan * i);
	         }
	         System.out.println();
	         
		}
		
	}

}
