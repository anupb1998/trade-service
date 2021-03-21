package com.db.trade.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.db.trade.data.entity.CounterParty;
import com.db.trade.repository.CounterPartyRepository;
import com.db.trade.service.intf.CounterPartyIntf;

@Service
public class CounterPartyService implements CounterPartyIntf {
	@Autowired
	public CounterPartyRepository counterPartyRepository;
	
	@Cacheable(value="cacheCounterParty")
	public List<CounterParty> getAllCounterPartys(){
		List<CounterParty> result = new ArrayList<>();
		counterPartyRepository.findAll().forEach(result::add);;
		return result;
	}
	
	@CacheEvict(value = "cacheCounterParty", allEntries = true)
	public void saveCounterParties(List<CounterParty> counterPartyLst) {
		counterPartyRepository.saveAll(counterPartyLst);		
	}

}
