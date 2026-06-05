package days18;

import java.util.Enumeration;
import java.util.Properties;

public class Ex12 {

	public static void main(String[] args) {
		
		// C:\Class\JavaClass\javaPro 
		String userDir = System.getProperty("user.dir");
		System.out.println(userDir);
		
		// String key, String value
		// 속성명 : 키값 가져온다
		
		Properties p = System.getProperties();
		
		// 열거자     <?> 와일드 카드 
		Enumeration<String> en = (Enumeration<String>) p.propertyNames();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			String value = p.getProperty(key);
			System.out.printf("%s: %s\n",key,value);
		}
	}

}
