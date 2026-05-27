package days05;

import java.util.Arrays;
import java.util.Random;

public class Ex07_07 {

	public static void main(String[] args) {
		
		int [] lottoNumbers = new Random().ints(1,46).distinct().limit(6).sorted().toArray();
		System.out.println(Arrays.toString(lottoNumbers));

	}

}
