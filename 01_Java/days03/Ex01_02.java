package days03;

import java.util.Calendar;

public class Ex01_02 {

	public static void main(String[] args) {
		
//		Calendar  c = Calendar.getInstance();
//		String s = String.format("Duke's Birthday: %1$tm %1$te,%1$tY", c);
//		System.out.println(s);
		
		System.out.println("-".repeat(50));
		
		String name = "이창익";
		short tot = 253;
		double avg = 84.333333;
		
//      %[argument_index$][flags][width][.precision]conversion
//  	System.out.printf("%1$s_%1$s_%1$s",name);		
//		System.out.printf("총점 [%10d]\n",tot);
//		System.out.printf("총점 [%-10d]\n",tot);
		
//                      	% conversion
//		System.out.printf("평균: [%10.2f]\n", avg);
		
		int no = 10;
//		System.out.printf("방번호: [%04d]\n", no);
		System.out.printf("방번호: [%d]\n", no); // 10진수
		System.out.printf("방번호: [%o]\n", no); // 8진수
		System.out.printf("방번호: [%x]\n", no); // 16진수
		System.out.printf("방번호: [%X]\n", no); // 대문자 16진수
		System.out.printf("방번호: [%d]\n", no); 
		System.out.printf("방번호: [%#o]\n", no); 
		System.out.printf("방번호: [%#x]\n", no); 
		System.out.printf("방번호: [%#X]\n", no); 
		
		
		int n = -123;
//		System.out.printf("n=%(d\n",n);
	}//main

}//class
