package days20;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * @author An
 * @date 2026. 6. 9. 오후 4:16:40 
 * @subject 
 * @content 
 * 
 * 			
 *
 */
public class Ex10_02 {

	public static void main(String[] args) {
			
		String name = ".\\src\\days20\\Child.ser";
		
		try (
				FileInputStream in = new FileInputStream(name);
				ObjectInputStream ois = new ObjectInputStream(in);
				){
			
			Child c1 = (Child) ois.readObject();
		
			System.out.println(c1.name);
			System.out.println(c1.age);
			System.out.println(c1.email);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("END");
		
		
	}

}
