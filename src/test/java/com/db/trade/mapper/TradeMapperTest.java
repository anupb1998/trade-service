package com.db.trade.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.db.trade.data.CounterParty;
import com.db.trade.data.Trade;
import com.db.trade.data.TradeBook;
import com.db.trade.model.TradeDto;

class TradeMapperTest {

	@Test
	void test() {
		CounterParty counterParty=new CounterParty("CP-1");
		TradeBook book=new TradeBook("B-1");
		Trade trade =new Trade(counterParty,book);
		TradeDto dto= TradeMapper.INSTANCE.toTradeDto(trade);
		assertEquals(trade.getCounterParty().getCounterPratyName(), dto.getCounterParty().getCounterPratyName());
	}
	
	@Test
	void testList() {
		CounterParty counterParty=new CounterParty("CP-1");
		TradeBook book=new TradeBook("B-1");
		Trade trade =new Trade(counterParty,book);
		Trade tradeSecond =new Trade(counterParty,book);
		List<Trade> tradeList=new ArrayList<>();
		tradeList.add(trade);
		tradeList.add(tradeSecond);
		List<Trade> dto= TradeMapper.INSTANCE.toTradeDtos(tradeList);
		assertEquals(tradeList.size(), dto.size());
	}

}
