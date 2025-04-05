package com.hackathon.java.entity;

//	"data":{"scraping_run_id":"70acb334-1235-11f0-a81a-0242ac120002","team_id":"a672a20f-1206-11f0-8f44-0242ac120003","scraping_run_duration":{"Microseconds":0,"Days":0,"Months":0,"Valid":false},"scraping_run_last_update_datetime":"2025-04-05T15:48:38.141829452Z","scraping_run_creation_datetime":"2025-04-05T15:48:38.141829516Z"}
public class ServerResponseDataContainer {
	private String scrapingRunID;
	private String teamID;
	
	/**
	 * @return the scrapingRunID
	 */
	public String getScrapingRunID() {
		return scrapingRunID;
	}
	/**
	 * @param scrapingRunID the scrapingRunID to set
	 */
	public void setScrapingRunID(String scrapingRunID) {
		this.scrapingRunID = scrapingRunID;
	}
	/**
	 * @return the teamID
	 */
	public String getTeamID() {
		return teamID;
	}
	/**
	 * @param teamID the teamID to set
	 */
	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}
}
