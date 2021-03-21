package com.db.trade.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.db.trade.data.entity.CounterParty;
import com.db.trade.dto.model.CounterPartyDto;

@Mapper
public interface CounterPartyMapper {
	CounterPartyMapper INSTANCE = Mappers.getMapper(CounterPartyMapper.class);

	CounterPartyDto toCounterPartyDto(CounterParty counterParty);

	List<CounterPartyDto> toCounterPartyDtos(List<CounterParty> tradeList);
}
