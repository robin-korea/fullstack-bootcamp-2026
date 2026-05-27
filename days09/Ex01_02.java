package days09;

/**
 * @author An
 * @date 2026. 5. 21. 오전 9:38:37 
 * @subject 입력받은 총점이 0<= ~ <=300 체크하는 정규표현식 연습
 * @content 
 *
 */
public class Ex01_02 {

	public static void main(String[] args) {
		
		int [] m = {0,5,99,120,299,300,301,-1,006,789};
		
		for(int i = 0; i < m.length; i++) {
			
			int tot;
			// 모든 타입에 빈 문자열을 더하면 String 형태로 바뀐다
			String sTot = m[i]+"";
//			String regex = "^[0-9][0-9][0-9]$";
//			String regex = "^//d{3}$";
			String regex = "^(300|[1-9]?\\d|[12]\\d{2})$";		
			if(sTot.matches(regex)) {
				
				tot = Integer.parseInt(sTot);
				System.out.println(tot);
			}else {
				System.out.println("잘못된 총점입니다");
			}
		}
		
	}

}
