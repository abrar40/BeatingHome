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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.shortcircuit.beatinghome.data.Appliance;
import com.shortcircuit.beatinghome.data.Group;

public class AppliancePanel extends JPanel{
	private Map<String, Object> model = new HashMap<String, Object>();
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JList<String> list = new JList<String>(listModel);
	private Map<String, Object> allAppliances = new HashMap<String, Object>();
	private ArrayList<String> appliances = new ArrayList<String>();
	private String txtSelectedAppliance;
	private Group selectedGroup = new Group();
	
	AppliancePanel(Map<String, Object>model){
		this.model=model;
		//loadData();
		init();
	}
	
	private void init(){
		setLayout(new GridBagLayout());
		
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
		
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridx=0;
		gbc_list.gridy=1;
		gbc_list.gridwidth=2;
		gbc_list.fill=GridBagConstraints.BOTH;
		gbc_list.insets = new Insets(5, 5, 5, 5);
		gbc_list.weighty=1;
		gbc_list.weightx=1;
		add(list, gbc_list);
		
		
	}
	
	private void loadData(){
		if(model.containsKey("Appliances"))
			allAppliances = (Map<String, Object>)model.get("Appliances");
		
	}
	
	public void reWriteListModel() {
		// TODO Auto-generated method stub
		loadData();
		listModel.removeAllElements();
		
		//Add the applications in the jlist
		if(appliances!=null){
			String[] ids = allAppliances.keySet().toArray(new String[0]);
			for(int i=0;i<ids.length;i++){
				Appliance temp = (Appliance) allAppliances.get(ids[i]);
				listModel.addElement(temp.getName());
				list.addListSelectionListener(new ListSelectionListener(){
					@Override
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
						int index = list.getSelectedIndex();
						txtSelectedAppliance = listModel.getElementAt(index);
						/*
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
								JPanel pnlGroup = (JPanel)model.get("GroupPanel");
								pnlGroup.revalidate();
						 */
					}
				});
				list.setSelectedIndex(0);
			}
		}	
	}


}
