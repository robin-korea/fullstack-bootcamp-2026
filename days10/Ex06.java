package days10;

public class Ex06 {

	public static void main(String[] args) throws InterruptedException{

		int [][] m = new int[5][5];
		
		magicSquare(m);
		
		dispM(m);

	}

	private static void magicSquare(int[][] m) throws InterruptedException {
		// 1의 위치는 0번째 행의 가운데 열
		// 기본적으로 열증가 행감소한다
		// 만약 찍혀있는 숫자가 n의 배수일경우 행증가만 한다
		// 열이 벗어나면 가장 작은 열로
		// 행이 벗어나면 가장 큰 행으로
		
		int v = 1;
		int row = 0, col = m[0].length/2;
		m[row][col] = v;
		
		while(v < m.length * m[0].length) {
			
			if(v % m.length == 0) {
				row++;
			}else {
				col++;
				row--;
				
				if(row == -1) {
					row = m.length-1;
				}
				if(col == m[0].length) {
					col = 0;
				}
			}
			
			dispM(m);
			Thread.sleep(1000); // 1초 후에 실행
			
			m[row][col] = ++v;
		}
		
	}

	private static void fillM2(int[][] m) {

		/* [1] 풀이
		for(int i = 0, v = 1; i <m.length; i++) {          // 5행
			for (int j = 0; j < m[i].length; j++, v++) { // 5열
				m[j][i] = v;
			}
		}
		 */

		for(int i = 0; i <m.length; i++) {          // 5행
			for (int j = 0; j < m[i].length; j++) { // 5열
				m[i][j] = i+1+j*m[i].length;
			}
		}
	}

	private static void fillM(int[][] m) {

		for(int i = 0, v = 1; i <m.length; i++) {          // 5행
			for (int j = 0; j < m[i].length; j++, v++) { // 5열
				m[i][j] = v;
			}
		}
	}

	private static void dispM(int[][] m) {
		for(int i = 0; i <m.length; i++) {          // 5행
			for (int j = 0; j < m[i].length; j++) { // 5열S
				System.out.printf("[%02d]",m[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
