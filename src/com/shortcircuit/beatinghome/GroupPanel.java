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

import com.shortcircuit.beatinghome.data.Environment;
import com.shortcircuit.beatinghome.data.Group;

public class GroupPanel extends JPanel{
	private Map<String, Object> model = new HashMap<String, Object>();
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JList<String> list = new JList<String>(listModel);
	private Map<String, Object> allGroups = new HashMap<String, Object>();
	private String txtSelectedGroup;
	private ArrayList<String> groups = new ArrayList<String>();
	private Group selectedGroup = new Group();
	
	GroupPanel(Map<String, Object>model){
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
		if(model.containsKey("Groups"))
			allGroups = (Map<String, Object>)model.get("Groups");
		Environment selectedEnv = (Environment) model.get("SelectedEnvironment");
		ArrayList<String> groupIDs = selectedEnv.getGroups();
		String line = "Loading groups -->";
		for(int i=0;i<groupIDs.size();i++){
			if(allGroups.containsKey(groupIDs.get(i))){
				Group group = (Group)allGroups.get(groupIDs.get(i));
				groups.add(group.getName());
				line=line+" "+group.getName();
			}
		}
		System.out.println(line);
	}

	public void reWriteListModel() {
		// TODO Auto-generated method stub
		loadData();
		listModel.removeAllElements();
		System.out.println("Adding groups to the group list now");
		//Add the groups in the jlist
		listModel.addElement("ALL APPLICATIONS");
		list.setSelectedIndex(0);
		if(groups!=null){
			for(int i=0;i<groups.size();i++){
				System.out.println("Adding group --> " + groups.get(i));
				listModel.addElement(groups.get(i));
			}
			list.addListSelectionListener(new ListSelectionListener(){
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					if(!e.getValueIsAdjusting()){
						int index = list.getSelectedIndex();
						txtSelectedGroup = listModel.getElementAt(index);
						if(txtSelectedGroup.equals("ALL APPLICATIONS"))
							model.put("GroupSelected", false);
						else
							model.put("GroupSelected", true);
						String[] ids = allGroups.keySet().toArray(new String[0]);
						for(int j=0;j<ids.length;j++){
							Group temp2 = (Group)allGroups.get(ids[j]);
							if(temp2.getName().equals(txtSelectedGroup))
								selectedGroup = temp2;
						}
						model.put("SelectedGroup", selectedGroup);
						AppliancePanel applPanel = (AppliancePanel)model.get("AppliancePanel");
						applPanel.reWriteListModel();
					}
					
				}
			});
			revalidate();
		}	
	}	

}
