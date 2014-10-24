package com.shortcircuit.beatinghome;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

import com.shortcircuit.beatinghome.appliances.AbstractApplianceInterface;
import com.shortcircuit.beatinghome.data.Environment;
import com.shortcircuit.beatinghome.data.Group;
import com.shortcircuit.beatinghome.data.User;

public class HomePanel extends AbstractGUI {
	private Map<String, Object>  model;
	private ArrayList<Environment> environments = null;
	private JPanel pnlEnv = new JPanel();
	private JPanel pnlAppl = new JPanel();
	private JPanel pnlGroup = new JPanel();
	private String selectedEnv = "";
	private ButtonGroup btnGroup = new ButtonGroup();
	private Environment selectedEnvironment = new Environment();
	JLabel lblEnv;
	private boolean firstTime = true;
	
	HomePanel(Map<String, Object> model){
		this.model = model;
		init();
	}
	
	private void init(){
		GridBagLayout gbl_main = new GridBagLayout();
		setLayout(gbl_main);
		
		pnlEnv.setLayout(new BoxLayout(pnlEnv, BoxLayout.Y_AXIS));
		Border border = BorderFactory.createTitledBorder("Environments");
		pnlEnv.setBorder(border);
		GridBagConstraints gbc_pnlEnv = new GridBagConstraints();
		gbc_pnlEnv.gridx = 0;
		gbc_pnlEnv.gridy = 0;
		gbc_pnlEnv.weightx= 0.2;
		gbc_pnlEnv.weighty=1;
		gbc_pnlEnv.gridheight=3;
		gbc_pnlEnv.insets = new Insets(10,10,10,10);
		gbc_pnlEnv.anchor = GridBagConstraints.WEST;
		gbc_pnlEnv.fill=GridBagConstraints.BOTH;
		add(pnlEnv, gbc_pnlEnv);
		
		lblEnv = new JLabel(selectedEnv);
		GridBagConstraints gbc_lblEnv = new GridBagConstraints();
		gbc_lblEnv.gridx=1;
		gbc_lblEnv.gridy=0;
		gbc_lblEnv.weighty=0.1;
		gbc_lblEnv.insets = new Insets(10, 10, 10, 10);
		add(lblEnv, gbc_lblEnv);
		
		pnlAppl.setLayout(new BoxLayout(pnlAppl, BoxLayout.Y_AXIS));
		Border border1 = BorderFactory.createTitledBorder("Appliances");
		pnlAppl.setBorder(border1);
		GridBagConstraints gbc_pnlAppl = new GridBagConstraints();
		gbc_pnlAppl.gridx=1;
		gbc_pnlAppl.gridy=2;
		gbc_pnlAppl.weightx=0.5;
		gbc_pnlAppl.weighty=0.7;
		gbc_pnlAppl.insets= new Insets(10, 10, 10, 10);
		gbc_pnlAppl.fill = GridBagConstraints.BOTH;
		add(pnlAppl, gbc_pnlAppl);
		
		pnlGroup.setLayout(new BoxLayout(pnlGroup, BoxLayout.Y_AXIS));
		Border border2 = BorderFactory.createTitledBorder("Groups");
		pnlGroup.setBorder(border2);
		GridBagConstraints gbc_pnlGroup = new GridBagConstraints();
		gbc_pnlGroup.gridx=1;
		gbc_pnlGroup.gridy=1;
		gbc_pnlGroup.weightx=0.3;
		gbc_pnlGroup.weighty=0.2;
		gbc_pnlGroup.insets= new Insets(10, 10, 10, 10);
		gbc_pnlGroup.fill = GridBagConstraints.BOTH;
		add(pnlGroup, gbc_pnlGroup);
	}
	
	public void beforeshow(){
		//Implement beforeshow method
		String user = (String) model.get("SelectedUser");
		System.out.println("beforeshow is being implemented for user:" +user);
		
		pnlEnv.add(envPanel());
		//showAppliances();
		revalidate();
	}
	
