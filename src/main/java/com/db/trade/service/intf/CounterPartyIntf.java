package com.db.trade.service.intf;

import java.util.List;

import com.db.trade.data.entity.CounterParty;

public interface CounterPartyIntf {
	public List<CounterParty> getAllCounterPartys();
	public void saveCounterParties(List<CounterParty> counterPartyLst);

}
