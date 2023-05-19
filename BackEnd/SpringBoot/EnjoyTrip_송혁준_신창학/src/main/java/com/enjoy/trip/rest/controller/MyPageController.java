package com.enjoy.trip.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enjoy.trip.dto.User;
import com.enjoy.trip.service.JWTService;
import com.enjoy.trip.service.MyPageService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/mypage")
public class MyPageController {
	private final MyPageService myPageService;
	private final JWTService jwtService;
	
	public MyPageController(MyPageService myPageService, JWTService jwtService) {
		this.myPageService = myPageService;
		this.jwtService = jwtService;
	}
	
	@GetMapping("/")
	public User getUser(HttpServletRequest request) throws Exception {
		// request에 있는 token에서 userId 추출하기
		return jwtService.getUserInfo(request);
	}
	
	@PutMapping("{userNo}")
	public int updateUser(@RequestBody User param, @PathVariable("userNo") int userNo) throws Exception {
		System.out.println(param.toString());
		System.out.println(userNo);
		param.setUserNo(userNo);
		return myPageService.updateUser(param);
	}
}
