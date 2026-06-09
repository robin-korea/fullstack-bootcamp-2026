package days20;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 * @author An
 * @date 2026. 6. 9. 오후 3:45:46 
 * @subject 직렬화 (Serialization): 객체를 파일/네트워크 입출력하기 위해서 스트림으로 만드는 것
 * @content 역직렬화 (Deserialization): 직렬화된 바이트를 객체의 필드값으로 복원하는 것
 *				ObjectInputStream 역직렬화       스트림 ->  객체 복원
 *				ObjectOutputStream 직렬화         객체 ->  스트림
 *
 *				UserInfo 클래스 객체  생성해서 직렬화시켯 파일 쓰기/읽기
 *
 */		
public class Ex09 {

	public static void main(String[] args) {
						
		UserInfo u1 = new UserInfo("홍길동","1234",25);
		UserInfo u2 = new UserInfo("홍길동","1234",25);
		
		ArrayList<UserInfo> list = new ArrayList<UserInfo>();
		list.add(u1);
		list.add(u2);
		
		String name = ".\\src\\days20\\UserInfo.ser";
		
		try (
				FileOutputStream out = new FileOutputStream(name);
				ObjectOutputStream oos = new ObjectOutputStream(out);
				){
			
			oos.writeObject(u1);
			oos.writeObject(u2);
			oos.writeObject(list);
			
			
			oos.flush(); // 저장
			System.out.println("u1, u2 객체를 직렬화해서 파일로 저장");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("END");

	}

}
