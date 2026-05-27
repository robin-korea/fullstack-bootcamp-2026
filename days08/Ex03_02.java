package days08;

/**
 * @author An
 * @date 2026. 5. 20. 오전 10:15:17 
 * @subject
 * @content 
 *
 */
public class Ex03_02 {

	public static void main(String[] args) {
		
		// [1] 1~n 합을 반환하는 메서드: sum
		System.out.println(sum(10));
		System.out.println(recusiveSum(10));
		
		// [2] 팩토리얼 메서드: factorial  (0! == 1)
		
		System.out.println(factorial(5));
		System.out.println(recusiveFactorial(5));
	}
	
	public static int recusiveFactorial(int n) {
		
		if(n == 0  || n == 1) {
			return 1;
		}else {
			return n *= recusiveFactorial (n-1);
		}
	}

	public static int factorial(int n) {
		
		int result = 1;
		for(int i = n; i >= 1; i--) {
			result *= i;
		}	
		return result;
	}

	//재귀 함수로 선언
	public static int recusiveSum(int n) {
		if(n == 1) {
			return 1;
		}else {
			return  n + recusiveSum(n-1);
		}
		
	}
	
	
	public static int sum(int n) {
		
		int result = 0;
		for(int i = 1; i<= n; i++) {
			result += i;
		}
		return result;
	}

}
