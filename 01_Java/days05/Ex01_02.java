package days05;

public class Ex01_02 {

	public static void main(String[] args) {
		
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			
			if( i < 10 ) {
				System.out.printf("%d+",i);
			}
			else {
				System.out.printf("%d",i);
			}
			
			sum += i;
			
		}
		System.out.printf("=%d\n",sum);
		
		int i = 1;
		int total = 0;
		while(i <= 10) {
			if( i < 10 ) {
				System.out.printf("%d+",i);
			}
			else {
				System.out.printf("%d",i);
			}
			
			total += i;
			i++;
		}
		
		System.out.printf("=%d",total);
		
	}

}

/* 2. 1+2+3+...+9+10=55
*    1에서 10까지의 합을 출력하는 코딩.
*    1) for문 사용해서 풀기
*    2) while문 사용해서 풀기
*/
