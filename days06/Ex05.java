package days06;

/**
 * @author An
 * @date 2026. 5. 18. 오후 2:27:39 
 * @subject 많은 수 중에 가장 큰 값, 작은 값
 * @content (배열 사용)
 *
 */
public class Ex05 {

	public static void main(String[] args) {
		
		int [] m = new int[10];
		
		for(int i = 0; i < m.length; i++) {
			m[i] = (int)(Math.random()*100)+1;
			System.out.printf("m[%d] = %02d\n",i,m[i]);
		}
		
		// int max = IntStream.of(m).max().getAsInt();
		
		int max = m[0];
		int min = m[0];
		for(int i = 1; i < m.length; i++) {
			max = Math.max(max, m[i]);
			min = Math.min(min, m[i]);
		}
		System.out.println("> 배열의 가장 큰 값: " + max);
		System.out.println("> 배열의 가장 작은 값: " + min);
		
	}

}
