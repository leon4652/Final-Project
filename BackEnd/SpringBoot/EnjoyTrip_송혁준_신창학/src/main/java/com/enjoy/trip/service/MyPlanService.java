package com.enjoy.trip.service;

import java.util.List;

import com.enjoy.trip.dto.MyPlan;

public interface MyPlanService {

	void saveMyPlan(MyPlan myPlan) throws Exception;

	int getMaxPlanNo() throws Exception;

	void saveMyPlanOrder(List<MyPlan> mp) throws Exception;
	
}
