package com.db.trade.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.db.trade.data.CounterParty;
import com.db.trade.data.Trade;
import com.db.trade.data.TradeBook;
import com.db.trade.exception.TradeExpiredException;
import com.db.trade.service.intf.TradeValidationIntf;
@SpringBootTest
@ActiveProfiles("test")
class TradeValidationServiceTest {
	@Autowired
	TradeValidationIntf tradeValService;
	@Test
	void tradeValidTest() throws TradeExpiredException {
		CounterParty counterParty=new CounterParty("CP-1");
		TradeBook book=new TradeBook("B-1");
		Trade trade =new Trade(counterParty,book);
		Calendar c = Calendar.getInstance();
		c.set(2022, 11, 1);
		trade.setMaturityDate(c.getTime());
		boolean isValid=tradeValService.validate(trade);
		assertEquals(true, isValid);
	}


	@Test
	void maturityDateExpiredTest() {
		CounterParty counterParty=new CounterParty("CP-1");
		TradeBook book=new TradeBook("B-1");
		Trade trade =new Trade(counterParty,book);
		Calendar c = Calendar.getInstance();
		c.set(2020, 11, 1);
		trade.setMaturityDate(c.getTime());
		assertThrows(TradeExpiredException.class,() -> {tradeValService.validate(trade);});
	}

}
