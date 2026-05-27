package days10;

/**
 * @author An
 * @date 2026. 5. 22. 오전 10:48:26 
 * @subject 가변	배열 : 열의 갯수가 다른 배열들
 * @content 
 *
 */
public class Ex04 {

	public static void main(String[] args) {

		int [][] m = new int[3][];
		m[0] = new int[10];
		m[1] = new int[5];
		m[2] = new int[30];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print("😊");
			}
			System.out.println();
		}

	}

}
