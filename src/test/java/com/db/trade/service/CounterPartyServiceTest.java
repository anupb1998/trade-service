package com.db.trade.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.db.trade.data.entity.CounterParty;
import com.db.trade.service.intf.CounterPartyIntf;


@SpringBootTest
@ActiveProfiles("test")
class CounterPartyServiceTest {
	@Autowired
	CounterPartyIntf counterPartyService;	

	@Test
	void saveCounterPartyTest() {
		List<CounterParty>  resultList=counterPartyService.getAllCounterPartys();
		assertEquals(3, resultList.size());
		
	}

}
