package days18;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author An
 * @date 2026. 6. 5. 오전 11:25:55
 * @subject 
 * @content 
 * 
 */
public class Ex06_02 {

	public static void main(String[] args) {

		int [] score = { 80, 95, 50, 85, 45, 65, 10, 100 };

		TreeSet<Integer> ts = new TreeSet<Integer>();
		
//		for (int i = 0; i < score.length; i++) {
//			ts.add(score[i]);
//		} // for i
		
		// int[] -> IntStream
		Arrays.stream(score).forEach(ts::add);		
		
		System.out.println( ts );
		
		
		// 50<= score 검색   < 80
		System.out.println( ts.subSet(50, 80) );
		
		// 80 이상인 점수 검색
		System.out.println( ts.tailSet( 80) );
		
		System.out.println( ts.headSet( 80) );
		
		// TreeSet   중복허용 X, 정렬, 검색, 부분검색 성능 뛰어나다.

		/*
		TreeSet<String> ts = new TreeSet<String>();

		ts.add("abc");		ts.add("alien");	ts.add("bat");
		ts.add("car");		ts.add("Car");		ts.add("disc");
		ts.add("dance");	ts.add("dzzz");		ts.add("dzzzz");
		ts.add("elephant");	ts.add("elevator");	ts.add("fan");
		ts.add("flower");

		System.out.println( ts );

		// 정렬된 Set
		SortedSet<String> ss = ts.subSet("a", "d");
		System.out.println( ss ); // [abc, alien, bat, car] "a" ~   "d" X
		 */



	}

}
