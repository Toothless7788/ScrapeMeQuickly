package com.hackathon.java.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class DemoURL {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("https://www.youtube.com");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
			connection.setRequestProperty( "charset", "utf-8");
			connection.setUseCaches(false);
			
			int responseCode = connection.getResponseCode();
			System.out.println("responseCode: " + responseCode);
			
			//Get Response  
		    InputStream is = connection.getInputStream();
		    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		    StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
		    String line;
		    while ((line = rd.readLine()) != null) {
		      response.append(line);
		      response.append('\r');
		    }
		    rd.close();
		    
		    System.out.println("response: " + response.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
