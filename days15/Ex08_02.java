package days15;

import java.io.IOException;
import java.util.Scanner;

import lombok.Getter;

/**
 * @author An
 * @date 2026. 6. 1. 오후 2:28:14 
 * @subject 점수가 0~100 사이가 아니라면 IOException 강제로 발생시켰지만
 * @content 사용자 정의 예외를 선언하고
 * 			그 사용자 정의 예외를 강제로 발생시키도록 한다
 *
 */
public class Ex08_02 {

	public static void main(String[] args) {
		// 강제로 예외를 발생시킬 때 throw 문을 사용.
		// throw new ArithmeticException();

		int kor = 0;

		try {
			kor = getScore();

		} catch (ScoreOutofBoundException e) {
			// e.printStackTrace();
			// System.err.println(e.toString());
			System.err.println(e.getERROR_CODE());
		}

		System.out.println(kor);


	} // main


	private static int getScore() throws ScoreOutofBoundException {

		Scanner scanner = new Scanner(System.in);
		int score = 0;      
		System.out.print("> 점수 입력 ? ");
		String input = scanner.next();      
		String regex = "^(\\d|[1-9]\\d|100)$"; // 0<= <=100      
		if (input.matches(regex)) {
			score = Integer.parseInt(input);
		} else {
			// 강제로 예외 발생시키겠다. 
			// throw new IOException("> 점수 범위 0<= <=100   !!!");
			throw new ScoreOutofBoundException("> 점수 범위 0<= <=100   !!!", 1004);
		}

		return score;
	}

}

// 사용자 정의 예외 클래스를 선언
@Getter
class ScoreOutofBoundException extends Exception{ // checked 예외

	private static final long serialVersionUID = 4406308359576961971L;

	private final int ERROR_CODE;

	
	public ScoreOutofBoundException(String message){
		this(message, 1001);
	}

	public ScoreOutofBoundException(String message, int error_code){
		super(message);
		this.ERROR_CODE = error_code;
	}

}