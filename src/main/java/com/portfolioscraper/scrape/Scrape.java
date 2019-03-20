package com.portfolioscraper.scrape;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.portfolioscraper.dao.DateTimeDAOImpl;
import com.portfolioscraper.entity.DateTime;
import com.portfolioscraper.entity.Stock;

public class Scrape {
	
	private static WebDriver driver;
	
	
	public static void main(String[] args) {
		
//		driver = new FirefoxDriver();
//		
//		Personal personal = new Personal();
//		String username = personal.getUsername();
//		String password = personal.getPassword();
//		
//		Scrape scrape = new Scrape();
//		scrape.login(username, password);
	}
	
	public void startScraping() {
		
		System.setProperty("webdriver.gecko.driver", "/Users/twilorip/Desktop/eclipse-workspace/portfolioV6/geckodriver");
		
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		
		driver = new FirefoxDriver(options);
		
		Personal personal = new Personal();
		String username = personal.getUsername();
		String password = personal.getPassword();
		
		login(username, password);
	}
	
	private void login(String username, String password) {
		String logScreen = "https://login.yahoo.com/config/login?.done=https%3A%2F%2Ffinance.yahoo.com%2Fportfolios&.intl=us&.lang=en-US&.src=finance";
		driver.get(logScreen);
		
		try {
			driver.findElement(By.id("login-username")).sendKeys(username);
			driver.findElement(By.id("login-signin")).click();
			Thread.sleep(3000);
			pass(password);
		} catch (Exception e) {
			System.out.println("Login Failed: " + e.getMessage());
		}	
	}
	
	private void pass(String password) {
		try {
			driver.findElement(By.id("login-passwd")).sendKeys(password);
			driver.findElement(By.id("login-signin")).click();
			Thread.sleep(2000);
			toYahooPortfolio();
		} catch (Exception e) {
			System.out.println("Password Failed: " + e.getMessage());
		}
	}
	
	private void toYahooPortfolio() {
		try {
			driver.navigate().to("https://finance.yahoo.com/portfolio/p_0/view/v1");
			Thread.sleep(3000);	
			valueScrape();
		} catch (Exception e) {
			System.out.println("To Portfolio Failed:** " + e.getMessage());
			driver.quit();
		}
	}
	
	private void valueScrape() throws ParseException {
		DateTimeDAOImpl dateTimeDAOImpl = new DateTimeDAOImpl();
		String date = dateTimeDAOImpl.currentDate();
		String time = dateTimeDAOImpl.currentTime();
        
		String portfolioTotal = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/div/div/div[4]/div/div/main/div[1]/div[1]")).getText();
		String dayGain = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/div/div/div[4]/div/div/main/div[1]/div[2]/div[2]")).getText();
        
        dateTimeDAOImpl.insertDateTimes(new DateTime(date, time, portfolioTotal, dayGain));
		
	}
	
	public static List<Stock> stockScrape() {
		List<Stock> stocks = new ArrayList<>();
		for(int i = 1; i <= 10; i++) {
			stocks.add(new Stock(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/div/div/div[4]/div/div/main/div[2]/div[2]/div/div[1]/table/tbody/tr[" + i + "]/td[1]/a")).getText(),
					driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/div/div/div[4]/div/div/main/div[2]/div[2]/div/div[1]/table/tbody/tr[" + i + "]/td[2]/span")).getText(),
					driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/div/div/div[4]/div/div/main/div[2]/div[2]/div/div[1]/table/tbody/tr[" + i + "]/td[3]/span")).getText(),
					driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/div/div/div[4]/div/div/main/div[2]/div[2]/div/div[1]/table/tbody/tr[" + i + "]/td[4]/span")).getText(),
					driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/div/div/div[4]/div/div/main/div[2]/div[2]/div/div[1]/table/tbody/tr[" + i + "]/td[8]")).getText()
			));
		}
		driver.quit();
		return stocks;
		
	}

}
