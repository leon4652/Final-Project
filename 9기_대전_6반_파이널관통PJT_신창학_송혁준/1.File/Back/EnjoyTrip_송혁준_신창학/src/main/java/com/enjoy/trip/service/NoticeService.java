package com.enjoy.trip.service;

import java.util.List;

import com.enjoy.trip.dto.Notice;

public interface NoticeService {

	List<Notice> selectNotice() throws Exception;

	void writeNotice(Notice param) throws Exception;

	boolean deleteNotice(int noticeNo) throws Exception;

	void updateNotice(Notice param) throws Exception;

	Notice getNotice(int noticeNo) throws Exception;

	List<Notice> subSelectNotice() throws Exception;

}
