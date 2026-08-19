package days20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author An
 * @date 2026. 6. 9. 오후 2:31:57 
 * @subject 
 * @content 
 *
 */
public class Ex07 {

	public static void main(String[] args) {

		// javaPro 폴더 및 모든 하위 폴더의 자바파일을 찾아서 출력

		String pathname = ".";
		File parent = new File(pathname);
		// File [] jf = parent.listFiles(f-> f.getName().endsWith("java"));
		String keyword = "parent";

		quickSearch(parent, keyword);

		System.out.println("END");

	}

	private static void quickSearch(File parent, String keyword) {

		File [] list = parent.listFiles();
		int lineNumber = 0;
		File f = null;
		String line = null;

		for (int i = 0; i < list.length; i++) {
			f = list[i];

			if(f.isDirectory()) { // 하위 디렉토리인지
				quickSearch(f,keyword);
			} else {
				lineNumber = 1;
				String fileName = f.getName();

				try (
						FileReader in = new FileReader(f);
						BufferedReader br = new BufferedReader(in);
						){

					while( (line = br.readLine()) != null) {
						if (line.contains(keyword)) {

							line = line.replaceAll(keyword, "[" + keyword + "]");

							System.out.printf("%s: %d: %s\n"
									,fileName,lineNumber,line);
						}
						lineNumber++;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} 
	}

}
