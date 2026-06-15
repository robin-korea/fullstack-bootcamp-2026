package days18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author An
 * @date 2026. 6. 5. 오전 10:14:18
 * @subject 빙고 게임
 * @content Collections.shuffle(al);
 * 
 */
public class Ex04 {

	public static void main(String[] args) {

		int [][] bingo = new int[5][5];

		// 2차원 배열에 1~25 정수를 랜덤하게 채워넣는 코딩.
		/* [1]
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				bingo[i][j] = i*5+j+1;
			}
		}

		for (int i = 0; i < 25; i++) {
			int x = (int) (Math.random() * 25); // 0~24
			int y = (int) (Math.random() * 25);
			int tmp = bingo[x / 5][x % 5];
			bingo[x / 5][x % 5] = bingo[y / 5][y % 5];
			bingo[y / 5][y % 5] = tmp;
		}
		*/
		
		// [2]  주머니 25 숫자 넣어두었다.
		ArrayList<Integer> al = new ArrayList<Integer>();
//		for (int i = 1; i <= 25; i++) {
//			al.add(i);
//		} // for i
		IntStream.rangeClosed(1, 25).forEach(al::add);
//		System.out.println( al );
		
		Collections.shuffle(al); 
		
		for (int i = 0, index = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++, index++) {
				bingo[i][j] = al.get(index);
			}
		}
		
		// 주머니에서 1개씩 랜덤하게 꺼내와서 배열에 순차적으로 채워넣을 생각.
		Random rnd = new Random();
		
		for (int i = 0, index = -1, n = -1; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++) {
				index = rnd.nextInt(al.size()); // 0<= <25
				n = al.remove(index);
				bingo[i][j] = n;
			}			
		}




		// 출력.
		for (int i = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++) {
				System.out.printf("[%02d]", bingo[i][j]);
			}
			System.out.println();
		}
	} // main

} // class











