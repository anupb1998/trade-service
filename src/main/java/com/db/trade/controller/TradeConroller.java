package com.db.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.trade.dto.model.TradeDto;
import com.db.trade.exception.StaleTradeException;
import com.db.trade.exception.TradeExpiredException;
import com.db.trade.mapper.TradeMapper;
import com.db.trade.service.intf.TradeIntf;

@RestController
public class TradeConroller {
	@Autowired
	TradeIntf tradeService;
	
	@GetMapping("/v1/trade/{id}")
	public TradeDto getById(@PathVariable("id") Long id) {	
		return TradeMapper.INSTANCE.toTradeDto(tradeService.getTrade(id).get());
	}
	@PostMapping("/v1/trade")
	public TradeDto insertTrade(@RequestBody TradeDto trade) throws TradeExpiredException {
		return TradeMapper.INSTANCE.toTradeDto(tradeService.saveTrade(TradeMapper.INSTANCE.toTrade(trade)));
	}
	@PutMapping("/v1/trade/update")
	public TradeDto updateTrade(@RequestBody TradeDto trade) throws StaleTradeException {
		return TradeMapper.INSTANCE.toTradeDto(tradeService.updateTrade(TradeMapper.INSTANCE.toTrade(trade)));
	}

}
