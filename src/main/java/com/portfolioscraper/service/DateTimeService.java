package com.portfolioscraper.service;

import java.util.List;

import com.portfolioscraper.entity.DateTime;
import com.portfolioscraper.entity.Stock;

public interface DateTimeService {
	
	public List<DateTime> getDateTimes();
	
	public List<Stock> getStocks(int id);
	
	public List<DateTime> getDate(int id);
	
}
