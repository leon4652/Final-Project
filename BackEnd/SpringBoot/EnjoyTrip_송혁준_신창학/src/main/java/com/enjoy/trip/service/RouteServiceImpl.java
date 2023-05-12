package com.enjoy.trip.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.enjoy.trip.dto.AttractionInfo;
import com.enjoy.trip.dto.MyRoute;
import com.enjoy.trip.mapper.RouteMapper;

@Service
public class RouteServiceImpl implements RouteService {
	private final RouteMapper routeMapper;
	private final AttractionService attractionService;
	
	public RouteServiceImpl(RouteMapper routeMapper, AttractionService attractionService) {
		this.routeMapper = routeMapper;
		this.attractionService = attractionService;
	}

	@Override
	public List<MyRoute> selectMyRouteList(int userNo) throws Exception {
		return routeMapper.selectMyRouteList(userNo);
	}

	@Override
	public MyRoute getMyRoute(int myRouteNo) throws Exception {
		MyRoute result = routeMapper.getMyRoute(myRouteNo);
		System.out.println(result);
		List<AttractionInfo> list = new ArrayList<>();
		for(int i=0; i < result.getOrders().size(); i++) 
			list.add(attractionService.getAttraction(result.getOrders().get(i).getAttractionId()));
		
		result.setOrderInfo(list);
		
		return result;
	}

	@Override
	public boolean updateRoute(MyRoute myRoute) throws Exception {
		int cnt = routeMapper.updateMyRoute(myRoute);
		if(cnt == 0) return false;
		
		//이전 경로 설정 삭제
		routeMapper.deleteOrders(myRoute.getMyRouteNo());
		
		//새로운 경로 추가
		routeMapper.insertOrders(myRoute);
		
		return true;
	}

	@Override
	public boolean deleteRoute(int myRouteNo) throws Exception {
		int cnt = routeMapper.deleteRoute(myRouteNo);
		if(cnt == 0) return false;
		routeMapper.deleteOrders(myRouteNo);
		return true;
	}

}
