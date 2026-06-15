package days21.sec03;

public class Person {
	
	public void actionWork(Workable workable) {
		workable.work("홍길동","작업");
	}
	
	public void actionSpeak(Speakable speakable) {
		speakable.speak("람다식 내용");
	}

}
