package days15;

public class K_Engine2036 implements Engine{
	
	int speed;
	
	@Override
	public void moreFuel(int fuel) {
		this.speed += fuel * 0.05;
	}

	@Override
	public void lessFuel(int fuel) {
		this.speed -= fuel * 0.05;
	}

	@Override
	public void stop() {
		this.speed = 0;
	}
	
	@Override
	public void turbo() {
		System.out.println("> 성능 향상된 터보 기능 구현...");
	}
	
}
