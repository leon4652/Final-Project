package com.enjoy.trip.dto;

import java.util.List;

public class MyRoute {
	private int myRouteNo;
	private int userNo;
	private String writerName;
	private String title;
	private int scrapCnt;
	private List<RouteOrders> orders;
	private List<AttractionInfo> orderInfo;
	
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public List<RouteOrders> getOrders() {
		return orders;
	}
	public void setOrders(List<RouteOrders> orders) {
		this.orders = orders;
	}
	public List<AttractionInfo> getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(List<AttractionInfo> orderInfo) {
		this.orderInfo = orderInfo;
	}
	public int getMyRouteNo() {
		return myRouteNo;
	}
	public void setMyRouteNo(int myRouteNo) {
		this.myRouteNo = myRouteNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getScrapCnt() {
		return scrapCnt;
	}
	public void setScrapCnt(int scrapCnt) {
		this.scrapCnt = scrapCnt;
	}
}
