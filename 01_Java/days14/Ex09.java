package days14;

/**
 * @author An
 * @date 2026. 5. 29. 오후 4:13:01 
 * @subject [인터페이스 사용 장점]
 * @content 1. 개발 시간 단축
 * 			2. 표준화 가능
 * 			3. 서로 관련 없는 클래스들에게 관계를 맺어 줄 수 있다.
 * 			4. 독립적인 프로그래밍이 가능
 *			
 *			예) 
 */
public class Ex09 {

	public static void main(String[] args) {
		
		int [] lotoArr = new int[ILotto.LENGTH];
		
		// 업캐스팅
//		ILotto lottoGame = new Lotto();
		ILotto lottoGame = new 시연Lotto제품();
		
		lottoGame.fillLotto(lotoArr);
		lottoGame.dispLotto(lotoArr);
		
		System.out.println("END");
		
	}

}
