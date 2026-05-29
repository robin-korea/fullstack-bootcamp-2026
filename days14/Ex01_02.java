package days14;

import java.util.Arrays;

public class Ex01_02 {

	public static void main(String[] args) {
		// 시간 복잡도
		String n = "publicStaticVoidMainStringArgs";
		
		int [] countArr = new int[26
		                          ];
		
		char [] nArr = n.toUpperCase().toCharArray();
		for (int i =0; i < nArr.length; i++) {
			int index = nArr[i]-65;
			countArr[index]++;
		}
		
		System.out.println(Arrays.toString(countArr));

	}

}
