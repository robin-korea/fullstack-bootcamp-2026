package days20;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author An
 * @date 2026. 6. 9. 오후 3:05:47 
 * @subject 시간표.pdf 450KB
 * @content    ㄴ 50KB
 * 			여러 개의 파일로 분할
 *           시간표-1.pdf
 *           시간표-2.pdf
 * 				   ㄴ 번호로 구분
 * 			-> 합치기
 *
 */
public class Ex08 {

	public static void main(String[] args) {
		
		String parent = ".\\src\\days20";
		String child = "\\시간표.pdf";
		File f = new File(parent + child);
		
		// System.out.println(f.length() + "(bytes)"); // 460800(bytes)
		final int VOLUME = 1024 * 50; // 50KB
		
		String fileName = f.getName();
		int index = fileName.indexOf(".");
		String baseFileName =  fileName.substring(0, index);
		String ext = fileName.substring(index);
		
		// 바이트 스트림 쓰기(저장)
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		int code = 0;
		int i = 0;
		index = 0;
		
		try (
				FileInputStream in = new FileInputStream(f);
				BufferedInputStream bis = new BufferedInputStream(in);
						){
			while((code = bis.read()) != -1) {
				if (i % VOLUME == 0) { // 50KB
					if(i != 0) bos.close();
					
					child = String.format("%s-%d%s", baseFileName, ++index, ext);
					File temp = new File(parent,child);
					fos = new FileOutputStream(temp);
					bos = new BufferedOutputStream(fos);
				}
				
				bos.write(code);
				i++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("END");

	}

}
