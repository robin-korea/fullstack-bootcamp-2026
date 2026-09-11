package org.doit.ik.di.test;

import org.doit.ik.di.RecordImpl;
import org.doit.ik.di.RecordViewImpl;

public class Ex01 {

	public static void main(String[] args) {
		
		// p.40 스프링을 사용하지 않고 객체 조립/사용하기
		// ( 성적 정보를 입력받아서 출력하는 일 : 인터페이스 , 클래스)
		
		RecordImpl record = new RecordImpl();
		
		// 생성자 DI
		// RecordViewImpl rvi = new RecordViewImpl(record);
		
		RecordViewImpl rvi = new RecordViewImpl();
		rvi.setRecord(record);
		
		rvi.input(); // 성적 정보를 입력
		rvi.output(); // 입력받은 성적 정보를 출력
		
		System.out.println("END.");
	}

}
