package days07;

/**
 * @author An
 * @date 2026. 5. 19. 오전 10:03:21 
 * @subject break 라벨
 * @content continue 라벨
 *
 */
public class Ex01_04 {

	public static void main(String[] args) {

		OUT:
		for(int i = 1; i<=9; i++) {
			for(int d = 2; d <= 9; d++) {
				if(d == 5) break OUT;
				System.out.printf("%d*%d=%d\t",d,i,d*i);
			}
			System.out.println();

		}
	}

}
