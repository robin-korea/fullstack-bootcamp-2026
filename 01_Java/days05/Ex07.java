package days05;

/**
 * @author An
 * @date 2026. 5. 15. 오후 2:03:21 
 * @subject [로또 번호 발생..]
 * @content 1 ~ 45 까지의 정수중 6개를 골라 무작위로 추첨
 *
 */
public class Ex07 {

	
	public static void main(String[] args) {
		
		// 0.0 <= double Math.random()  < 1.0 
		// 1 <=     로또번호  <= 45

		// 0.0 <= double Math.random() * 45 < 45.0
		//  1 <=   (int)(Math.random() * 45)+1 < 46
		
		// 0.0 ~ 1.0 사이의 double 형 값을 리턴함
		
		int kor = (int) (Math.random()*101);
		
		System.out.println(kor);
		
	}

}
