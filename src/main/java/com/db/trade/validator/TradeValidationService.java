package com.db.trade.validator;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.db.trade.data.Trade;
import com.db.trade.exception.TradeExpiredException;
import com.db.trade.service.intf.TradeValidationIntf;

@Service
public class TradeValidationService implements TradeValidationIntf{
	/**
	 * Validated the Trade for maturity date
	 * In future can create Chain of Responsibility if more validations are there.
	 * @param trade
	 * @throws TradeExpiredException
	 */
	public boolean validate(Trade trade) throws TradeExpiredException {
		if(trade.getMaturityDate().before(new Date())) {
			throw new TradeExpiredException("Maturity date is in past");
		}
		return true;
	}
}
