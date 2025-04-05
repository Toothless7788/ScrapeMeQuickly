package com.hackathon.java.demo;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DemoProxy {
	public static void main(String[] args) {
		System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "false");
		System.setProperty("jdk.http.auth.proxying.disabledSchemes", "false");
		
		// Set the proxy settings (IP and port)
		String proxyHost = "194.87.135.1"; // Replace with your proxy host
		int proxyPort = 9875; // Replace with your proxy port
		String proxyUsername = "pingproxies";
		String proxyPassword = "scrapemequickly";
		
		// Set authorization header (Basic Authentication)
		Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(proxyUsername, proxyPassword.toCharArray());
            }
        });
		

        // Create the proxy object
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));

        try {
            // Connect to the webpage using Jsoup with the proxy settings
            Document document = Jsoup.connect("http://youtube.com")  // Replace with your target URL
                    .proxy(proxy)
                    .get();

            // Print the webpage title
            System.out.println("Title: " + document.title());
            System.out.println("document: " + document);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
