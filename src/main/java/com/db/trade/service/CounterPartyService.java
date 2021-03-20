package com.db.trade.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.db.trade.data.CounterParty;
import com.db.trade.repository.CounterPartyRepository;

@Service
public class CounterPartyService {
	@Autowired
	public CounterPartyRepository counterPartyRepository;
	
	@Cacheable(value="cacheCounterParty")
	public List<CounterParty> getAllCounterPartys(){
		List<CounterParty> result = new ArrayList<>();
		counterPartyRepository.findAll().forEach(result::add);;
		return result;
	}
	
	public void saveCounterParties(List<CounterParty> counterPartyLst) {
		counterPartyRepository.saveAll(counterPartyLst);		
	}

}
