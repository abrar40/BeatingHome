package com.shortcircuit.beatinghome;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.shortcircuit.beatinghome.data.Environment;
import com.shortcircuit.beatinghome.data.User;

public class EnvironmentPanel extends JPanel{
	private Map<String, Object> model = new HashMap<String, Object>();
	private ArrayList<Environment> environments = new ArrayList<Environment>();
	private DefaultListModel<String> modelEnv = new DefaultListModel<String>();
	private JList<String> listEnv = new JList<String>(modelEnv);
	private String txtSlctEnv;
	private Environment selectedEnvironment;
	private JLabel lblEnv = new JLabel();
	
	EnvironmentPanel(Map<String, Object>model){
		this.model = model;
		init();
	}
	
	private void init(){
		setLayout(new GridBagLayout());
		String userName = (String) model.get("SelectedUser");
		lblEnv = (JLabel)model.get("EnvironmentTitle");
		
		//Get the environments corresponding to the user
		if(model.containsKey("Users")){
			ArrayList<User> users = (ArrayList<User>)model.get("Users");
			for(int i=0; i<users.size();i++){
				User temp = users.get(i);
				if(userName.equals(temp.getName())){
					environments = temp.getEnvironments();
					System.out.println("Environments loaded");
				}
			}
		}
		
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.gridx=0;
		gbc_btnAdd.gridy=0;
		gbc_btnAdd.weighty=Double.MIN_VALUE;
		gbc_btnAdd.weightx=1;
		gbc_btnAdd.anchor= GridBagConstraints.EAST;
		add(btnAdd, gbc_btnAdd);
		
		JButton btnDlt = new JButton("-");
		btnDlt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		GridBagConstraints gbc_btnDlt = new GridBagConstraints();
		gbc_btnDlt.gridx=1;
		gbc_btnDlt.gridy=0;
		gbc_btnDlt.weightx=Double.MIN_VALUE;
		gbc_btnDlt.weighty=Double.MIN_VALUE;
		gbc_btnDlt.anchor= GridBagConstraints.EAST;
		add(btnDlt, gbc_btnDlt);
		
		GridBagConstraints gbc_listEnv = new GridBagConstraints();
		gbc_listEnv.gridx=0;
		gbc_listEnv.gridy=1;
		gbc_listEnv.gridwidth=2;
		gbc_listEnv.fill=GridBagConstraints.BOTH;
		gbc_listEnv.insets = new Insets(5, 5, 5, 5);
		gbc_listEnv.weighty=1;
		gbc_listEnv.weightx=1;
		add(listEnv, gbc_listEnv);
		
		//Add the environments in the jlist
		if(environments!=null){
			for(int i=0;i<environments.size();i++){
				Environment temp = environments.get(i);
				System.out.println("Adding env --> "+ temp.getName());
				modelEnv.addElement(temp.getName());
			}
			listEnv.addListSelectionListener(new ListSelectionListener(){
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					if(!e.getValueIsAdjusting()){
						System.out.println("Environment ActionListener kicked off");
						int index = listEnv.getSelectedIndex();
						txtSlctEnv = modelEnv.getElementAt(index);
						lblEnv.setText(txtSlctEnv);
						lblEnv.revalidate();
						for(int j=0;j<environments.size();j++){
							Environment temp2 = environments.get(j);
							if(temp2.getName().equals(txtSlctEnv))
								selectedEnvironment = temp2;
						}
						model.put("SelectedEnvironment", selectedEnvironment);
						GroupPanel pnlGroup = (GroupPanel)model.get("GroupPanel");
						pnlGroup.reWriteListModel();
						pnlGroup.revalidate();
					}
				}
			});
			listEnv.setSelectedIndex(0);
		}
	}

}
