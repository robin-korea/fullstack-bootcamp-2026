package days18;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author An 
 * @date 2026. 6. 5. 오전 7:31:22
 * @subject Queue
 * @content   ㄴ FIFO 구조
 *            ㄴ offer()     poll()/peek()     isEmpty()
 * 
 */
public class Ex01 {

	public static void main(String[] args) {
		// <E> Element 요소  FIFO
		Queue q = new LinkedList();
		q.offer("안정빈");
		q.offer("조지훈");
		System.out.println( q.offer("문규리") );
		
		while ( !q.isEmpty() ) {
			System.out.println( q.poll() );
		} 
		
				

	} // main

} // class





