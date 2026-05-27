package days07;

import java.util.Random;

/**
 * @author An
 * @date 2026. 5. 19. 오후 5:10:19 
 * @subject 랜덤하게 카드 4자리를 ****로 변환해서 출력
 * @content 
 *
 */
public class Ex07 {

	public static void main(String[] args) {
		
		String card ="7655-8988-9234-5677";
		String [] cardArr = card.split("-");
		
		Random rnd = new Random();
		int index = rnd.nextInt(4);
		
		cardArr[index] = "****";
		
		String dispCard = String.join("-", cardArr);
		System.out.println(dispCard);
		
		
	}

}
