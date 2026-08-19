package days20;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author An
 * @date 2026. 6. 9. 오전 9:29:40 
 * @subject
 * @content Piped[Reader]/Piped[Writer]
 * 				ㄴ Reader, Writer 문자 스트림 
 *				ㄴ 스레드 간에 데이터를 주고 받을 때 사용하는 스트림
 *				
 *				RandomAccessFile 스트림
 *                  ㄴ 파일의 어느 위치에서나 읽기/쓰기가 가능한 스트림
 *                  ㄴ   seek(index)
 *                  ㄴ   getFilePointer()
 *                           파일포인터
 */
public class Ex03 {

	public static void main(String[] args) throws IOException {

		// [2] 테스트
		String s = "I Love normal Java";
		String q = "javabook";

		String name = ".\\random.txt";
		String mode = "rw";

		try (RandomAccessFile raf = new RandomAccessFile(name, mode)){
			raf.writeBytes(s); // "I Love normal Java"
		} catch (Exception e) {
			e.printStackTrace();
		}

		일시정지(); // 파일 확인
		
		try (RandomAccessFile raf = new RandomAccessFile(name, mode)){
			raf.seek(2); // fp 0 -> 2
			raf.writeBytes(q); // "javabook"
		} catch (Exception e) {
			e.printStackTrace();
		}

		일시정지(); // 파일 확인
		
		try (RandomAccessFile raf = new RandomAccessFile(name, mode)){
			raf.seek(2); // fp 0 -> 2
			String line = raf.readLine();
			System.out.println(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("END");
		
		
		// [1] 간단하게 테스트
		//		String name = ".\\test.txt";
		//		String mode = "rw";
		//		
		//		try (
		//			RandomAccessFile raf = new RandomAccessFile(name, mode);
		//				){
		//			System.out.println("> 파일 포인터의 위치 : " + raf.getFilePointer());
		//			raf.writeInt(100); // 4바이트 int
		//			System.out.println("> 파일 포인터의 위치 : " + raf.getFilePointer());
		//			raf.writeLong(200L); // 8바이트 long
		//			System.out.println("> 파일 포인터의 위치 : " + raf.getFilePointer());
		//			raf.seek(0); // 처음으로 원위치
		//			System.out.println("> 파일 포인터의 위치 : " + raf.getFilePointer());
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}

	}

	private static void 일시정지() throws IOException {

		// 일시 정지 + 엔터 계속....
		System.out.println("> 엔터 치면 진행한다. ");
		System.in.read();
		System.in.skip(System.in.available()); // 13, 10 제거
		
	}

}
