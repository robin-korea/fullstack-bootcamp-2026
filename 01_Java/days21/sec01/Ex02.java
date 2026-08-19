package days21.sec01;

public class Ex02 {

	public static void main(String[] args) {
		
		Person a = new Person();
		a.action( () -> {
			// 실행문이 2개 이상 {} 필수
			System.out.println("청소");
			System.out.println("빨래");
		});
		
		
		
		
		Person b = new Person();
		// 실행문이 1개인 경우에는 {} 중괄호 생략 가능
		b.action(() -> System.out.println("공부"));
	}

}
