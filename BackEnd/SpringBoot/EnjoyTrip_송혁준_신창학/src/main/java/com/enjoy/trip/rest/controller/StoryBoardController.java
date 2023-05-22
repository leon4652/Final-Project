package com.enjoy.trip.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enjoy.trip.dto.StoryBoard;
import com.enjoy.trip.service.StoryBoardService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/storyboard")
public class StoryBoardController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private StoryBoardService storyBoardService;
	public StoryBoardController(StoryBoardService storyBoardService) {
		this.storyBoardService = storyBoardService;
	}
	

	@GetMapping("/list")
	public List<StoryBoard> select() throws Exception {
		return storyBoardService.selectStoryBoard();
	}
	

	@GetMapping("/info/{storyBoardNo}")
	public StoryBoard getBoard(@PathVariable int storyBoardNo) throws Exception {
		return storyBoardService.getStoryBoard(storyBoardNo);
	}
	
	@PostMapping("/write")
	public void write(@RequestBody StoryBoard storyBoard) throws Exception {
		storyBoardService.writeStoryBoard(storyBoard);
	}
	

	@DeleteMapping("/delete/{storyBoardNo}")
	public ResponseEntity<?> delete(@PathVariable int storyBoardNo) throws Exception {
		storyBoardService.deleteStoryBoard(storyBoardNo);
		
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (storyBoardService.deleteStoryBoard(storyBoardNo)) resultMap.put("message", SUCCESS);
		else resultMap.put("message", FAIL);
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@PutMapping("/update/{storyBoardNo}")
	public void modify(@PathVariable int storyBoardNo, @RequestBody StoryBoard storyBoard) throws Exception {
		storyBoard.setStoryBoardNo(storyBoardNo);
		storyBoardService.updateStoryBoard(storyBoard);
	}
	
}
