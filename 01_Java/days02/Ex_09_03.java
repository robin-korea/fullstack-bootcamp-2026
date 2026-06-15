package days02;

public class Ex_09_03 {

	public static void main(String[] args) {
			
		/*
		 * 1) 자동형변환
		 *    A경우: 작은자료형 +(연산) 큰자료형 -> 큰자료형
		 *    B경우: 작은자료형의 값을 큰자료형에 할당(대입)할 때는 
		 * 2) 강제형변환
		 * */
		
		int i = 100;  // [][][][] 4byte
		//       int
		long l = 1;   // [][][][][][][][] byte
		
		System.out.println( i + l );  // 자동형변환 처리된 경우
		
		int a = 100;
		long b = a;
		System.out.println( b );
		
		// byte + byte + byte -> int 
		
		
		//  1  [][][][] int
		// 1L   1l
		long x = 1;
		long y = 1L; // 1l
		
		// Type mismatch: cannot convert from double to float
		float avg = 98.76F; // f 접미사
		
		
		int z = 100;
		//        cast 연산자  ()     cast 강제형변환
		short s = (short)z;
		System.out.println( s );
		
		// () 최우선연산자
		// ( 4 + 5 ) * 2 = 18
		
	}//main

}//class
