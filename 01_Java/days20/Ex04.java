package days20;

import java.io.File;
import java.io.IOException;

/**
 * @author An
 * @date 2026. 6. 9. 오전 10:33:05 
 * @subject [File 클래스]
 * @content   ㄴ 파일, 디렉토리(폴더)를 관리할 수 있는 기능이 구현된 클래스
 *
 */
public class Ex04 {

	public static void main(String[] args) throws IOException {

		// String pathname = ".\\src\\days25";
		// String pathname = ".\\src\\days20";
		String pathname = ".\\src\\days20\\Ex01.java";
		File f = new File(pathname);

		System.out.println(f.exists());       // true
		System.out.println(f.isFile());       // true
		System.out.println(f.isDirectory());  // false

		System.out.println(File.pathSeparator);
		System.out.println(File.separator);

		String fileName = f.getName();
		System.out.println(fileName);

		// 순수파일명: Ex01
		// 확장자:    java
		
		int index = fileName.indexOf(".");
		String baseFileName = fileName.substring(0,index);
		System.out.println(baseFileName);
		
		String ext = fileName.substring(index+1);
		System.out.println(ext);
		
		System.out.println("=".repeat(50));
		
		//.\src\days20\Ex01.java
		System.out.println(f.getPath());
		
		// C:\Class\JavaClass\javaPro\.\src\days20\Ex01.java
		System.out.println(f.getAbsolutePath());
		
		// C:\Class\JavaClass\javaPro\src\days20\Ex01.java
		System.out.println(f.getCanonicalPath());
		
		System.out.println("=".repeat(50));
		System.out.println(f.getParent());
		File pf = f.getParentFile();
		System.out.println(pf);
	}

}
