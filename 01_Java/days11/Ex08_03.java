package days11;

/**
 * @author An
 * @date 2026. 5. 26. 오후 4:37:13 
 * @subject 클래스 배열 초기화
 * @content 
 *
 */
public class Ex08_03 {

	public static void main(String[] args) {

		/* 
		// i 변수 초기화
//		int i ;// 초기화
//		i = 10; // 초기화

		// [ 배열 초기화 ]
//		int [] m = new int[3];
//		m[0] = 1;
//		m[1] = 2;
//		m[2] = 3;

//		int [] m = new int[] {1, 2, 3};
		int [] m = {
						1, 
						2, 
						3
					};
		 */

		// [클래스 배열 초기화 ]

		// p1 객체 생성 후 x, y 필드값을 1,2로 초기화
		//		Point p1 = new Point();
		//		p1.x = 1;
		//		p1.y = 2;


		//		int [] m = new int[3];
		//		m[0] = 1;
		//		m[1] = 2;
		//		m[2] = 3;
		// 클래스 배열
		/*
		Point [] pArr = new Point[3];
		pArr[0] = new Point(); 
		pArr[1] = new Point(); 
		pArr[2] = new Point(); 
		 */

		// [클래스 배열 초기화]
		Point [] pArr = {
				new Point(),
				new Point(),
				new Point()
		};





	}

}
