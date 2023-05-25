package com.enjoy.trip.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.enjoy.trip.dto.User;
import com.enjoy.trip.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	private UserMapper userMapper;
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User getUser(User user) throws Exception {
		if (user.getUserId() == null || user.getUserPw() == null) return null;
		return userMapper.getUser(user);
	}

	@Override
	public void updateRefreshToken(String userId, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", refreshToken);
		userMapper.updateRefreshToken(map);
	}

	@Override
	public User getUserById(String userId) throws Exception {
		return userMapper.getUserById(userId);
	}

	@Override
	public void deleRefreshToken(String userId) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", null);
		userMapper.deleteRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userId) throws Exception {
		return userMapper.getRefreshToken(userId);
	}

	@Override
	public boolean checkDuplicateId(String userId) throws Exception {
		int cnt = userMapper.checkDuplicateId(userId);
		return cnt == 0;
	}

	@Override
	public boolean signUp(User user) {
		boolean check = true;
		try {
			userMapper.insertUser(user);
		} catch (SQLException e) {
			check = false;
		}
		System.out.println(check);
		return check;
	}

	@Override
	public User findPwByUser(User user) throws Exception {
		return userMapper.getUserById(user.getUserId());
	}

}
