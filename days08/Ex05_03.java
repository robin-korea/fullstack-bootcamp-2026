package days08;

import java.util.Arrays;

public class Ex05_03 {

	public static void main(String[] args) {
	      
	      // x=10, y=20     참조타입
	      int [] m = new int[2];
	      
	      m[0]=10;
	      m[1]=20;
	      
	      System.out.println( Arrays.toString(m));
	      
	      dispM( m );
	      
	      System.out.println( Arrays.toString(m));
	       
	   } // main

	   private static void dispM(int[] m) { 
	      int temp = m[0];
	      m[0] = m[1];
	      m[1] = temp;
	   }

} 


