package days06;

import java.util.Scanner;

/**
 * @author An
 * @date 2026. 5. 18. 오후 2:03:35 
 * @subject 제어문
 * @content 세 정수(x,y,z)을 선언 후 값을 입력받아서
 *			가장 큰 값, 가장 작은 값을 찾아서 출력
 *			
 *			삼항연산자 사용
 */
public class Ex04_02 {

	public static void main(String[] args) {
		
		int x,y,z;
		
		Scanner sc = new Scanner(System.in);
		
		x = sc.nextInt();
		y = sc.nextInt();
	    z = sc.nextInt();
	    
	    System.out.printf("> x=%d, y=%d, z=%d\n",x,y,z);
	    
	    int max = x > y ? (x > z ? x : z) : (y > z ? y : z);
	    System.out.println("가장 큰 값: " + max);
	    
	    int min = x > y ? (y > z ? z : y) : (x > z ? z : x);
	    System.out.println("가장 작은 값: " + min);
	}

}