	private JPanel envPanel(){
		JPanel pnlEnv = new JPanel();
		pnlEnv.setLayout(new BoxLayout(pnlEnv, BoxLayout.Y_AXIS));
		String user = (String) model.get("SelectedUser");
		
		//Get the environments corresponding to the user
		ArrayList<User> users = (ArrayList<User>)model.get("Users");
		for(int i=0; i<users.size();i++){
			User temp = users.get(i);
			if(user.equals(temp.getName())){
				environments = temp.getEnvironments();
			}
		}
		//Add the environments as radio buttons
		if(environments!=null){
			for(int i=0;i<environments.size();i++){
				Environment temp = environments.get(i);
				final JRadioButton rdbtn = new JRadioButton(temp.getName());
				rdbtn.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						selectedEnv = rdbtn.getText();
						lblEnv.setText(selectedEnv);
						lblEnv.revalidate();
						for(int j=0;j<environments.size();j++){
							Environment temp2 = environments.get(j);
							if(temp2.getName().equals(selectedEnv))
								selectedEnvironment = temp2;
						}
						groupPanel(selectedEnvironment);
					}
				});
				if(i==0){
					rdbtn.setSelected(true);
					selectedEnv = rdbtn.getText();
					lblEnv.setText(selectedEnv);
					lblEnv.revalidate();
					selectedEnvironment = temp;
					groupPanel(selectedEnvironment);
				}	
				btnGroup.add(rdbtn);
				pnlEnv.add(rdbtn);
			}
		}
		return pnlEnv;
	}
	
	private void groupPanel(Environment env){
		//Create the groups combo box
		pnlGroup.removeAll();
		pnlGroup.setLayout(new BoxLayout(pnlGroup, BoxLayout.Y_AXIS));
		ArrayList<String> al_groups = new ArrayList<String>();
		al_groups.add("None");
		ArrayList<String> groupList = env.getGroups();
		Map<String, Group> groups = (Map<String, Group>)model.get("Groups");
		Group group = null;
		for(int j=0; j<groupList.size();j++){
			group = groups.get(groupList.get(j));
			//JLabel lblGroupName = new JLabel(group.getName());
			al_groups.add(group.getName());
		}

		final JComboBox<String> cmbx = new JComboBox<String>(al_groups.toArray(new String[0]));
		cmbx.setEditable(false);
		cmbx.setSelectedIndex(0);
		cmbx.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				firstTime=false;
				showAppliances((String)cmbx.getSelectedItem());
			}
		});
		pnlGroup.add(cmbx);
		pnlGroup.revalidate();
		if(firstTime)
			showAppliances("None");
	}
	
	private void showAppliances(String name){
		pnlAppl.removeAll();
		if(name.equals("None")){
			ArrayList<String> appl = selectedEnvironment.getAppliances();
			Map<String, Object> appliances = (Map<String, Object>) model.get("Appliances");
			for(int j=0; j<appl.size(); j++){
				AbstractApplianceInterface applInf = (AbstractApplianceInterface) appliances.get(appl.get(j));
				pnlAppl.add(applPanel(applInf));
			}
		}else{
			if(name!=null){
				Group group = new Group();
				Map<String, Object> groups = (Map<String, Object>)model.get("Groups");
				for(int i=1; i<=groups.size(); i++){
					String tempID = "group-"+i;
					if(groups.containsKey(tempID)){
						Group temp = (Group) groups.get(tempID);
						if(temp.getName().equals(name))
							group=(Group) groups.get(tempID);
					}
				}
				ArrayList<String> appl = group.getAppliances();
				System.out.println("Size of the appliances in the group is " + appl.size());
				Map<String, Object> appliances = (Map<String, Object>) model.get("Appliances");
				for(int j=0; j<appl.size(); j++){
					System.out.println("Adding appliance ");
					AbstractApplianceInterface applInf = (AbstractApplianceInterface) appliances.get(appl.get(j));
					pnlAppl.add(applPanel(applInf));
				}
			}
		}
		pnlAppl.revalidate();
	}
	private JPanel applPanel(AbstractApplianceInterface appl){
		JPanel pnlAppl = new JPanel();
		pnlAppl.setLayout(new BoxLayout(pnlAppl, BoxLayout.Y_AXIS));
		
		JLabel lblName = new JLabel(appl.getName());
		String state;
		if(appl.getState())
			state="on";
		else
			state="off";
		JLabel lblState = new JLabel(state);
		
		JPanel pnlHor = new JPanel();
		pnlHor.setLayout(new BoxLayout(pnlHor, BoxLayout.X_AXIS));
		pnlHor.add(lblName);
		pnlHor.add(Box.createHorizontalStrut(20));
		pnlHor.add(lblState);
		pnlAppl.add(pnlHor);
		return pnlAppl;
	}
	
	

}
