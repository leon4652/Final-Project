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

	public void saveMyPlan(List<MyPlan> mp) throws Exception {
		//myPlanMapper.saveMyPlan(mp);
	}

	@Override
	public void saveMyPlan(MyPlan myPlan) throws Exception {
		myPlanMapper.saveMyPlan(myPlan);
	}
}
