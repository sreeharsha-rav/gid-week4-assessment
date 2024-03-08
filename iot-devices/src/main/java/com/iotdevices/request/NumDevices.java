package com.iotdevices.request;

//Class to model the number of devices request
public class NumDevices {
	// Fields
	private String statusQuery;    // status substring to query
	private int threshold;    // threshold to query
	private String dateStr;    // month and year to query in MM-YYYY format
	
	// Constructors
	public NumDevices(String statusQuery, int threshold, String dateStr) {
		super();
		this.statusQuery = statusQuery;
		this.threshold = threshold;
		this.dateStr = dateStr;
	}
	
	// Getters and setters
	public String getStatusQuery() {
		return statusQuery;
	}
	
	public void setStatusQuery(String statusQuery) {
		this.statusQuery = statusQuery;
	}
	
	public int getThreshold() {
		return threshold;
	}
	
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	
	public String getDateStr() {
		return dateStr;
	}
	
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	
}