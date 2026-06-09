package days20;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * @author An
 * @date 2026. 6. 9. 오후 4:16:40 
 * @subject UserInfo u1, u2          -> 직렬화  userinfo.ser
 * @content ArrayList<UserInfo> list -> 직렬화
 * 
 * 			userinfo.ser -> 역직렬화 해서 사용(출력)
 *
 */
public class Ex09_02 {

	public static void main(String[] args) {
			
		String name = ".\\src\\days20\\UserInfo.ser";
		
		try (
				FileInputStream in = new FileInputStream(name);
				ObjectInputStream ois = new ObjectInputStream(in);
				){
			
			UserInfo u1 = (UserInfo) ois.readObject();
			UserInfo u2 = (UserInfo) ois.readObject();
			ArrayList<UserInfo> list = (ArrayList<UserInfo>) ois.readObject();
			
			System.out.println(u1);
			System.out.println(u2);
			System.out.println(list);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("END");
		
		
	}

}
