package com.hackathon.java.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class DemoProxy {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "false");
		System.setProperty("jdk.http.auth.proxying.disabledSchemes", "false");
		
		// Global variables
		// Proxy
		String proxyHost = "194.87.135.5";
		int proxyPort = 9875;
		String proxyUsername = "pingproxies";
		String proxyPassword = "scrapemequickly";
		
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));

        // Set authorization header (Basic Authentication)
		Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(proxyUsername, proxyPassword.toCharArray());
            }
        });
		
		URL url = new URL("https://www.youtube.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
		connection.setRequestMethod("GET");
		connection.setRequestProperty( "Content-Type", "application/json"); 
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
	}
}
