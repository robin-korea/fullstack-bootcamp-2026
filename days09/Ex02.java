package days09;

import java.util.Arrays;

/**
 * @author An
 * @date 2026. 5. 21. 오전 10:38:57 
 * @subject 10 -> 00001010  제어문 연습
 * @content 
 *
 */
public class Ex02 {

	public static void main(String[] args) {
		
		int n = 10;
		String s = binaryConvert(n);
		System.out.println(s);
		
	}

	public static String binaryConvert(int n) {
		int [] result = new int[8];
		
		int index = result.length-1;
		int share = n, rest;
		while(share != 0) {
			rest = share % 2;
			share /= 2;
//			System.out.println(rest);
			result[index--] = rest;
		}
		return Arrays.toString(result);
	}

}
