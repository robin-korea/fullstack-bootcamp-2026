package days04;

/**
 * @author An
 * @date 2026. 5. 14. 오후 4:31:14 
 * @subject
 * @content 
 *
 */
public class Ex10_02 {

	public static void main(String[] args) {
		
//		for(int i = 1; i <=10; i++) {
//			System.out.println(i);
//		}
		
		int sum = 0;
		
		for(int i = 1; i <= 10; i++) {
			System.out.printf("%d+",i);
			sum += i;
		}
		System.out.printf("=%d",sum);
		
		
	}//main

}//class
