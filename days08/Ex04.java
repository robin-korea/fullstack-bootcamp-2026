package days08;

/**
 * @author An
 * @date 2026. 5. 20. 오전 11:46:40 
 * @subject
 * @content String 메서드 확인
 *			: charAt(), length(), split(), join(), repeat(), substring(), indexOf() 
 */
public class Ex04 {

	public static void main(String[] args) {


		// 1) 830412-*******

		String rrn = "830412-1700001";
		String result = toMaskedRRN(rrn);
		System.out.println(result);


		// 2) 830412-1*******

		result = toMaskedRRNWithGender(rrn);
		System.out.println(result);
	}
	// [2] 풀이
	public static String toMaskedRRNWithGender(String rrn) {
		int index = rrn.indexOf("-");
		
		return String.format("%s*******", rrn.substring(0, index +2));
	}
	// indexOf 위치 찾아주기 없으면 -1  0부터 시작
	public static String toMaskedRRN(String rrn) {
		
		int index = rrn.indexOf("-");
//		System.out.println("> 찾은 위치: " + index);
		
		return String.format("%s*******", rrn.substring(0, index +1));
	}


	/* [1] 풀이
	public static String toMaskedRRNWithGender(String rrn) {
		String [] rrnArr = rrn.split("-");
		String rrnFront = rrnArr[0];
		String rrnBack = rrnArr[1];
		char gender = rrnBack.charAt(0);

		return String.format("%s-%c******", rrnFront, gender);
	}

	public static String toMaskedRRN(String rrn) {
		return String.format("%s-*******", rrn.split("-")[0]);
	}
	 */

}
