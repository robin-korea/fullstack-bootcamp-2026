package days10;

import java.util.Arrays;

public class Ex09_02 {

	public static void main(String[] args) {
		
		int[][] m = {
				{1,2,3,4},  
				{5,6,7,8}    
		};
		
		int [] n = new int[8];
		
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				n[i*m[i].length+j] = m[i][j]; 
			}
		}
		
		System.out.println(Arrays.toString(n));

	}

}
