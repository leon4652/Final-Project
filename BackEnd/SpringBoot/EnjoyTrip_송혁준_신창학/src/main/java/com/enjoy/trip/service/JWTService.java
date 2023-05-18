package com.enjoy.trip.service;

public interface JWTService {

	String createAccessToken(String key, String userId);

	String createRefreshToken(String key, String userId);

	boolean checkToken(String header);

}
