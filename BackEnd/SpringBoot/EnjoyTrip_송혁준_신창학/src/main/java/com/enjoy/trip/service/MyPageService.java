package com.enjoy.trip.service;

import com.enjoy.trip.dto.User;

public interface MyPageService {

	User getUser(int userNo) throws Exception;

	int updateUser(User user) throws Exception;

}
