package days18;
import java.io.FileWriter;
import java.util.Properties;

public class Ex11 {

	public static void main(String[] args) {
		
		String group = "1조:양인석/안정빈/신창만/이지훈/장미성";
		
		String [] groupArr = group.split(":");
		String fileName = ".\\src\\days18\\group1.properties";


		Properties p = new Properties();
		// p.put(className, p)
		p.setProperty(groupArr[0], groupArr[1]);

		try (
				FileWriter writer = new FileWriter(fileName);
				){
			p.store(writer, "comments");

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("END");

	}
}
