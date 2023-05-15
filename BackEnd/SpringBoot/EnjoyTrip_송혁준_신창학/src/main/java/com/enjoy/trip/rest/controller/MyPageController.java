package com.enjoy.trip.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enjoy.trip.dto.User;
import com.enjoy.trip.service.MyPageService;

@RestController
@RequestMapping("/mypage")
public class MyPageController {
	private final MyPageService myPageService;
	
	public MyPageController(MyPageService myPageService) {
		this.myPageService = myPageService;
	}
	
	@GetMapping("{userNo}")
	public User getUser(@PathVariable("userNo") int userNo) throws Exception {
		return myPageService.getUser(userNo);
	}
	
	@PutMapping("{userNo}")
	public int updateUser(@RequestBody User param, @PathVariable("userNo") int userNo) throws Exception {
		param.setUserNo(userNo);
		return myPageService.updateUser(param);
	}
}
