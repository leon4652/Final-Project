package com.enjoy.trip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enjoy.trip.dto.MyPlan;
import com.enjoy.trip.mapper.MyPlanMapper;

@Service
public class MyPlanServiceImpl implements MyPlanService {
	private MyPlanMapper myPlanMapper;

	public MyPlanServiceImpl(MyPlanMapper myPlanMapper) {
		this.myPlanMapper = myPlanMapper;
	}

	@Override
	public void saveMyPlan(MyPlan myPlan) throws Exception {
		myPlanMapper.saveMyPlan(myPlan);
	}

	@Override
	public int getMaxPlanNo() throws Exception {
		return myPlanMapper.getMaxPlanNo();
	}

	@Override
	public void saveMyPlanOrder(List<MyPlan> mp) throws Exception {
		myPlanMapper.saveMyPlanOrder(mp);	
	}

	@Override
	public List<MyPlan> getThisLocationReviews(int sidoCode, int gugunCode) throws Exception {
		return myPlanMapper.getThisLocationReviews(sidoCode, gugunCode);
	}

	@Override
	public List<MyPlan> getMyPlanOrder(int myPlanNo) throws Exception {
		return myPlanMapper.getMyPlanOrder(myPlanNo);
	}
}
