package days13;

/**
 * @author An
 * @date 2026. 5. 28. 오후 12:25:50 
 * @subject [싱글톤(Singleton) 패턴]
 * @content     ㄴ 프로그램 전체에서 객체를 단 하나만 생성하도록 보장하는 디자인 패턴
 *                - 데이터베이스 연결 관리 객체    : BoardDAO
				  - 설정(Configuration) 객체   : 
				  - 로그(Logger) 객체
			      - 스레드 풀(Thread Pool) 객체
 *
 */
public class Ex05 {

	public static void main(String[] args) {
		
		
		// BoardDAO dao1 = new BoardDAO();
		BoardDAO dao1 = BoardDAO.getInstance();
		System.out.println(dao1.hashCode());
		dao1.create();
		
		// BoardDAO dao2 = new BoardDAO();
		BoardDAO dao2 = BoardDAO.getInstance();
		System.out.println(dao2.hashCode());
		dao2.create();
		
		// BoardDAO dao3 = new BoardDAO();
		BoardDAO dao3 = BoardDAO.getInstance();
		System.out.println(dao3.hashCode());
		dao3.create();
		

	}

}
