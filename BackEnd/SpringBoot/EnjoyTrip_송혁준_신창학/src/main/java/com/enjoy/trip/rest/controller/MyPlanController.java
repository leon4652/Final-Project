package com.enjoy.trip.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.enjoy.trip.dto.MyRoute;
import com.enjoy.trip.dto.MyPlan;
import com.enjoy.trip.service.AttractionService;
import com.enjoy.trip.service.MyPlanService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/myplan")
public class MyPlanController {
	private final MyPlanService myPlanService;

	public MyPlanController(MyPlanService myPlanService) {
		this.myPlanService = myPlanService;
	}
	@PostMapping("save")
	public void saveMyPlan(@RequestBody List<MyPlan> mp) throws Exception {
		//1. myPlan 타입 저장
		myPlanService.saveMyPlan(mp.get(0));
		//3. order 저장 (myPlan값), 현재 최대 myPlan값 가져오기
		int myPlanNo = myPlanService.getMaxPlanNo();
		for (MyPlan myPlan : mp) {
			myPlan.setMyPlanNo(myPlanNo);
		}
		myPlanService.saveMyPlanOrder(mp);
	}
	
	@GetMapping("review/{sidoCode}/{gugunCode}")
	public List<MyPlan> getThisLocationReviews(@PathVariable("sidoCode") int sidoCode, @PathVariable("gugunCode") int gugunCode) throws Exception {
		return myPlanService.getThisLocationReviews(sidoCode, gugunCode);
	}
}
