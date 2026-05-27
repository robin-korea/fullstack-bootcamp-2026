package days04;

/**
 * @author An
 * @date 2026. 5. 14. 오전 11:47:13 
 * @subject ++n 전위형 증감연산자
 * @content n++ 후위형 증감연산자
 *          전위형과 후위형 증감 연산자의 차이점
 *          
 */
public class Ex06_03 {

	public static void main(String[] args) {
		
		int x = 10;
		int y = x++;
		
		// x -> 11 y -> 10
		System.out.printf("> x=%d, y=%d\n",x,y);
		
		int a = 10;
		int b = ++a;
		
		// a -> 11 b -> 11
		System.out.printf("> a=%d, b=%d\n",a,b);
		
		
//		while(10>x++) {}  // 먼저 처리하고 나중에 하나 올림
// 		while(10>++x) {}  // 올린다음에 처리
		
		
		
	}//main

}//class
