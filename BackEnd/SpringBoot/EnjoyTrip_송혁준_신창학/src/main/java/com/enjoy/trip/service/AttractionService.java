package com.enjoy.trip.service;

import java.util.List;
import java.util.Map;

import com.enjoy.trip.dto.AttractionInfo;
import com.enjoy.trip.dto.Gugun;
import com.enjoy.trip.dto.Sido;

public interface AttractionService {

	List<AttractionInfo> selectAttractionList(Map<String, Object> param) throws Exception;

	AttractionInfo getAttraction(int contentId) throws Exception;

	List<Sido> selectSidoList() throws Exception;

	List<Gugun> selectGugun(int sidoCode) throws Exception;

}
