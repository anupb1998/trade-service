package com.db.trade.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.db.trade.data.entity.CounterParty;
import com.db.trade.data.entity.Trade;
import com.db.trade.data.entity.TradeBook;
import com.db.trade.dto.model.CounterPartyDto;
import com.db.trade.dto.model.TradeBookDto;
import com.db.trade.dto.model.TradeDto;

class TradeMapperTest {

	@Test
	void tradeDtoTest() {
		CounterParty counterParty=new CounterParty("CP-1");
		TradeBook book=new TradeBook("B-1");
		Trade trade =new Trade(counterParty,book);
		TradeDto dto= TradeMapper.INSTANCE.toTradeDto(trade);
		assertEquals(trade.getCounterParty().getCounterPratyName(), dto.getCounterParty().getCounterPratyName());
	}
	@Test
	void tradeTest() {
		CounterPartyDto counterParty=new CounterPartyDto("CP-1");
		TradeBookDto book=new TradeBookDto("B-1");
		TradeDto tradeDto =new TradeDto(counterParty,book);
		Calendar c = Calendar.getInstance();
		c.set(2022, 11, 1);
		tradeDto.setMaturityDate(c.getTime());
		Trade trade= TradeMapper.INSTANCE.toTrade(tradeDto);
		assertEquals(tradeDto.getCounterParty().getCounterPratyName(), trade.getCounterParty().getCounterPratyName());
	}
	
	@Test
	void TradeDtoListTest() {
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
