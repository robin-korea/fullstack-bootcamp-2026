package org.doit.ik.blog.config;

import org.springframework.boot.security.autoconfigure.web.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class JwtWebSecurityConfig {

	private final JwtCookieAuthenticationFilter jwtCookieAuthenticationFilter;

	@Bean 
	WebSecurityCustomizer configure() {
		return (web) -> web.ignoring()
				.requestMatchers(PathRequest.toH2Console())
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations())
				.requestMatchers("/static/**", "/resources/**", "/cdn-main/**");   
	}

	@Bean 
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		return http
				.csrf(AbstractHttpConfigurer::disable)   // CSRF 비활성화
				// 세션을 사용하지 않고 JWT로 인증
				.sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth ->   // 인증, 인가 설정
				auth
				.requestMatchers(
						  "/api/auth/login"
						, "/api/auth/logout"
                        , "/api/auth/refresh"
						, "/login"
						, "/signup"
						, "/user"
						, "/"
						, "/index"
						, "/blog_js/**"
						, "/images/**"
						, "/error"
						).permitAll()
				.anyRequest().authenticated()
						)
				// 인증되지 않은 사용자가 접근하면 로그인 페이지로 이동
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(
                                (request, response, authException) -> {
                                    response.sendRedirect("/login");
                                }
                        )
                )
                // JWT 인증 필터 등록( 중요: 필터 등록 순서 )
                .addFilterBefore(jwtCookieAuthenticationFilter
                				, UsernamePasswordAuthenticationFilter.class)
				.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
