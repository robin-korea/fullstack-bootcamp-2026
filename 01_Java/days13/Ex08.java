package days13;

public class Ex08 {

	public static void main(String[] args) {
		
		/*
		 * 1. 상속: A클래스 ◁---- B 클래스 
		 *          부모           자식
		 *         super          sub
		 *          기초           파생
		 * 
		 * 2. 부모(super)클래스의 필드+메소드 물려준다
		 * 3. 장점: 부모클래스의 코드를 재사용 가능
		 * 4. extends
		 * 5. 다중 상속 X, 단일 상속만 가능
		 * 
		 *        에) x,y 두 좌표: Ex01_03.java   Point 클래스 
		 *            x,y,z 새 좌표: Point3D 클래스 선언 + 사용
		 * 
		 * 6. super 사용..
		 */
		
		Point3D p = new Point3D();
		/*
		 * 
		 * 스택                                         힙
		 *                        S             Point 부모 인스턴스                  E S                E
		 * []                     [x][y][부모 메서드 참조][부모 메서드 참조][부모 메서드 참조][z][자식 메서드 참조][super][this]
		 *  p                     0x100번지                                                            0x100  0x100
		 * 객체
		 * 
		 * Method Area
		 * 
		 * [Point.메서드] [Point3D 메서드]
		 */
		
		
	}

}
