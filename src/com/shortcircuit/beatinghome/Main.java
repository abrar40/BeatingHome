package com.shortcircuit.beatinghome;



import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.shortcircuit.beatinghome.data.LoadData;

public class Main {
	static final Map<String, Object> model = new HashMap<String, Object>();
	private JFrame frame;
	private static JPanel cardPanel;
	private AbstractGUI current;
	private static List<AbstractGUI> panels = new ArrayList<AbstractGUI>();
	private static ArrayList<String> panelNames = new ArrayList<String>();
	
	
	Main() throws IOException{
		LoadData load = new LoadData(model);
		init();
	}
	
	public void init() throws IOException{
		frame = new JFrame("Beating Home");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		
		cardPanel = new JPanel();
		frame.getContentPane().add(cardPanel);				
		cardPanel.setLayout(new CardLayout(0, 0));
				
		//**************************CARD PANEL DECLARATIONS***************************************************
		JPanel loginPanel = new LoginPanel(model);
		loginPanel.setName("LoginPanel");
		cardPanel.add(loginPanel, "LoginPanel");
		panelNames.add("LoginPanel");
		
		JPanel profilePanel = new ProfilePanel(model);
		profilePanel.setName("ProfilePanel");
		cardPanel.add(profilePanel, "ProfilePanel");
		panelNames.add("ProfilePanel");
		
		JPanel homePanel = new HomePanel(model);
		homePanel.setName("HomePanel");
		cardPanel.add(homePanel, "HomePanel");
		panelNames.add("HomePanel");
		
		
	
		//**********************ADD PANELS TO ARRAYLIST********************************
		current = (AbstractGUI)loginPanel;
		panels.add((AbstractGUI)loginPanel);
		panels.add((AbstractGUI)profilePanel);
		panels.add((AbstractGUI)homePanel);

		
	}
	
	
	void next(){
		AbstractGUIInterface panel = current;
		try{
			panel.next();
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(cardPanel, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
		CardLayout cards = (CardLayout)cardPanel.getLayout();
		cards.next(cardPanel);
		current = panels.get(panels.indexOf(current)+1);
		revalidateButton();
	}	

	void back(){
		AbstractGUIInterface panel = current;
		try{
			panel.back();
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(cardPanel, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
		CardLayout cards = (CardLayout)cardPanel.getLayout();
		cards.previous(cardPanel);
		current = panels.get(panels.indexOf(current)-1);
		revalidateButton();
	}
	
	 public static void showPanel(String name){
		int index = panelNames.indexOf(name) ;
		AbstractGUIInterface panel = panels.get(index);
		try{
			panel.beforeshow();
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(cardPanel, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
		CardLayout cards = (CardLayout)cardPanel.getLayout();
		cards.show(cardPanel, name);
		
	}
	
	void cancel(){
		
	}
	
	void revalidateButton() {
		// TODO Auto-generated method stub
		
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window;
				
					window = new Main();
					window.frame.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}

}
