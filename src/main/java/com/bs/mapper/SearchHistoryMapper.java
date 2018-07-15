package com.bs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bs.vo.SearchHistoryVO;

@Mapper
public interface SearchHistoryMapper {

	public SearchHistoryVO getSearchHistory(int userId);

	public String now();
}
