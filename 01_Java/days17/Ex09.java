package days17;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author An
 * @date 2026. 6. 4. 오후 2:53:02 
 * @subject [Vector 컬렉션 클래스]
 * @content C -> L -> ArrayList 컬렉션 클래스
 *					  Vector 컬렉션 클래스( 차이점: 멀티 스레드 안전)
 */
public class Ex09 {

	public static void main(String[] args) {


		Vector v = new Vector(3);
		System.out.println(v.size()); // 0
		System.out.println(v.capacity()); // 3

		v.addElement("양인석");
		v.add("안정빈");
		v.add("신창만");

		System.out.println(v.size()); // 3

		v.add("이지훈");

		System.out.println(v.capacity()); // 6

		System.out.println(v.get(0));
		System.out.println(v.getFirst());
		System.out.println(v.elementAt(0));
		
		// 모든 요소 출력. 반복자, 열거자
		Enumeration em = v.elements();
		
		while (em.hasMoreElements()) { // 요소 가지고 있니? true/flase
			String name = (String) em.nextElement();
			System.out.println(name);
		}
		
		// 마지막 요소
		int lastInex = v.size() - 1;
		System.out.println(v.get(lastInex));
		System.out.println(v.lastElement());
		
		v.remove(0);
		v.remove("안정빈");
		
	}

}
