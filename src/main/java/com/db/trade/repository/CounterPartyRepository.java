package com.db.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.trade.data.CounterParty;

@Repository
public interface CounterPartyRepository extends JpaRepository<CounterParty, Long>{

}
