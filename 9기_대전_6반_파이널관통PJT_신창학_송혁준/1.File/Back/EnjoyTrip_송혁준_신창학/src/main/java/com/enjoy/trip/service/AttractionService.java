package com.enjoy.trip.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.enjoy.trip.dto.AttractionInfo;
import com.enjoy.trip.dto.Gugun;
import com.enjoy.trip.dto.Sido;

public interface AttractionService {

	List<AttractionInfo> selectAttractionList(Map<String, Object> param) throws Exception;

	AttractionInfo getAttraction(int contentId) throws Exception;

	List<Sido> selectSidoList() throws Exception;

	List<Gugun> selectGugun(int sidoCode) throws Exception;

	Gugun searchGugun(String regionName, int sidoCode) throws Exception;

	List<AttractionInfo> searchAtt(int contentTypeId, int sidoCode, int gugunCode) throws Exception;

	AttractionInfo searchAttUsingMarker(double lat, double lan) throws Exception;

	int[] getSidoCodeUsingKeyWord(String keyWord) throws Exception;

}
