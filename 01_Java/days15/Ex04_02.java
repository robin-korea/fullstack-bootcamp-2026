package days15;

import days14.Employee;

/**
 * @author An
 * @date 2026. 6. 1. 오전 10:44:54 
 * @subject
 * @content 익명 == 무명(Anonymous) 클래스 
 *          	- 클래스의 선언 + 객체 생성 합쳐진 이름없는 클래스 
 *         		- 일회용
 *
 *				1) 이름이 없는 클래스 (일회용)
 *				2) 클래스 선언 과 동시에 객체 생성 (new 연산자)
 *				3) 익명 클래스 선언 형식
 *                   (1) new 부모클래스명(){
 *                          필드 선언 X
 *                    		메소드 선언 X
 *                    		
 *                    		@Override
 *                    		부모클래스의 메소드만 재정의할 수 있다
 *                    	}
 *                    
 *                   (2) new 인터페이스명(){
 *                          필드 선언 X
 *                    		메소드 선언 X
 *                    		
 *                    		@Override
 *                    		인터페이스의 추상 메소드만 재정의할 수 있다
 *                    	}
 *
 *
 */
public class Ex04_02 {

	public static void main(String[] args) {
		
		// Car,            Engine -> 상용화 테스트용도의 새로운 엔진 객체 
		Car testCar = new Car(new Engine() {
			
			@Override
			public void stop() {
				System.out.println("일회용 엔진의 stop()...");
			}
			
			@Override
			public void moreFuel(int fuel) {
				System.out.println("일회용 엔진의 moreFuel()...");	
			}
			
			@Override
			public void lessFuel(int fuel) {
				System.out.println("일회용 엔진의 lessFuel()...");
			}
		});
		
		testCar.speedUp(100);
		testCar.stop();
		
		
		
		// Cannot instantiate the type Employee
		// 추상 클래스이기 때문에 new 연산자로 객체를 생성 할 수 없다
		// Employee emp = new Employee(); //
		Employee emp = new Employee("홍길동","주소","연락처","입사일자" ) {
			
			@Override
			public int getPay() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
	}

}
