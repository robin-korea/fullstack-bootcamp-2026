package days09;

import java.io.IOException;

public class Ex01_03 {

	public static void main(String[] args) throws IOException {

		char ch ;
		System.out.print("> 한 문자 입력: ");
		ch = (char) System.in.read();
		System.out.println("> ch: "+ ch);

		System.in.skip(System.in.available());
		
		System.out.print("> 한 문자 입력: ");
		ch = (char) System.in.read();
		System.out.println("> ch: "+ ch);
	}

}
