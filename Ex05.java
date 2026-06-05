package days18;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @author An
 * @date 2026. 6. 5. 오전 10:44:23
 * @subject 
 * @content 
 * 
 */
public class Ex05 {

	public static void main(String[] args) {
		// 순서유지X, 중복허용X       순서유지O, 중복허용X  
		HashSet<Student> hs = new LinkedHashSet<Student>();
		
		hs.add(new Student("2020001", "홍길동", 25));
		hs.add(new Student("2020002", "서영학", 25));
		hs.add(new Student("2020003", "최승우", 25));
		
		System.out.println( hs );
		
		System.out.println( hs.add(new Student("2020001", "정창기", 24)) );

		System.out.println( hs );
	} // main

} // class




