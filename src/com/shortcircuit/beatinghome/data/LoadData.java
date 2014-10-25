package com.shortcircuit.beatinghome.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class LoadData {
	private Map<String, Object> model = new HashMap<String, Object>();
	static String resDir = "resources";
	static String usernamePath = "resources/flUsernames.txt";
	static String envPath = "resources/flEnvironments.txt";
	static String applPath = "resources/flAppliances.txt";
	static String groupPath = "resources/flGroups.txt";
	static File flUsernames = new File(usernamePath);
	static File flEnvironments = new File(envPath);
	static File flAppliances = new File(applPath);
	static File flGroups = new File(groupPath);
	
	public LoadData(Map<String, Object> model) throws IOException{
		this.model = model;
		loadAppliances();
		loadGroups();
		loadUsernames();
	}
	
	private void loadUsernames() throws IOException{
		createFlUsernames();
		createFlEnvironments();
		createFlAppliances();
		createFlGroups();
		ArrayList<User> users = new ArrayList<User>();
		FileReader frUsername =new FileReader(flUsernames);
		BufferedReader brUsername = new BufferedReader(frUsername);
		String line;
		while((line=brUsername.readLine())!=null){
			StringTokenizer st = new StringTokenizer(line, ";");
			String username = st.nextToken();
			String password = st.nextToken();
			User user = new User();
			user.setName(username);
			user.setPassword(password);
			user.setEnvironments(loadEnvironments(username));
			users.add(user);
		}
		brUsername.close();
		model.put("Users", users);
		
	}
	
	private ArrayList<Environment> loadEnvironments(String username) throws IOException{
		ArrayList<Environment> list = new ArrayList<Environment>();
		
		FileReader frEnv =new FileReader(flEnvironments);
		BufferedReader brEnv = new BufferedReader(frEnv);
		String line;
		while((line=brEnv.readLine())!=null){
			StringTokenizer st = new StringTokenizer(line, ";");
			String userName =st.nextToken();
			if(userName.equals(username)){
				Environment env = new Environment();
				String name = st.nextToken();
				env.setUsername(username);
				env.setName(name);
				while(st.hasMoreTokens()){
					String addition = st.nextToken();
					StringTokenizer st1 = new StringTokenizer(addition,"-");
					String type = st1.nextToken();
					if(type.equals("appl")){
						env.addAppliance(addition);
					}else if(type.equals("group")){
						env.addGroup(addition);
					}
				}
				list.add(env);
				//System.out.println("Loading Environment ->" + env.getName());
			}
		}
		brEnv.close();
		return list;
	}
	
	private void loadAppliances() throws IOException{
		Map<String, Object> appliances = new HashMap<String,Object>();
		FileReader frAppl =new FileReader(flAppliances);
		BufferedReader brAppl = new BufferedReader(frAppl);
		String line;
		while((line=brAppl.readLine())!=null){
			StringTokenizer st = new StringTokenizer(line, ";");
			String id =st.nextToken();
			String type = st.nextToken();
			
			Appliance appliance = new Appliance();
			appliance.setID(id);
			appliance.setName(st.nextToken());
			appliance.setLocation(st.nextToken());
			appliance.setMacAddress(st.nextToken());
			appliance.setPowerRating(st.nextToken());
			String state=st.nextToken();
			if(state.equals("true"))
				appliance.setState(true);
			else if(state.equals("false"))
				appliance.setState(false);
			double controlValue = Double.parseDouble(st.nextToken());
			appliance.setControlValue(controlValue);	
			appliances.put(id, appliance);
			
		}
		brAppl.close();
		model.put("Appliances", appliances);
	}
	
	private void loadGroups() throws IOException{
		Map<String, Object> groups = new HashMap<String,Object>();
		FileReader frGroup =new FileReader(flGroups);
		BufferedReader brGroup = new BufferedReader(frGroup);
		String line;
		while((line=brGroup.readLine())!=null){
			Group group =new Group();
			StringTokenizer st = new StringTokenizer(line, ";");
			String id =st.nextToken();
			String name = st.nextToken();
			ArrayList<String> list = new ArrayList<String>();
			while(st.hasMoreTokens()){
				list.add(st.nextToken());
			}
			group.setID(id);
			group.setName(name);
			group.setAppliances(list);
			groups.put(id, group);
			
			//System.out.println("Loading Group -> "+group.getID() + " " 
				//	+ group.getName());
		}
		brGroup.close();
		model.put("Groups", groups);
	}
	
	public static void createResDir(){
		File dir = new File(resDir);
		if(!dir.exists())
			dir.mkdir();
	}
	
	public static void createFlUsernames() throws IOException{
		if(!flUsernames.exists())
			flUsernames.createNewFile();
	}
	
	public static void createFlEnvironments() throws IOException{
		if(!flEnvironments.exists())
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
