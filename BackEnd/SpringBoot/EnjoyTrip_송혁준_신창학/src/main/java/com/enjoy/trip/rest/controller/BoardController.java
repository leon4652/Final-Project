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
import com.enjoy.trip.service.BoardService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/board")
public class BoardController {
	private BoardService boardService;
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	

	@GetMapping("/list")
	public List<ShareBoard> select() throws Exception {
		return boardService.selectBoard();
	}
	

	@GetMapping("/info/{boardNo}")
	public ShareBoard getBoard(@PathVariable int boardNo) throws Exception {
		return boardService.getBoard(boardNo);
	}
	
	@PostMapping("/write")
	public void write(@RequestBody ShareBoard param) throws Exception {
		boardService.writeBoard(param);
	}
	

	@GetMapping("/delete/{boardNo}")
	public void delete(@PathVariable int boardNo) throws Exception {
		boardService.deleteBoard(boardNo);
	}

	@PutMapping("/update/{boardNo}")
	public void modify(@PathVariable int boardNo, @RequestBody ShareBoard param) throws Exception {
		param.setNo(boardNo); //번호 찾아서 객체에 저장
		boardService.updateBoard(param);
	}
	
	@GetMapping("/getattraction/{userNo}")
	public List<ShareAttraction> getAttraction(@PathVariable int userNo) throws Exception {
		return boardService.getShareAttraction(userNo);
	}

	
}
