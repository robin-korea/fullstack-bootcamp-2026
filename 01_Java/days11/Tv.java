package days11;

public class Tv {
	
	// 필드 - 속성
	public String color;
	boolean power = false;
	public int channel = 11;     

	// 메서드 - 동작
	public void power() {
		power = !power;
	}
	public void channelUp() {
		channel++;
	}
	public void channelDown() {
		channel--;
	}

}
