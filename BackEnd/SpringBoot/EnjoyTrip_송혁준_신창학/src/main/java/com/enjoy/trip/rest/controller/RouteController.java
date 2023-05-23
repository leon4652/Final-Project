package com.enjoy.trip.rest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.enjoy.trip.dto.AttractionInfo;
import com.enjoy.trip.dto.MyRoute;
import com.enjoy.trip.service.RouteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/myroute")
public class RouteController {
	private final RouteService routeService;
	
	public RouteController(RouteService routeService) {
		this.routeService = routeService;
	}
	
	@GetMapping("{userNo}")
	public List<MyRoute> selectMyRouteList(@PathVariable("userNo") int userNo) throws Exception{
		return routeService.selectMyRouteList(userNo); 
	}
	
	@GetMapping("view/{myRouteNo}")
	public MyRoute getMyRoute(@PathVariable("myRouteNo") int myRouteNo) throws Exception {
		return routeService.getMyRoute(myRouteNo);
	}
	
	@PutMapping("{myRouteNo}")
	public boolean updateRoute(@PathVariable("myRouteNo") int myRouteNo, @RequestBody MyRoute myRoute) throws Exception {
		myRoute.setMyRouteNo(myRouteNo);
		return routeService.updateRoute(myRoute);
	}
	
	@DeleteMapping("{myRouteNo}")
	public boolean deleteRoute(@PathVariable int myRouteNo) throws Exception {
		return routeService.deleteRoute(myRouteNo);
	}
	
	@PostMapping("save")
	public MyRoute saveMyRoute(@RequestBody List<AttractionInfo> atts) throws Exception {
		System.out.println(atts.toString());
		for (AttractionInfo attractionInfo : atts) {
			System.out.println(attractionInfo.getTitle());
		}
		return null;
	}
}
