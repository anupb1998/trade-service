package com.db.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.trade.data.TradeBook;

@Repository
public interface TradeBookRepository extends JpaRepository<TradeBook, Long>{

}
