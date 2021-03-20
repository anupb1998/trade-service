package com.db.trade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.trade.mapper.CounterPartyMapper;
import com.db.trade.model.CounterPartyDto;
import com.db.trade.service.CounterPartyService;

@RestController
public class CounterPartyController {
	@Autowired
	CounterPartyService counterPartyService;
	
	@GetMapping("/api/party")
	public List<CounterPartyDto> getAll() {	
		return CounterPartyMapper.INSTANCE.toCounterPartyDtos(counterPartyService.getAllCounterPartys());
	}

}
