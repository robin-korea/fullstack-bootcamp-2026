package days17;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author An
 * @date 2026. 6. 4. 오전 10:45:47 
 * @subject List 구현한 컬렉션 클래스: ArrayList
 * @content    ㄴ 특징: 순서 유지, 중복 허용
 *
 */
public class Ex05_02 {

	public static void main(String[] args) {
		
		// <E> 제네릭클래스: Element(요소)
		ArrayList groupList = new ArrayList(300);
		System.out.println(groupList.isEmpty()); // 요쇼의 유무
		System.out.println(groupList.size()); // 0 size : 배열 안에 있는 요소의 갯수
		groupList.add("양인석");
		groupList.add("안정빈");
		groupList.add("신창만");
		System.out.println(groupList.size());
		System.out.println(groupList.isEmpty());
		
		groupList.add("이지훈");
		groupList.add("장미성");		
		System.out.println(groupList.size());
		
		groupList.trimToSize(); // 남아있는 갯수 제거 (295개)
		
		// 2번째 사람의 이름 얻어와서 출력
		String name = (String) groupList.get(1);
		System.out.println("> 두 번째 사람의 이름: " + name);
		
		// groupList.remove(1);
		
		int index = groupList.indexOf("안정빈");
		System.out.println(index); // 1
		
		groupList.remove(index);
		
//		for (int i = 0, size = groupList.size(); i < size; i++) {
//			name = (String) groupList.get(i);
//			System.out.println(name);
//			
//		}
		
		System.out.println(groupList); // [양인석, 신창만, 이지훈, 장미성] groupList.toString() 생략됨
		
		groupList.add(index, "문규리");
		System.out.println(groupList); // [양인석, 문규리, 신창만, 이지훈, 장미성]
		
		// 1명 팀원으로 더 추가 : 중복허용, 순서유지
		groupList.addFirst("이지훈");
		System.out.println(groupList); // [이지훈, 양인석, 문규리, 신창만, 이지훈, 장미성]
		
		// "이지훈" 찾아서 모두 삭제 -> 출력
		
		/* [1] 앞에서 부터 삭제
		for (int i = 0, size = groupList.size(); i < size; i++) {
			name = (String) groupList.get(i);
			if(name.equals("이지훈")) {
				System.out.println(i + " : " + name);
				groupList.remove(i);
				i--;
				size--;
			}
			
		}
		*/ 
		// [2] 뒤에서 부터 삭제
		/*
		for (int i = groupList.size()-1; i >=0; i--) {
			name = (String) groupList.get(i);
			if(name.equals("이지훈")) {
				System.out.println(i + " : " + name);
				groupList.remove(i);
			}
			
		}
		*/
		 
		// [3] 반복자(iterator) 사용해서 출력 + "이지훈" 제거
		// <E> 제네릭 삭제
		/*
		Iterator ir = groupList.iterator();
		while (ir.hasNext()) {
			name = (String) ir.next();
//			System.out.println("> " + name);
			if(name.equals("이지훈")) {
				ir.remove();
			}
		}
		*/
		
		// [4] 
		/*
		ArrayList removeList = new ArrayList();
		removeList.add("이지훈");
		removeList.add("신창만");
		
		List removeList = List.of("이지훈","신창만");
		
		groupList.removeAll(removeList); // 매개변수 다형성, 인터페이스, 업캐스팅
		*/
		
		// [5] groupList.removeIf(Predicate p)
		//                  ㄴ 조건에 만족하는 요소를 모두 제거
		//                  ㄴ Predicate p 삭제할 조건
		//                     @FunctionalInterface 함수형 인터페이스
		/*
		groupList.removeIf(new Predicate<String>() {

			@Override
			public boolean test(String name) {
				return name.equals("이지훈");
			}
		});
		*/
		
		// groupList.removeIf( n -> n.equals("이지훈"));
		
//		groupList.sort(new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2); // 같으면 0 다르면 음수, 양수
//			}
//			
//		});
		
		groupList.sort((o1, o2) -> {
			String a = (String)o1;
			String b = (String)o2;
			return a.compareTo(b) *-1;
		});
		
		// groupList.sort( ( o1,  o2) -> ((String)o1).compareTo((String)o2) );
	
		System.out.println(groupList);
		
		// 모든 요소를 제거
		// groupList.clear();
		// System.out.println(groupList);
		
		// 맨 뒤 2 명의 이름을 출력
		int fromIndex = 4;
		int toIndex = groupList.size();
		
		List endList = groupList.subList(fromIndex, toIndex);
		System.out.println(endList);
		
	}

}
