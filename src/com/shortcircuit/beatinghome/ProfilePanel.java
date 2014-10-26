package com.shortcircuit.beatinghome;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.*;

import com.shortcircuit.beatinghome.data.SaveData;

public class ProfilePanel extends AbstractGUI{
	Map<String, Object> model;
	
	ProfilePanel(Map<String, Object>model){
		this.model=model;
		init();
	}
	
	private void init(){
		GridBagLayout gbl_profile = new GridBagLayout();
		setLayout(gbl_profile);
		
		JLabel lblTitle = new JLabel("CREATE YOUR PROFILE");
		lblTitle.setHorizontalAlignment(JTextField.CENTER);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(5, 5, 20, 5);
		gbc_lblTitle.anchor = GridBagConstraints.CENTER;
		gbc_lblTitle.gridx=0;
		gbc_lblTitle.gridy=0;
		gbc_lblTitle.gridwidth=5;
		//gbc_lblTitle.weightx=0.5;
		gbc_lblTitle.fill= GridBagConstraints.HORIZONTAL;
		add(lblTitle, gbc_lblTitle);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(5, 5, 5, 5);
		gbc_lblName.anchor = GridBagConstraints.CENTER;
		//gbc_lblName.gridwidth=2;
		gbc_lblName.gridx=0;
		gbc_lblName.gridy=1;
		gbc_lblName.gridwidth=1;
		//gbc_lblTitle.weightx=0.5;
		gbc_lblName.fill= GridBagConstraints.HORIZONTAL;
		add(lblName, gbc_lblName);
		
		JTextField txtName = new RoundJTextField(15,"");
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(5, 5, 5, 5);
		gbc_txtName.anchor = GridBagConstraints.CENTER;
		gbc_txtName.gridx=1;
		gbc_txtName.gridy=1;
		gbc_txtName.gridwidth=4;
		//gbc_lblTitle.weightx=0.5;
		gbc_txtName.fill= GridBagConstraints.HORIZONTAL;
		add(txtName, gbc_txtName);
		
		
		JLabel lblUser = new JLabel("Username");
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.insets = new Insets(5, 5, 5, 5);
		gbc_lblUser.anchor = GridBagConstraints.CENTER;
		gbc_lblUser.gridx=0;
		gbc_lblUser.gridy=2;
		gbc_lblUser.gridwidth=1;
		//gbc_lblTitle.weightx=0.5;
		gbc_lblUser.fill= GridBagConstraints.HORIZONTAL;
		add(lblUser, gbc_lblUser);
		
		JTextField txtUser = new RoundJTextField(15,"");
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.insets = new Insets(5, 5, 5, 5);
		gbc_txtUser.anchor = GridBagConstraints.CENTER;
		gbc_txtUser.gridx=1;
		gbc_txtUser.gridy=2;
		gbc_txtUser.gridwidth=4;
		//gbc_lblTitle.weightx=0.5;
		gbc_txtUser.fill= GridBagConstraints.HORIZONTAL;
		add(txtUser, gbc_txtUser);
		
		JLabel lblPass = new JLabel("Password");
		GridBagConstraints gbc_lblPass = new GridBagConstraints();
		gbc_lblPass.insets = new Insets(5, 5, 5, 5);
		gbc_lblPass.anchor = GridBagConstraints.CENTER;
		gbc_lblPass.gridx=0;
		gbc_lblPass.gridy=3;
		gbc_lblPass.gridwidth=1;
		gbc_lblTitle.weightx=0.5;
		gbc_lblPass.fill= GridBagConstraints.HORIZONTAL;
		add(lblPass, gbc_lblPass);
		
		JPasswordField txtPass = new RoundJPassField(15, "");
		txtPass.setEchoChar('*');
		GridBagConstraints gbc_txtPass = new GridBagConstraints();
		gbc_txtPass.insets = new Insets(5, 5, 5, 5);
		gbc_txtPass.anchor = GridBagConstraints.CENTER;
		gbc_txtPass.gridx=1;
		gbc_txtPass.gridy=3;
		gbc_txtPass.gridwidth=4;
		//gbc_lblTitle.weightx=0.5;
		gbc_txtPass.fill= GridBagConstraints.HORIZONTAL;
		add(txtPass, gbc_txtPass);
		
	
		JLabel lblEnv = new JLabel("Environement");
		GridBagConstraints gbc_lblEnv = new GridBagConstraints();
		gbc_lblEnv.insets = new Insets(5, 5, 5, 5);
		gbc_lblEnv.anchor = GridBagConstraints.CENTER;
		gbc_lblEnv.gridx=0;
		gbc_lblEnv.gridy=4;
		gbc_lblEnv.gridwidth=1;
		//gbc_lblTitle.weightx=0.5;
		gbc_lblEnv.fill= GridBagConstraints.HORIZONTAL;
		add(lblEnv, gbc_lblEnv);
		
		JTextField txtEnv = new RoundJTextField(15,"Home");
		GridBagConstraints gbc_txtEnv = new GridBagConstraints();
		gbc_txtEnv.insets = new Insets(5, 5, 5, 5);
		gbc_txtEnv.anchor = GridBagConstraints.CENTER;
		gbc_txtEnv.gridx=1;
		gbc_txtEnv.gridy=4;
		gbc_txtEnv.gridwidth=4;
		//gbc_lblTitle.weightx=0.5;
		gbc_txtEnv.fill= GridBagConstraints.HORIZONTAL;
		add(txtEnv, gbc_txtEnv);
		
		JButton butCreate = new JButton("Create Profile");
		GridBagConstraints gbc_But = new GridBagConstraints();
		gbc_But.insets = new Insets(20, 5, 5, 5);
		gbc_But.anchor = GridBagConstraints.CENTER;
		gbc_But.gridx=0;
		gbc_But.gridy=5;
		//gbc_lblTitle.weightx=0.5;
		gbc_But.gridwidth=5;
		gbc_But.gridheight=2;
		gbc_But.fill= GridBagConstraints.HORIZONTAL;
		add(butCreate, gbc_But);
		butCreate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username = txtUser.getText();
				String password = new String(txtPass.getPassword());
				String name = txtEnv.getText();
				ArrayList<String> appliances= new ArrayList<String>();
				ArrayList<String> groups =new ArrayList<String>();
				appliances.add("Light");
				groups.add("Group1");
				
				//change once function is complete
				if(false){//SaveData.UExist(username)){
					JOptionPane.showMessageDialog(null, "Username exists, please enter a different Username!");
				}else{
					try {
						SaveData.saveUser(username, password);
						SaveData.saveEnvironment(username, name, appliances, groups); //sample apps? groups?
						Main.showPanel("LoginPanel");
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				}
			}
	
		});
		
		JButton back = new JButton("Back to Login");
		GridBagConstraints gbc_back = new GridBagConstraints();
		gbc_back.insets = new Insets(5, 5, 5, 5);
		gbc_back.anchor = GridBagConstraints.CENTER;
		gbc_back.gridx=0;
		gbc_back.gridy=7;
		//gbc_lblTitle.weightx=0.5;
		gbc_back.gridwidth=5;
		gbc_back.gridheight=2;
		gbc_back.fill= GridBagConstraints.HORIZONTAL;
		add(back, gbc_back);
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main.showPanel("LoginPanel");
			}
		
		});
		
	}
}
