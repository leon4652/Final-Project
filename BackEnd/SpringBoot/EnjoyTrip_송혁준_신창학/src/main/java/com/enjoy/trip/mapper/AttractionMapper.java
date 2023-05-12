package com.enjoy.trip.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.enjoy.trip.dto.AttractionInfo;

@Mapper
public interface AttractionMapper {

	List<AttractionInfo> selectAttractionList(Map<String, Object> param) throws SQLException;

	AttractionInfo getAttraction(int contentId) throws SQLException;

}
