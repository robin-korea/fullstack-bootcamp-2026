package days11;

import java.util.Random;

/**
 * @author An
 * @date 2026. 5. 26. 오후 4:18:32 
 * @subject 
 * @content 
 *
 */
public class Ex08_02 {

	public static void main(String[] args) {

		Point [] pArr = new Point[10];
		
		for (int i = 0; i < pArr.length; i++) {
			pArr[i] = new Point();
			pArr[i].x = new Random().nextInt(1, 100);
			pArr[i].y = new Random().nextInt(1, 100);
		}

		for (int i = 0; i < pArr.length; i++) {
			pArr[i].printPoint();
		}

	}

}
