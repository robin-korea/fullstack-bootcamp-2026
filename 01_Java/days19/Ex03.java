package days19;

import java.io.File;
import java.io.FileReader;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author An
 * @date 2026. 6. 8. 오후 4:32:17 
 * @subject 
 * @content 
 *
 */
public class Ex03 {

	public static void main(String[] args) {

		String parent = ".\\src\\days19";
		String child = "Ex01.java";

		File file = new File(parent, child);

		System.out.println(file.length() + "bytes");
		System.out.println(file.lastModified()); // 1780902938887 (long 형)

		/*
		Date d = new Date(file.lastModified());
		System.out.println(d.toLocaleString());
		 */

		long time = file.lastModified();
		LocalDateTime dt = toLocalDateTime(time);
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		System.out.println(dt.format(dtf));
		
		System.out.println(file.isDirectory());  // false
		System.out.println(file.isFile());       // true

		try (
				// 문자를 다루는 스트림(읽기 용도)
				FileReader reader = new FileReader(file);
				){
			
			int code;
			while( (code = reader.read()) != -1) {
				System.out.print((char)code);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static LocalDateTime toLocalDateTime(long time) {
		return LocalDateTime.ofInstant(
				Instant.ofEpochMilli(time),
				ZoneId.systemDefault());
	}

}
