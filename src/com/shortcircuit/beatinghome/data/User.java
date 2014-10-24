package com.shortcircuit.beatinghome.data;

import java.util.ArrayList;

public class User {
	private String name;
	private String password;
	private ArrayList<Environment> environments = new ArrayList<Environment>();
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public void setEnvironments(ArrayList<Environment> environments){
		this.environments=environments;
	}
	
	public void addEnvironment(Environment env){
		environments.add(env);
	}
	
	public void removeEnvironment(Environment env){
		environments.remove(env);
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<Environment> getEnvironments(){
		return environments;
	}

}
