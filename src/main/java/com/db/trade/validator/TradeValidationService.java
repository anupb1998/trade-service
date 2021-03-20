package com.db.trade.validator;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.db.trade.data.Trade;
import com.db.trade.exception.TradeExpiredException;

@Service
public class TradeValidationService {
	
	public void validate(Trade trade) throws TradeExpiredException {
		if(trade.getMaturityDate().before(new Date())) {
			throw new TradeExpiredException("Maturity date is in past");
		}
		
	}
}
