
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

}
}
}
}
public static void saveEnvironment(String username, String name,
ArrayList<String> appliances, ArrayList<String> groups) throws IOException{
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

//bw.write(data);
bw.newLine();
bw.close();
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