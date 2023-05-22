package com.enjoy.trip.service;

import java.util.List;

import com.enjoy.trip.dto.StoryBoard;

public interface StoryBoardService {

	List<StoryBoard> selectStoryBoard() throws Exception;

	StoryBoard getStoryBoard(int storyBoardNo) throws Exception;

	boolean deleteStoryBoard(int storyBoardNo) throws Exception;

	void updateStoryBoard(StoryBoard storyBoard) throws Exception;

	void writeStoryBoard(StoryBoard storyBoard) throws Exception;

}
