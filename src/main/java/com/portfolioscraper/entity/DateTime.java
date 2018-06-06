package com.portfolioscraper.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="date_time")
public class DateTime {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private String date;
	
	@Column(name="time")
	private String time;
	
	@Column(name="total")
	private String total;
	
	@Column(name="dayGain")
	private String dayGain;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="date_time_id")
	private List<Stock> stocks;
	
	
	public DateTime() {
		
	}

	public DateTime(String date, String time, String total, String dayGain) {
		
		this.date = date;
		this.time = time;
		this.total = total;
		this.dayGain = dayGain;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getDayGain() {
		return dayGain;
	}

	public void setDayGain(String dayGain) {
		this.dayGain = dayGain;
	}
	
	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
	//add convenience method
	public void addStock(List<Stock> list) {
		if(stocks == null) {
			stocks = new ArrayList<>();
		}
		
		stocks.addAll(list);
	}

	@Override
	public String toString() {
		return "DateTime [id=" + id + ", date=" + date + ", time=" + time + ", total=" + total + ", dayGain=" + dayGain
				+ ", stocks=" + stocks + "]";
	}

}
