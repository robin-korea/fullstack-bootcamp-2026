package days09;

public class Ex07 {

	public static void main(String[] args) {
		// ****
		// ****
		// ****
		// ****

		// System.out.println("****");
		// System.out.println("****");
		// System.out.println("****");
		// System.out.println("****");

		// for (int i = 1; i <= 4; i++) {
		//	 System.out.println("****");
		//	}

		// i=1  j=1,2,3,4       
		// i=2  j=1,2,3,4
		// i=3  j=1,2,3,4
		// i=4  j=1,2,3,4
		for (int i = 1; i <= 4; i++) {       // 행갯수   
			for (int j = 1; j <= 4; j++) {  // 열갯수
				System.out.print("*");
			} 
			System.out.println();         
		}

	}

}
