package org.doit.ik.blog.config.jwt;

import java.time.Duration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
// application.properties 설정 읽어와서 자동으로 객체 필드 설정
@ConfigurationProperties("spring.jwt")
public class JwtProperties {
	
	   private String issuer;
	   private String secretKey;

	   // Access Token 만료시간
	    private Duration accessTokenExpiration;
	    // Refresh Token 만료시간
	    private Duration refreshTokenExpiration;
}
