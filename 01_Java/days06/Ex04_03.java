package days06;

import java.util.Scanner;

/**
 * @author An
 * @date 2026. 5. 18. 오후 2:03:35 
 * @subject 제어문
 * @content 세 정수(x,y,z)을 선언 후 값을 입력받아서
 *			가장 큰 값, 가장 작은 값을 찾아서 출력
 *
 *			Math.min(), Math.max() 사용
 */
public class Ex04_03 {

	public static void main(String[] args) {
		
		int x,y,z;
		
		Scanner sc = new Scanner(System.in);
		
		x = sc.nextInt();
		y = sc.nextInt();
	    z = sc.nextInt();
	    
	    System.out.printf("> x=%d, y=%d, z=%d\n",x,y,z);
	    
	    int max = Math.max(x, y);
	    max = Math.max(max, z);
	    
	    System.out.println("> 가장 큰 값: " + max);
	    
	    int min = Math.min(x, y);
	    min = Math.min(min, z);
	    
	    System.out.println("> 가장 작은 값: " + min);
	    
	}

}
