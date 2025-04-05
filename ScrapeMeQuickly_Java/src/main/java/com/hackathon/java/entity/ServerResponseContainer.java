package com.hackathon.java.entity;

//		{"message":"Succesfully started scraping run","data":{"scraping_run_id":"70acb334-1235-11f0-a81a-0242ac120002","team_id":"a672a20f-1206-11f0-8f44-0242ac120003","scraping_run_duration":{"Microseconds":0,"Days":0,"Months":0,"Valid":false},"scraping_run_last_update_datetime":"2025-04-05T15:48:38.141829452Z","scraping_run_creation_datetime":"2025-04-05T15:48:38.141829516Z"}}
public class ServerResponseContainer {
	private String message;
	private ServerResponseDataContainer data;
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the data
	 */
	public ServerResponseDataContainer getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(ServerResponseDataContainer data) {
		this.data = data;
	}
}
