package days18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author An
 * @date 2026. 6. 5. 오전 9:24:29
 * @subject                  1조->  ArrayList
 * @content                  2조->  ArrayList
 *                 5강의장-> ArrayList
 */
public class Ex08 {

	public static void main(String[] args) {
		
		String fileName = ".\\src\\days18\\1차_조편성.txt";
		String line = null;  // 1조:양인석/안정빈/신창만/이지훈/장미성
		
//		ArrayList<ArrayList<String>> class5 = new ArrayList<>(); 
		ArrayList< HashMap<String, ArrayList<String>>  > class5 = new ArrayList<>(); 
		
		try (
			FileReader in = new FileReader(fileName);	
			BufferedReader br = new BufferedReader(in);	
			){
			
			HashMap<String, ArrayList<String>> tmHMap = null; // HashMap
			String teamName = null;  // 팀명   Key
			ArrayList<String> tmList = null; // 팀원 리스트 Value
			String regex = "[/:]";
			String [] lineArr = null;
			while( ( line = br.readLine() ) != null ) {
				tmHMap = new HashMap<String, ArrayList<String>>();
//				System.out.println(line);
				// 1조:양인석/안정빈/신창만/이지훈/장미성
				tmList = new ArrayList<String>();
				lineArr = line.split(regex);
				teamName = lineArr[0]; // 팀명 KEY
				for (int i = 1; i < lineArr.length; i++) {
					String name = lineArr[i];
					tmList.add(name);
				}
				tmHMap.put(teamName , tmList);
				class5.add(tmHMap);
			} // while
			
			// 5강의장의 각 조원들 출력하는 메소드 호출
			dispClass5(class5);
			
			System.out.println( "END");
		} catch (Exception e) {
			e.printStackTrace();		
		}
		

	} // main

	private static void dispClass5(ArrayList<HashMap<String, ArrayList<String>>> class5) {
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
		Iterator<HashMap<String, ArrayList<String>>> ir = class5.iterator();
		 
		while (ir.hasNext()) {		
			HashMap<String, ArrayList<String>> tmHMap = (HashMap<String, ArrayList<String>>) ir.next();
			
			Set<Entry<String, ArrayList<String>>> eSet= tmHMap.entrySet();			
			Iterator<Entry<String, ArrayList<String>>> ir2 = eSet.iterator();
			while (ir2.hasNext()) {
				Entry<String, ArrayList<String>> entry = (Entry<String, ArrayList<String>>) ir2.next();
				
				String teamName = entry.getKey(); // 팀명
				System.out.printf("%s\n", teamName);
				ArrayList<String>  tmList =entry.getValue();
				Collections.sort(tmList); // 각 팀원들 오름차순 정렬
				Iterator<String> ir3 = tmList.iterator();
				while (ir3.hasNext()) {
					String name = (String) ir3.next();
					System.out.printf("  ㄴ %s\n", name);
				} // while ir3
			} // while ir2
		} // while ir
		
	} // 

} // class
 





