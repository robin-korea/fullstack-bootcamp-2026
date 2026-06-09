package days20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class Ex08_02 {

	public static void main(String[] args) throws IOException {
		
		Vector<FileInputStream> v = new Vector<>();
		
		for(int i = 1; i <= 9; i++) {
			String name = ".\\src\\days20\\시간표-" + i + ".pdf";
			FileInputStream fis = new FileInputStream(name);
			v.add(fis);
		}
		
		Enumeration<FileInputStream> en = v.elements();
		SequenceInputStream sis = new SequenceInputStream(en);
		
		FileOutputStream fos = new FileOutputStream(".\\src\\days01\\시간표.pdf");
		
		int b;
		
		while((b = sis.read())!= -1){
			fos.write(b);
		}
		
		fos.close();
		sis.close();
		
		System.out.println("END");
	}

}
