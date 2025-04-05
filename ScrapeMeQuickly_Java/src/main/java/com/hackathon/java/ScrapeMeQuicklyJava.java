package com.hackathon.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hackathon.java.entity.Answer;
import com.hackathon.java.entity.Proxy;
import com.hackathon.java.entity.Scraper;
import com.hackathon.java.entity.ScraperAnswer;

public class ScrapeMeQuicklyJava {
	private List<Proxy> proxies;
	private String scrapingRunID;
	
	public ScrapeMeQuicklyJava() {
		// Proxy servers
		// Total number - 100000
		proxies = new ArrayList<Proxy>();
		proxies.add(new Proxy("194.87.135.1", 9875, "pingproxies", "scrapemequickly"));
		proxies.add(new Proxy("194.87.135.2", 9875, "pingproxies", "scrapemequickly"));
		proxies.add(new Proxy("194.87.135.3", 9875, "pingproxies", "scrapemequickly"));
		proxies.add(new Proxy("194.87.135.4", 9875, "pingproxies", "scrapemequickly"));
		proxies.add(new Proxy("194.87.135.5", 9875, "pingproxies", "scrapemequickly"));
	}
	
	public void startScrapingRun(String teamID) {
		
	}
	
	public Answer solve() throws InterruptedException {
		Scraper scraper1 = new Scraper(0, 19999, "https://scrapemequickly.com/cars/static", proxies.get(0).getHost(), proxies.get(0).getPort(), proxies.get(0).getUsername(), proxies.get(0).getPassword(), scrapingRunID);
		Scraper scraper2 = new Scraper(20000, 29999, "https://scrapemequickly.com/cars/static", proxies.get(1).getHost(), proxies.get(1).getPort(), proxies.get(1).getUsername(), proxies.get(1).getPassword(), scrapingRunID);
		Scraper scraper3 = new Scraper(30000, 59999, "https://scrapemequickly.com/cars/static", proxies.get(2).getHost(), proxies.get(2).getPort(), proxies.get(2).getUsername(), proxies.get(2).getPassword(), scrapingRunID);
		Scraper scraper4 = new Scraper(60000, 79999, "https://scrapemequickly.com/cars/static", proxies.get(3).getHost(), proxies.get(3).getPort(), proxies.get(3).getUsername(), proxies.get(3).getPassword(), scrapingRunID);
		Scraper scraper5 = new Scraper(80000, 99999, "https://scrapemequickly.com/cars/static", proxies.get(4).getHost(), proxies.get(4).getPort(), proxies.get(4).getUsername(), proxies.get(4).getPassword(), scrapingRunID);
		
		Thread threadScraper1 = new Thread(scraper1);
		Thread threadScraper2 = new Thread(scraper2);
		Thread threadScraper3 = new Thread(scraper3);
		Thread threadScraper4 = new Thread(scraper4);
		Thread threadScraper5 = new Thread(scraper5);
		
		// Run threads
		threadScraper1.start();
		threadScraper2.start();
		threadScraper3.start();
		threadScraper4.start();
		threadScraper5.start();
		
		threadScraper1.join();
		threadScraper2.join();
		threadScraper3.join();
		threadScraper4.join();
		threadScraper5.join();
		
		// Get result
		int minYear = Integer.MAX_VALUE;
		int maxYear = Integer.MIN_VALUE;
		double priceSum = 0;
		Map<String, Integer> makesCounts = new HashMap<String, Integer>();
		int maxCount = -1;
		String makeMode = "";
		
		List<ScraperAnswer> sas = new ArrayList<ScraperAnswer>();
		
		for(ScraperAnswer sa: sas) {
			if(sa.getMaxYear() > maxYear) {
				maxYear = sa.getMaxYear();
			}
			if(sa.getMinYear() < minYear) {
				minYear = sa.getMinYear();
			}
			priceSum += sa.getPriceSum();
			
			for (Map.Entry<String, Integer> entry : sa.getMakesCounts().entrySet()) {
				if(!makesCounts.containsKey(entry.getKey())) {
					// New element
					makesCounts.put(entry.getKey(), 0);
				}
				
				makesCounts.put(entry.getKey(), entry.getValue() + entry.getValue());
				
				if(makesCounts.get(entry.getKey()) > maxCount) {
					makeMode = entry.getKey();
					// Update maxCount
					maxCount = makesCounts.get(entry.getKey());
				}
			}
		}
		
		// Return result
		return new Answer(maxYear, minYear, priceSum, 100000, makeMode);
	}
	
	public void submit(Answer answer) {
		
	}
	
	public static void main(String[] args) {
		
		
		
	}
}
