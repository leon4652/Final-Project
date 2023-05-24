package com.enjoy.trip.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.enjoy.trip.dto.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTServiceImpl implements JWTService {
	private UserService userService;
	public JWTServiceImpl(UserService userService) {
		this.userService = userService;
	}

	private static final String SALT = "enjoyTrip";

	private static final int ACCESS_TOKEN_EXPIRE_MINUTES = 1; // 분단위
	private static final int REFRESH_TOKEN_EXPIRE_MINUTES = 2; // 주단위

	
	@Override
	public String createAccessToken(User user) {
		return create(user, "access-token", 1000 * 60 * 60 * 24 *  ACCESS_TOKEN_EXPIRE_MINUTES);
	}

	@Override
	public String createRefreshToken(User user) {
		return create(user, "refresh-token", 1000 * 60 * 60 * 24 * 7 * REFRESH_TOKEN_EXPIRE_MINUTES);
	}

	private String create(User user, String subject, long expire) {
		Claims claims = Jwts.claims()
				// 토큰 제목 설정 ex) access-token, refresh-token
				.setSubject(subject)
				// 생성일 설정
				.setIssuedAt(new Date())
				// 만료일 설정 (유효기간)
				.setExpiration(new Date(System.currentTimeMillis() + expire));

		// 저장할 data의 key, value
		claims.put("userId", user.getUserId());
		claims.put("userNo", user.getUserNo());
		claims.put("isAdmin", user.getIsAdmin());		

		String jwt = Jwts.builder()
				// Header 설정 : 토큰의 타입, 해쉬 알고리즘 정보 세팅.
				.setHeaderParam("typ", "JWT").setClaims(claims)
				// Signature 설정 : secret key를 활용한 암호화.
				.signWith(SignatureAlgorithm.HS256, this.generateKey()).compact(); // 직렬화 처리.

		return jwt;
	}
	
	private byte[] generateKey() {
		byte[] key = null;
		try {
			// charset 설정 안하면 사용자 플랫폼의 기본 인코딩 설정으로 인코딩 됨.
			key = SALT.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return key;
	}

	@Override
	public boolean checkToken(String jwt) {
		try {
//			Json Web Signature? 서버에서 인증을 근거로 인증정보를 서버의 private key로 서명 한것을 토큰화 한것
//			setSigningKey : JWS 서명 검증을 위한  secret key 세팅
//			parseClaimsJws : 파싱하여 원본 jws 만들기
			Jws<Claims> claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Map<String, Object> get(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		String jwt = request.getHeader("access-token");
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(jwt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> value = claims.getBody();
		/**
		 * userId : useId
		 * userNo : userNo
		 */
		return value;
	}

	@Override
	public String getUserId() {
		return (String) this.get("user").get("userid");
	}
	
	@Override
	public User getUserInfo(HttpServletRequest request) throws Exception {
		String accessToken = request.getHeader("access-token");
		Map<String, Object> map = get(accessToken);
		String userId = (String) map.get("userId");
		return userService.getUserById(userId);
	}
}
