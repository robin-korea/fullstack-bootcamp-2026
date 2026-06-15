package days19;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * @author An
 * @date 2026. 6. 8. 오후 5:33:30 
 * @subject Data[InputStream]/Data[OutputStream]
 * @content   바이트 스트림
 *
 */
public class Ex06 {

	public static void main(String[] args) {
		
		// 한 학생의 성적 정보
		String name = "홍길동";

		int kor = 90, eng = 80, mat = 99;
		int tot = kor + eng + mat;
		double avg = (double)tot/3;
		boolean gender = true;

		String fileName = ".\\student02.dat"; 
		
		try (
			FileOutputStream out = new FileOutputStream(fileName);	
			DataOutputStream dos = new DataOutputStream(out);
				){
			dos.writeUTF(name);
			dos.writeInt(kor);
			dos.writeInt(eng);
			dos.writeInt(mat);
			dos.writeInt(tot);
			dos.writeDouble(avg);
			dos.writeBoolean(gender);
			
			//입(파일)
			dos.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("END");

	}

}


