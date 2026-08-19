package days09;

/**
 * @author An
 * @date 2026. 5. 21. 오후 3:45:33 
 * @subject 3차원배열 면/행/열
 * @content 
 *
 */
public class Ex06_03 {

	public static void main(String[] args) {
		// 2면 2행 2열 3차원 배열 m
		int [][][] m = new int[2][3][4];
		
		System.out.println(m.length); // 면 갯수 출력
		System.out.println(m[0].length); // 행 갯수
		System.out.println(m[0][0].length); // 열 갯수
		
		dispM(m);
		
	}

	private static void dispM(int[][][] m) {
		
		for (int i = 0; i < m.length; i++) { // 면
			for (int j = 0; j < m[i].length; j++) { // 행
				for (int k = 0; k < m[i][j].length; k++) { // 열
					System.out.printf("m[%d][%d][%d]=%d ",i,j,k,m[i][j][k]);
				}
				System.err.println();
			}
			System.out.println();
		}
		
	}

}
