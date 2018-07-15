package com.bs.common.ENUM;

public enum RestEnum {
	CLIENT_SECRET("KakaoAK 68d05303102f89f45adeafa8c3805d57"), SEARCH_BOOK_PATH("/v2/search/book?"), HOST("https://dapi.kakao.com");
	
	
    final private String value;
    
    RestEnum(String value) {
    	this.value= value;
    }
    public String getValue() { 
    	return value; 
    }
}
