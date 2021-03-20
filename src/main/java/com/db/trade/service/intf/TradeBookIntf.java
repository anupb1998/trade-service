package com.db.trade.service.intf;

import java.util.List;

import com.db.trade.data.TradeBook;

public interface TradeBookIntf {
	public List<TradeBook> getAllTradeBooks();
	public void saveTradeBooks(List<TradeBook> tradeBookLst);
}
