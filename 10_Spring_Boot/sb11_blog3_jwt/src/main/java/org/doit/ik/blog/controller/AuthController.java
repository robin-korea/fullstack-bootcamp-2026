package org.doit.ik.blog.controller;

import org.doit.ik.blog.config.jwt.JwtProperties;
import org.doit.ik.blog.config.jwt.JwtTokenProvider;
import org.doit.ik.blog.domain.User;
import org.doit.ik.blog.dto.AddUserRequest;
import org.doit.ik.blog.service.RefreshTokenService;
import org.doit.ik.blog.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

   private final JwtTokenProvider jwtTokenProvider;
   private final JwtProperties jwtProperties;
   private final UserService userService;
   private final RefreshTokenService refreshTokenService;

   // 1. 로그인
   @PostMapping("/api/auth/login")
   public ResponseEntity<?> login( @RequestBody AddUserRequest userRequest, HttpServletResponse response) {

      // 1) 사용자 인증
      User user = userService.login( userRequest.getEmail(),userRequest.getPassword() );

      // 2) Access Token 생성
      String accessToken = jwtTokenProvider.generateAccessToken( user, jwtProperties.getAccessTokenExpiration() );

      // 3) Refresh Token 생성
      String refreshToken = jwtTokenProvider.generateRefreshToken( user, jwtProperties.getRefreshTokenExpiration() );

      // 4) Refresh Token DB 저장
      refreshTokenService.save( user.getId(), refreshToken );

      // 5) Access Token 쿠키
      ResponseCookie accessCookie = ResponseCookie.from("accessToken", accessToken)
                                       .httpOnly(true)
                                       .secure(true)
                                       .path("/")
                                       .maxAge(jwtProperties.getAccessTokenExpiration())
                                       .sameSite("Lax")
                                       .build();

      // 6) Refresh Token 쿠키
      ResponseCookie refreshCookie = ResponseCookie.from("refreshToken", refreshToken)
                                       .httpOnly(true)
                                       .secure(true)
                                       .path("/")
                                       .maxAge(jwtProperties.getRefreshTokenExpiration())
                                       .sameSite("Lax")
                                       .build();

      // 7) Cookie 저장: 엑세스 토큰, 리프레시 토큰
      response.addHeader( HttpHeaders.SET_COOKIE, accessCookie.toString() );
      response.addHeader( HttpHeaders.SET_COOKIE, refreshCookie.toString() );

      return ResponseEntity.ok("로그인 성공");
   }

   // 2. 로그아웃 
   @GetMapping("/api/auth/logout")
   public ResponseEntity<Void> logout( @CookieValue(value = "refreshToken", required = false)
                              String refreshToken,
                              HttpServletResponse response) {

      System.out.println("😊😊 api/auth/logout refreshToken = " + refreshToken);

      // 1) DB에서 Refresh Token 삭제
      if (refreshToken != null) {
         refreshTokenService.deleteByRefreshToken(refreshToken);
      }

      // 2) Access Token 쿠키 삭제 위해서 만기시점 0 설정
      ResponseCookie accessCookie = ResponseCookie.from("accessToken", "")
                                       .httpOnly(true)
                                       .secure(true)
                                       .path("/")
                                       .maxAge(0)
                                       .sameSite("Lax")
                                       .build();

      // 3) Refresh Token 쿠키 삭제 위해서 만기시점 0 설정
      ResponseCookie refreshCookie = ResponseCookie.from("refreshToken", "")
                                       .httpOnly(true)
                                       .secure(true)
                                       .path("/")
                                       .maxAge(0)
                                       .sameSite("Lax")
                                       .build();

      // 4. Cookie 삭제: 엑세스, 리프레시 쿠키 삭제
      response.addHeader( HttpHeaders.SET_COOKIE, accessCookie.toString() );
      response.addHeader( HttpHeaders.SET_COOKIE, refreshCookie.toString() );

      // 5. 로그인 페이지로 이동
      return ResponseEntity.status(HttpStatus.FOUND).header(HttpHeaders.LOCATION, "/login").build();
   }

   /**
    * 3. Access Token 재발급 
    *       Access Token이 없거나 만료되었을 때
    *       Refresh Token을 이용해서 새로운 Access Token을 발급한다.
    */
   @PostMapping("/api/auth/refresh")
   public ResponseEntity<?> refreshAccessToken(
         @CookieValue( value = "refreshToken", required = false)
         String refreshToken,
         HttpServletResponse response) {

      // 1) Refresh Token이 없는 경우
      if (refreshToken == null || refreshToken.isBlank()) {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Refresh Token이 없습니다.");
      }

      // 2) Refresh Token JWT 유효성 검사
      if (!jwtTokenProvider.validToken(refreshToken)) {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("유효하지 않은 Refresh Token입니다.");
      }

      // 3) Refresh Token인지 확인
      if (!jwtTokenProvider.isRefreshToken(refreshToken)) {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Refresh Token이 아닙니다.");
      }

      // 4) DB에 저장된 Refresh Token인지 확인
      boolean exists = refreshTokenService.existsByRefreshToken( refreshToken );

      if (!exists) {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("존재하지 않는 Refresh Token입니다.");
      }

      try {

         // 6) Refresh Token으로 새로운 Access Token 생성
         String newAccessToken = jwtTokenProvider.generateAccessTokenFromRefreshToken(
                                                      refreshToken,
                                                      jwtProperties.getAccessTokenExpiration()
                                                      );

         // 7) 새로운 Access Token Cookie 생성
         ResponseCookie accessCookie = ResponseCookie.from( "accessToken", newAccessToken )
                                          .httpOnly(true)
                                          .secure(true)
                                          .path("/")
                                          .maxAge(
                                                jwtProperties.getAccessTokenExpiration()
                                                )
                                          .sameSite("Lax")
                                          .build();

         // 7-2) 새로운 Access Token Cookie 저장
         response.addHeader( HttpHeaders.SET_COOKIE, accessCookie.toString() );

         return ResponseEntity.ok( "Access Token 재발급 성공" );

      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Access Token 재발급 실패");
      }
      
   }
   
   // 로그인 실패시 처리 : 로그인 성공 경고창 뜨는 문제
   @ExceptionHandler(IllegalArgumentException.class)
   public ResponseEntity<String> handleLoginException(IllegalArgumentException e) {
       return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
   }

}