package com.citiustech.service;

public class TradeDetails {

	private long tradeId;
	private Region region;
	private int status;
	
	public TradeDetails(int i, Region tokyo, int j) {
		// TODO Auto-generated constructor stub
	}
	public TradeDetails() {
		// TODO Auto-generated constructor stub
	}
	public long getTradeId() {
		return tradeId;
	}
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "TradeDetails [tradeId=" + tradeId + ", region=" + region
				+ ", status=" + status + "]";
	}
}
