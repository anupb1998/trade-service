package com.db.trade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.trade.dto.model.CounterPartyDto;
import com.db.trade.mapper.CounterPartyMapper;
import com.db.trade.service.intf.CounterPartyIntf;

@RestController
public class CounterPartyController {
	@Autowired
	CounterPartyIntf counterPartyService;
	
	@GetMapping("/v1/party")
	public List<CounterPartyDto> getAll() {	
		return CounterPartyMapper.INSTANCE.toCounterPartyDtos(counterPartyService.getAllCounterPartys());
	}

}
