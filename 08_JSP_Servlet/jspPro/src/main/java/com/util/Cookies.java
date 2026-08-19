package com.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class Cookies {   

   //          키:쿠키이름   값:쿠키객체
   public Map<String, Cookie> cookieMap = new HashMap<>();

   // 생성자
   public Cookies( HttpServletRequest request ) {
      Cookie []  cookies = request.getCookies();
      if( cookies != null ) {
         for (Cookie c : cookies) {
            String cname =  c.getName();
            cookieMap.put(cname, c);
         } // for
      } // if
   }
   
   // 쿠키 이름으로 쿠키를 가져오는 생성자
   public Cookie getCookie( String cname ) {
      return this.cookieMap.get(cname);
   }
   
   // 존재하는지 확인
   public boolean exists( String cname ) {
      return this.cookieMap.get(cname)  != null ;  // true, false
   }

   	// 쿠키 생성
   public static Cookie createCookie(String cname, String cvalue) throws UnsupportedEncodingException {
      Cookie c = new Cookie( cname, URLEncoder.encode(cvalue, "UTF-8"));
      return c;
   }
   
   // 쿠키 생성인데 경로와 파기일자까지
   public static Cookie createCookie(String cname, String cvalue, String path, int expiry) throws UnsupportedEncodingException {
      Cookie c = new Cookie( cname, URLEncoder.encode(cvalue, "UTF-8"));
      c.setPath(path);
      c.setMaxAge(expiry);
      return c;
   }
   
   // 쿠키 생성인데 도메인 추가
   public static Cookie createCookie(String cname, String cvalue, String domain, String path, int expiry) throws UnsupportedEncodingException {
      Cookie c = new Cookie( cname, URLEncoder.encode(cvalue, "UTF-8"));
      c.setDomain(domain);
      c.setPath(path);
      c.setMaxAge(expiry);
      return c;
   }
   
   // 쿠키 이름으로 쿠키 값을 가져오는 메서드
   public String getValue( String cname) throws UnsupportedEncodingException {
      String cvalue = null; 
      Cookie c =  this.cookieMap.get(cname);
      if( c != null ) {
         cvalue = URLDecoder.decode(c.getValue(), "UTF-8");
      } 
      return cvalue;
   }

}



