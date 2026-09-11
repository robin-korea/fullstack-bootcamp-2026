package org.doit.ik.di2.test;

import org.doit.ik.di.RecordViewImpl;
import org.doit.ik.di2.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex03 {

	public static void main(String[] args) {
		
		// p85 스프링을 사용해서 객체 조립/사용하기 (자바 코드 Config.java)
		//    (성적정보를 입력받아서 출력하는 일)
		
		// p62
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		
		RecordViewImpl rvi = ctx.getBean("rvi",RecordViewImpl.class);
		
		rvi.input(); // 성적 정보를 입력
		rvi.output(); // 입력받은 성적 정보를 출력
		
		System.out.println("END.....");
	}

}
