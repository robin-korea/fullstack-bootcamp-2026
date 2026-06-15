package days16;

/**
 * @author An
 * @date 2026. 6. 2. 오후 4:21:39 
 * @subject 
 * @content 
 *
 */
public class Ex14 {

	public static void main(String[] args) {
		
		   /*
	       * [jdk1.8 java.time 패키지 및 하위 패키지의
	       *           ㄴ  날짜, 시간 클래스 ]
	       *           
	       * 1. 5개의 time 패키지 + 하위 패키지
	       * 
	       * 2. j.t 패키지의 핵심 클래스
	       *    ㄴ 특징 : 날짜 클래스 , 시간 클래스 분리
	       *    
	       *    1) 날짜 : LocalDate 클래스
	       *    2) 시간 : LocalTime 클래스
	       *    
	       *    3) 날짜 + 시간 : LocalDateTime 클래스 
	       *    4) 날짜 + 시간 + 시간대 : ZonedDateTime 클래스 
	       * 
	       *  => 모두 Temporal, TemporalAccessor, TemporalAdjuster
	       *    인터페이스를 구현한 클래스 이다.  
	       * 
	       * 3. 날짜와 날짜 사이의 간격 : Period 클래스
	       *    시간과 시간 사이의 간격 : Duration 클래스 
	       *  => TemporalAmount 인터페이스를 구현한 클래스이다.
	       *  
	       * 4. 날짜,시간 객체 생성 : new 연산자 X
	       *    ㄴ now(), of() 메소드
	       *    
	       * 5. 날짜, 시간의 특정 필드(년,월,일,시간,분,초 등등)을 얻어올 때
	       *    ㄴ get(int field)
	       *    ㄴ getXXX() 가져오려는 필드 값 XX
	       *    
	       *    ㄴ plus()/minus()
	       *    ㄴ with()  
	       * 
	       * 6. TemporalUnit 인터페이스
	       *    ㄴ 날짜, 시간의 단위 정의해 놓은 인터페이스
	       *    ㄴ 이 인터페이스를 구현한 클래스 : ChronoUnit클래스
	       *    
	       * 7. TemproalField 인터페이스
	       *    ㄴ 필드  
	       *    ㄴ 필드를 정의해 놓은 인터페이스
	       *    ㄴ 이 인터페이스를 구현한 클래스 : ChronoField 클래스
	       * */ 
		
	}

}
