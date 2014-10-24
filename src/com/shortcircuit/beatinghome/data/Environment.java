package com.shortcircuit.beatinghome.data;

import java.util.ArrayList;

public class Environment {
	private String name;
	private String username;
	private ArrayList<String> appliances = new ArrayList<String>();
	private ArrayList<String> groups = new ArrayList<String>();
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public void addAppliance(String applID){
		appliances.add(applID);
	}
	
	public void addGroup(String group){
		groups.add(group);
	}
	
	public void removeAppliance(String applID){
		appliances.remove(applID);
	}
	
	public void removeGroup(String group){
		groups.remove(group);
	}
	
	public String getName(){
		return name;
	}
	
	public String getUsername(){
		return username;
	}
	
	public ArrayList<String> getAppliances(){
		return appliances;
	}
	
	public ArrayList<String> getGroups(){
		return groups;
	}

}
