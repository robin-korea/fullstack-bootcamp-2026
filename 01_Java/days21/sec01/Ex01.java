package days21.sec01;

public class Ex01 {

	public static void main(String[] args) {
		
		action(new Calculable() {
			
			@Override
			public void calculate(int x, int y) {
				
				int result = x + y;
				System.out.printf("%d + %d = %d\n",x,y,result);
				
			}
		});
		
		// 람다식 표현
		action((x, y) -> {
			int result = x - y;
			System.out.printf("%d - %d = %d",x,y,result);
		});
		
		

	}
	
	public static void action(Calculable calculable) {
		// 데이터
		int x = 10;
		int y = 20;
		
		calculable.calculate(x, y);
	}

}
