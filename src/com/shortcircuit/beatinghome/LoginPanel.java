package com.shortcircuit.beatinghome;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
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
		
		final JTextField txtUsername = new RoundJTextField(15, "Username...");
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.insets = new Insets(5, 5, 5, 5);
		gbc_txtUsername.anchor = GridBagConstraints.CENTER;
		gbc_txtUsername.gridx=0;
		gbc_txtUsername.gridy=0;
		gbc_txtUsername.fill= GridBagConstraints.HORIZONTAL;
		add(txtUsername, gbc_txtUsername);
		txtUsername.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtUsername.setText("");
            }
        });
		
		final JPasswordField txtPassword = new RoundJPassField(15,"Password...");
		txtPassword.setEchoChar('*');
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(5, 5, 5, 5);
		gbc_txtPassword.anchor = GridBagConstraints.CENTER;
		gbc_txtPassword.gridx=0;
		gbc_txtPassword.gridy=1;
		gbc_txtPassword.fill= GridBagConstraints.HORIZONTAL;
		add(txtPassword, gbc_txtPassword);
		txtPassword.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtPassword.setText("");
            }
        });
		
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
				String password = new String(txtPassword.getPassword());

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
					//System.out.println("No match for password/username");
					JOptionPane.showMessageDialog(null, "No match for password/username!");
			}
		});
		
		btnProfile.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Main.showPanel("ProfilePanel");
				
			}
			
		});
	}
	
	

}
