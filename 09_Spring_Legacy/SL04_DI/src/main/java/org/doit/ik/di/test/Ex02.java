package org.doit.ik.di.test;

import org.doit.ik.di.RecordViewImpl;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex02 {

	public static void main(String[] args) {
		// p42 스프링을 사용해서 객체 생성 조립/사용하기
		// (성적 정보를 입력받아서 출력하는 일 : 인터페이스, 클래스)
		
		// 1) 조립설명서   application-context.xml
		String [] resourceLocations = {"classpath:org/doit/ik/di/application-context.xml"};
		// 2) 조립기      ???ApplicationContext
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		// 3) 자동으로 스프링(DI) 컨테이너 안에 빈 객체 생성/조립 -> 사용
		
		// RecordViewImpl rvi = (RecordViewImpl) ctx.getBean("rvi");
		
		RecordViewImpl rvi = ctx.getBean("rvi",RecordViewImpl.class);
		
		rvi.input(); // 성적 정보를 입력
		rvi.output(); // 입력받은 성적 정보를 출력
		
		System.out.println("END...");
		
	}

}
