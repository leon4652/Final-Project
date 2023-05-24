package com.enjoy.trip.service;

import java.util.List;

import com.enjoy.trip.dto.MyPlan;

public interface MyPlanService {

	void saveMyPlan(List<MyPlan> mp) throws Exception;

	void saveMyPlan(MyPlan myPlan) throws Exception;
	
}
