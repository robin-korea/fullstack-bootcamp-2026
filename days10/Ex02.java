package days10;

import java.util.Arrays;
import java.util.Random;

public class Ex02 {

	public static void main(String[] args) {

		int [] m = new Random().ints(1,100).limit(5).toArray();
		System.out.println(m.length);
		System.out.println(Arrays.toString(m));
		
		int index = m.length;
		
		if(index >= m.length) {
			int [] temp = new int[m.length+3];
			
			/* [배열 m -> temp 배열에 복사]
			for(int i = 0; i < m.length; i++) {
				temp[i] = m[i];
			}
			*/
			System.arraycopy(m, 0, temp, 0, m.length);
			// System.arraycopy(m, 1, temp, 2, 3); m에 1번 인덱스 값부터 temp 에 2번째 인덱스에 3개 추가
			// Arrays.copyOf
			m = temp;
		}
		
		m[index] = 100;
		
		System.out.println(Arrays.toString(m));

	}

}
