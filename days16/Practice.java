package days16;

import java.io.FileReader;

public class Practice {

	public static void main(String[] args) {

		String fileName = ".\\src\\days16\\Ex01.java";

		int [][] counts = {
				new int[26],
				new int[26],
				new int[10]
		};

		try (
				FileReader reader = new FileReader(fileName);
				){
			int code = -1;
			char one;
			while( (code = reader.read()) != -1 ) {
				// System.out.println(Integer.toBinaryString(code));
				
				one = (char) code;
				
				if(Character.isUpperCase(one)) { 
					counts[0][one-'A']++;
				} else if(Character.isLowerCase(one)) {
					counts[1][one-'a']++;
				}else if(Character.isDigit(one)) {
					counts[2][one-'0']++;
				}
			}

			// 막대그래프 출력
			for (int i = 0; i < counts[0].length; i++) {
				System.out.printf("%c(%d): %s\n",i+'A',counts[0][i],"#".repeat(counts[0][i]));
			}
			
			System.out.println();
			
			for (int i = 0; i < counts[1].length; i++) {
				System.out.printf("%c(%d): %s\n",i+'a',counts[1][i],"#".repeat(counts[1][i]));
			}
			
			System.out.println();
			
			for (int i = 0; i < counts[2].length; i++) {
				System.out.printf("%c(%d): %s\n",i+'0',counts[2][i],"#".repeat(counts[2][i]));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	} 
}
