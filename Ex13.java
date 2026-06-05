package days18;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author An
 * @date 2026. 6. 5. 오후 3:12:20 
 * @subject 배열 기능 구현된 클래스 : Arrays 클래스
 * @content 컬렉션 클래스 기능 구현된 클래스 : Collections 클래스
 *
 */
public class Ex13 {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Collections.addAll(list, 1,2,3,4,5);
		
		// [1, 2, 3, 4, 5]
		System.out.println(list);
		
		// 오른쪽으로 2칸식 이동
		// [4, 5, 1, 2, 3]
		
		Collections.rotate(list, 2);
		System.out.println(list);
		
		Collections.swap(list, 0, 2);
		System.out.println(list);
		
		Collections.shuffle(list);
		System.out.println(list);
		
		// 바로 내림차순 정렬
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		
		// 오름차순 정렬
		Collections.sort(list);
		System.out.println(list);
		
		// 내림차순 정렬
		Collections.reverse(list);
		System.out.println(list);
		
		Collections.fill(list, 0);
		System.out.println(list);
		
		int index = Collections.binarySearch(list, 100);
		System.out.println(index); // 음수값 -> 못찾음
		
		Collections.replaceAll(list, 0, 100);
		System.out.println(list);
	}

}
