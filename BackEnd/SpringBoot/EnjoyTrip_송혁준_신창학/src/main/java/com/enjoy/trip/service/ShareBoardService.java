package com.enjoy.trip.service;

import java.util.List;

import com.enjoy.trip.dto.ShareBoard;
import com.enjoy.trip.dto.ShareAttraction;

public interface ShareBoardService {
	List<ShareBoard> selectBoard() throws Exception;

	void deleteBoard(int shareBoardNo) throws Exception;

	void writeBoard(ShareBoard write) throws Exception;

	ShareBoard getBoard(int shareBoardNo) throws Exception;

	void updateBoard(ShareBoard update) throws Exception;

	List<ShareAttraction> getShareAttraction(int userNo) throws Exception;
}
