package days13;

import java.util.Date;

public class Ex08_02 {

	public static void main(String[] args) {
	
		MyDate d = new MyDate();
		System.out.println(d.toLocaleString());
		
		d.printDate();
	}

}

class MyDate extends Date{
	// 필드
	// 생성자
	// 메서드
	public void printDate() {
		System.out.println(this);
	}                    // ㄴ MyDate 객체 
}
