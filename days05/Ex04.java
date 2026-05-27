package days05;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		
		int n;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수(n)을 입력해 주세요 :");
		n = sc.nextInt();
		
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			System.out.printf("%d+",i);
			sum += i;
		}
		System.out.printf("=%d",sum);

	}

}
