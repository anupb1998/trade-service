package com.db.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.trade.data.Trade;
import com.db.trade.exception.StaleTradeException;
import com.db.trade.exception.TradeExpiredException;
import com.db.trade.mapper.TradeMapper;
import com.db.trade.model.TradeDto;
import com.db.trade.service.TradeService;

@RestController
public class TradeConroller {
	@Autowired
	TradeService tradeService;
	
	@GetMapping("/api/trade/{id}")
	public TradeDto getById(@PathVariable("id") Long id) {	
		return TradeMapper.INSTANCE.toTradeDto(tradeService.getTrade(id).get());
	}
	@PostMapping("/api/trade")
	public TradeDto insertTrade(@RequestBody Trade trade) throws TradeExpiredException {
		return TradeMapper.INSTANCE.toTradeDto(tradeService.saveTrade(trade));
	}
	@PutMapping("/api/trade/update")
	public TradeDto updateTrade(@RequestBody Trade trade) throws StaleTradeException {
		return TradeMapper.INSTANCE.toTradeDto(tradeService.updateTrade(trade));
	}

}
