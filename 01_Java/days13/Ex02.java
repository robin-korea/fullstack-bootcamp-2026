package days13;

/**
 * @author An
 * @date 2026. 5. 28. 오전 10:43:04 
 * @subject 정적 멤버 = 정적 필드 + 정적 메서드
 * @content           static    static
 *
 */
public class Ex02 {

	public static void main(String[] args) {
	    
		// The field Save.rate is not visible
		// Save.rate = 0.04;
		Save.setRate(0.04);
		
		Save s1 = new Save("양인석",10000,0.04);
		Save s2 = new Save("안정빈",150000,0.04);
		Save s3 = new Save("신창만",560000,0.04);
		
		s1.setRate(0.77);
		
		System.out.println(s1.getRate());
		System.out.println(s2.getRate());
		System.out.println(s3.getRate());
		
		
		
		/*
		 * 
		 *  힙                             스택
		 * [name][money][rate]           0x100
		 * [0x100]                        s1
		 * 
		 * [name][money][rate]           0x200               
		 * [0x200]                        s2
		 * 
		 * [name][money][rate]           0x300        
		 * [0x300]                        s3
		 *                               
		 * 
		 * 메소드 영역
		 * getter setter rate
		 * 
		 */
		
	}

}

// 저축 클래스
class Save{
	
	// 인스턴스 변수 name, money 는 객체를 생성해야지 사용 할 수 있다
	private String name; // 예금주
	private int money; // 예금액
	
	// 클래스 변수, 정적(static)변수
	// 정적 변수는 객체를 생성하지 않아도 클래스.필드 로 사용 가능
 	private static double rate = 0.01; // 이자율
	
 	static { // 초기화 블록
 		rate = 0.04;
 	}
	public Save() {
		
	}
	
	public Save(String name, int money, double rate) {
	//	super();
		this.name = name;
		this.money = money;
		this.rate = rate;
	}
	
	public void printSave() {
		System.out.printf("> 예금주:%s, 예금액:%d, 이자율:%.2f\n", name,money,rate);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	// 정작(static) 메소드
	//    ㄴ static 필드를 접근하기 위해서는 static 메소드가 필요하다
	public static double getRate() {
		return rate;
	}

	public static void setRate(double rate) {
		Save.rate = rate;
	}
	
	
	
}
