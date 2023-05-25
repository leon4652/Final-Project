package com.enjoy.trip.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.enjoy.trip.dto.StoryBoard;

@Mapper
public interface StoryBoardMapper {

	List<StoryBoard> selectStoryBoard() throws SQLException;

	void hitsRateUp(int storyBoardNo) throws SQLException;

	StoryBoard getStoryBoard(int storyBoardNo) throws SQLException;

	void deleteStoryBoard(int storyBoardNo) throws SQLException;

	void updateStoryBoard(StoryBoard storyBoard) throws SQLException;

	void writeStoryBoard(StoryBoard storyBoard) throws SQLException;

	List<StoryBoard> subSelectStoryBoard() throws SQLException;

}
