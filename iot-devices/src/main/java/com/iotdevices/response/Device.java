package com.iotdevices.response;

//Device class is the model for the device object
public class Device {
	
	private long id;	// unique ID of the device
	private long timestamp;	// timestamp of the device
	private String status;	// status of the device
	private OperatingParameters operatingParameters;	// operating parameters of the device
	private Asset asset;	// information about the asset of the device
	private Parent parent;	// information about the parent of the device
	
	// Constructors
	public Device() {
		super();
	}
	
	public Device(long id, long timestamp, String status, OperatingParameters operatingParameters, Asset asset, Parent parent) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.status = status;
		this.operatingParameters = operatingParameters;
		this.asset = asset;
		this.parent = parent;
	}
	
	// Getters and setters
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public OperatingParameters getOperatingParameters() {
		return operatingParameters;
	}
	
	public void setOperatingParameters(OperatingParameters operatingParameters) {
		this.operatingParameters = operatingParameters;
	}
	
	public Asset getAsset() {
		return asset;
	}
	
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	
	public Parent getParent() {
		return parent;
	}
	
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		return "Device [id=" + id + ", timestamp=" + timestamp + ", status=" + status + ", operatingParameters="
				+ operatingParameters + ", asset=" + asset + ", parent=" + parent + "]";
	}
	
}
