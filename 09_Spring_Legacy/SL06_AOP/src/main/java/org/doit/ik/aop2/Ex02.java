package org.doit.ik.aop2;

import org.doit.ik.aop.Calculator;
import org.doit.ik.aop.CalculatorImpl;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex02 {

	public static void main(String[] args) {
		
		// 1. 스프링 AOP API 사용하는 방법...
		// application-context.xml
		
		// org.doit.ik.aop2.advice 패키지
		//  ㄴ LogPrintAroundAdvice.java 공통기능 클래스 추가
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:org/doit/ik/aop2/application-context.xml");
		
		// 보조기능을 장착시킨 프록시
		Calculator calc = ctx.getBean("calcProxy", Calculator.class);
		System.out.println(calc.add(10, 2));
		
		// 보조기능 X 실제 객체
		/*
		 * calc = ctx.getBean("calc", Calculator.class); System.out.println(calc.add(1,
		 * 2));
		 */
		
		
		System.out.println("END...");
	}

}
