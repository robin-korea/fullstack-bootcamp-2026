package days21.sec07;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;



/**
 * @author An
 * @date 2026. 6. 10. 오전 11:22:32 
 * @subject parallel 병렬 + 스트림 처리
 * @content 
 *
 */
public class Ex02 {

	public static void main(String[] args) {
		
		
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("조지훈");
		list.add("문규리");
		list.add("양인석");
		list.add("장미성");
		list.add("오수빈");
		
		// 요소들을 반복처리: 반복자(iterator), 스트림
		// list.stream();
		
		 Stream<String> stream = list.parallelStream();
		 stream.forEach(name -> {
			 String threadName = Thread.currentThread().getName();
			 System.out.println(threadName + " : " +name);
		 });
		 
		
	}

}
