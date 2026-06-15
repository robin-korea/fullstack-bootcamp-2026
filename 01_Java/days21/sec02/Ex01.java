package days21.sec02;

public class Ex01 {

	public static void main(String[] args) {
		
		Button btnStart = new Button();
		Button btnStop = new Button();
		
		btnStart.setClickListener(() -> {
			System.out.println("기기를 작동시킨다");
			
		});
		
		btnStop.setClickListener(() -> {
			System.out.println("기기를 중지시킨다");
			
		});
		
		btnStart.click();
		btnStop.click();
	}

}
