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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.enjoy.trip.dto.ShareBoard;
import com.enjoy.trip.dto.ShareAttraction;
import com.enjoy.trip.dto.User;
import com.enjoy.trip.service.ShareBoardService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/shareboard")
public class ShareBoardController {
	private final ShareBoardService shareBoardService;
	public ShareBoardController(ShareBoardService shareBoardService) {
		this.shareBoardService = shareBoardService;
	}

	@GetMapping("/list")
	public List<ShareBoard> select() throws Exception {
		return shareBoardService.selectBoard();
	}
	

	@GetMapping("/info/{shareBoardNo}")
	public ShareBoard getBoard(@PathVariable int shareBoardNo) throws Exception {
		return shareBoardService.getBoard(shareBoardNo);
	}
	
	@PostMapping("/write")
	public void write(@RequestBody ShareBoard param) throws Exception {
		shareBoardService.writeBoard(param);
	}
	

	@DeleteMapping("/delete/{shareBoardNo}")
	public void delete(@PathVariable int shareBoardNo) throws Exception {
		shareBoardService.deleteBoard(shareBoardNo);
	}

	@PutMapping("/update/{shareBoardNo}")
	public void modify(@PathVariable int shareBoardNo, @RequestBody ShareBoard param) throws Exception {
		param.setShareBoardNo(shareBoardNo);
		shareBoardService.updateBoard(param);
	}
	
	@GetMapping("/getattraction/{userNo}")
	public List<ShareAttraction> getAttraction(@PathVariable int userNo) throws Exception {
		return shareBoardService.getShareAttraction(userNo);
	}

	
}
