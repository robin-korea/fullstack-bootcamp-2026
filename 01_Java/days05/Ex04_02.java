package days05;

import java.util.Scanner;

public class Ex04_02 {

	public static void main(String[] args) {
		// 두 정수 (n, m)을 입력받아 두 정수 사이의 합 출력

		int n;
		int m;

		Scanner sc = new Scanner(System.in);

		System.out.print("두 정수(n,m)을 입력해 주세요 :");

		n = sc.nextInt();
		m = sc.nextInt();
		
		int sum = 0;
		
		// 1
//		if ( n > m) {
//			int temp = n;
//			n = m;
//			m = temp;
//		}
//		
//		for (int i = n; i <= m; i++) {
//			System.out.printf("%d+",i);
//			sum += i;
//		}
		
		// 2
//		if(n > m) {
//			for (int i = n; i >= m; i--) {
//				System.out.printf("%d+",i);
//				sum += i;
//			}
//		}
//			else {
//				for (int i = n; i <= m; i++) {
//					System.out.printf("%d+",i);
//					sum += i;
//				}
//			}
		
		// 3
		
		int min = n > m ? m : n;
		int max = Math.max(n, m);
		
		for (int i = min; i <= max; i++) {
			System.out.printf("%d+",i);
			sum += i;
		}
			
	System.out.printf("=%d",sum);
	}
}
