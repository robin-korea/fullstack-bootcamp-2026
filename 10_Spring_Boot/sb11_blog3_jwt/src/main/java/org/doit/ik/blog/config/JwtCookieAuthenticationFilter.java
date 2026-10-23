package org.doit.ik.blog.config;

import java.io.IOException;

import org.doit.ik.blog.config.jwt.JwtProperties;
import org.doit.ik.blog.config.jwt.JwtTokenProvider;
import org.doit.ik.blog.service.RefreshTokenService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2; 

// TokenAuthenticationFilter 교재의 이 필터 대신 사용
@Component
@RequiredArgsConstructor
@Log4j2
public class JwtCookieAuthenticationFilter extends OncePerRequestFilter {

   private final JwtTokenProvider jwtTokenProvider;   
   private final JwtProperties jwtProperties;
   private final RefreshTokenService refreshTokenService;   // 

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

       // 1. Cookie에서 Access Token 가져오기
        String accessToken = getCookie( request, "accessToken" ); 
        
        // [2] Access Token이 존재하는 경우
      if (accessToken != null) {
         
         log.info("✔️ AT 존재합니다.");
         
         // 3. JWT 유효성 검사
         boolean validToken = jwtTokenProvider.validToken(accessToken);
         
         // 4. 실제 Access Token인지 확인
         boolean accessTokenType = validToken && jwtTokenProvider.isAccessToken(accessToken);
         
         // 5. 유효한 Access Token이면 인증 객체 생성
         if (accessTokenType) {
            Authentication authentication = jwtTokenProvider.getAuthentication( accessToken );
            // 6. SecurityContext에 인증 정보 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);
         }
         
      }else {  // Access Token이 존재하지 않는 경우
         
         log.info("❌ AT 존재하지 않습니다. ");

            // Refresh Token 확인
            String refreshToken = getCookie( request, "refreshToken"); 

            // 8. Refresh Token이 존재하는 경우
            if (refreshToken != null) {
               log.info("✔️ RT 존재합니다. ");

                // Refresh Token 유효성 검사
                boolean validRefreshToken = jwtTokenProvider.validToken(refreshToken);
                // 실제 Refresh Token인지 확인
                boolean refreshTokenType = validRefreshToken && jwtTokenProvider.isRefreshToken(refreshToken);

               // 9. Refresh Token이 유효한 경우 
                if (refreshTokenType) {
                   
                   System.out.println("😊😊 JwtCookieAuthenticationFilter.refreshToken: " + refreshToken );
                   
                   // 10. 새로운 Access Token 발급
                    String newAccessToken =
                          jwtTokenProvider.generateAccessTokenFromRefreshToken(
                                    refreshToken,
                                    jwtProperties.getAccessTokenExpiration()
                            );
                    
                    ResponseCookie accessCookie =
                        ResponseCookie.from("accessToken", newAccessToken)
                        .httpOnly(true)
                        .secure(true)
                        .path("/")
                        .maxAge(jwtProperties.getAccessTokenExpiration())
                        .sameSite("Lax")
                        .build(); 
                    response.addHeader( HttpHeaders.SET_COOKIE, accessCookie.toString() );
                    Authentication authentication = jwtTokenProvider.getAuthentication( newAccessToken );
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    
                    // 11. 새로운 Refresh Token 발급
                    String newRefreshToken = jwtTokenProvider.generateRefreshTokenFromRefreshToken(refreshToken, jwtProperties.getRefreshTokenExpiration());
                    ResponseCookie refreshCookie = ResponseCookie.from("refreshToken", newRefreshToken)
                                       .httpOnly(true)
                                       .secure(true)
                                       .path("/")
                                       .maxAge(jwtProperties.getRefreshTokenExpiration())
                                       .sameSite("Lax")
                                       .build(); 
                   response.addHeader( HttpHeaders.SET_COOKIE, refreshCookie.toString() );
                    
                   // 12. Refresh Token 새로 발급 후 업데이트 
                   Long userid = this.jwtTokenProvider.getUserId(refreshToken); 
                   refreshTokenService.save( userid, newRefreshToken); // 
                    
                }
            }else {
               log.info("❌ RT 존재하지 않습니다. ");                
            }
        } 

        // 7. 다음 필터로 요청 전달
        filterChain.doFilter(request, response);
    }

    //  Cookie에서 특정 이름의 값을 가져온다.
    private String getCookie( HttpServletRequest request, String name) {

        if (request.getCookies() == null) {
            return null;
        }

        for (Cookie cookie : request.getCookies()) {
            if (name.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }

        return null;
    }
    
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request)
            throws ServletException {
        String path = request.getServletPath();
        // 정적 리소스 확장자
        return path.matches(
                ".*\\.(css|js|mjs|png|jpg|jpeg|gif|svg|ico|webp|woff|woff2|ttf|map)$"
        );
    }
}
