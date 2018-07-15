package com.bs.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.bs.common.ENUM.RestEnum;
import com.bs.common.Utils.BSUtils;
import com.bs.vo.ProcRtnVO;

@Service
public class SearchHistorySvcImpl implements SearchHistorySvc {

	@Override
	//public ProcRtnVO getSearchBookList(Map<String, Object> reqMap) {
	public String getSearchBookList(Map<String, Object> reqMap) {
		RestEnum addr = RestEnum.SEARCH_BOOK_PATH;
		
		String result = BSUtils.apiCallByGet(addr.getValue(), reqMap);
		return result;
	}

}
