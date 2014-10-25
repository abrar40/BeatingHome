
package com.shortcircuit.beatinghome.data;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SaveData {
	private static Map<String, Object> model = new HashMap<String, Object>();
	static String resDir = "resources";
	static String usernamePath = "resources/flUsernames.txt";
	static String envPath = "resources/flEnvironments.txt";
	static String applPath = "resources/flAppliances.txt";
	static String groupPath = "resources/flGroups.txt";
	static File flUsernames = new File(usernamePath);
	static File flEnvironments = new File(envPath);
	static File flAppliances = new File(applPath);
	static File flGroups = new File(groupPath);

	SaveData(Map<String, Object>model){
		this.model=model;
	}
	
	public static void saveUser(String username, String password) throws IOException{
		System.out.println("SaveData: save user method started");
		createFlUsernames();
		FileWriter fw = new FileWriter(flUsernames, true);
		BufferedWriter bw = new BufferedWriter(fw);
		String data = username+";"+password;
		bw.write(data);
		bw.newLine();
		bw.close();
	}
	
	public static void saveData() throws IOException{
		if(model.containsKey("Users")){
			ArrayList<User> al_users = (ArrayList<User>)model.get("User");
			createFlEnvironments();
			for(int i=0; i<al_users.size();i++){
				User user = al_users.get(i);
				ArrayList<Environment> al_envs = user.getEnvironments();
				for(int j=0;j<al_envs.size(); j++){
					Environment env = al_envs.get(j);
					String username = env.getUsername();
					String name = env.getName();
					ArrayList<String> appliances = env.getAppliances();
					ArrayList<String> groups = env.getGroups();
					saveEnvironment(username, name, appliances, groups);
				}
			}
		}
		
		if(model.containsKey("Appliances")){
			Map<String, Object> applianceMap = (Map<String, Object>)model.get("Appliances");
			createFlAppliances();
			FileWriter fw = new FileWriter(flAppliances);
			BufferedWriter bw = new BufferedWriter(fw);
			String[] keys = applianceMap.keySet().toArray(new String[0]);
			for(int i=0; i<keys.length; i++){
				Appliance appl = (Appliance) applianceMap.get(keys[i]);
				String line = appl.getPrintLine();
				bw.write(line);
				bw.newLine();
			}
			bw.close();
		}
		
		if(model.containsKey("Groups")){
			Map<String, Object> groupsMap = (Map<String, Object>)model.get("Groups");
			createFlGroups();
			FileWriter fw = new FileWriter(flGroups);
			BufferedWriter bw = new BufferedWriter(fw);
			String[] keys = groupsMap.keySet().toArray(new String[0]);
			for(int i=0; i<keys.length; i++){
				Group group = (Group) groupsMap.get(keys[i]);
				String line = group.getPrintLine();
				bw.write(line);
				bw.newLine();
			}
			bw.close();
		}
	}
	
	public static void saveEnvironment(String username, String name,
			ArrayList<String> appliances, ArrayList<String> groups) throws IOException{
		//Save an environment
		System.out.println("SaveData: save environment method started");
		FileWriter fw = new FileWriter(flEnvironments);
		BufferedWriter bw = new BufferedWriter(fw);
		String appls="";
		for(int i=0; i<appliances.size(); i++){
			if(appls.equals(""))
			appls = appliances.get(i);
			else
			appls=appls+";"+appliances.get(i);
		}
		String grps="";
		for(int i=0; i<groups.size(); i++){
			if(grps.equals(""))
			grps = groups.get(i);
			else
			grps=grps+";"+groups.get(i);
		}
		String line = username + ";" + name;
		if(!appls.equals(""))
			line=line+";"+appls;
		if(!grps.equals(""))
			line=line+";"+grps;
		bw.write(line);
		bw.newLine();
		bw.close();
	}
	
	public static void deleteEnvironment(String username1, String name1) throws IOException{
		if(model.containsKey("Users")){
			ArrayList<User> al_users = (ArrayList<User>)model.get("User");
			createFlEnvironments();
			for(int i=0; i<al_users.size();i++){
				User user = al_users.get(i);
				if(username1.equals(user.getName())){
					ArrayList<Environment> al_envs = user.getEnvironments();
					for(int j=0;j<al_envs.size(); j++){
						Environment env = al_envs.get(j);
						String name = env.getName();
						if(name1.equals(name)){
							al_envs.remove(j);
						}
					}
					user.setEnvironments(al_envs);
				}
				al_users.remove(i);
				al_users.add(user);
			}
			model.put("User", al_users);
		}
	}
	
	public static void deleteAppliance(String id){
		if(model.containsKey("Appliances")){
			Map<String, Object> appliances = (Map<String, Object>)model.get("Appliances");
			String[] keys = appliances.keySet().toArray(new String[0]);
			for(int i=0; i<keys.length; i++){
				Appliance applInf = (Appliance)appliances.get(keys[i]);
				if(id.equals(applInf.getID())){
					appliances.remove(keys[i]);
				}
			}
			model.put("Appliances", appliances);
		}
	}
	
	public static void deleteGroup(String id){
		if(model.containsKey("Groups")){
			Map<String, Object> groups = (Map<String, Object>)model.get("Groups");
			String[] keys = groups.keySet().toArray(new String[0]);
			for(int i=0; i<keys.length; i++){
				Group group = (Group) groups.get(keys[i]);
				if(id.equals(group.getID())){
					groups.remove(keys[i]);
				}
			}
			model.put("Groups", groups);
		}
	}
	
	public static void createFlUsernames() throws IOException{
		if(!flUsernames.exists())
		flUsernames.createNewFile();
	}
	
	public static void createFlEnvironments() throws IOException{
		if(!flEnvironments.exists())///
		flEnvironments.createNewFile();
	}
	
	public static void createFlAppliances() throws IOException{
		if(!flAppliances.exists())
		flAppliances.createNewFile();
	}
	
	public static void createFlGroups() throws IOException{
		if(!flGroups.exists())
		flGroups.createNewFile();
	}
}