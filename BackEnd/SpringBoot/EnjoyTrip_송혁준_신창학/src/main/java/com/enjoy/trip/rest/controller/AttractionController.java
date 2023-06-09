package com.enjoy.trip.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enjoy.trip.dto.AttractionInfo;
import com.enjoy.trip.dto.Gugun;
import com.enjoy.trip.dto.Sido;
import com.enjoy.trip.paging.Page;
import com.enjoy.trip.service.AttractionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/attraction")
public class AttractionController {
	private final AttractionService attractionService;

	public AttractionController(AttractionService attractionService) {
		this.attractionService = attractionService;
	}

	// 관광지 정보 보기
	@GetMapping("list")
	public List<AttractionInfo> selectAttractionList(@RequestParam("sido") int sidoCode,
			@RequestParam("pageNo") int pageNo) throws Exception {
		Page page = new Page();
		page.setPageNo(pageNo);

		Map<String, Object> param = new HashMap<>();
		param.put("sido", sidoCode);
		param.put("page", page);

		return attractionService.selectAttractionList(param);
	}

	// 관광지 상세 정보 보기
	@GetMapping("view/{contentId}")
	public AttractionInfo selectView(@PathVariable("contentId") int contentId) throws Exception {
		return attractionService.getAttraction(contentId);
	}

	// 시도 정보 가져오기
	@GetMapping("sido")
	public List<Sido> selectSido() throws Exception {
		return attractionService.selectSidoList();
	}

	//해당 시도의 구군 리스트 가져오기
	@GetMapping("gugun/{sidoCode}")
	public List<Gugun> selectGugun(@PathVariable("sidoCode") int sidoCode) throws Exception {
		return attractionService.selectGugun(sidoCode);
	}

	// 시도코드 / 지역이름으로 탐색
	@GetMapping("search/name/{regionName}/{sidoCode}")
	public Gugun getRegion(@PathVariable("regionName") String regionName, @PathVariable("sidoCode") int sidoCode)
			throws Exception {
		return attractionService.searchGugun(regionName, sidoCode);
	}

	// 관광지 상세 정보 보기
	@GetMapping("view/{contentTypeId}/{sidoCode}/{gugunCode}")
	public List<AttractionInfo> getAttractionInfo(@PathVariable("contentTypeId") int contentId,
			@PathVariable("sidoCode") int sidoCode, @PathVariable("gugunCode") int gugunCode) throws Exception {
		return attractionService.searchAtt(contentId, sidoCode, gugunCode);
	}
	
	// (마커)좌표로 해당 위지 확인하기
	@GetMapping("search/{lat}/{lan}")
	public AttractionInfo getAttractionInfoUsingMarker(@PathVariable("lat") double lat, @PathVariable("lan") double lan) throws Exception {
		return attractionService.searchAttUsingMarker(lat, lan);
	}
	
	//키워드 이름으로 지역 찾아서 시도코드 반환하기
	@GetMapping("search/keyword/{keyWord}")
	public int[] getSidoCodeUsingKeyWord(@PathVariable("keyWord") String keyWord) throws Exception {
		return attractionService.getSidoCodeUsingKeyWord(keyWord);
	}
	
}
