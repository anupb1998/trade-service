package com.db.trade.dto.model;

import org.springframework.http.HttpStatus;

public class ServiceError {
	private HttpStatus status;
	   private String message;
	   private String debugMessage;

	   private ServiceError() {	      
	   }

	   public ServiceError(HttpStatus status) {
	       this();
	       this.status = status;
	   }

	   public ServiceError(HttpStatus status, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = "Unexpected error";
	       this.debugMessage = ex.getLocalizedMessage();
	   }

	   public ServiceError(HttpStatus status, String message, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = message;
	       this.debugMessage = ex.getLocalizedMessage();
	   }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}
	   
	   
}
