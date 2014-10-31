package com.shortcircuit.beatinghome;

import java.awt.Font;
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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.shortcircuit.beatinghome.data.Appliance;
import com.shortcircuit.beatinghome.data.Environment;
import com.shortcircuit.beatinghome.data.Group;
import com.shortcircuit.beatinghome.data.User;

public class HomePanel extends AbstractGUI {
	private Map<String, Object>  model;
	private ArrayList<Environment> environments = null;
	private JPanel pnlEnv = new JPanel();
	private DefaultListModel<String> modelEnv = new DefaultListModel<String>();
	private JList listEnv = new JList(modelEnv);
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
		lblEnv.setFont(new Font("Serif", Font.BOLD, 36));
		GridBagConstraints gbc_lblEnv = new GridBagConstraints();
		gbc_lblEnv.gridx=1;
		gbc_lblEnv.gridy=0;
		gbc_lblEnv.weighty=0.1;
		gbc_lblEnv.insets = new Insets(10, 10, 10, 10);
		add(lblEnv, gbc_lblEnv);
		model.put("EnvironmentTitle", lblEnv);
		
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
		GroupPanel groupPanel = new GroupPanel(model);
		pnlGroup.add(groupPanel);
		model.put("GroupPanel", groupPanel);
		AppliancePanel applPanel = new AppliancePanel(model);
		pnlAppl.add(applPanel);
		model.put("AppliancePanel", applPanel);
		EnvironmentPanel envPanel = new EnvironmentPanel(model);
		System.out.println("Adding Environment Panel");
		pnlEnv.add(envPanel);
		if(model.containsKey("SelectedEnvironment"))
			selectedEnvironment=(Environment)model.get("SelectedEnvironment");
		
		revalidate();
	}
	
}
