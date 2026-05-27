package days08;

public class Ex03_03 {

	public static void main(String[] args) {
		
		
		System.out.println(power(2,3));
		System.out.println(recursivePower(3,4));
	}

	public static int recursivePower(int base, int intexponent) {
		
		if(intexponent == 0) {
			return 1;
		}else {
			return base *  recursivePower(base, intexponent-1);
		}
	}

	public static int power(int base, int intexponent) {
		
		int result = 1;
		
		
		for(int i = 1; i <= intexponent; i++) {
			result *= base;
		}
		
		return result;
	}
	
}

/*
 * [[문제] 거듭제곱 == 멱 
 *   
 *   power(base, exponent)
 * 	 recusivePower(base, exponent)
 */
