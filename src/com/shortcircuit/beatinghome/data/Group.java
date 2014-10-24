package com.shortcircuit.beatinghome.data;

import java.util.ArrayList;

public class Group {
	private String name;
	private String id;
	private ArrayList<String> appliances = new ArrayList<String>();
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setID(String id){
		this.id=id;
	}
	
	public void setAppliances(ArrayList<String> appliances){
		this.appliances=appliances;
	}
	public void addAppliance(String applID){
		appliances.add(applID);
	}
	
	public void removeAppliance(String applID){
		appliances.remove(applID);
	}
	
	public String getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<String> getAppliances(){
		return appliances;
	}
	

}
