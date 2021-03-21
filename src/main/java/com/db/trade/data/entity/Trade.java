package com.db.trade.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Immutable;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Immutable
public class Trade {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long tradeId;
	@Version
    private int version;
	@OneToOne(targetEntity = CounterParty.class)
	@JoinColumn(name = "counterPartyId", foreignKey = @javax.persistence.ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT))
	private CounterParty counterParty;
	@OneToOne(targetEntity = TradeBook.class)
	@JoinColumn(name = "bookId", foreignKey = @javax.persistence.ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT))
    private TradeBook tradeBook;
	
    @JsonFormat(pattern="dd/MM/YYYY")
    private Date maturityDate;
	
    @JsonFormat(pattern="dd/MM/YYYY")
    @CreationTimestamp
    private Date createdDate;
	
    @JsonFormat(pattern="dd/MM/YYYY")
    @UpdateTimestamp
    private Date updateDate;
    @Column(columnDefinition = "varchar(1) default 'N'")
    private String isExpired;    
    public Trade() {
    	
    }
	public Trade(CounterParty counterParty, TradeBook tradeBook) {
		super();
		this.counterParty = counterParty;
		this.tradeBook = tradeBook;
	}
	public Long getTradeId() {
		return tradeId;
	}
	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public CounterParty getCounterParty() {
		return counterParty;
	}
	public void setCounterParty(CounterParty counterParty) {
		this.counterParty = counterParty;
	}
	public TradeBook getTradeBook() {
		return tradeBook;
	}
	public void setTradeBook(TradeBook tradeBook) {
		this.tradeBook = tradeBook;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
		if(maturityDate.before(new Date())) {
			setIsExpired( "Y");
		}else {
			setIsExpired( "N");
		}
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public String getIsExpired() {
		return isExpired;
	}
	public void setIsExpired(String isExpired) {
			this.isExpired = isExpired;
		
	}   

}
