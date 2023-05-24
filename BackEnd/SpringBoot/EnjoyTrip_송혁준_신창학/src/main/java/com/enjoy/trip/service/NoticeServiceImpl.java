package com.enjoy.trip.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.enjoy.trip.dto.Notice;
import com.enjoy.trip.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {
	private NoticeMapper noticeMapper;
	public NoticeServiceImpl(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}

	@Override
	public List<Notice> selectNotice() {
		return noticeMapper.selectNotice();
	}

	@Override
	public void writeNotice(Notice param) throws Exception {
		noticeMapper.writeNotice(param);
	}

	@Override
	public boolean deleteNotice(int noticeNo) throws Exception {
		boolean check = true;
		try {
			noticeMapper.deleteNotice(noticeNo);
		} catch (SQLException e) {
			check = false;
		}
		return check;

	}

	@Override
	public void updateNotice(Notice param) throws Exception {
		noticeMapper.updateNotice(param);
	}

	@Override
	public Notice getNotice(int noticeNo) throws Exception {
		return noticeMapper.getNotice(noticeNo);
	}


}
