package days14;

public class Ex07 {

	public static void main(String[] args) {


	}

}
abstract class Player{

	// 필드
	boolean pause;  // 작동 중지
	int currentPos; // 현재 위치

	// 생성자
	public Player() { 
	}

	// 추상 메서드 선언
	abstract void play(int pos);
	abstract void stop();

}
abstract class AudioPlayer extends Player{

	// 필드 : pause, currentPos

	// 추상메서드 : play,stop

	@Override
	void play(int pos) {
		System.out.println("> 추상 메서드 오버라이딩 완료!");
	}
	
}
class CDPlayer extends AudioPlayer{

	@Override
	void stop() {
		System.out.println("> 추상 메서드 오버라이딩 완료!");
	}
	
	
}