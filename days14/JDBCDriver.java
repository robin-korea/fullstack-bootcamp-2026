package days14;

public interface JDBCDriver {

	public abstract void open(); // DB 연결하는 메서드
	void close();  // DB 연결 종료(닫기) 

	// CRUD 작업
	void select();
	void insert();
	void update();
	void delete();

}
