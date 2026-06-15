package days07;

public class Ex02 {

	public static void main(String[] args) {
		
		String inputValue = "홍길동, 98, 78, 77";
		
		// inputValue = inputValue.replace(" ", ""); // replace 를 사용하여 새로운 문자열에 저장
		// String 은 불변 
		System.out.println(inputValue);
		
		String name;
		int kor, eng, math;
		
		//메서드의 매개변수로 String regex 선언 (regex 의 뜻은 정규표현식 이다). \s 공백 * 0 이상
		String [] dataArr = inputValue.split("\\s*,\\s*");
		System.out.println(dataArr.length);
		
		name = dataArr [0];
//		kor = Integer.parseInt(dataArr[1].trim());
//		eng = Integer.parseInt(dataArr[2].trim());
//		math = Integer.parseInt(dataArr[3].trim());
		
		kor = Integer.parseInt(dataArr[1]);
		eng = Integer.parseInt(dataArr[2]);
		math = Integer.parseInt(dataArr[3]);
		
		int total = kor + eng + math;
		
		System.out.println(total);
	}

}
