package days21.sec03;

/**
 * @author An
 * @date 2026. 6. 10. 오전 9:49:29 
 * @subject 매개변수가 있는 람다식 예제
 * 
 * @content 
 *
 */
public class Ex01 {

	public static void main(String[] args) {

		Person p = new Person();

		// 매개변수가 2개 있는 람다식
		p.actionWork((name, job) -> {
			System.out.print(name + "이 ");
			System.out.println(job + "을 합니다.");
		});
		// 매개변수가 1개 있는 람다식
		p.actionSpeak((content) -> {
			System.out.print("\"" + content + "\"");
			System.out.println("(이)라고 말합니다.");
		});


	}

}
