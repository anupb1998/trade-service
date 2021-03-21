package com.db.trade.service.intf;

import com.db.trade.data.entity.Trade;
import com.db.trade.exception.TradeExpiredException;

public interface TradeValidationIntf {
	public boolean validate(Trade trade) throws TradeExpiredException;
}
