package com.db.trade.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.db.trade.data.CounterParty;


@SpringBootTest
class CounterPartyServiceTest {
	@Autowired
	CounterPartyService counterPartyService;

	@Test
	void saveCounterPartyTest() {
		List<CounterParty> cpList=new ArrayList<CounterParty>();
		for(int i=1;i<=3;i++) {
		CounterParty counterParty=new CounterParty("CP-"+i);
		cpList.add(counterParty);
		}
		
		counterPartyService.saveCounterParties(cpList);
		List<CounterParty>  resultList=counterPartyService.getAllCounterPartys();
		System.err.println(resultList);
		assertEquals(3, resultList.size());
		
	}

}
