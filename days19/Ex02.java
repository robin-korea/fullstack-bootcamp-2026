package days19;

/**
 * @author An
 * @date 2026. 6. 8. 오후 4:16:23 
 * @subject Chapter 18 자바의 IO(입출력)
 * @content 
 *
 */
public class Ex02 {

	public static void main(String[] args) {
		/*
		 *   1. 자바의 IO(입출력)
		 *   		 기준
		 *   <컴퓨터 내부에서 프로그램>   --출력-->   <외부 장치(프로그램)>
		 *                            송신           모니터, 프린터
		 *                           Output
		 *                                  
		 *                           <--입력---         키보드
		 *                              수신
		 *                             Input 
		 *                                           
		 *   2. 자바의 모든 입출력은 [스트림(Stream)] 이라는 개념으로 이루어진다. 
		 *   
		 *   3. 자바 스트림(Stream)
		 *      ㄴ 흐르는 물 , (빨대)
		 *      ㄴ 단방향
		 *          1) 읽기(입력) 스트림
		 *          2) 쓰기(출력) 스트림
		 *          
		 *   4. 자바 스트림 2가지 종류
		 *      1) 문자(텍스트)  스트림
		 *          Reader 최상위 부모클래스
		 *          Writer       "                 
		 *                FileReader, FileWriter
		 *          1문자 ( == char == 유니코드 2바이트  )      
		 *                     int
		 *          한 문자,  문자열, 문자 배열 
		 *                Buffered[Reader]/Buffered[Writer]
		 *                     
		 *      2) 바이트(이진)  스트림
		 *          InputStream  최상위 부모클래스
		 *          OutputStream 최상위 부모클래스
		 *              FileInputStream, FileOutputStream 
		 *          0/1    1비트 단위 처리 X
		 *          1바이트(8비트) , 바이트 배열,  정수(int) 
		 *               BufferedInputStream/ BufferedOutputStream
		 *  
		 *  5. 보조스트림 - 어떤 스트림의 입출력을 더 쉽도록 보조
		 *   역할을 하는 스트림
		 *      - 문자 보조스트림 ( 입/출 )
		 *      - 바이트 보조스트림 ( 입/출 )
		 * */


	}

}
