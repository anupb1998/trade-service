package com.db.trade.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.db.trade.data.TradeBook;
import com.db.trade.repository.TradeBookRepository;
import com.db.trade.service.intf.TradeBookIntf;

@Service
public class TradeBookService implements TradeBookIntf {
	@Autowired
	TradeBookRepository bookRepository;
	
	@Cacheable(value="cacheTradeBook")
	public List<TradeBook> getAllTradeBooks(){
		List<TradeBook> result = new ArrayList<>();
		bookRepository.findAll().forEach(result::add);
		return result;
	}
	
	@CacheEvict(value = "cacheTradeBook", allEntries = true)
	public void saveTradeBooks(List<TradeBook> tradeBookLst) {
		bookRepository.saveAll(tradeBookLst);		
	}

}
