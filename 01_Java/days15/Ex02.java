package days15;

import java.io.Serializable;

/**
 * @author An
 * @date 2026. 6. 1. 오전 9:16:48 
 * @subject 인터페이스, 클래스 사용 예제
 * @content 
 *
 */
public class Ex02 implements Serializable{ // 안에 아무것도 없지만 직렬화 가능한 클래스 

	public static void main(String[] args) {
		
		// ArrayList

	}

}

// (군사) 사병, 탱크... 단일체
class Unit{

	// 필드 : 유닛의 위치
	int x;
	int y;
	int currentHP; // 현재 유닛의 체력

}

class AirUnit extends Unit{

}

class GroundUnit extends Unit{

}

interface Movable{
	void move(int x, int y);
}

interface Attackable {
	void attack(Unit unit); // 매개변수 다형성
}

interface Fightable extends Movable, Attackable{

}

class Fighter implements Fightable{

	@Override
	public void move(int x, int y) {


	}

	@Override
	public void attack(Unit unit) {

	}


}

class Tank extends GroundUnit implements Fightable, Repairable{

	@Override
	public void move(int x, int y) {

	}

	@Override
	public void attack(Unit unit) {

	}

}


class Marin extends Unit implements Fightable{

	@Override
	public void move(int x, int y) {

	}

	@Override
	public void attack(Unit unit) {

	}

}

class DropShip extends AirUnit implements Fightable, Repairable{

	@Override
	public void move(int x, int y) {

	}

	@Override
	public void attack(Unit unit) {

	}


}

interface Repairable{
	// 상수, 추상 메서드 선언 X
}

// 수리, 건축 기능을 가진 클래스
class SCV extends GroundUnit implements Repairable{

	// 수리 메소드: 대상(수송선, 탱크, SCV 수리 가능 마린 수리 불가)
	
	void repair(Repairable target) {
		
		if (target instanceof Tank) {
			Unit u = (Unit) target; // 다운캐스팅
			// 탱크 수리  처리
		} else if (target instanceof DropShip){
			DropShip ds = (DropShip) target;
		}else {
			
		}
	}
	
	/*
	void repair(DropShip unit) {

	}
	void repair(Tank unit) {

	}
	void repair(SCV unit) {

	}
	*/
	
	


}


