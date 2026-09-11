package org.doit.ik.di2;

import org.doit.ik.di.RecordImpl;
import org.doit.ik.di.RecordViewImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
// @Import({Config2.class, Config3.class}) 자바 설정 파일을 조합할 때 사용하는 어노테이션
// @ImportResource("classpath:org/doit/ik/di/application-context.xml")
// @ComponentScan(basePackages = "org.doit.ik.di4")
public class Config {
	
	// RecordImpl record = new RecordImpl();
	
	@Bean
	public RecordImpl record() {
		return new RecordImpl();
	}
	
	// RecordViewImpl rvi = new RecordViewImpl(record);
	@Bean("rvi")
	public RecordViewImpl getRecordViewImpl() {
		
		return new RecordViewImpl(record());
	}
	
}
