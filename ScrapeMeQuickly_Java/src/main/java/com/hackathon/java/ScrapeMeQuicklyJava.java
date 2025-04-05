package com.hackathon.java;

import java.util.ArrayList;
import java.util.List;

import com.hackathon.java.entity.Proxy;
import com.hackathon.java.entity.Scraper;

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
	
	public void solve() throws InterruptedException {
		Thread scraper1 = new Thread(new Scraper(0, 19999, "https://scrapemequickly.com/cars/static", proxies.get(0).getHost(), proxies.get(0).getPort(), proxies.get(0).getUsername(), proxies.get(0).getPassword(), scrapingRunID));
		Thread scraper2 = new Thread(new Scraper(0, 19999, "https://scrapemequickly.com/cars/static", proxies.get(0).getHost(), proxies.get(0).getPort(), proxies.get(0).getUsername(), proxies.get(0).getPassword(), scrapingRunID));
		Thread scraper3 = new Thread(new Scraper(0, 19999, "https://scrapemequickly.com/cars/static", proxies.get(0).getHost(), proxies.get(0).getPort(), proxies.get(0).getUsername(), proxies.get(0).getPassword(), scrapingRunID));
		Thread scraper4 = new Thread(new Scraper(0, 19999, "https://scrapemequickly.com/cars/static", proxies.get(0).getHost(), proxies.get(0).getPort(), proxies.get(0).getUsername(), proxies.get(0).getPassword(), scrapingRunID));
		Thread scraper5 = new Thread(new Scraper(0, 19999, "https://scrapemequickly.com/cars/static", proxies.get(0).getHost(), proxies.get(0).getPort(), proxies.get(0).getUsername(), proxies.get(0).getPassword(), scrapingRunID));
		
		// Run threads
		scraper1.start();
		scraper2.start();
		scraper3.start();
		scraper4.start();
		scraper5.start();
		
		scraper1.join();
		scraper2.join();
		scraper3.join();
		scraper4.join();
		scraper5.join();
		
		// Get result
	}
	
	public void submit() {
		
	}
	
	public static void main(String[] args) {
		
		
		
	}
}
