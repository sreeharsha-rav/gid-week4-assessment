package com.iotdevices.response;

//Class to model the operating parameters of a device
public class OperatingParameters {
	
	private int rotorSpeed; 	// speed of the rotor
	private int slack; 	// slack of the device
	private double rootThreshold; 	// root threshold of the device
	
	// Constructors
	public OperatingParameters() {
		super();
	}
	
	public OperatingParameters(int rotorSpeed, int slack, double rootThreshold) {
		super();
		this.rotorSpeed = rotorSpeed;
		this.slack = slack;
		this.rootThreshold = rootThreshold;
	}
	
	// Getters and setters
	public int getRotorSpeed() {
		return rotorSpeed;
	}
	
	public void setRotorSpeed(int rotorSpeed) {
		this.rotorSpeed = rotorSpeed;
	}
	
	public int getSlack() {
		return slack;
	}
	
	public void setSlack(int slack) {
		this.slack = slack;
	}
	
	public double getRootThreshold() {
		return rootThreshold;
	}
	
	public void setRootThreshold(double rootThreshold) {
		this.rootThreshold = rootThreshold;
	}
	
	@Override
	public String toString() {
		return "OperatingParameters [rotorSpeed=" + rotorSpeed + ", slack=" + slack + ", rootThreshold=" + rootThreshold
				+ "]";
	}
	
}
