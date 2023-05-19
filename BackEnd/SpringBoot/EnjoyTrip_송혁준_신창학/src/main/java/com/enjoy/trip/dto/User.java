package com.enjoy.trip.dto;

public class User {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private String email0;
	private String email1;
	private int sido;
	private int gugun;
	private int birthYear;
	private String birthMonth;
	private String birthDate;
	private String registDate;
	private String updateDate;
	private String removeDate;
	private int isAdmin;
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail0() {
		return email0;
	}
	public void setEmail0(String email0) {
		this.email0 = email0;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public int getSido() {
		return sido;
	}
	public void setSido(int sido) {
		this.sido = sido;
	}
	public int getGugun() {
		return gugun;
	}
	public void setGugun(int gugun) {
		this.gugun = gugun;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public String getBirthMonth() {
		return birthMonth;
	}
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getRemoveDate() {
		return removeDate;
	}
	public void setRemoveDate(String removeDate) {
		this.removeDate = removeDate;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", email0=" + email0 + ", email1=" + email1 + ", sido=" + sido + ", gugun=" + gugun + ", birthYear="
				+ birthYear + ", birthMonth=" + birthMonth + ", birthDate=" + birthDate + ", registDate=" + registDate
				+ ", updateDate=" + updateDate + ", removeDate=" + removeDate + ", isAdmin=" + isAdmin + "]";
	}
	
	
}
