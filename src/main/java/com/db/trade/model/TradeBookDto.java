package com.db.trade.model;

import java.io.Serializable;

public class TradeBookDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long bookId; 
    private String bookName;
    public TradeBookDto() {
    	
    }
    public TradeBookDto(String bookName) {
		this.bookName = bookName;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
    

}
