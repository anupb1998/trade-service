package com.db.trade.service.intf;

import java.util.List;
import java.util.Optional;

import com.db.trade.data.Trade;
import com.db.trade.exception.StaleTradeException;
import com.db.trade.exception.TradeExpiredException;

public interface TradeIntf {
	public Trade saveTrade(Trade trade) throws TradeExpiredException;
	public Optional<Trade> getTrade(Long id);
	public List<Trade> getAllTrades();
	public Trade updateTrade(Trade trade) throws StaleTradeException;

}
