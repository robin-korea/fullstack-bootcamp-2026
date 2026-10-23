package org.doit.ik.config;

import java.net.http.HttpClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
@EnableMethodSecurity
public class SecurityConfig {
	
	// 1. PasswordEncoder 설정
	@Bean PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// 2. authentication-manager 설정" SS에서 인증처리 하는 핵심 객체
	//       ㄴ authentication-provider : 인증처리 구현체 중에 인 메모리상의 인증 처리.
	
	/*
	@Bean InMemoryUserDetailsManager userDetailsManager() {
		UserDetails user = User.builder()
				.username("kenik")
				.password(this.passwordEncoder().encode("1234"))
				.roles("USER")
				.build();
		UserDetails admin = User.builder()
				.username("admin")
				.password(this.passwordEncoder().encode("1234"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
	*/
	
	@Bean SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		log.info("😘😘 SecurityConfig.securityFilterChain()...");
		// 인가(Authorization)가 필요한 리소스 설정방법: 2가지
		// 1) 설정을 통해서 패턴을 지정
		// 2) 어노테이션을 사용
		
		http
			.authorizeHttpRequests((auth) -> {
			auth
				// .requestMatchers("/sample/admin").hasRole("ADMIN")
				// .requestMatchers("/sample/member").hasRole("USER")
				.anyRequest().permitAll();
		})
		
		.exceptionHandling(exception -> exception.accessDeniedHandler(accessDeniedHandler()));
		
		// http.formLogin( Customizer.withDefaults()); // /login 요청시 스프링 시큐리티의 기본 로그인 페이지 사용
		
		http.formLogin((form) -> {
			form.defaultSuccessUrl("/", true)
			.permitAll();
		});
		
		// csrf 설정, Spring Security 7 에서 API 가 변경
		http.csrf(csrf -> csrf.disable());
		
		http.logout(logout -> logout
								.logoutSuccessUrl("/")
								.permitAll()
				);
		
		return http.build();
		
	}
	
	@Bean AccessDeniedHandler accessDeniedHandler() {
		return (request, response, accessDeciedException) -> {
			response.sendRedirect("/error/403");
		};
		
	}

}
