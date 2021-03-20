package com.db.trade.model;

import java.io.Serializable;
import java.util.Date;

public class TradeDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long tradeId;
    private int version;
    private CounterPartyDto counterParty;
    private TradeBookDto tradeBook;
    private Date maturityDate;
    private Date createdDate;
    private Date updateDate;
    private boolean isExpired;
	public Long getTradeId() {
		return tradeId;
	}
	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public CounterPartyDto getCounterParty() {
		return counterParty;
	}
	public void setCounterParty(CounterPartyDto counterParty) {
		this.counterParty = counterParty;
	}
	public TradeBookDto getTradeBook() {
		return tradeBook;
	}
	public void setTradeBook(TradeBookDto tradeBook) {
		this.tradeBook = tradeBook;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public boolean isExpired() {
		return isExpired;
	}
	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}   

}
