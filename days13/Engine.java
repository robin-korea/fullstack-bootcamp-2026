package days13;

public class Engine {
	
	// 필드
//	private String model; // 엔진 모델명
//	private int displacement; // 배기량
//	private int horsepower;  // 마력
//	private boolean running; // 시동 상태
	
	int speed;
	
	// 생성자
	// 메서드
	void moreFuel(int fuel) {
		this.speed += fuel * 0.05;
	}
	
	void lessFuel(int fuel) {
		this.speed -= fuel * 0.05;
	}
	
	void stop() {
		this.speed = 0;
	}
}
