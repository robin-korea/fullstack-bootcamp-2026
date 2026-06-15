package days11;

/**
 * @author An
 * @date 2026. 5. 26. 오후 3:16:28 
 * @subject
 * @content 
 *
 */
public class Ex07_02 {

	public static void main(String[] args) {

		// *** 클래스 복사(copy) ***
		Tv t1 = new Tv();
		// 힙(동적)영역                                                                      스택영역 [0x100번지]
		//          필드
		// [color][channel][power][power()주소][channelUp()주소][cannelDown()주소]                    t1  변수,지역변수,참조변수, 객체
		//                       인스턴스                                                           객체
		// 0x100번지
		// [power()][channelUp()][cannelDown()]
		// new Tv()  객체를 생성하는 코딩
		//              인스턴스화

		Tv t2 = t1; // 클래스 복사(copy)
		//                                                                                        [0x100번지]
		//                        
		
		t1.channel = 20;
		System.out.println(t2.channel);
		
		t1.channelUp();
		t2.channelUp();
		
		System.out.println(t2.channel);
		
		print(t1);
		System.out.println(t1.channel);
		
	}

	private static void print(Tv t) { // 클래스 복사  Tv t = t1;
		 t.channel = 100;
		
	}

}
