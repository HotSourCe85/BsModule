package com.bs.vo;

import java.util.Date;

public class SearchHistoryVO {
	
	int searchId;
	int userId;
	String searchValue;
	Date  crtDt;
	
	public int getSearchId() {
		return searchId;
	}
	public void setSearchId(int searchId) {
		this.searchId = searchId;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	public Date getCrtDt() {
		return crtDt;
	}
	public void setCreateDate(Date crtDt) {
		this.crtDt = crtDt;
	}
}
