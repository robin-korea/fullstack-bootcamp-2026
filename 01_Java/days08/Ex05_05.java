package days08;

public class Ex05_05 {

	 public static void main(String[] args) {
		  // Call By Reference 
	      int x = 10, y = 20;      
	      System.out.printf("x=%d, y=%d\n", x, y);
	      // drawLine();     Call By Name
	      swapXY(x, y);   // Call By Value
	      System.out.printf("x=%d, y=%d\n", x, y);   
	   }

	   private static void swapXY(int x, int y) {
	      int temp = x;
	      x = y;
	      y = temp;          
	      
	   }

}
