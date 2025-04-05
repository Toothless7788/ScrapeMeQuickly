package com.hackathon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.hackathon.java.entity.Answer;
import com.hackathon.java.entity.ProxyContainer;
import com.hackathon.java.entity.Scraper;
import com.hackathon.java.entity.ScraperAnswer;

public class ScrapeMeQuicklyJava {
	private List<ProxyContainer> proxies;
	private String scrapingRunID;
	private final static String PROXY_USERNAME = "pingproxies";
	private final static String PROXY_PASSWORD = "scrapemequickly";
	
	public ScrapeMeQuicklyJava() {
		// Proxy servers
		// Total number - 100000
		proxies = new ArrayList<ProxyContainer>();
		proxies.add(new ProxyContainer("194.87.135.1", 9875, "pingproxies", "scrapemequickly"));
		proxies.add(new ProxyContainer("194.87.135.2", 9875, "pingproxies", "scrapemequickly"));
		proxies.add(new ProxyContainer("194.87.135.3", 9875, "pingproxies", "scrapemequickly"));
		proxies.add(new ProxyContainer("194.87.135.4", 9875, "pingproxies", "scrapemequickly"));
		proxies.add(new ProxyContainer("194.87.135.5", 9875, "pingproxies", "scrapemequickly"));
		
		// Set authorization header (Basic Authentication)
		Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(PROXY_USERNAME, PROXY_PASSWORD.toCharArray());
            }
        });
	}
	
	@SuppressWarnings("deprecation")
	public String startScrapingRun(String teamID) throws IOException {
		URL url = new URL("https://api.scrapemequickly.com/scraping-run?team_id=" + teamID);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty( "Content-Type", "application/json"); 
		connection.setRequestProperty( "charset", "utf-8");
		connection.setUseCaches(false);
		
		int responseCode = connection.getResponseCode();
		System.out.println("startScrapingRun responseCode: " + responseCode);
		
		InputStream inputStream = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		System.out.println("lines: " + reader.lines().collect(Collectors.joining("\n")));
		
		// Clean up
		reader.close();
		
		return "None";
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
	
	@SuppressWarnings("deprecation")
	public void submit(Answer answer, String runID) throws IOException {
		URL url = new URL("https://api.scrapemequickly.com/cars/solve?scraping_run_id=" + runID);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty( "Content-Type", "application/json"); 
		connection.setRequestProperty( "charset", "utf-8");
		connection.setUseCaches(false);
		connection.setDoOutput(true);
		
		Gson gson = new Gson();
		
		// Convert the 'answers' Map to a JSON string
        String jsonInputString = gson.toJson(answer);
        System.out.println("answer: " + jsonInputString);

        // Write JSON string to the output stream of the connection
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
		
		int responseCode = connection.getResponseCode();
		System.out.println("startScrapingRun responseCode: " + responseCode);
		
		InputStream inputStream = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		System.out.println("lines: " + reader.lines().collect(Collectors.joining("\n")));
		
		// Clean up
		reader.close();
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "false");
		System.setProperty("jdk.http.auth.proxying.disabledSchemes", "false");
		final String TEAM_ID = "a672a20f-1206-11f0-8f44-0242ac12000";
		
		ScrapeMeQuicklyJava driver = new ScrapeMeQuicklyJava();
		
		String runID = driver.startScrapingRun(TEAM_ID);
		Answer finalAnswer = new Answer(110, 1, 10, 5, "modeMake");
//		Answer finalAnswer = driver.solve();
		driver.submit(finalAnswer, runID);
		
		System.out.println("Programme terminated successfully ...");
	}
}
