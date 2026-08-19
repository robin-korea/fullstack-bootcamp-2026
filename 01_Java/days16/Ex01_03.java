package days16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author An
 * @date 2026. 6. 2. 오전 10:21:29 
 * @subject
 * @content 
 *
 */
public class Ex01_03 {

	public static void main(String[] args) {
		
		// 학생명단.txt 읽어서 학생 이름만 출력
		
		// . 현재 디렉토리    javaPro 폴더
		// .. 상위 디렉토리   
		String fileName = ".\\src\\days16\\학생명단.txt";
		String saveFileName = ".\\src\\days16\\학생명단.html";
		
		try(
				FileReader in = new FileReader(fileName);
				BufferedReader br = new BufferedReader(in);
				FileWriter out = new FileWriter(saveFileName);
				){
			
			String name = null;
			System.out.println("<ol>");
			out.write("<ol>\\n");   // 파일쓰기(저장)
			while((name = br.readLine()) != null) {
				System.out.printf("<li>%s</li>\n",name);
				out.write("<li>"+name+"</li>\n");  // 파일쓰기(저장)
			}
			System.out.println("</ol>");
			out.write("</ol>\\n");  // 파일쓰기(저장)
			 
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("END");
	}

}
