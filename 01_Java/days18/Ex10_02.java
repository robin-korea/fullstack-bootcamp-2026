package days18;

import java.io.FileReader;
import java.util.Properties;

/**
 * @author An
 * @date 2026. 6. 5. 오후 2:08:05 
 * @subject C -> L : ArrayList, Vector, Stack ,LinkedList 
 * @content C -> S : HashSet, LinkedHashSet, TreeSet
 * 				 M : HashMap(신) == HashTable(구)
 *                     ㄴ 동기화 처리 X    ㄴ 동기화 처리 O
 *                     
 *                     Properties 컬렉션 클래스 (중요)
 *                        ㄴ key String, value String 
 *                        ㄴ 주로 설정 파일을 읽기/쓰기
 *                        ㄴ ???.properties 확장자
 *                        ㄴ Hashtable 의 자식 클래스
 */
public class Ex10_02 {

	public static void main(String[] args) {
		// 1. database.properties 파일을 읽어와서 Properties 객체 p로 만들고
		// p 로 부터 DB 연결 정보를 얻어와서 출력

		String fileName = ".\\src\\days18\\database.properties";

		// DB 연결 문자열 (ConnectionString)

		String className = null;          
		String url = null;                  
		String user = null;                                                                   
		String password = null;

		Properties p = new Properties();

		
		try (
				FileReader reader = new FileReader(fileName);
				){
			// p.store()  p 객체를 파일로 저장할때 사용
			// p.load()   파일 읽어와서 p 객체를 생성할 때
			p.load(reader);
			
			className = p.getProperty("className");
			url = p.getProperty("url");
			user = p.getProperty("user");
			password = p.getProperty("password");
			System.out.println(className);
			System.out.println(url);
			System.out.println(user);
			System.out.println(password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("END");

	}

}

// p 객체  setProperties()             -> p.store() -> FileWriter ->  ???.properties 파일로 저장
// ???.properties 파일로 -> FileReader -> p.load() 생성 -> p.getProperties("user") 와서 사용









