package com.db.trade.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class TradeBook {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long bookId; 
    private String bookName;
    public TradeBook() {
    	
    }
    
	public TradeBook(String bookName) {
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
