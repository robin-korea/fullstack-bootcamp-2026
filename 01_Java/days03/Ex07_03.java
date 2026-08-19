package days03;

/**
 * @author An
 * @date 2026. 5. 13. 오후 3:49:35 
 * @subject String 을 기본형 8가지로 변환
 * @content 
 *
 */
public class Ex07_03 {

	public static void main(String[] args) {
		
		String s = "90";
		int v = Integer.parseInt(s);
		System.out.println(v);
		
		// String -> byte
		
		byte b = Byte.parseByte(s);
		System.out.println(b);
		
		// String -> long
		
		long l = Long.parseLong(s);
		System.out.println(l);
		
		// String -> double
		
		double d = Double.parseDouble(s);
		System.out.println(d);
		
	}//main

}//class
