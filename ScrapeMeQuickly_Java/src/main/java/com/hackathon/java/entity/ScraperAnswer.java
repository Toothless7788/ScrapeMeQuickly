package com.hackathon.java.entity;

import java.util.Map;

public class ScraperAnswer {
	private double priceSum;
	private int maxYear;
	private int minYear;
	private Map<String, Integer> makesCounts;
	
	public ScraperAnswer(double priceSum, int maxYear, int minYear, Map<String, Integer> makesCounts) {
		this.setPriceSum(priceSum);
		this.setMaxYear(maxYear);
		this.setMinYear(minYear);
		this.setMakesCounts(makesCounts);
	}

	/**
	 * @return the priceSum
	 */
	public double getPriceSum() {
		return priceSum;
	}

	/**
	 * @param priceSum the priceSum to set
	 */
	public void setPriceSum(double priceSum) {
		this.priceSum = priceSum;
	}

	/**
	 * @return the maxYear
	 */
	public int getMaxYear() {
		return maxYear;
	}

	/**
	 * @param maxYear the maxYear to set
	 */
	public void setMaxYear(int maxYear) {
		this.maxYear = maxYear;
	}

	/**
	 * @return the minYear
	 */
	public int getMinYear() {
		return minYear;
	}

	/**
	 * @param minYear the minYear to set
	 */
	public void setMinYear(int minYear) {
		this.minYear = minYear;
	}

	/**
	 * @return the makesCounts
	 */
	public Map<String, Integer> getMakesCounts() {
		return makesCounts;
	}

	/**
	 * @param makesCounts the makesCounts to set
	 */
	public void setMakesCounts(Map<String, Integer> makesCounts) {
		this.makesCounts = makesCounts;
	}
}
