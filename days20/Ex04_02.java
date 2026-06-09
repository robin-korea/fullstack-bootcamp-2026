package days20;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex04_02 {

	public static void main(String[] args) {
		
		String userDir = System.getProperty("user.dir");
		// C:\Class\JavaClass\javaPro
		// System.out.println(userDir);
		
		File parent = new File(userDir);
		
		File [] list = parent.listFiles();
		
		String pattern = "yyyy-MM-dd a h:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		for (int i = 0; i < list.length; i++) {
			File f = list [i];
			String name = f.getName();
			
			// 2026-05-20 오후 2:22
			long time = f.lastModified();
			
			Date d = new Date(time);
			String lmDate = sdf.format(d);
			
			long fLength = f.length();
	
			System.out.printf("%s\t%s\t%d(kb) \n",f.isDirectory() ? "[" + name + "]" : name, 
					lmDate,f.isDirectory() ? 0 : (int)(Math.ceil((double)fLength/1024)));
		}

	}

}
