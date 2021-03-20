package com.db.trade.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.db.trade.data.Trade;
import com.db.trade.exception.StaleTradeException;
import com.db.trade.exception.TradeExpiredException;
import com.db.trade.repository.TradeRepository;
import com.db.trade.service.intf.TradeIntf;
import com.db.trade.service.intf.TradeValidationIntf;

@Service
public class TradeService implements TradeIntf {
	@Autowired
	TradeRepository repository;
	@Autowired
	TradeValidationIntf tradeValidator;
	
	public Trade saveTrade(Trade trade) throws TradeExpiredException {
		tradeValidator.validate(trade);
		return repository.save(trade);
	}
	
	public Optional<Trade> getTrade(Long id) {
		return repository.findById(id);
	}
	
	public List<Trade> getAllTrades(){
		List<Trade> result = new ArrayList<>();
		repository.findAll().forEach(result::add);
		return result;
	}
	public Trade updateTrade(Trade trade) throws StaleTradeException {
		try {
			return repository.saveAndFlush(trade);
		}catch (ObjectOptimisticLockingFailureException olex) {
			throw new StaleTradeException("Trade update by some other transaction.");
		}
	}
	

}
