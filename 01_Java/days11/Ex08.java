package days11;

/**
 * @author An
 * @date 2026. 5. 26. 오후 3:48:42 
 * @subject 클래스 배열
 * @content 클래스 배열 초기화
 *
 */
public class Ex08 {

	public static void main(String[] args) {

		// 시간 정보(시,분,초) * 10개 저장
		//      int hour1, minute1, second;
		//      int hour2, minute1, second;
		//      int hour3, minute1, second;
		//      int hour1, minute1, second;
		//      int hour1, minute1, second;
		//      int hour1, minute1, second;
		//      int hour1, minute1, second;
		//      int hour1, minute1, second;
		//      int hour1, minute1, second;
		//      int hour10, minute10, second10;

		// 1차원 배열
		//      int [] hourArr = new int[10];
		//      int [] minuteArr = new int[10];
		//      int [] secondArr = new int[10];

		// 2차원  배열   각 0열:시간, 1열:분, 2열:초
		//      int [][] timeArr = new int[10][3]; 

		//      Time t1 = new Time(); // t1 객체
		//      t1.hour = 2;
		//      t1.minute = 30;
		//      t1.second = 40;

		// 클래스 배열 선언
		//      자료형 [] 배열명 = new 자료형[배열크기];
		Time [] timeArr = new Time[10];
		//  timeArr[0]      timeArr[9] 객체명   
		//  [][][][][][][][][][]                 [0x100번지]
		//  0x100번지                              timeArr  배열명

		timeArr[0] = new Time();
		timeArr[0].hour = 9;
		timeArr[0].minute = 20;
		timeArr[0].second = 35;

		System.out.println(  timeArr[0].hour );

		timeArr[9] = new Time();

	}

}
