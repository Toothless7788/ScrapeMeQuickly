package com.hackathon.java.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scraper implements Runnable {
	private List<Integer> years;
	private double priceSum;
	private int carNum;
	private Map<String, Integer> makesCounts;    // In the form of {make_name, make_count} - for mode make
	private int minCarInedx;
	private int maxCarIndex;
	private String url;    // The url of the target server to get data from
	private String proxyUrl;    // The url of the proxy server
	
	public Scraper(int minCarIndex, int maxCarIndex, String url, String proxyUrl) {
		this.minCarInedx = minCarIndex;
		this.maxCarIndex = maxCarIndex;
		
		years = new ArrayList<Integer>();
		makesCounts = new HashMap<String, Integer>();
	}

	@Override
	public void run() {
		//TODO Do the scraping thing here
	}
	
}
