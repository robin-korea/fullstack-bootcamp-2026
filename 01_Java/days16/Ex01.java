package days16;

import java.util.Arrays;

/**
 * @author An
 * @date 2026. 6. 2. 오전 9:01:49 
 * @subject
 * @content 문자열을 다루는 클래스
 *  
 * 			1. String 클래스
 *  			 ㄴ 변경 불가능한 클래스이다        
 			2. StringBuffer 클래스
			3. StringBuilder 클래스
   			4. StringTokenizer 클래스  == String.split()
    		5. StringJoiner 클래스 X == String.join()
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		
		String a = "abc";
		String b = "AbC";
		
		System.out.println(a.equals(b));
		// 대소문자 구분 없이 비교하는 메서드
		System.out.println(a.equalsIgnoreCase(b));
			
//		String s = "  public static void main(String[] args) {    ";
//		
//		String [] sArr = s.trim().split("\\s");
//		System.out.println(Arrays.toString(sArr));
//		
//		System.out.println("<b>" + String.join("</b><b>", sArr) + "</b>");
		
		// var 키워드 컴파일 할때 자동적으로 컴파일러가 추정해서 변환해주는 키워드
		// 지역변수 에서 사용 가능
//		String name = "홍길동";
//		int age = 20;
//		double avg = 98.77;
//		
//		var name = "홍길동";
//		var age = 20;
//		var avg = 98.77;
		
		// 검색어: keyword, searchWord
		
//		String keyword = "main";
//		int index = -1;
		
		// 찾는 문자열의 위치값 확인
		// indexOf : 앞에서 부터 찾아나가는 방법
		// if ((index = s.indexOf(keyword)) != -1) {
		// lastIndexOf : 끝에서 부터 찾아나가는 방법
		/*
		if ((index = s.lastIndexOf(keyword)) != -1) {
			System.out.println("찾는 문자열이 " + index + " 위치에 있다.");
			
			// main -> 메인 수정
			System.out.println(s.substring(0, index) + "메인" + s.substring(index + keyword.length()));
			
			System.out.println(s.replace(keyword,"메인"));
			
			// ic Ic -> 아이시
			System.out.println(s.replaceAll("[iI][cC]","아이시"));
			// (?i) 대소문자 구분 없다
			System.out.println(s.replaceAll("(?i)ic","아이시"));
			// 첫번째 값만 변경한다
			
			System.out.println(s.replaceFirst("(?i)ic","아이시"));
			
		}else {
			System.out.println("찾는 문자열이 없다.");
		}
		*/
		
		// 문자열이 있는지 없는지 유무만 파악하는 메서드 : contains 
//		 if (s.contains(keyword)) {
//			 System.out.println("찾는 문자열이 있다.");
//		 }else {
//			 System.out.println("찾는 문자열이 없다.");
//		 }
		
		
		
		/*
		// String -> char []
		char [] cArr = s.toCharArray();
		
		// char[] -> String
		String t = String.valueOf(cArr);
		
		System.out.println(s);
		
		s = s.trim();
		System.out.println("[" + s + "]");
		*/
		
		/*
		int length = s.length();
		System.out.println("1. 문자열 길이: " + length);
		
		char third = s.charAt(2);
		System.out.println("2. 세번째 한 문자: " + third);
		
		String su = s.toUpperCase();
		System.out.println(su);
		
		String sl = s.toLowerCase();
		System.out.println(sl);
		
		String regex = "[\\s()]";
		String [] sArr = s.split(regex);
		System.out.println(Arrays.toString(sArr));
		*/
	}

}
