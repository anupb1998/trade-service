package com.db.trade.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.db.trade.dto.model.ServiceError;
import com.db.trade.exception.StaleTradeException;
import com.db.trade.exception.TradeExpiredException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(TradeExpiredException.class)
	protected ResponseEntity<Object> handleExpiredExceptionTrade(TradeExpiredException ex) {
		String error = ex.getMessage();
		return buildResponseEntity(new ServiceError(HttpStatus.BAD_REQUEST, error, ex));
	}
	@ExceptionHandler(StaleTradeException.class)
	protected ResponseEntity<Object> handleStaleTrade(StaleTradeException ex) {
		String error = ex.getMessage();
		return buildResponseEntity(new ServiceError(HttpStatus.BAD_REQUEST, error, ex));
	}
	
	private ResponseEntity<Object> buildResponseEntity(ServiceError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}
