package com.db.trade.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.db.trade.data.TradeBook;
import com.db.trade.model.TradeBookDto;

@Mapper
public interface TradeBookMapper {
	TradeBookMapper INSTANCE = Mappers.getMapper(TradeBookMapper.class);

	TradeBookDto toBookDto(TradeBook tradeBook);

	List<TradeBookDto> toBookDtos(List<TradeBook> tradeBookList);
}
