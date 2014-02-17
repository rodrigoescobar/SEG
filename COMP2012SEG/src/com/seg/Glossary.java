package com.seg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Glossary extends JFrame{
	
	//FOR DEBUGGING ONLY
	public static void main(String[] args)
	{
		new Glossary();
	}
	
	private JTextField userEntry;
	private JList options;
	private JTextArea output;
	private HashMap<String, String> database;
	private DefaultListModel listModel;
	ArrayList<String> keys = new ArrayList<String>();
	String [] optionArray;
	
	public Glossary()
	{
		super("Glossary");
		database = new HashMap<String, String>();
		
		try {
			readInDatabase("db.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i<database.size(); i++){
			optionArray[i] = keys.get(i);
		}
		listModel = new DefaultListModel();
		
		userEntry = new JTextField();
		options = new JList(optionArray);
		output = new JTextArea("Information will appear here", 25, 35);
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel inputPanel = new JPanel(new BorderLayout());
		JPanel outputPanel = new JPanel();
		outputPanel.setBackground(Color.WHITE);
		JScrollPane inputScrollPane = new JScrollPane(inputPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollPane outputScrollPane = new JScrollPane(outputPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		outputScrollPane.setSize(300, 500);
		mainPanel.add(inputScrollPane, BorderLayout.WEST);
		mainPanel.add(outputScrollPane, BorderLayout.CENTER);
		
		inputPanel.add(userEntry, BorderLayout.PAGE_START);
		inputPanel.add(options, BorderLayout.CENTER);
		outputPanel.add(output);
		
		int i = 0;
		for(String entry : database.keySet())
		{
			listModel.add(i, entry);
			i++;
		}
		
		options.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				output.setText(database.get(optionArray[options.getLeadSelectionIndex()]));
			}
		});

		this.setMinimumSize(new Dimension(700,500));
		this.setContentPane(mainPanel);
		this.setVisible(true);
	}
	
	private void readInDatabase(String filename) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		
		String[] entry;
		String line = reader.readLine();
		while(line != null)
		{
			entry = line.split("%");
			
			database.put(entry[0], entry[1]);
			keys.add(entry[0]);
			line = reader.readLine();
		}
		optionArray = new String[database.size()];
	}
}