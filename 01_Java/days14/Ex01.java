package days14;

import java.util.Arrays;

public class Ex01 {

	public static void main(String[] args) {

		String n = "keNik";     
		String m= "kKnie";  

		// 1. 대소구분X
		n = n.toUpperCase();  
		m = m.toUpperCase();  

		// 2. 순서 - 정렬
		char [] nArr = n.toCharArray();
		char [] mArr = m.toCharArray();    
		
		Arrays.sort(nArr);
		Arrays.sort(mArr);
		
		
		// 3. 문자열 변환 char[] -> String
		n = new String( nArr );
		m = new String( mArr );

		// 4. 비교
		if ( n.equals(m) ) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

	}

}
