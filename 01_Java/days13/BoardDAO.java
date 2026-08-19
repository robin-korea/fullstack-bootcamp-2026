package days13;

public class BoardDAO {
	
	// Double-Checked-Locking(DCL) 방식에서 필수 (이중 잠금 확인)
	private static volatile BoardDAO boardDAO = null;
	
	
	private BoardDAO() {
		
	}
	
	public static synchronized BoardDAO getInstance() {
		if(boardDAO == null) {
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}
	
	// CRUD
	
	public void create() {
		System.out.println("게시글 작성...");
	}
	public void read() {
		System.out.println("게시글 조회...");
	}
	
	public void update() {
		System.out.println("게시글 수정...");
	}
	public void delete() {
		System.out.println("게시글 삭제...");
	}
	
}
