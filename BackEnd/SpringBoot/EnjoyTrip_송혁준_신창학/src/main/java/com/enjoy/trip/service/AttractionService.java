package com.enjoy.trip.service;

import java.util.List;
import java.util.Map;

import com.enjoy.trip.dto.AttractionInfo;

public interface AttractionService {

	List<AttractionInfo> selectAttractionList(Map<String, Object> param) throws Exception;

	AttractionInfo getAttraction(int contentId) throws Exception;

}
