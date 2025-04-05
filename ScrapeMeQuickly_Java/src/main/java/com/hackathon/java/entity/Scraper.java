package com.hackathon.java.entity;

import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Scraper implements Runnable {
	private double priceSum = 0;
	private Map<String, Integer> makesCounts;    // In the form of {make_name, make_count} - for mode make
	private int minCarIndex;
	private int maxCarIndex;
	private Proxy proxy;
	private String domain;
	private String scrapingRunID;
	
	public Scraper(int minCarIndex, int maxCarIndex, String domain, String proxyHost, int proxyPort, String proxyUsername, String proxyPassword, String scrapingRunID) {
		this.minCarIndex = minCarIndex;
		this.maxCarIndex = maxCarIndex;
		this.domain = domain;
		this.scrapingRunID = scrapingRunID;
		// Proxy
		this.proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
		
		Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(proxyUsername, proxyPassword.toCharArray());
            }
        });
		
		makesCounts = new HashMap<String, Integer>();
	}

	@Override
	public void run() {
		try {
			for (int i = minCarIndex; i <= maxCarIndex; i++) {
				URL url = new URL(domain + "/" + i + "?scraping_run_id=" + scrapingRunID);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
				connection.setRequestMethod("GET");
				//connection.setRequestProperty( "Content-Type", "application/json"); 
				//connection.setRequestProperty( "charset", "utf-8");
				//connection.setUseCaches(false);
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
