package com.db.trade.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.db.trade.data.TradeBook;
@SpringBootTest
class TradeBookServiceTest {
	@Autowired
	TradeBookService tradeBookService;

	@Test
	void saveTradeBookTest() {
		List<TradeBook> tradeBook=new ArrayList<>();
		for(int i=1;i<=3;i++) {
			TradeBook trdBk=new TradeBook("B"+i);
			tradeBook.add(trdBk);
		}
		
		tradeBookService.saveTradeBooks(tradeBook);
		List<TradeBook> tradeBookDb=tradeBookService.getAllTradeBooks();
		assertEquals(3, tradeBookDb.size());
	}

}
