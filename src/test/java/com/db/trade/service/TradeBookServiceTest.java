package com.db.trade.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.db.trade.data.TradeBook;
import com.db.trade.service.intf.TradeBookIntf;
@SpringBootTest
@ActiveProfiles("test")
class TradeBookServiceTest {
	@Autowired
	TradeBookIntf tradeBookService;
	

	@Test
	void saveTradeBookTest() {
		List<TradeBook> tradeBookDb=tradeBookService.getAllTradeBooks();
		assertEquals(3, tradeBookDb.size());
	}

}
