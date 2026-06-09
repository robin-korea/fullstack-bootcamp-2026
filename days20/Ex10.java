package days20;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Ex10 {

	public static void main(String[] args) {
		
		// [1]
		// Parent 부모클래스가 직렬화가 가능한 클래스라면
		// Child 자식클래스도 자동으로 직렬화가 가능한 클래스가 된다
		
		// [2]
		// Parent 부모클래스는 직렬화가 구현 안된 클래스이고
		// Child 자식클래스는 직렬화 가능한 클래스 인 경우
		// 부모의 멤버는 직렬화 대상이 되지 않는다
		// 그래서 name 은 직렬화 되어서 저장 되지 않았다
		// [해결]
		// 직접 Child 자식 클래스에서 부모 멤버를 직렬화하는 코딩을 추가해 준다
		
			Child c1 = new Child();
			c1.name = "홍길동";
			c1.age = 20;
			c1.email = "hong@naver.com";

			String name = ".\\src\\days20\\Child.ser";

			try (
					FileOutputStream out = new FileOutputStream(name);
					ObjectOutputStream oos = new ObjectOutputStream(out);
					){
				
				oos.writeObject(c1);


				oos.flush(); // 저장
				System.out.println("c1 객체를 직렬화해서 파일로 저장");

			} catch(Exception e) {
				e.printStackTrace();
			}

			System.out.println("END");


	}

}
// [2]
class Parent{
	String name;
}

class Child extends Parent implements Serializable{
	
	int age;
	// transient : 직렬화 대상에서 제외시키는 예약어
	transient String email;
	
	
	// 직접 부모 멤버를 직렬화 대상을 추가
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.writeUTF(name);
		out.defaultWriteObject();
	}
	
	private void readObject(ObjectInputStream in ) throws IOException, ClassNotFoundException{
		name = in.readUTF();
		in.defaultReadObject();
	}
}


/* [1]
class Parent implements Serializable{
	String name;
}

class Child extends Parent{
	int age;
}
*/