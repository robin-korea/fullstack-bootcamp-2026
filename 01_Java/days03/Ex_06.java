package days03;

public class Ex_06 {

	public static void main(String[] args) {
		
		 int x = 10;
	     int y = 20;
	      
	     System.out.printf("> 전: x=%d, y=%d\n", x, y);
	      
	     // 임시 기억공간이 필요하다.
	     {
	    	int temp = x; // x 값을 temp 에 넣는다   temp -> 10 , x -> 10
	    	x = y;        // y 값을 x 에 넣는다      x -> 20 , y -> 20
	    	y = temp;     // temp 값을 y 에 넣는다   y -> 10 , temp -> 10
	     }
	     
	     System.out.printf("> 후: x=%d, y=%d\n", x, y);   
		
		
	}//main

}//class
