package com.bs.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ProcRtnVO implements Serializable{
	private static final long serialVersionUID = 2232888639352128486L;
	
	private String rtnCd;
	private String rtnMsg;
	private Map<String, Object> rtnMap;
	
	public String getRtnCd() {
		return rtnCd;
	}
	public void setRtnCd(String rtnCd) {
		this.rtnCd = rtnCd;
	}
	public String getRtnMsg() {
		return rtnMsg;
	}
	public void setRtnMsg(String rtnMsg) {
		this.rtnMsg = rtnMsg;
	}
	public Map<String, Object> getRtnMap() {
		return rtnMap;
	}
	public void setRtnMap(Map<String, Object> rtnMap) {
		this.rtnMap = rtnMap;
	}
	
	public static class Builder{
		private final ProcRtnVO procRtnVO = new ProcRtnVO();
		
		public String getRtnCd() {
			return this.procRtnVO.rtnCd;
		}
		public Builder setRtnCd(String rtnCd) {
			this.procRtnVO.rtnCd = rtnCd;
			return this;
		}
		public String getRtnMsg() {
			return this.procRtnVO.rtnMsg;
		}
		public Builder setRtnMsg(String rtnMsg) {
			this.procRtnVO.rtnMsg = rtnMsg;
			return this;
		}
		
		public Map<String, Object> getRtnMap() {
			return this.procRtnVO.rtnMap;
		}
		
		public Builder setRtnMap(Map<String, Object> rtnMap) {
			this.procRtnVO.rtnMap = rtnMap;
			return this;
		}
		
		public Builder addMap(String key, Object value) {
			if(null == this.procRtnVO.rtnMap) {
				this.procRtnVO.rtnMap = new HashMap<String, Object>();
			}
			this.procRtnVO.rtnMap.put(key, value);
			return this;
		}
		
		public ProcRtnVO build() {
			return this.procRtnVO;
		}
	}
}
