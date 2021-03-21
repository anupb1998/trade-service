package com.db.trade.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.db.trade.data.entity.Trade;
import com.db.trade.dto.model.TradeDto;

@Mapper
public interface TradeMapper {
	TradeMapper INSTANCE = Mappers.getMapper(TradeMapper.class);

	TradeDto toTradeDto(Trade trade);

	List<TradeDto> toTradeDtos(List<Trade> tradeList);
	Trade toTrade(TradeDto trade);
}
