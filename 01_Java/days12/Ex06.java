package days12;

import java.util.Date;

public class Ex06 {

	public static void main(String[] args) {
		
		Date d = new Date();
		System.out.println(d.toLocaleString());
		
		Date open = new Date(2026-1900, 5-1, 11, 9, 0, 0);
		System.out.println(open.toLocaleString());
		
	}

}
