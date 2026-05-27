package days11;

/**
 * @author An
 * @date 2026. 5. 26. 오후 3:08:02 
 * @subject
 * @content 클래스의 복사(copy)
 *			클래스의 복제(clone) - 얕은 복제/깊은 복제
 *			       차이점
 *				   Tv 클래스 추가
 */
public class Ex07 {

	public static void main(String[] args) {

		// Tv 객체 선언
		Tv t1 = new Tv();

		t1.power(); // false -> true
		System.out.println(t1.channel); // 객체명.필드명
		t1.channelUp();
		t1.channelUp(); // 객체명.메소드명()
		t1.channelUp();
		System.out.println(t1.channel);
		t1.power(); // true -> false
		
		System.out.println("END");
	}

}
