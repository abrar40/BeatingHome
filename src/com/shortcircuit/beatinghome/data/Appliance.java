package com.shortcircuit.beatinghome.data;

public class Appliance {
	private String id;
	private String type;
	private String name;
	private String location;
	private String macAddress;
	private String powerRating;
	private boolean state;
	private double controlValue;
	
	public void setID(String id){
		this.id = id;
	}
	
	public void setType(String type) {
		// TODO Auto-generated method stub
		this.type=type;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setLocation(String location){
		this.location=location;
	}
	
	public void setMacAddress(String macAddress){
		this.macAddress=macAddress;
	}
	
	public void setPowerRating(String powerRating){
		this.powerRating=powerRating;
	}
	
	public String getID(){
		return id;
	}
	
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
	
	public String getName(){
		return name;
	}
	
	public String getLocation(){
		return location;
	}
	
	public String getMacAddress(){
		return macAddress;
	}
	
	public String getPowerRating(){
		return powerRating;
	}

	public void setState(boolean state) {
		// TODO Auto-generated method stub
		this.state=state;
	}

	public boolean getState() {
		// TODO Auto-generated method stub
		return state;
	}

	
	public String getPrintLine() {
		// TODO Auto-generated method stub id, type, name, location, mac, power_rating, on/off,
		String line = id+";"+type+";"+name+";"+location+";"+macAddress+";"+powerRating+";"+state+";"+controlValue;
		return line;
	}

	public void setControlValue(double controlValue) {
		// TODO Auto-generated method stub
		this.controlValue=controlValue;
	}

	
	public double getControlValue() {
		// TODO Auto-generated method stub
		return controlValue;
	}
	
}
