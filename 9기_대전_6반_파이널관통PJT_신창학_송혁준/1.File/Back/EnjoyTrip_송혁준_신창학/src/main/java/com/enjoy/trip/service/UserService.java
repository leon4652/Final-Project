package com.enjoy.trip.service;

import java.util.HashMap;

import com.enjoy.trip.dto.User;

public interface UserService {

	User getUser(User user) throws Exception;

	void updateRefreshToken(String userId, String refreshToken) throws Exception;

	User getUserById(String userId) throws Exception;

	void deleRefreshToken(String userId) throws Exception;

	Object getRefreshToken(String userId) throws Exception;

	boolean checkDuplicateId(String userId) throws Exception;

	boolean signUp(User user) throws Exception;

	User findPwByUser(User user) throws Exception;

}
