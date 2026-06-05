package days18;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

/**
 * @author An
 * @date 2026. 6. 5. 오전 11:38:12
 * @subject 
 * @content 
 * 
 */
public class Ex07 {

	public static void main(String[] args) {
		/*  1. 키key-값value 한 쌍으로 데이터를 저장하는 구조
		 *     엔트리(Entry)
		 *  2. 키는 중복 허용 X
		 *  3. Map 인터페이스를 구현한 클래스
		 *     1) [Hash]Map    신                                 ArrayList StringBuilder 
		 *     4) [Hash]table  구 , 멀티스레드 안전(동기화처리 0) Vector    StringBuffer
		 *     
		 *        Hash - 해싱이라는 기법을 사용해서 데이터를 저장 -> 검색 성능 뛰어나다.
		 *        
		 *        해싱기법 - 해시함수(hash function)을 이용해서 
		 *                   데이터를 해시테이블( hash table)에 저장하고 검색하는 기법
		 *                 - 해시함수는 데이터가 저장되어 있는 곳을 알려 주기 때문에 
		 *                 다량의 데이터 중에 원하는 데이터를 빠르게 검색할 수 있다. 
		 *                   
		 *      
		 *     2) TreeMap       - 검색,정렬
		 *     3) LinkedHashMap - 순서 유지
		 * */
		
		// <E>    Element
		// <K, V> Key, Value
		// key=id
		// Value= name
		HashMap<String, String> hm = new HashMap<>();
		
		hm.put("admin", "관리자");
		hm.put("hong", "홍길동");
		
		hm.put("kenik", "켄익");
		hm.put("kenik", "이창익");		
		
		System.out.println( hm );
		
		// [모든 key 출력]
		/*
		Set<String> kSet= hm.keySet();
		System.out.println( kSet ); // [hong, kenik, admin]
		Iterator<String> ir = kSet.iterator();
		while (ir.hasNext()) {
			String key = (String) ir.next();
			String value = hm.get(key);
			System.out.printf( "key=%s - value=%s\n", key, value );
		}
		*/
		
		// [모든 value 출력]
		Collection<String> vc =  hm.values();
//		System.out.println( vc ); // [홍길동, 이창익, 관리자]
		
		// [모든 Entry(key-value) 출력]	***
		Set<Entry<String, String>> eSet = hm.entrySet();
		Iterator<Entry<String, String>> ir = eSet.iterator();
		while (ir.hasNext()) {
			Entry<String, String> entry = (Entry<String, String>) ir.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " : " + value);
		} // while
		
		
		
		/*
		// key가 hong 존재 체크
		System.out.println( hm.containsKey("hong") );
		System.out.println( hm.containsValue("홍길동") );
		
		// key   hong 찾아서  hm에서 삭제
		if (hm.containsKey("hong")) {
			hm.remove("hong");
		}

		System.out.println( hm ); // {kenik=이창익, admin=관리자}
		
		// key -> get() -> value 
		String value = hm.get("admin");
		System.out.println( value );
		*/
		
		
	} // main

} // class









