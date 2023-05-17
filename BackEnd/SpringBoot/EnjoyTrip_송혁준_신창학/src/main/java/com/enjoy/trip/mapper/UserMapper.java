package com.enjoy.trip.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.enjoy.trip.dto.User;

@Mapper
public interface UserMapper {

	User getUser(User user) throws SQLException;

	void updateRefreshToken(Map<String, String> map) throws SQLException;

	User getUserById(String userId) throws SQLException;

	void deleteRefreshToken(Map<String, String> map) throws SQLException;

	Object getRefreshToken(String userId) throws SQLException;

	int checkDuplicateId(String userId) throws SQLException;

	void insertUser(User user) throws SQLException;

}
