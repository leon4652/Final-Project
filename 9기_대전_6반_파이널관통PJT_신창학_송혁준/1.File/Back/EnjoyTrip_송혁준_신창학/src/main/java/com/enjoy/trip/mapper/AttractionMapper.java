package com.enjoy.trip.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.ResponseEntity;

import com.enjoy.trip.dto.AttractionInfo;
import com.enjoy.trip.dto.Gugun;
import com.enjoy.trip.dto.Sido;

@Mapper
public interface AttractionMapper {

	List<AttractionInfo> selectAttractionList(Map<String, Object> param) throws SQLException;

	AttractionInfo getAttraction(int contentId) throws SQLException;

	List<Sido> selectSidoList() throws SQLException;

	List<Gugun> selectGugun(int sidoCode) throws SQLException;

	Gugun searchGugun(String regionName, int sidoCode) throws SQLException;

	List<AttractionInfo> searchAtt(int contentTypeId, int sidoCode, int gugunCode) throws Exception; 

	AttractionInfo searchAttUsingMarker(double lat, double lan) throws Exception;

	int[] getSidoCodeUsingKeyWord(String keyWord) throws Exception;

}
