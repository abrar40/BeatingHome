package com.shortcircuit.beatinghome.appliances;

public interface AbstractApplianceInterface {
	
	public void setID(String id);
	public void setName(String name);
	public void setLocation(String location);
	public void setMacAddress(String macAddress);
	public void setPowerRating(String powerRating);
	public void setState(boolean state);
	public String getID();
	public String getName();
	public String getLocation();
	public String getMacAddress();
	public String getPowerRating();
	public boolean getState();
}
