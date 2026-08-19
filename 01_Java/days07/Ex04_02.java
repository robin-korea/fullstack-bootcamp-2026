package days07;

// 배열에서 길이   .length   -> 변수
// 문자열에서 길이 .length()  -> 메서드

public class Ex04_02 {

	public static void main(String[] args) {

		String a = "한aBcDe";

		String u = myToUpperCase(a);
		//		String u = a.toUpperCase();

		System.out.println(u);

	}
	
	
	public static String myToUpperCase(String s) {

		char [] sArr = s.toCharArray();
		// System.out.println(Arrays.toString(sArr));
		
		String upper = "";
		char ch;
		for(int i = 0; i < s.length(); i++) {
			ch = sArr[i];
			if(Character.isLowerCase(ch)) {
				ch = Character.toUpperCase(ch);
			}
			upper += ch;
		}
		return upper;
	}


	/* 1번 풀이
	public static String myToUpperCase(String s) {

		String result = "";
		char ch;

		for(int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
				ch = (char)(ch-32);
			}
			result += ch;
		}

		return result;
	}
	 */

}
