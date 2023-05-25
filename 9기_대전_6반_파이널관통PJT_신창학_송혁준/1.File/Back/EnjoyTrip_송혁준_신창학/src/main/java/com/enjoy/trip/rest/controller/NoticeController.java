package com.enjoy.trip.rest.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enjoy.trip.dto.Notice;
import com.enjoy.trip.service.NoticeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/notice")
public class NoticeController {
	private NoticeService noticeService;
	public NoticeController(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@GetMapping("/list")
	public List<Notice> select() throws Exception {
		return noticeService.selectNotice();
	}
	
	@GetMapping("/sublist")
	public List<Notice> subSelect() throws Exception {
		return noticeService.subSelectNotice();
	}

	@PostMapping("/write")
	public void writeNotice(@RequestBody Notice param) throws Exception {
		noticeService.writeNotice(param);
	}
	
	@DeleteMapping("/delete/{noticeNo}")
	public void deleteNotice(@PathVariable int noticeNo) throws Exception {
		noticeService.deleteNotice(noticeNo);
	}

	@PutMapping("/update/{noticeNo}")
	public void updateNotice(@PathVariable int noticeNo, @RequestBody Notice param) throws Exception {
		param.setNoticeNo(noticeNo);
		noticeService.updateNotice(param);
	}
	
	@GetMapping("/info/{noticeNo}")
	public Notice getNotice(@PathVariable int noticeNo) throws Exception {
		return noticeService.getNotice(noticeNo);
	}
	
	
	
}
