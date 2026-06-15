package days04;

/**
 * @author An
 * @date 2026. 5. 14. 오후 4:48:39 
 * @subject
 * @content 
 *
 */
public class Ex11 {

	public static void main(String[] args) {
		
		int i = 1;
		int sum = 0;
		
		while(i <= 10) {
			System.out.printf("%d+",i);			
			
			sum += i;
			i++;
		}
		
		System.out.printf("=%d\n",sum);
		
		System.out.println("END");
		
	}

}
