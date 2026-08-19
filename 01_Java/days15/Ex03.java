package days15;

/**
 * @author An
 * @date 2026. 6. 1. 오전 10:08:40 
 * @subject has-a 관계: Car, Engine
 * @content    ㄴ 결합력이 높은 코딩은 좋은 코딩이 아니다
 * 		       ㄴ 생성자 DI(의존성 주입)
 *			   ㄴ setter DI
 *
 *			   
 */
public class Ex03 {

	public static void main(String[] args) {
		
		// 2026 상반기
		Car k1 = new Car(new H_Engine());

		// 2026 하반기
		Car k2 = new Car(new K_Engine());
		
		// k1의 엔진 고장
		k1.setEngine(new K_Engine()); // setter DI
		
	}

}
