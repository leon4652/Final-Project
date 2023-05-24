package com.enjoy.trip.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
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
		
		//myPlan 객체로 왔다. 이걸 파싱해서 하나는 myPlan으로, 하나는 myPlanOrder로 보내야 함
		/*
		 myPlan : myplanno(자동), userid, userno, triptitle, myplanlike, myplanhit 
		 myplanOrder : myplanno(받아와야 함), title, addr, first_image, expecttime
		 */
		
		
		//myPlan 타입 저장
		myPlanService.saveMyPlan(mp.get(0));
		//현재 최대 myPlan값 가져오기
		//order 저장 (myPlan값)
//		myPlanService.saveMyPlanOrder(mp);
	}
}
