package com.enjoy.trip.dto;

public class StoryBoard {
	private int storyBoardNo;
	private int storyBoardHit;
	private String storyBoardTitle;
	private String storyBoardContent;
	private int storyBoardLike;
	private int userNo;
	private int commentCount;
	private String registDate;
	private String updateDate;
	private String removeDate;
	private String userName;
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getStoryBoardNo() {
		return storyBoardNo;
	}
	public void setStoryBoardNo(int storyBoardNo) {
		this.storyBoardNo = storyBoardNo;
	}
	public int getStoryBoardHit() {
		return storyBoardHit;
	}
	public void setStoryBoardHit(int storyBoardHit) {
		this.storyBoardHit = storyBoardHit;
	}
	public String getStoryBoardTitle() {
		return storyBoardTitle;
	}
	public void setStoryBoardTitle(String storyBoardTitle) {
		this.storyBoardTitle = storyBoardTitle;
	}
	public String getStoryBoardContent() {
		return storyBoardContent;
	}
	public void setStoryBoardContent(String storyBoardContent) {
		this.storyBoardContent = storyBoardContent;
	}
	public int getStoryBoardLike() {
		return storyBoardLike;
	}
	public void setStoryBoardLike(int storyBoardLike) {
		this.storyBoardLike = storyBoardLike;
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
