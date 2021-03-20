package com.db.trade.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.db.trade.data.CounterParty;
import com.db.trade.model.CounterPartyDto;

class CounterPartyMapperTest {

	@Test
	void test() {
		CounterParty counterParty=new CounterParty("CP-1");
		CounterPartyDto counterPartyDto=CounterPartyMapper.INSTANCE.toCounterPartyDto(counterParty);
		assertEquals(counterParty.getCounterPratyName(), counterPartyDto.getCounterPratyName());
	}
	@Test
	void testList() {
		List<CounterParty> cpList=new ArrayList<CounterParty>();
		for(int i=1;i<=3;i++) {
		CounterParty counterParty=new CounterParty("CP-"+i);
		cpList.add(counterParty);
		}
		List<CounterPartyDto> counterPartyDto=CounterPartyMapper.INSTANCE.toCounterPartyDtos(cpList);
		assertEquals(cpList.size(), counterPartyDto.size());
	}

}
