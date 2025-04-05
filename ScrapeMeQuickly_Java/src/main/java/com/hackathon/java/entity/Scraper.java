package com.hackathon.java.entity;

import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scraper implements Runnable {
	private double priceSum = 0;
	private Map<String, Integer> makesCounts;    // In the form of {make_name, make_count} - for mode make
	private int minCarInedx;
	private int maxCarIndex;
	private Proxy proxy;
	
	public Scraper(int minCarIndex, int maxCarIndex, String domain, String proxyHost, int proxyPort, String proxyUsername, String proxyPassword) {
		this.minCarInedx = minCarIndex;
		this.maxCarIndex = maxCarIndex;
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
		//TODO Do the scraping thing here
	}
	
}
