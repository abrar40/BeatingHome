package com.shortcircuit.beatinghome;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.shortcircuit.beatinghome.data.SaveData;
import com.shortcircuit.beatinghome.data.User;

public class LoginPanel extends AbstractGUI{
	Map<String, Object> model;
	static String resDir = "resources";
	LoginPanel(Map<String, Object>model) throws IOException{
		this.model= model;
		init();
	}
	
	public void init() throws IOException{
		GridBagLayout gbl_login = new GridBagLayout();
		setLayout(gbl_login);
		
		final JTextField txtUsername = new JTextField("Username...");
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.insets = new Insets(5, 5, 5, 5);
		gbc_txtUsername.anchor = GridBagConstraints.CENTER;
		gbc_txtUsername.gridx=0;
		gbc_txtUsername.gridy=0;
		gbc_txtUsername.fill= GridBagConstraints.HORIZONTAL;
		add(txtUsername, gbc_txtUsername);
		
		final JTextField txtPassword = new JTextField("Password...");
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(5, 5, 5, 5);
		gbc_txtPassword.anchor = GridBagConstraints.CENTER;
		gbc_txtPassword.gridx=0;
		gbc_txtPassword.gridy=1;
		gbc_txtPassword.fill= GridBagConstraints.HORIZONTAL;
		add(txtPassword, gbc_txtPassword);
		
		JButton btnLogin = new JButton("Login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(5, 5, 5, 5);
		gbc_btnLogin.anchor = GridBagConstraints.CENTER;
		gbc_btnLogin.gridx=0;
		gbc_btnLogin.gridy=2;
		gbc_btnLogin.fill= GridBagConstraints.HORIZONTAL;
		add(btnLogin, gbc_btnLogin);
		
		JButton btnProfile = new JButton("New Profile");
		GridBagConstraints gbc_btnProfile = new GridBagConstraints();
		gbc_btnProfile.insets = new Insets(5, 5, 5, 5);
		gbc_btnProfile.anchor = GridBagConstraints.CENTER;
		gbc_btnProfile.gridx=0;
		gbc_btnProfile.gridy=3;
		gbc_btnProfile.fill= GridBagConstraints.HORIZONTAL;
		add(btnProfile, gbc_btnProfile);
		
		final File dir = new File(resDir);
		final File flUsername = new File("resources/flUsernames.txt");
		
		btnLogin.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ArrayList<User> users = (ArrayList<User>)model.get("Users");
				String username = txtUsername.getText();
				String password = txtPassword.getText();

				boolean match=false;
				for(int i=0;i<users.size();i++){
					User temp = users.get(i);
					if(temp.getName().equals(username) && 
							temp.getPassword().equals(password)){
						match=true;
						model.put("SelectedUser", temp.getName());
					}
						
				}
				if(match)
					Main.showPanel("HomePanel");
				else
					System.out.println("No match for password/username");
			}
		});
		
		btnProfile.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*String username = txtUsername.getText();
				String password = txtPassword.getText();
				
				try {
					SaveData.saveUser(username, password);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}*/
				Main.showPanel("ProfilePanel");
				
			}
			
		});
	}
	
	

}
