package days11;

public class Ex03 {

	public static void main(String[] args) {
		Car myCar = null;
		
		// The local variable myCar may not have been initialized
		// myCar.name = "K9";
		
		myCar = new Car();
		
		testInstance(myCar);
	
	}

	private static void testInstance(Car myCar) {
		// java.lang.NullPointerException
		myCar.name = "K3";
		myCar.dispCarInfo();
	}

}
