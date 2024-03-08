package com.iotdevices.response;

//Class to model parent information about the device
public class Parent {
	
	private long id;	// unique ID of the parent
	private String alias;	// alias of the parent
	
	// Constructors
	public Parent() {
		super();
	}
	
	public Parent(long id, String alias) {
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
		return "Parent [id=" + id + ", alias=" + alias + "]";
	}
	
}
