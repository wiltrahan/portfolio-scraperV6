package com.portfolioscraper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="symbol")
	private String symbol;
	
	@Column(name="value")
	private String value;
	
	@Column(name="dayAmtChg")
	private String dayAmtChg;
	
	@Column(name="dayPctChg")
	private String dayPctChg;
	
	@Column(name="totalShrs")
	private String totalShrs;
	
	@ManyToOne
	@JoinColumn(name="date_time_id")
	private DateTime dateTime;
	
	public Stock() {
		
	}

	public Stock(String symbol, String value, String dayAmtChg, String dayPctChg, String totalShrs) {
		this.symbol = symbol;
		this.value = value;
		this.dayAmtChg = dayAmtChg;
		this.dayPctChg = dayPctChg;
		this.totalShrs = totalShrs;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDayAmtChg() {
		return dayAmtChg;
	}

	public void setDayAmtChg(String dayAmtChg) {
		this.dayAmtChg = dayAmtChg;
	}

	public String getDayPctChg() {
		return dayPctChg;
	}

	public void setDayPctChg(String dayPctChg) {
		this.dayPctChg = dayPctChg;
	}

	public String getTotalShrs() {
		return totalShrs;
	}

	public void setTotalShrs(String totalShrs) {
		this.totalShrs = totalShrs;
	}
	
	
	public DateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", symbol=" + symbol + ", value=" + value + ", dayAmtChg=" + dayAmtChg
				+ ", dayPctChg=" + dayPctChg + ", totalShrs=" + totalShrs + "]";
	}

	
}
