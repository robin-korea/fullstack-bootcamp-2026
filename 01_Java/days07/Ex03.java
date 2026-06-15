package days07;

import com.util.Graphic2D;

/**
 * @author An
 * @date 2026. 5. 19. 오전 11:36:56 
 * @subject 메소드(Method) 설명
 * @content == 함수(function)
 * 				ㄴ 프로그래밍에서 반복되는 명령어들을 찾아서
 * 				   별도로 묶어서 필요할 때 마다 불러서 사용할 수 있도록 한것
 * 
 *              ㄴ 프로그램의 구조화 -> 유지, 보수 용이
 *              
 *          	ㄴ 메소드(==함수) 선언 형식 
 *          	  [접][기]리턴자료형 메소드명([매개변수...])  함수 원형, prototype
 *          		{         함수의 몸체(body)
 *          			//실행문
 *          			//실행문
 *          			//실행문    
 *          			//실행문
 *          			
 *          			[return 함수값;]          
 *          
 *          		}
 *          
 *          
 *          	ㄴ 오버로딩(Overload) : 매개변수의 갯수, 타입이 다른 동일한 이름의 메소드를 선언 (중복함수)
 *      							  리턴 자료형 X
 *      		
 *      		ㄴ 
 *      
 *      		
 *        
 */
public class Ex03 {

	public static void main(String[] args) {	

		//		System.out.println("---------------");
		//		drawLine();
		Graphic2D.drawLine();
		System.out.println(" 부서명  : 사원명 ");
		//		System.out.println("---------------");
		//		drawLine(50);
		Graphic2D.drawLine(50);
		System.out.println(" 영업부  : 이태규 ");
		System.out.println(" 총무부  : 신희민 ");
		System.out.println(" 생산부  : 박현주 ");
		System.out.println(" 기획부  : 김예지 ");
		System.out.println(" 기획부  : 하동호 ");
		//		System.out.println("---------------");
		//		drawLine(30,'*');
		Graphic2D.drawLine(30,'*');
	}



}

