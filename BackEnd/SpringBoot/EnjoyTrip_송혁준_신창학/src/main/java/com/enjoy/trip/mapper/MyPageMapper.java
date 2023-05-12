package com.enjoy.trip.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.enjoy.trip.dto.User;

@Mapper
public interface MyPageMapper {

	User getUser(int userNo) throws SQLException;

	int updateUser(User user) throws SQLException;



}
