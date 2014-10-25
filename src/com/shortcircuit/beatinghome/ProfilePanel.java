package com.shortcircuit.beatinghome;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.*;

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
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(5, 5, 5, 5);
		gbc_lblTitle.anchor = GridBagConstraints.NORTH;
		gbc_lblTitle.gridx=0;
		gbc_lblTitle.gridy=0;
		gbc_lblTitle.gridwidth=2;
		gbc_lblTitle.fill= GridBagConstraints.HORIZONTAL;
		add(lblTitle, gbc_lblTitle);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(5, 5, 5, 5);
		gbc_lblName.anchor = GridBagConstraints.NORTH;
		//gbc_lblName.gridwidth=2;
		gbc_lblName.gridx=0;
		gbc_lblName.gridy=1;
		gbc_lblName.gridwidth=1;
		gbc_lblName.fill= GridBagConstraints.HORIZONTAL;
		add(lblName, gbc_lblName);
		
		JTextField txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(5, 5, 5, 5);
		gbc_txtName.anchor = GridBagConstraints.NORTH;
		gbc_txtName.gridx=1;
		gbc_txtName.gridy=1;
		gbc_txtName.gridwidth=5;
		gbc_txtName.fill= GridBagConstraints.HORIZONTAL;
		add(txtName, gbc_txtName);
		
		
		JLabel lblUser = new JLabel("Username");
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.insets = new Insets(5, 5, 5, 5);
		gbc_lblUser.anchor = GridBagConstraints.NORTH;
		gbc_lblUser.gridx=0;
		gbc_lblUser.gridy=2;
		gbc_lblUser.gridwidth=1;
		gbc_lblUser.fill= GridBagConstraints.HORIZONTAL;
		add(lblUser, gbc_lblUser);
		
		JTextField txtUser = new JTextField();
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.insets = new Insets(5, 5, 5, 5);
		gbc_txtUser.anchor = GridBagConstraints.NORTH;
		gbc_txtUser.gridx=1;
		gbc_txtUser.gridy=2;
		gbc_txtUser.gridwidth=5;
		gbc_txtUser.fill= GridBagConstraints.HORIZONTAL;
		add(txtUser, gbc_txtUser);
		
		JLabel lblPass = new JLabel("Password");
		GridBagConstraints gbc_lblPass = new GridBagConstraints();
		gbc_lblPass.insets = new Insets(5, 5, 5, 5);
		gbc_lblPass.anchor = GridBagConstraints.NORTH;
		gbc_lblPass.gridx=0;
		gbc_lblPass.gridy=3;
		gbc_lblPass.gridwidth=1;
		gbc_lblPass.fill= GridBagConstraints.HORIZONTAL;
		add(lblPass, gbc_lblPass);
		
		JTextField txtPass = new JTextField();
		GridBagConstraints gbc_txtPass = new GridBagConstraints();
		gbc_txtPass.insets = new Insets(5, 5, 5, 5);
		gbc_txtPass.anchor = GridBagConstraints.NORTH;
		gbc_txtPass.gridx=1;
		gbc_txtPass.gridy=3;
		gbc_txtPass.gridwidth=5;
		gbc_txtPass.fill= GridBagConstraints.HORIZONTAL;
		add(txtPass, gbc_txtPass);
		
		JButton butCreate = new JButton("Create Profile");
		GridBagConstraints gbc_But = new GridBagConstraints();
		gbc_But.insets = new Insets(5, 5, 5, 5);
		gbc_But.anchor = GridBagConstraints.NORTH;
		gbc_But.gridx=1;
		gbc_But.gridy=4;
		gbc_But.gridwidth=5;
		gbc_But.fill= GridBagConstraints.HORIZONTAL;
		add(butCreate, gbc_But);
		butCreate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			
			
		});
		
	}
}
