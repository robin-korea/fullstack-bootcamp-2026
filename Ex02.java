package days18;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.SequencedSet;

/**
 * @author An
 * @date 2026. 6. 5. 오전 9:14:24
 * @subject LinkedHashSet 컬렉션 클래스
 * @content   = HashSet<E> + implements SequencedSet<E>
 *            ㄴ 중복허용 X +     순서유지 O
 * 
 */
public class Ex02 {

	public static void main(String[] args) {
		
		LinkedHashSet<Integer>  s = new LinkedHashSet<>();
		s.add(20);
		s.add(new Integer(10));
		s.add(20);
		s.add(15);
		
		// [20, 10, 15]    중복허용 X +     순서유지 O
		System.out.println( s );
		

	} // main

} // class
