package com.shortcircuit.beatinghome;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTextField;

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
		gbc_lblTitle.anchor = GridBagConstraints.WEST;
		gbc_lblTitle.gridx=0;
		gbc_lblTitle.gridy=0;
		gbc_lblTitle.gridwidth=2;
		gbc_lblTitle.fill= GridBagConstraints.HORIZONTAL;
		add(lblTitle, gbc_lblTitle);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(5, 5, 5, 5);
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.gridx=0;
		gbc_lblName.gridy=1;
		gbc_lblName.gridwidth=1;
		gbc_lblName.fill= GridBagConstraints.HORIZONTAL;
		add(lblName, gbc_lblName);
		
		JTextField txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(5, 5, 5, 5);
		gbc_txtName.anchor = GridBagConstraints.WEST;
		gbc_txtName.gridx=1;
		gbc_txtName.gridy=1;
		gbc_txtName.gridwidth=1;
		gbc_txtName.fill= GridBagConstraints.HORIZONTAL;
		add(txtName, gbc_txtName);
		
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(5, 5, 5, 5);
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.gridx=0;
		gbc_lblEmail.gridy=2;
		gbc_lblEmail.gridwidth=1;
		gbc_lblEmail.fill= GridBagConstraints.HORIZONTAL;
		add(lblEmail, gbc_lblEmail);
		
		JTextField txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.insets = new Insets(5, 5, 5, 5);
		gbc_txtEmail.anchor = GridBagConstraints.WEST;
		gbc_txtEmail.gridx=1;
		gbc_txtEmail.gridy=2;
		gbc_txtEmail.gridwidth=1;
		gbc_txtEmail.fill= GridBagConstraints.HORIZONTAL;
		add(txtEmail, gbc_txtEmail);
		
		JLabel lblLocation = new JLabel("Location");
		GridBagConstraints gbc_lblLocation = new GridBagConstraints();
		gbc_lblLocation.insets = new Insets(5, 5, 5, 5);
		gbc_lblLocation.anchor = GridBagConstraints.WEST;
		gbc_lblLocation.gridx=0;
		gbc_lblLocation.gridy=3;
		gbc_lblLocation.gridwidth=1;
		gbc_lblLocation.fill= GridBagConstraints.HORIZONTAL;
		add(lblLocation, gbc_lblLocation);
		
		JTextField txtLocation = new JTextField();
		GridBagConstraints gbc_txtLocation = new GridBagConstraints();
		gbc_txtLocation.insets = new Insets(5, 5, 5, 5);
		gbc_txtLocation.anchor = GridBagConstraints.WEST;
		gbc_txtLocation.gridx=1;
		gbc_txtLocation.gridy=3;
		gbc_txtLocation.gridwidth=1;
		gbc_txtLocation.fill= GridBagConstraints.HORIZONTAL;
		add(txtLocation, gbc_txtLocation);
		
		JLabel lblOccupation = new JLabel("Occupation");
		GridBagConstraints gbc_lblOccupation = new GridBagConstraints();
		gbc_lblOccupation.insets = new Insets(5, 5, 5, 5);
		gbc_lblOccupation.anchor = GridBagConstraints.WEST;
		gbc_lblOccupation.gridx=0;
		gbc_lblOccupation.gridy=4;
		gbc_lblOccupation.gridwidth=1;
		gbc_lblOccupation.fill= GridBagConstraints.HORIZONTAL;
		add(lblOccupation, gbc_lblOccupation);
		
		JTextField txtOccupation = new JTextField();
		GridBagConstraints gbc_txtOccupation = new GridBagConstraints();
		gbc_txtOccupation.insets = new Insets(5, 5, 5, 5);
		gbc_txtOccupation.anchor = GridBagConstraints.WEST;
		gbc_txtOccupation.gridx=1;
		gbc_txtOccupation.gridy=4;
		gbc_txtOccupation.gridwidth=1;
		gbc_txtOccupation.fill= GridBagConstraints.HORIZONTAL;
		add(txtOccupation, gbc_txtOccupation);
		
	}
}
