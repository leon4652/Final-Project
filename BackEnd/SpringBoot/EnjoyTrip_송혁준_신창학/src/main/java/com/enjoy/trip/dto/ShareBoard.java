package com.enjoy.trip.dto;

public class ShareBoard {
	private int shareBoardNo;
	private int shareBoardHit;
	private String shareBoardTitle;
	private String shareBoardContent;
	private int shareBoardLike;
	private int userNo;
	private int commentCount;
	private String registDate;
	private String updateDate;
	private String removeDate;
	private String userName;
	
	public int getShareBoardNo() {
		return shareBoardNo;
	}
	public void setShareBoardNo(int shareBoardNo) {
		this.shareBoardNo = shareBoardNo;
	}
	public int getShareBoardHit() {
		return shareBoardHit;
	}
	public void setShareBoardHit(int shareBoardHit) {
		this.shareBoardHit = shareBoardHit;
	}
	public String getShareBoardTitle() {
		return shareBoardTitle;
	}
	public void setShareBoardTitle(String shareBoardTitle) {
		this.shareBoardTitle = shareBoardTitle;
	}
	public String getShareBoardContent() {
		return shareBoardContent;
	}
	public void setShareBoardContent(String shareBoardContent) {
		this.shareBoardContent = shareBoardContent;
	}
	public int getShareBoardLike() {
		return shareBoardLike;
	}
	public void setShareBoardLike(int shareBoardLike) {
		this.shareBoardLike = shareBoardLike;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
