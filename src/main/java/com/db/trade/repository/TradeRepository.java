package com.db.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.trade.data.entity.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {

}
