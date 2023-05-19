package com.enjoy.trip.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.enjoy.trip.dto.User;

public interface JWTService {

	String createAccessToken(String key, String userId, int userNo);

	String createRefreshToken(String key, String userId, int userNo);

	boolean checkToken(String header);

	Map<String, Object> get(String key);
	
	String getUserId();
	
	public User getUserInfo(HttpServletRequest request) throws Exception;
}
