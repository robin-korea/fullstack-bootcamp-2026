package days19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author An
 * @date 2026. 6. 8. 오후 5:14:08 
 * @subject
 * @content 
 *
 */
public class Ex05 {

	public static void main(String[] args) throws IOException {
		
		// System.in.read();
		
		// InputStream: 바이트 단위로 읽기 용도의 스트림
//		InputStream is = System.in;
//		
//		System.out.print("> 한 문자 입력 : ");
//		int b = is.read();
//		System.out.println(b);
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 키보드 부터 입력을 하다가 enter 를 치면 키보드로 부터 읽어드릴 수 있는 객체는 System.in
		// System.in: byte 단위로 읽어 드리는 스트림
		// System.in 은 '한' 을 읽어 올 수 없다 (byte가 아니기 때문에)
		// InputStreamReader 보조해주는 스트림 -> byte 값을 한 문자로 변환해주는 스트림
		// 여러개라면 buffer 기능이 있는 보조스트림에게 담는다 ex) [한문자][한문자][한문자][한문자]
		//	     ㄴ BufferedReader
	
		// br.readLine();  바이트 -> 한문자 -> 버퍼 문자열 -> 한라인문자열 전체를 읽기: readLine();
		
		// System.in 을 사용해서 한글 출력
		
		byte [] b = new byte[100];
		
		InputStream is = System.in;
		int totalBytes = is.read(b); // 키보드로 부터 읽어와서 byte 배열 b 한테 저장
		
		char one = new String(b).charAt(0);
		
		System.out.println(one);
		
		System.out.println("END");
	}  
		
}
