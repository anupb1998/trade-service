package com.db.trade.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.db.trade.data.entity.CounterParty;
import com.db.trade.data.entity.TradeBook;

@Component
public class DataLoader implements ApplicationRunner {
	@Autowired
	CounterPartyService counterPartyService;
	@Autowired
	TradeBookService tradeBookService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
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

}
