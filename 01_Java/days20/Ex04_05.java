package days20;

import java.io.File;

/**
 * @author An
 * @date 2026. 6. 9. 오후 12:22:12 
 * @subject 첨부파일: 파일 업로드...
 * @content   ㄴ 회원가입 폴더
 * 			  ㄴ 상품 등록 폴더
 *
 */
public class Ex04_05 {

	public static void main(String[] args) {
		
		// days20 폴더 안에 upload 폴더 유무 확인 하고
		// 만약에 존재하지 않는다면 폴더 생성
		
		String pathname = ".\\src\\days20";
		File parent = new File(pathname);
		
		// parent.listFiles();
		
		File uploadFile = new File(parent, "upload");
		
		// System.out.println(uploadFile.exists()); // false
		
		if(!uploadFile.exists()) {
			
			// mkdir(), mkdirs()의 차이점: 
			// System.out.println(uploadFile.mkdir());
			// System.out.println(uploadFile.mkdirs());
			
		}
	}

}
