package com.bs.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.mapper.SearchHistoryMapper;
import com.bs.vo.ProcRtnVO;


public interface SearchHistorySvc {
	//ProcRtnVO getSearchBookList(Map<String, Object> reqMap);
	String getSearchBookList(Map<String, Object> reqMap);
}
