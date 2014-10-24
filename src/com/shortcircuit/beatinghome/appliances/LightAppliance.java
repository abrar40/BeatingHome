package com.shortcircuit.beatinghome.appliances;

public class LightAppliance implements AbstractApplianceInterface {
	private String id;
	private String name;
	private String location;
	private String macAddress;
	private String powerRating;
	private boolean state;
	
	public void setID(String id){
		this.id = id;
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
}
