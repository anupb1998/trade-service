package com.db.trade.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.db.trade.data.entity.CounterParty;
import com.db.trade.data.entity.Trade;
import com.db.trade.data.entity.TradeBook;
import com.db.trade.dto.model.TradeDto;
import com.db.trade.mapper.TradeMapper;
import com.db.trade.service.intf.CounterPartyIntf;
import com.db.trade.service.intf.TradeBookIntf;
import com.db.trade.service.intf.TradeIntf;
import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)

class TradeConrollerTest {
	public static final String uri = "/v1/trade";
	protected MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;
	@Autowired
	ObjectMapper mapper;
	@Autowired
	CounterPartyIntf counterPartyService;
	@Autowired
	TradeBookIntf tradeBookService;
	@Autowired
	TradeIntf tradeService;
	
	@BeforeAll
	public void setUp(){
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	void addTradeTest() throws Exception {
		List<CounterParty>  resultList=counterPartyService.getAllCounterPartys();
		List<TradeBook> tradeBookDb=tradeBookService.getAllTradeBooks();
		Trade trade=new Trade(resultList.get(0),tradeBookDb.get(0));
		TradeDto tradeDto =TradeMapper.INSTANCE.toTradeDto(trade);
		Calendar c = Calendar.getInstance();
		c.set(2022, 11, 1);
		tradeDto.setMaturityDate(c.getTime());
		String body=mapper.writeValueAsString(tradeDto);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(body).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
	}
	@Test
	void addTradeMaturityExceptionTest() throws Exception {
		List<CounterParty>  resultList=counterPartyService.getAllCounterPartys();
		List<TradeBook> tradeBookDb=tradeBookService.getAllTradeBooks();
		Trade trade=new Trade(resultList.get(0),tradeBookDb.get(0));
		TradeDto tradeDto =TradeMapper.INSTANCE.toTradeDto(trade);
		Calendar c = Calendar.getInstance();
		c.set(2020, 11, 1);
		tradeDto.setMaturityDate(c.getTime());
		String body=mapper.writeValueAsString(tradeDto);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(body).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		assertEquals(400, mvcResult.getResponse().getStatus());
	}
	@Test
	void tradeUpdateTest() throws Exception {
		List<CounterParty>  resultList=counterPartyService.getAllCounterPartys();
		List<TradeBook> tradeBookDb=tradeBookService.getAllTradeBooks();
		Trade trade=new Trade(resultList.get(0),tradeBookDb.get(0));
		TradeDto tradeDto =TradeMapper.INSTANCE.toTradeDto(trade);
		Calendar c = Calendar.getInstance();
		c.set(2021, 11, 1);
		tradeDto.setMaturityDate(c.getTime());
		String body=mapper.writeValueAsString(tradeDto);
		mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(body).accept(MediaType.APPLICATION_JSON_VALUE))
		.andReturn();
		List<Trade> tradeList=tradeService.getAllTrades();
		tradeDto =TradeMapper.INSTANCE.toTradeDto(tradeList.get(0));
		c.set(2022, 11, 1);
		tradeDto.setMaturityDate(c.getTime());
		body=mapper.writeValueAsString(tradeDto);
		
		MvcResult mvcResultUpdate = mvc.perform(MockMvcRequestBuilders.put(uri+"/update").contentType(MediaType.APPLICATION_JSON_VALUE).content(body).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		assertEquals(200, mvcResultUpdate.getResponse().getStatus());
	}
	@Test
	void tradeStaleExceptionTest() throws Exception {
		List<CounterParty>  resultList=counterPartyService.getAllCounterPartys();
		List<TradeBook> tradeBookDb=tradeBookService.getAllTradeBooks();
		Trade trade=new Trade(resultList.get(0),tradeBookDb.get(0));
		TradeDto tradeDto =TradeMapper.INSTANCE.toTradeDto(trade);
		Calendar c = Calendar.getInstance();
		c.set(2021, 11, 1);
		tradeDto.setMaturityDate(c.getTime());
		String body=mapper.writeValueAsString(tradeDto);
		mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(body).accept(MediaType.APPLICATION_JSON_VALUE))
		.andReturn();
		List<Trade> tradeList=tradeService.getAllTrades();
		tradeDto =TradeMapper.INSTANCE.toTradeDto(tradeList.get(0));
		c.set(2022, 11, 1);
		tradeDto.setMaturityDate(c.getTime());
		tradeDto.setVersion(0);
		body=mapper.writeValueAsString(tradeDto);
		
		MvcResult mvcResultUpdate = mvc.perform(MockMvcRequestBuilders.put(uri+"/update").contentType(MediaType.APPLICATION_JSON_VALUE).content(body).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		assertEquals(400, mvcResultUpdate.getResponse().getStatus());
	}
	@Test
	void getTradeIdTest() throws Exception {
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri+"{id}",1).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		assertEquals(404, mvcResult.getResponse().getStatus());
	}
}
