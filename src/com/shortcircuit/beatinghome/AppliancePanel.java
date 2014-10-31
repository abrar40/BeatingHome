package com.shortcircuit.beatinghome;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.shortcircuit.beatinghome.data.Appliance;
import com.shortcircuit.beatinghome.data.Environment;
import com.shortcircuit.beatinghome.data.Group;

public class AppliancePanel extends JPanel{
	private Map<String, Object> model = new HashMap<String, Object>();
	private DefaultListModel<Appliance> listModel = new DefaultListModel<Appliance>();
	private JList<Appliance> list = new JList<Appliance>(listModel);
	private ApplianceCellRenderer renderer = new ApplianceCellRenderer();
	private Map<String, Object> allAppliances = new HashMap<String, Object>();
	private ArrayList<Appliance> appliances = new ArrayList<Appliance>();
	private ArrayList<String> al_appls = new ArrayList<String>();
	private String txtSelectedAppliance;
	private Appliance selectedAppliance;
	private Group selectedGroup = new Group();
	
	AppliancePanel(Map<String, Object>model){
		this.model=model;
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
		
		list.setCellRenderer(renderer);
		JScrollPane pane = new JScrollPane(list);
		GridBagConstraints gbc_pane = new GridBagConstraints();
		gbc_pane.gridx=0;
		gbc_pane.gridy=1;
		gbc_pane.gridwidth=2;
		gbc_pane.fill=GridBagConstraints.BOTH;
		gbc_pane.insets = new Insets(5, 5, 5, 5);
		gbc_pane.weighty=1;
		gbc_pane.weightx=1;
		add(pane, gbc_pane);
		
	}
	
	private void loadData(){
		if(model.containsKey("Appliances"))
			allAppliances = (Map<String, Object>)model.get("Appliances");
		appliances=new ArrayList<Appliance>();
		boolean groupSelected;
		groupSelected = (boolean)model.get("GroupSelected");
		if(groupSelected){
			selectedGroup = (Group)model.get("SelectedGroup");
			ArrayList<String> applIDs = selectedGroup.getAppliances();
			String line = "Loading appliances -->";
			for(int i=0;i<applIDs.size();i++){
				if(allAppliances.containsKey(applIDs.get(i))){
					Appliance appl = (Appliance) allAppliances.get(applIDs.get(i));
					appliances.add(appl);
				}
			}
		}else{
			Environment selectedEnv = (Environment) model.get("SelectedEnvironment");
			ArrayList<String> applIDs = selectedEnv.getAppliances();
			String line = "Loading appliances -->";
			for(int i=0;i<applIDs.size();i++){
				if(allAppliances.containsKey(applIDs.get(i))){
					Appliance appl = (Appliance) allAppliances.get(applIDs.get(i));
					appliances.add(appl);
				}
			}
		}
	}
	
	public void reWriteListModel() {
		// TODO Auto-generated method stub
		loadData();
		listModel.removeAllElements();
		//renderer.removeAll();
		//Add the applications in the jlist
		if(appliances!=null){
			for(int i=0;i<appliances.size();i++){
				Appliance temp = appliances.get(i);
				System.out.println("Adding Appliance --> "+ temp.getName());
				listModel.addElement(temp);
			}
			list.addListSelectionListener(new ListSelectionListener(){
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
				}
			});
			list.setSelectedIndex(0);
		}	
	}
}

class ApplianceCellRenderer extends JPanel implements ListCellRenderer{
	private Appliance selectedAppliance = new Appliance();
	JLabel lblTitle;
	JLabel lblType;
	JLabel lblLocation;
	JPanel pnlControl;
	
	ApplianceCellRenderer(){
		setLayout(new GridBagLayout());
		
		lblTitle = new JLabel("");
		lblTitle.setFont(new Font("Serif", Font.BOLD, 20));
		//add(lblTitle);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridx=0;
		gbc_lblTitle.gridy=0;
		gbc_lblTitle.weightx=0.3;
		gbc_lblTitle.weighty=1;
		gbc_lblTitle.insets= new Insets(2, 2, 2, 2);
		gbc_lblTitle.anchor = GridBagConstraints.WEST;
		add(lblTitle, gbc_lblTitle);
		
		lblType = new JLabel("");
		lblType.setFont(new Font("Serif", Font.ITALIC, 16));
		lblType.setForeground(Color.LIGHT_GRAY);
		//add(lblType);
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.gridx=0;
		gbc_lblType.gridy=1;
		gbc_lblType.weightx=0.3;
		gbc_lblType.weighty=0.5;
		gbc_lblType.insets= new Insets(2, 2, 2, 2);
		gbc_lblType.anchor = GridBagConstraints.WEST;
		add(lblType, gbc_lblType);
		
		lblLocation = new JLabel("");
		lblLocation.setFont(new Font("Serif", Font.ITALIC, 16));
		lblLocation.setForeground(Color.LIGHT_GRAY);
		//add(lblLocation);
		GridBagConstraints gbc_lblLocation = new GridBagConstraints();
		gbc_lblLocation.gridx=0;
		gbc_lblLocation.gridy=2;
		gbc_lblLocation.weightx=0.3;
		gbc_lblLocation.weighty=0.5;
		gbc_lblLocation.insets= new Insets(2, 2, 2, 2);
		gbc_lblLocation.anchor = GridBagConstraints.WEST;
		add(lblLocation, gbc_lblLocation);
		
		pnlControl = new JPanel();
		GridBagConstraints gbc_pnlControl = new GridBagConstraints();
		gbc_pnlControl.gridx=1;
		gbc_pnlControl.gridy=0;
		gbc_pnlControl.weightx=1;
		gbc_pnlControl.weighty=1;
		gbc_pnlControl.gridheight=3;
		gbc_pnlControl.anchor=GridBagConstraints.EAST;
		add(pnlControl, gbc_pnlControl);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		Appliance appl = (Appliance) value;
		
		lblTitle.setText(appl.getName());
		lblLocation.setText(appl.getLocation());
		lblType.setText(appl.getType());
		
		if(appl.getType().equals("light")){
			//pnlControl.add(pnlLightControl());
		}else if(appl.getType().equals("ac")){
	
		}else if(appl.getType().equals("music")){
		
		}
		
		return this;
	}
	
	JPanel pnlLightControl(){
		JPanel pnl = new JPanel();
		//pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
		
		
		return pnl;
	}
	
}
