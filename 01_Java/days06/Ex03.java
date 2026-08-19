package days06;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {

		/* 1번 문제
		String message = "Let's go!";

		System.out.println("3\n2\n1");
		System.out.println(message);
		 */

		Scanner sc = new Scanner(System.in);
		int angle1 = sc.nextInt();
		int angle2 = sc.nextInt();
		
		int sum_angle = (angle1 + angle2) % 360;
		System.out.println(sum_angle);
		
	}

}
