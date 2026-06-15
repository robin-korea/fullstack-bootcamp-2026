package days16;

public class Ex01_02 {

	public static void main(String[] args) {
		
		String url = "www.naver.com";
		
		String prefix = "https://";
		// ~으로 시작하니 boolean 형
		System.out.println(url.startsWith(prefix));
		
		String suffix = ".com";
		// ~으로 끝나니 boolean 형
		System.out.println(url.endsWith(suffix));
	}

}
