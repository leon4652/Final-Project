package com.enjoy.trip.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.enjoy.trip.dto.MyPlan;

@Mapper
public interface MyPlanMapper {
	void saveMyPlanOrder(List<MyPlan> mp) throws Exception;

	void saveMyPlan(MyPlan myPlan) throws Exception;

	int getMaxPlanNo() throws Exception;
	
	List<MyPlan> getThisLocationReviews(int sidoCode, int gugunCode) throws Exception;
	
	List<MyPlan> getMyPlanOrder(int myPlanNo) throws Exception;
}
