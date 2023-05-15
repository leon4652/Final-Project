package com.enjoy.trip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enjoy.trip.dto.ShareBoard;
import com.enjoy.trip.dto.ShareAttraction;
import com.enjoy.trip.dto.User;
import com.enjoy.trip.mapper.ShareBoardMapper;

@Service
public class ShareBoardServiceImpl implements ShareBoardService {
	private ShareBoardMapper boardMapper;	
	public ShareBoardServiceImpl(ShareBoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	@Override
	public List<ShareBoard> selectBoard() throws Exception {
		return boardMapper.selectBoard();
	}
	
	@Override
	public void deleteBoard(int shareBoardNo) throws Exception {
		boardMapper.deleteBoard(shareBoardNo);
	}

	@Override
	public void updateBoard(ShareBoard update) throws Exception {
		boardMapper.updateBoard(update);
	}

	@Override
	public void writeBoard(ShareBoard write) throws Exception {
		boardMapper.writeBoard(write);
	}

	@Override
	public ShareBoard getBoard(int shareBoardNo) throws Exception {
		boardMapper.hitsRateUp(shareBoardNo);
		return boardMapper.getBoard(shareBoardNo);
	}

	@Override
	public List<ShareAttraction> getShareAttraction(int userNo) throws Exception {
		return boardMapper.getShareAttraction(userNo);
	}





}
