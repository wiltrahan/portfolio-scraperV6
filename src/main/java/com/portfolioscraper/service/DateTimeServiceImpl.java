package com.portfolioscraper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolioscraper.dao.DateTimeDAO;
import com.portfolioscraper.entity.DateTime;
import com.portfolioscraper.entity.Stock;

@Service
public class DateTimeServiceImpl implements DateTimeService {
	
	//inject Date Time DAO
	@Autowired
	DateTimeDAO dateTimeDAO;

	@Override
	@Transactional
	public List<DateTime> getDateTimes() {
		
		return dateTimeDAO.getDateTimes();
	}

	@Override
	public List<Stock> getStocks(int id) {
		
		return dateTimeDAO.getStocks(id);
	}

	@Override
	public List<DateTime> getDate(int id) {
		return dateTimeDAO.getDate(id);
	}

}
