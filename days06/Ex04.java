package days06;

import java.util.Scanner;

/**
 * @author An
 * @date 2026. 5. 18. 오후 2:03:35 
 * @subject 제어문
 * @content 세 정수(x,y,z)을 선언 후 값을 입력받아서
 *			가장 큰 값, 가장 작은 값을 찾아서 출력
 *
 *			if~else 문
 */
public class Ex04 {

	public static void main(String[] args) {
		
		int x,y,z;
		
		Scanner sc = new Scanner(System.in);
		
		x = sc.nextInt();
		y = sc.nextInt();
	    z = sc.nextInt();
	    
	    System.out.printf("> x=%d, y=%d, z=%d\n",x,y,z);
	    
	    if(x > y) {
	    	if(x > z) {
	    		System.out.println("가장 큰 값: " + x);
	    	}else {
	    		System.out.println("가장 큰 값: " + z);
	    	}
	    } else {
	    	if(y > z) {
	    		System.out.println("가장 큰 값: " + y);
	    	}else {
	    		System.out.println("가장 큰 값: " + z);
	    	}
	    }
	    
	    if(x > y) {
	    	if(y > z) {
	    		System.out.println("가장 작은 값: " + z);
	    	}else {
	    		System.out.println("가장 작은 값: " + y);
	    	}
	    } else {
	    	if(x > z) {
	    		System.out.println("가장 작은 값: " + z);
	    	}else {
	    		System.out.println("가장 작은 값: " + x);
	    	}
	    }
	    
	}

}
