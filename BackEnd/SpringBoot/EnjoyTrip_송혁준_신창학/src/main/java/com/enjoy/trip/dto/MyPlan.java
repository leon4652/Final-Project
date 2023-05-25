package com.enjoy.trip.dto;

import java.sql.Date;
import java.util.Calendar;

public class MyPlan {
	private int myPlanNo;
	private String title;
	private String addr1;
	private String firstImage;
	private int idx;
	private double expectTime;
	private String userId;
	private int userNo;
	private String tripTitle;
	private String tripContent;
	private String sidoCode;
	private String gugunCode;
	
	
	
	public String getSidoCode() {
		return sidoCode;
	}
	public void setSidoCode(String sidoCode) {
		this.sidoCode = sidoCode;
	}
	public String getGugunCode() {
		return gugunCode;
	}
	public void setGugunCode(String gugunCode) {
		this.gugunCode = gugunCode;
	}
	public String getTripContent() {
		return tripContent;
	}
	public void setTripContent(String tripContent) {
		this.tripContent = tripContent;
	}
	
	public String getTripTitle() {
		return tripTitle;
	}
	public void setTripTitle(String tripTitle) {
		this.tripTitle = tripTitle;
	}
	public int getMyPlanNo() {
		return myPlanNo;
	}
	public void setMyPlanNo(int myPlanNo) {
		this.myPlanNo = myPlanNo;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getFirstImage() {
		return firstImage;
	}
	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}
	public double getExpectTime() {
		return expectTime;
	}
	public void setExpectTime(double expectTime) {
		this.expectTime = expectTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	
	
}
