package com.hackathon.java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Sandbox {
	public static void main(String[] args) {
		String html = "<html><head><title>First parse</title></head><body><p>Parsed HTML into a doc.</p></body></html>";
		Document document = Jsoup.parse(html);
	}
}
