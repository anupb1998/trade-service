package com.db.trade.dto.model;

import java.io.Serializable;

public class CounterPartyDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long counterPratyId; 
    private String counterPratyName;
    public CounterPartyDto() {
    	
    }
    public CounterPartyDto(String counterPratyName) {
		this.counterPratyName = counterPratyName;
	}
	public Long getCounterPratyId() {
		return counterPratyId;
	}
	public void setCounterPratyId(Long counterPratyId) {
		this.counterPratyId = counterPratyId;
	}
	public String getCounterPratyName() {
		return counterPratyName;
	}
	public void setCounterPratyName(String counterPratyName) {
		this.counterPratyName = counterPratyName;
	}
}
