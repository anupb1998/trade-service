package com.db.trade.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.db.trade.data.TradeBook;
import com.db.trade.model.TradeBookDto;

class TradeBookMapperTest {

	@Test
	void test() {
		TradeBook book=new TradeBook("B-1");
		TradeBookDto dto= TradeBookMapper.INSTANCE.toBookDto(book);
	    assertEquals(book.getBookName(), dto.getBookName());
	}
	@Test
	void testList() {
		List<TradeBook> tradeBook=new ArrayList<>();
		for(int i=1;i<=3;i++) {
			TradeBook trdBk=new TradeBook("B"+i);
			tradeBook.add(trdBk);
		}
		List<TradeBookDto> mappedList=TradeBookMapper.INSTANCE.toBookDtos(tradeBook);
		assertEquals(tradeBook.size(), mappedList.size());
	}

}
