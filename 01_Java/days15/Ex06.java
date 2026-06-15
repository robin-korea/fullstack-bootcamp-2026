package days15;

/**
 * @author An
 * @date 2026. 6. 1. 오전 11:44:57 
 * @subject
 * @content 
 *
 */
public class Ex06 {

	public static void main(String[] args) {

		/*
		 * [예외처리(Exception Handling)]
		 * 1. 오류 ? 프로그램 실행 중에 오작동 또는 비정상 종료되는 원인
		 * 2. 오류 발생 시점에 따라... 
		 *   1) 컴파일 오류
		 *      int a
		 *   2) 실행 오류 == 런타임(Runtime) 오류  
		 *     int [] m  = null;
	             m[0] = 100;
	             System.out.println( m[0]);
	                (1) 에러(Error) : 복구할 수 없는 심각한 오류
	                                  메모리 부족, 스택 오버프로워 등등
	                    Error 부모클래스
	                       ㄴ Error 자식클래스....              
	                (2) 예외(Exception) : 에러보다 덜 심각한 비교적 수습될 수 있는 실행 오류
	                    Exception 부모클래스
	                       ㄴ 자식 클래스
	           3) 논리적 오류( 가장 어려운 오류 ) 
	                 int i = Integer.MAX_VALUE;
	               int j = i + 100;
	               System.out.println( j ); // -2147483549           
		 * */

		/*
		 *  java.lang.NullPointerException 예외가 발생했다.
		 *  JVM 안에  "예외처리기"가 발생한 예외를 예외객체(NullPointerException)
		 *  로 생성해서 개발자에 예외를 처리하도록 전달...
		 *  
		 *  [예외처리]
		 *  - 프로그램 실행 시 발생할 수 있는 예기치 못한 예외의 발생에
		 *  대비한 코드를 작성하는 것.
		 *  
		 *                          Object
		 *                             ↑
		 *                          Throwable
		 *                             ↑  
		 *           Exception                      Error
		 *              ↑
		 *      [RuntimeException]       IOException...
		 *             ㄴ NullPointerException                                       
		 *             ㄴ ArithmeticExceptioon    
		 *             등등    
		 *             
		 *  [예외]
		 *  [예외처리]
		 *  *** [예외처리 방법] ***
		 *     1. try~catch문 사용
		 *     2. throws 문 사용                                       
		 * */


	}

}
