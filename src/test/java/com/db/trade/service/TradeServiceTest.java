package com.db.trade.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.db.trade.data.entity.CounterParty;
import com.db.trade.data.entity.Trade;
import com.db.trade.data.entity.TradeBook;
import com.db.trade.exception.StaleTradeException;
import com.db.trade.exception.TradeExpiredException;
import com.db.trade.service.intf.CounterPartyIntf;
import com.db.trade.service.intf.TradeBookIntf;
import com.db.trade.service.intf.TradeIntf;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TradeServiceTest {
	@Autowired
	CounterPartyIntf counterPartyService;
	@Autowired
	TradeBookIntf tradeBookService;
	@Autowired
	TradeIntf tradeService;
	
	@BeforeAll
	public void setUp(){
		List<TradeBook> tradeBook=new ArrayList<>();
		for(int i=1;i<=3;i++) {
			TradeBook trdBk=new TradeBook("B"+i);
			tradeBook.add(trdBk);
		}		
		tradeBookService.saveTradeBooks(tradeBook);
		
		List<CounterParty> cpList=new ArrayList<CounterParty>();
		for(int i=1;i<=3;i++) {
		CounterParty counterParty=new CounterParty("CP-"+i);
		cpList.add(counterParty);
		}		
		counterPartyService.saveCounterParties(cpList);
	}

	@Test
	void saveTadeTest() throws TradeExpiredException {
		List<CounterParty>  resultList=counterPartyService.getAllCounterPartys();
		List<TradeBook> tradeBookDb=tradeBookService.getAllTradeBooks();
		Trade trade=new Trade(resultList.get(0),tradeBookDb.get(0));
		Calendar c = Calendar.getInstance();
		c.set(2022, 11, 1);
		trade.setMaturityDate(c.getTime());
		tradeService.saveTrade(trade);
		assertEquals(c.getTime(), trade.getMaturityDate());
	}
	
	@Test
	void maturityDateExpiredTest() {
		List<CounterParty>  resultList=counterPartyService.getAllCounterPartys();
		List<TradeBook> tradeBookDb=tradeBookService.getAllTradeBooks();
		Trade trade=new Trade(resultList.get(0),tradeBookDb.get(0));
		Calendar c = Calendar.getInstance();
		c.set(2004, 11, 1);
		trade.setMaturityDate(c.getTime());
		assertThrows(TradeExpiredException.class,() -> {tradeService.saveTrade(trade);});
	}
	@Test
	void updateTradeTest() throws StaleTradeException {
		Trade trade=tradeService.getAllTrades().get(0);
		Calendar c = Calendar.getInstance();
		c.set(2022, 11, 1);
		trade.setMaturityDate(c.getTime());
		tradeService.updateTrade(trade);
		assertEquals(c.getTime(),trade.getMaturityDate());
	}
	@Test
	void updateStaleTradeTest() throws StaleTradeException {
		Trade trade=tradeService.getAllTrades().get(0);
		Trade tradeSecond=tradeService.getAllTrades().get(0);
		Calendar c = Calendar.getInstance();
		c.set(2022, 12, 1);
		trade.setMaturityDate(c.getTime());
		tradeService.updateTrade(trade);
		
		c.set(2022, 12, 1);
		tradeSecond.setMaturityDate(c.getTime());
		assertThrows(StaleTradeException.class,() -> {tradeService.updateTrade(trade);});
	}
	
	@Test
	void findTradeByIdTest() {
		Trade trade=tradeService.getAllTrades().get(0);
		Optional<Trade> tradeDb=tradeService.getTrade(trade.getTradeId());
		assertEquals(trade.getTradeId(), tradeDb.get().getTradeId());
	}

}
