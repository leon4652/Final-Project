package com.enjoy.trip.service;

import org.springframework.stereotype.Service;

import com.enjoy.trip.dto.User;
import com.enjoy.trip.mapper.MyPageMapper;

@Service
public class MyPageServiceImpl implements MyPageService {
	
	private final MyPageMapper myPageMapper;
	public MyPageServiceImpl(MyPageMapper myPageMapper) {
		this.myPageMapper = myPageMapper;
	}

	@Override
	public User getUser(int userNo) throws Exception {
		return myPageMapper.getUser(userNo);
	}

	@Override
	public int updateUser(User user) throws Exception {
		return myPageMapper.updateUser(user);
	}

}
