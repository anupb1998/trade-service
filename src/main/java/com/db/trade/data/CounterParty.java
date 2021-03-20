package com.db.trade.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class CounterParty {
	
	private Long counterPartyId;
	private String counterPratyName;
	public CounterParty() {
		
	}
	public CounterParty(String counterPratyName) {
		this.counterPratyName = counterPratyName;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getCounterPratyId() {
		return counterPartyId;
	}

	public void setCounterPratyId(Long counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

	public String getCounterPratyName() {
		return counterPratyName;
	}

	public void setCounterPratyName(String counterPratyName) {
		this.counterPratyName = counterPratyName;
	}
}
