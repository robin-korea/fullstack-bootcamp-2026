package org.doit.ik.di5.test;

import org.doit.ik.di5.AuthInfo;
import org.doit.ik.di5.AuthenticationService;
import org.doit.ik.di5.PasswordChangeService;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test01 {

	public static void main(String[] args) {
		
		String configLocation = "classpath:org/doit/ik/di5/application-context5.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		AuthenticationService authSvc = ctx.getBean(AuthenticationService.class);
		AuthInfo authInfo = authSvc.authenticate("bkchoi", "1234");
		System.out.println("인증 성공 ID: " + authInfo.getId());
		
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
		System.out.println("비밀번호 변경 완료!");
		
		ctx.close();

	}

}
