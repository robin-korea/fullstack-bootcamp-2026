package days17;

import java.util.Stack;

/**
 * @author An
 * @date 2026. 6. 4. 오후 5:17:45 
 * @subject C -> L : ArrayList, Vector, LinkedList
 * @content C -> S : HashSet, LinkedHashSet 
 * 
 * 
 * 			[Stack 컬렉션 클래스]
 *              ㄴ LIFO 자료구조
 * 			------------
 *      ->           2 1 
 * 			------------
 *			
 *			Stack -> Vector -> List 
 *					  ㄴ 멀티 스레드에 안전
 *
 */
public class Ex12 {

	public static void main(String[] args) {
		
		Stack s = new Stack();
//		s.add(s);            X
//		s.addElement(s);     X
//		s.addFirst(s);       X
		s.push("양인석");
		s.push("안정빈");
		s.push("신창만");
		s.push("이지훈");
		
		System.out.println(s.size());
		
		// System.out.println(s.pop()); // 제거
		System.out.println(s.peek()); // 읽기만 하는거 제거 X
		
		System.out.println(s.size());
		
		System.out.println(s.search("서주원")); // 없으면 -1 있으면 위치값
		
		System.out.println(s.isEmpty()); // true/false
		
		// push(), pop()/peek(), isEmpty(), search()

	}

}
