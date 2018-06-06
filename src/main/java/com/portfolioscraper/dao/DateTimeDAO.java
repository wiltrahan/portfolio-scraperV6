package com.portfolioscraper.dao;

import java.text.ParseException;
import java.util.List;

import com.portfolioscraper.entity.DateTime;
import com.portfolioscraper.entity.Stock;

public interface DateTimeDAO {

	public List<DateTime> getDateTimes();
		
	public void insertDateTimes(DateTime datetime) throws ParseException;
		
	public String currentDate() throws ParseException;
	
	public String currentTime() throws ParseException;

	String formatTime(String time) throws ParseException;

	public List<Stock> getStocks(int id);
	
	public List<DateTime> getDate(int id);
	
}
