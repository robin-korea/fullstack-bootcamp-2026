package days07;


/**
 * @author An
 * @date 2026. 5. 19. 오전 11:31:41 
 * @subject foreach문 (확장 for문)
 * @content 
 *
 */
public class Ex02_03 {

	public static void main(String[] args) {
		
		String inputValue = "홍길동,23,45,56,167";
		
		String [] dataArr = inputValue.split(",",3);
				
		// [2] foreach 문 사용해서 출력 
		// 배열 또는 컬렉션 클래스에서 사용
		for (String s : dataArr) {
			System.out.println(s);
		}
		
		
		
		
		/* [1]
		for (int i = 0; i < dataArr.length; i++) {
			System.out.printf("dataArr[%d]=%s\n",i,dataArr[i]);
		}
		*/
		
		
	}

}
