package days14;

public interface ILotto {
	
	// public final static int LENGTH = 6;
	int LENGTH = 6;
	
	// 추상 메서드
	// public abstract 숨겨져 있음
	void fillLotto(int [] lotto);
	void dispLotto(int [] lotto);
	void isDuplicateLotto(int [] lotto);
}
