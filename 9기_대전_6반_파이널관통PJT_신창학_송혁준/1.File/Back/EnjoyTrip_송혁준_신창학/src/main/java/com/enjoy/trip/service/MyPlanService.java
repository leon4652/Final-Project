package com.enjoy.trip.service;

import java.util.List;

import com.enjoy.trip.dto.MyPlan;

public interface MyPlanService {

	void saveMyPlan(MyPlan myPlan) throws Exception;

	int getMaxPlanNo() throws Exception;

	void saveMyPlanOrder(List<MyPlan> mp) throws Exception;
	
	List<MyPlan> getThisLocationReviews(int sidoCode, int gugunCode) throws Exception;
	
	List<MyPlan> getMyPlanOrder(int myPlanNo) throws Exception;

	void planLikeUp(int myPlanNo) throws Exception;

	void planHitUp(int myPlanNo) throws Exception;
}
