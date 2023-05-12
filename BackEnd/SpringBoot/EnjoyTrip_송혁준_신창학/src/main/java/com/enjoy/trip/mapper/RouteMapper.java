package com.enjoy.trip.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.enjoy.trip.dto.MyRoute;

@Mapper
public interface RouteMapper {

	List<MyRoute> selectMyRouteList(int userNo) throws SQLException;

	MyRoute getMyRoute(int myRouteNo) throws SQLException;

	int updateMyRoute(MyRoute myRoute) throws SQLException;

	void deleteOrders(int myRouteNo) throws SQLException;

	void insertOrders(MyRoute myRoute) throws SQLException;

	int deleteRoute(int myRouteNo) throws SQLException;

}
