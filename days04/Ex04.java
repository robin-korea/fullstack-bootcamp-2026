package days04;

public class Ex04 {

	public static void main(String[] args) {

		// 문자열을 비교할 때는 동등(==, !=) 연산자 대신 equals()와 !equals()를 사용
		System.out.println( +3 );  // 부호연산자
		System.out.println( 5+3 );
		System.out.println( "5"+3 );

		// 연산자 방향  <------      ------> 의미?
		// [  4바이트 -21~21억 정수]
		//          x
		int x = 3 + 5 + 6 + 7;
		System.out.println( x );

		// 연산자 방향  <------    

		boolean flag = false;
		//                  !   부정(Not)연산자
		
		System.out.println( !!!!!flag );

		//int a=100, b=100, c=100, d=100;
		int a, b, c, d;
		
		// a,b,c,d 변수의 값을 모두 100으로 초기화
		//	      a = 100;
		//	      b = 100;
		//	      c = 100;
		//	      d = 100;

		a = b = c = d = 100;
		// ----------->


	}//main

}//class
