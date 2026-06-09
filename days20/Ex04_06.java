package days20;

import java.io.File;

public class Ex04_06 {

	public static void main(String[] args) {
		
		  // [문제1]
	      // javaPro 폴더
	      //    ㄴ temp 폴더 생성
	      //          ㄴ 1조  폴더 생성 
	      //          ㄴ 2조  폴더 생성
	      //          ㄴ 3조  폴더 생성
		
		/*
		File f1 = new File(".\\temp\\1조");
		File f2 = new File(".\\temp\\2조");
		
		f1.mkdirs();
		f2.mkdirs();
		*/
		
		for (int i = 1; i < 3; i++) {
			File f = new File(".\\temp\\" + i + "조");
			f.mkdirs();
		}
	}

}
