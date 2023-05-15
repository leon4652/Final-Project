package com.enjoy.trip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enjoy.trip.dto.StoryBoard;
import com.enjoy.trip.mapper.StoryBoardMapper;

@Service
public class StoryBoardServiceImpl implements StoryBoardService {
	private final StoryBoardMapper storyBoardMapper;
	public StoryBoardServiceImpl(StoryBoardMapper storyBoardMapper) {
		this.storyBoardMapper = storyBoardMapper;
	}

	@Override
	public List<StoryBoard> selectStoryBoard() throws Exception {
		return storyBoardMapper.selectStoryBoard();
	}

	@Override
	public StoryBoard getStoryBoard(int storyBoardNo) throws Exception {
		storyBoardMapper.hitsRateUp(storyBoardNo);
		return storyBoardMapper.getStoryBoard(storyBoardNo);
	}

	@Override
	public void deleteStoryBoard(int storyBoardNo) throws Exception {
		storyBoardMapper.deleteStoryBoard(storyBoardNo);
	}

	@Override
	public void updateStoryBoard(StoryBoard storyBoard) throws Exception {
		storyBoardMapper.updateStoryBoard(storyBoard);
	}

	@Override
	public void writeStoryBoard(StoryBoard storyBoard) throws Exception {
		storyBoardMapper.writeStoryBoard(storyBoard);
	}
}
