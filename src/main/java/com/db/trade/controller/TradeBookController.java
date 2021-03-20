package com.db.trade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.trade.mapper.TradeBookMapper;
import com.db.trade.model.TradeBookDto;
import com.db.trade.service.TradeBookService;

@RestController
public class TradeBookController {
	@Autowired
	TradeBookService tradeBook;
	@GetMapping("/api/tradebook")
	public List<TradeBookDto> getAll() {	
		return TradeBookMapper.INSTANCE.toBookDtos(tradeBook.getAllTradeBooks());
	}

}
