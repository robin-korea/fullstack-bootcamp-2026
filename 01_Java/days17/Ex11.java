package days17;

import java.util.HashSet;

/**
 * @author An
 * @date 2026. 6. 4. 오후 3:43:43 
 * @subject C -> L : ArrayList, Vector, LinkedList
 * @content C -> S : HashSet 컬렉션 클래스
 *				 ㄴ 순서유지 X, 중복 허용 X
 */
public class Ex11 {

	public static void main(String[] args) {
		
		HashSet hs = new HashSet(); // default 용량 16, 증가치 0.75
		hs.add(9);
		hs.add(1);
		hs.add(15);
		
		// [1, 9, 15]  순서 유지 X
		System.out.println(hs);
		
		// 중복 불가
		hs.add(1);
		System.out.println(hs);
		
		// null 삽입 가능
		hs.add(null);
		System.out.println(hs);
		
		hs.remove(1);
	}

}
