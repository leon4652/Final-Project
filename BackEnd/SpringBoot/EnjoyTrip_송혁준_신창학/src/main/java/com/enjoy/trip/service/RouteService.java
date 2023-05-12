package com.enjoy.trip.service;

import java.util.List;

import com.enjoy.trip.dto.MyRoute;

public interface RouteService {

	List<MyRoute> selectMyRouteList(int userNo) throws Exception;

	MyRoute getMyRoute(int myRouteNo) throws Exception;

	boolean updateRoute(MyRoute myRoute) throws Exception;

	boolean deleteRoute(int myRouteNo) throws Exception;

}
