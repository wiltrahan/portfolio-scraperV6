package com.portfolioscraper.dao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Repository;

import com.portfolioscraper.entity.DateTime;
import com.portfolioscraper.entity.Stock;
import com.portfolioscraper.scrape.Scrape;



@Repository
public class DateTimeDAOImpl implements DateTimeDAO {

	//inject session factory
	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public List<DateTime> getDateTimes() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<DateTime> theQuery = 
				currentSession.createQuery("from DateTime", DateTime.class);
		
		//execute query and get result list
		List<DateTime> dateTimes = theQuery.getResultList();
			
		//return results	
		return dateTimes;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> getStocks(int id) {
		List<Stock> theStocks = new ArrayList<>();

		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(DateTime.class)
				.addAnnotatedClass(Stock.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			theStocks = session.createQuery("from Stock where date_time_id=" + id).getResultList();
//			for(Stock tempStock : theStocks) {
//				System.out.println(tempStock);
//			}

			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		return theStocks;
	}
	
	@SuppressWarnings("unchecked")
	public List<DateTime> getDate(int id) {
		List<DateTime> theDate = new ArrayList<>();

		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(DateTime.class)
				.addAnnotatedClass(Stock.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			theDate = session.createQuery("from DateTime where id=" + id).getResultList();
//			for(Stock tempStock : theStocks) {
//				System.out.println(tempStock);
//			}

			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		return theDate;
	}
	
	
	public void insertDateTimes(DateTime dateTime) throws ParseException {
		
		sessionFactory = new Configuration()
									.configure()
									.addAnnotatedClass(DateTime.class)
									.addAnnotatedClass(Stock.class)
									.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//create date time object
			DateTime tempDate = dateTime;
			//create stock object

			tempDate.addStock(Scrape.stockScrape());

			//start transaction
			session.beginTransaction();
			
			//save date time object
			//this also saves stock object because of CascadeType.ALL
			session.save(tempDate);
			
			//commit transaction
			session.getTransaction().commit();
			
		} finally {
			sessionFactory.close();
		}
		
	}
	
	public String currentDate() throws ParseException {
		
		String dateTime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		String[] timeSplit = dateTime.split("\\s+");

		return timeSplit[0];
	}

	@Override
	public String currentTime() throws ParseException {
		
		String dateTime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		String[] timeSplit = dateTime.split("\\s+");
		
		return formatTime(timeSplit[1]);

	}

	@Override
	public String formatTime(String time) throws ParseException {
		//old format
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	    Date timeFormat = sdf.parse(time);
	    //new format
	    SimpleDateFormat sdf2 = new SimpleDateFormat("h:mm aa");
	    //formatting the given time to new format with AM/PM
	    return sdf2.format(timeFormat);
		
	}

}
