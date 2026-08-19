package days20;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author An
 * @date 2026. 6. 9. 오전 9:15:47 
 * @subject 여러 개의 입력 스트림을 연속적으로 연결해서
 * @content 하나의 스트림으로 데이터를 처리할 수 있는 바이트 스트림: SequenceInputStream
 *          예) 용량이 큰 파일 -> 여러 개의 작은 용량의 파일로 분리해서 생성
 *            -> 하나의 스트림으로 처리
 */
public class Ex02 {

	public static void main(String[] args) throws IOException {
		
		byte [] n = {1,2,3};
		byte [] m = {4,5,6};
		byte [] k = {7,8,9};
		
		// 1) 각각의 배열을 스트림 3개 생성
		
		ByteArrayInputStream baisN = new ByteArrayInputStream(n);
		ByteArrayInputStream baisM = new ByteArrayInputStream(m);
		ByteArrayInputStream baisK = new ByteArrayInputStream(k);
		
//		[1]
//		SequenceInputStream sisNM = new SequenceInputStream(baisN, baisM);
//		SequenceInputStream sisNMK = new SequenceInputStream(sisNM, baisK);
		
		//[2]
		Vector<ByteArrayInputStream> v = new Vector<ByteArrayInputStream>();
		v.add(baisN);		
		v.add(baisM);		
		v.add(baisK);		
		Enumeration<ByteArrayInputStream> en = v.elements();
		SequenceInputStream sisNMK = new SequenceInputStream(en);
		
		// 출력 코딩
		int b;
		while ((b = sisNMK.read()) != -1) {
			System.out.println(b);
		}
	}

}
