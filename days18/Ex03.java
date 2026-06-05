package days18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author An
 * @date 2026. 6. 5. 오전 9:24:29
 * @subject                  1조->  ArrayList
 * @content                  2조->  ArrayList
 *                 5강의장-> ArrayList
 */
public class Ex03 {

	public static void main(String[] args) {
		
		String fileName = ".\\src\\days18\\1차_조편성.txt";
		String line = null;  // 1조:양인석/안정빈/신창만/이지훈/장미성
		
		ArrayList<ArrayList<String>> class5 = new ArrayList<>(); 
		
		try (
			FileReader in = new FileReader(fileName);	
			BufferedReader br = new BufferedReader(in);	
			){
			
			ArrayList<String> tmList = null;
			String regex = "[/:]";
			String [] lineArr = null;
			while( ( line = br.readLine() ) != null ) {
//				System.out.println(line);
				// 1조:양인석/안정빈/신창만/이지훈/장미성
				tmList = new ArrayList<String>();
				lineArr = line.split(regex);
				for (int i = 1; i < lineArr.length; i++) {
					String name = lineArr[i];
					tmList.add(name);
				}
				
				class5.add(tmList);
			} // while
			
			// 5강의장의 각 조원들 출력하는 메소드 호출
			dispClass5(class5);
			
			System.out.println( "END");
		} catch (Exception e) {
			e.printStackTrace();		
		}
		

	} // main

	private static void dispClass5(ArrayList<ArrayList<String>> class5) {
		/*
		 * [5강의장]
		 * 1조
		 *   ㄴ 1번 홍길동         이름 오름차순 정렬 팀원 출력
		 *   :
		 * 2조
		 *   ㄴ 1번 김길동
		 *   :  
		 * 
		 * */ 
		System.out.println("[5강의장]");
		Iterator<ArrayList<String>> ir = class5.iterator();
		int n = 1;
		while (ir.hasNext()) {
			System.out.printf("%d조\n", n++);
			ArrayList<String> tmList = (ArrayList<String>) ir.next();
			Collections.sort(tmList); // 각 팀원들 오름차순 정렬
			Iterator<String> ir2 = tmList.iterator();
			while (ir2.hasNext()) {
				String name = (String) ir2.next();
				System.out.printf("  ㄴ %s\n", name);
			} // while ir2
			
		} // while ir
		
	} // 

} // class








