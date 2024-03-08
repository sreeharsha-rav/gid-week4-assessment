package com.iotdevices.response;

//Class to model the asset information of the device
public class Asset {
	
	private long id; // unique ID of the asset
	private String alias; // alias of the asset

	// Constructors
	public Asset() {
		super();
	}

	public Asset(long id, String alias) {
		super();
		this.id = id;
		this.alias = alias;
	}

	// Getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	@Override
	public String toString() {
		return "Asset [id=" + id + ", alias=" + alias + "]";
	}
}
