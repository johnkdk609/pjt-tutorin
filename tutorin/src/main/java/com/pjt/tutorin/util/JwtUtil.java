package com.pjt.tutorin.util;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private String SALT = "SSAFY_NonMajor_JavaTrack_SecretKey";
	// Q. HMAC 알고리즘을 활용하여 주어진 키를 암호키로 변경한다.
	private SecretKey secretKey = Keys.hmacShaKeyFor(SALT.getBytes(StandardCharsets.UTF_8));

	public String createToken(String email) {
		//Q. JWT builder 메서드를 통해 완성해 보겠다.
		//[헤더] typ : JWT
		//[페이로드] email 정보, 만료시간 1시간
		//[디지털서명] 위에서 작성한 키를 이용하여 암호화 한다.
		Date exp = new Date(System.currentTimeMillis() + 1000 * 60 * 60); // 1시간
		return Jwts.builder().header().add("typ", "JWT").and().claim("email", email).expiration(exp).signWith(secretKey)
				.compact();
	}


	public Jws<Claims> validate(String token) {
		//Q. JWT parser 메서드를 통해 클레임을 가져온다.
		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
	}
}
