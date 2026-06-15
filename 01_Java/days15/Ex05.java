package days15;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author An
 * @date 2026. 6. 1. 오전 11:14:49 
 * @subject 익명클래스 예제
 * @content 
 *
 */
public class Ex05 {

	public static void main(String[] args) {

		String [] s = { "kbs", "sbs", "mbc", "jtbc" };

		System.out.println(Arrays.toString(s));

		// 오름차순 정렬
		// Arrays.sort(s);

		// 내림차순 정렬
		// Arrays.sort(s, new StringComparator());

		/*
		Arrays.sort(s, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2) * -1;
			}

		});
		 */
		
		// @FunctionalInterface (함수형 인터페이스)
//		           ㄴ 안에 메서드 하나밖에 없다
		
		// 람다 스트림
//		Arrays.sort(s, (o1, o2) -> o1.compareTo(o2) * -1);
		
		// 배열을 사용하기 쉽도록 기능이 구현된 클래스 : Arrays
		// 컬렉션을 사용하기 쉽도록 기능이 구현된 클래스 : Collections
		Arrays.sort(s,Collections.reverseOrder());
		
		System.out.println(Arrays.toString(s));

	}

}

/*
// 문자열을 비교하는 비교자(comparator): 클래스 선언
class StringComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		String s1 = (String) o1;
		String s2 = (String) o2;

		// s1 s2 음수  s2 s1 양수  s2 == s1 0
		return s1.compareTo(s2) * -1;

	}


}
 */
