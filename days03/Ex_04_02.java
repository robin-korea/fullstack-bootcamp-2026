package days03;

public class Ex_04_02 {

	public static void main(String[] args) {
		
		char upperCase = 'X';
		// Type mismatch: cannot convert from int to char
		char lowerCase = (char) (upperCase + 32);
		
		System.out.printf("%c -> %c\n",upperCase, lowerCase);
		
		
		
	}

}
