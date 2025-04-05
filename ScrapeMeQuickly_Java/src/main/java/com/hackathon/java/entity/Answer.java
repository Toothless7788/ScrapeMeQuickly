package com.hackathon.java.entity;

public class Answer {
	private int maxYear;
	private int minYear;
	private double priceAverage;
	private String modeMake;
	
	public Answer(int maxYear, int minYear, double priceSum, int priceCount, String modeMake) {
		this.maxYear = maxYear;
		this.minYear = minYear;
		this.priceAverage = priceSum / priceCount;
		this.modeMake = modeMake;
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
	 * @return the priceAverage
	 */
	public double getPriceAverage() {
		return priceAverage;
	}

	/**
	 * @param priceAverage the priceAverage to set
	 */
	public void setPriceAverage(double priceAverage) {
		this.priceAverage = priceAverage;
	}

	/**
	 * @return the modeMake
	 */
	public String getModeMake() {
		return modeMake;
	}

	/**
	 * @param modeMake the modeMake to set
	 */
	public void setModeMake(String modeMake) {
		this.modeMake = modeMake;
	}
}
