package org.doit.ik.blog.config.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;

public class JwtKeyGenerator {
	
	public static void main(String[] args) {
		
		String secret_key = Encoders.BASE64.encode(Jwts.SIG.HS256.key().build().getEncoded());
		
		System.out.println(secret_key);
	}
	
}
