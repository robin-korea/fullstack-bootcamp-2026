package days15;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Car {
	// 필드
	private String name;
	private String gearType;
	private int door;
	
	// 인터페이스
	private Engine engine = null;  // 집합 관계
	
	public Car(Engine engine) {
		this.engine = engine;
	}
	
	// 메소드
	void speedUp(int fuel) {
		this.engine.moreFuel(fuel);
	}
	
	void speedDown(int fuel) {
		this.engine.lessFuel(fuel);
	}
	
	void stop() {
		this.engine.stop();
	}
	
}
