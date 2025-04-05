package com.hackathon.java.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scraper implements Runnable {
	private List<Integer> years;
	private double priceSum = 0;
	private int carNum = 0;
	private Map<String, Integer> makesCounts;    // In the form of {make_name, make_count} - for mode make
	private int minCarInedx;
	private int maxCarIndex;
	private String url;    // The url of the target server to get data from
	private String proxyHost;    // The host of the proxy server
	private int proxyPort;    // The port of the host of the proxy server
	private String proxyUsername;
	private String proxyPassword;
	
	public Scraper(int minCarIndex, int maxCarIndex, String url, String proxyHost, int proxyPort, String proxyUsername, String proxyPassword) {
		this.minCarInedx = minCarIndex;
		this.maxCarIndex = maxCarIndex;
		this.url = url;
		// Proxy
		this.proxyHost = proxyHost;
		this.proxyPort = proxyPort;
		this.proxyUsername = proxyUsername;
		this.proxyPassword = proxyPassword;
		
		years = new ArrayList<Integer>();
		makesCounts = new HashMap<String, Integer>();
	}

	@Override
	public void run() {
		//TODO Do the scraping thing here
	}
	
}
