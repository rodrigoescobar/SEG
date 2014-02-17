package com.seg;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.seg.lights.Papi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JViewport;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI extends JFrame{
	public JFileChooser fc;
	private final double MAXSIZE = 10;
	AirportVisualisation airportDisplay;
	JScrollPane scroller;
	JViewport viewport;
	Runway [] run; 
	String [] runways;
	JComboBox cb2 = new JComboBox(new DefaultComboBoxModel());
	DefaultComboBoxModel cbm;
	JButton daynight = new JButton("Night");
	private JRadioButton opDesirableRadioButton;
	private JRadioButton requiredRadioButton;
	private int button=1;
	public int angle=0;
	
	Map <String, Integer> lmap;
	private int cat = -1; // the currently selected cat
	
	//runway category matrix
	private int[][] a = {   {  0,  1, -1, -1, -1 }, 
							{ -1, -1,  1, 1, 1 },
							{ -1,  0,  1, 1, 1 },
							{ -1, -1,  0, 1, 1 },
							{  1,  1,  1, 1, 1 },
							{  1,  1,  1, 1, 1 },
							{  1,  1,  1, 1, 1 },
							{  1,  1,  1, 1, 1 },
							{  1,  1,  1, 1, 1 },
							{ -1, -1,  0, 1, 1 },
							{ -1, -1,  1, 1, 1 },
							{ -1, -1,  1, 1, 1 },  
							{  1,  1,  1, 1, 1 },
							{  1,  1,  1, 1, 1 }, 
							{ -1, -1,  1, 1, 1 }, 
							{  1,  1,  1, 1, 1 }, 
							{  1,  1,  1, 1, 1 } };
	
	//taxiway category matrix
	private int[][] t = {	{  1,  1,  1,  1,  1},
							{ -1, -1,  0,  1,  1},
							{  0,  1,  1, -1, -1},
							{ -1,  1,  1,  1,  1} };
	
	
	public GUI(String airportName){
		super(airportName);
	} 

	public static void main(String[]Args){
		new GUI("AirportProject").start();
	}

	public void start(){

		final JPanel mainPanel = new JPanel(new BorderLayout());
		fc = new JFileChooser();

		airportDisplay = new AirportVisualisation("complex.xml");
		scroller = new JScrollPane(airportDisplay);
		viewport = scroller.getViewport();
		MyMouseListener listener = new MyMouseListener();
		viewport.addMouseListener(listener);
		viewport.addMouseMotionListener(listener);
		viewport.addMouseWheelListener(new MyWheelListener());
		scroller.addKeyListener(new MyKeyListener());

		run = new Runway[airportDisplay.airport.getRunway().size()];
		runways = new String[airportDisplay.airport.getRunway().size()];

		JSlider slider = new JSlider(JSlider.HORIZONTAL, 10, 80, 40);
		slider.setMajorTickSpacing(15);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		final JPanel airportPanel = new JPanel(new BorderLayout());
		final JPanel optionListPanel = new JPanel();
		final GridBagConstraints c = new GridBagConstraints();
		final JPanel optionPanel = new JPanel(new BorderLayout());
		JPanel optionsLabelPanel = new JPanel();
		JLabel optionLabel = new JLabel("Options");
		optionsLabelPanel.add(optionLabel);

		Border border = new EmptyBorder(10, 10, 10, 10);
		Border etchedBorder = new EtchedBorder();

		final JLabel airportNameLabel = new JLabel(airportDisplay.getAirport().getAirportName(), JLabel.CENTER);

		String [] types = {"Blank", "Visual", "Non-precision", "Cat I", "Cat II", "Cat III"};
		final JComboBox cb = new JComboBox(types); 
		
		
		ActionListener buttonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((JRadioButton) e.getSource()).getText().equals("Required")) button=1;
				else button=0;
				airportDisplay.key=new ArrayList<Integer>();
			    if (cat!=-1) 
			    	{ for (int i=0; i<a.length; i++)
			    			if (a[i][cat]==1) airportDisplay.key.add(i*10+cat);
			    	  if (button==0)
			    		 for (int i=0; i<a.length; i++)
			    			 if (a[i][cat]==0) airportDisplay.key.add(i*10+cat);
			    	}
			    airportDisplay.taxiway_key=new ArrayList<Integer>();
			    if (cat!=-1) 
		    	{ for (int i=0; i<t.length; i++)
		    			if (t[i][cat]==1) airportDisplay.taxiway_key.add(i*10+cat);
		    	  if (button==0)
		    		 for (int i=0; i<t.length; i++)
		    			 if (t[i][cat]==0) airportDisplay.taxiway_key.add(i*10+cat);
		    	}
			    airportDisplay.repaint();
			    scroller.requestFocusInWindow();
		} };
		
		final JRadioButton requiredRadioButton = new JRadioButton("Required");
		requiredRadioButton.setSelected(true);
		JRadioButton opDesirableRadioButton = new JRadioButton("Operational Desirable");
		opDesirableRadioButton.addActionListener(buttonListener);
		requiredRadioButton.addActionListener(buttonListener);
		
		ButtonGroup group2 = new ButtonGroup();
		group2.add(requiredRadioButton);
		group2.add(opDesirableRadioButton);		

		JPanel group2Panel = new JPanel(new GridLayout(0,1));
		group2Panel.add(requiredRadioButton);
		group2Panel.add(opDesirableRadioButton);


		getApproachDirection();

		cb2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String str2 = (String) cb2.getSelectedObjects()[0];
				//System.out.println(str2);
				//System.out.println(str2.substring(7,8));
				int no = Integer.parseInt(str2.substring(7,8));
				//System.out.println(run[no-1].height);
				run[no-1].toggleApproachDirection();
				//System.out.println("toggled");
				repaint();
                // Return focus to the airport scroller to enable key listeners
                scroller.requestFocusInWindow();
			}
		});
		
		JButton glossaryBtn = new JButton("Glossary");
		glossaryBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Glossary();
		    scroller.requestFocusInWindow();
			}
			
		});
		
		lmap = new HashMap <String, Integer>();
		lmap.put("Approach Simple Lights",new Integer(1));
		lmap.put("Calvert Lights",new Integer(14));
		lmap.put("Papi Lights",new Integer(24));
		lmap.put("Centre Lights",new Integer(34));
		lmap.put("Edge Lights",new Integer(44));
		lmap.put("End Lights",new Integer(54));
		lmap.put("Starter Extension Lights",new Integer(64));
		lmap.put("Stopway Lights",new Integer(74));
		lmap.put("Threshold Lights",new Integer(84));
		lmap.put("Touchdown Zone Light",new Integer(94));
		lmap.put("AimingPoint Markings",new Integer(104));
		lmap.put("Edge Markings",new Integer(114));
		lmap.put("Threshold Markings",new Integer(124));
		lmap.put("PreThreshold Markings",new Integer(134));
		lmap.put("Touchdown Zone Markings",new Integer(144));
		lmap.put("Centre Line Markings",new Integer(154));
		lmap.put("Designator Markings",new Integer(164));
		
		String [] lightsArray = {"Approach Simple Lights", "Calvert Lights", "Papi Lights", "Centre Lights","Edge Lights", 
				"End Lights", "Starter Extension Lights", "Stopway Lights", "Threshold Lights", "Touchdown Zone Light"}; 
		String [] markingsArray = {"AimingPoint Markings", "Edge Markings", "Threshold Markings", "PreThreshold Markings", 
					"Touchdown Zone Markings", "Centre Line Markings", "Designator Markings" };
		JComboBox lights = new JComboBox(lightsArray);
		JComboBox markings = new JComboBox(markingsArray);
		
		ActionListener CbListener = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				airportDisplay.key=new ArrayList<Integer>();
				airportDisplay.taxiway_key=new ArrayList<Integer>();
				//cb.setSelectedIndex(5);
			   // button=1;
			    //requiredRadioButton.setSelected(true);
				JComboBox box = (JComboBox)e.getSource();
		        String component = (String) box.getSelectedItem();
		        airportDisplay.key.add(lmap.get(component));
		        airportDisplay.repaint();
				scroller.requestFocusInWindow();	
			}
		};
		
		markings.addActionListener(CbListener);
		lights.addActionListener(CbListener);
		
		ChangeListener sliderListener = new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider)e.getSource();
			    if (!source.getValueIsAdjusting()) 
			    	{ angle = (int)source.getValue();
			    	  airportDisplay.mapping.put(new Integer(21),new Papi(angle));
			    	  airportDisplay.mapping.put(new Integer(22),new Papi(angle));
			    	  airportDisplay.mapping.put(new Integer(23),new Papi(angle));
			    	  airportDisplay.mapping.put(new Integer(24),new Papi(angle));
			    	  repaint();
			    	}
			    scroller.requestFocusInWindow();
			    //System.out.println(angle);
	    } };
	    
		slider.addChangeListener(sliderListener);
		
		JPanel another = new JPanel(new GridLayout(14,1));
		another.add(cb);
		another.add(requiredRadioButton);
		another.add(opDesirableRadioButton);
		another.add(new JLabel("Change approach direction on:"));
		another.add(cb2);
		another.add(new JLabel("View airport lights at:"));
		another.add(daynight);
		another.add(new JLabel("Approach angle:"));
		another.add(slider);
		
		another.add(glossaryBtn);
		another.add(new JLabel("Display individual lights:"));
		another.add(lights);
		another.add(new JLabel("Display individual markings:"));
		another.add(markings);
		
		/*JPanel secondGrid = new JPanel(new GridLayout(2,1));
		secondGrid.add(another);
		
		JPanel sliderPanel = new JPanel(new GridLayout(7,1,10,5));
		sliderPanel.add(new JLabel("Approach angle:"));
		sliderPanel.add(slider);
		secondGrid.add(sliderPanel);
		sliderPanel.add(glossaryBtn);
		sliderPanel.add(lights);
		sliderPanel.add(markings);*/
		
		daynight.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (daynight.getText().equals("Night")){
					daynight.setText("Day");
					airportDisplay.day = false;
					repaint();
				}else{
					daynight.setText("Night");
					airportDisplay.day = true;
					repaint();
				}
				// Return focus to the airport scroller to enable key listeners
                scroller.requestFocusInWindow();
			}});
		optionListPanel.add(another);
		cb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = (String) cb.getSelectedObjects()[0]; 
				//System.out.println(str);
				
				cat=-1;
				if(str.equals("Visual")) {   cat=0;  }
				else if(str.equals("Non-precision")) {   cat=1; }
					 else if(str.equals("Cat I")) {  cat=2; }
					 	  else if(str.equals("Cat II")) {   cat=3; }
					 	  	   else if(str.equals("Cat III")) {   cat=4; }
					 	  	   		 
				// matrices -> update keys array in AirportVisualisation
				airportDisplay.key=new ArrayList<Integer>();
				if (cat!=-1) 
		    	{ for (int i=0; i<a.length; i++)
		    			if (a[i][cat]==1) airportDisplay.key.add(i*10+cat);
		    	  if (button==0)
		    		 for (int i=0; i<a.length; i++)
		    			 if (a[i][cat]==0) airportDisplay.key.add(i*10+cat);
		    	}
				airportDisplay.taxiway_key=new ArrayList<Integer>();
				if (cat!=-1) 
		    	{ for (int i=0; i<t.length; i++)
		    			if (t[i][cat]==1) airportDisplay.taxiway_key.add(i*10+cat);
		    	  if (button==0)
		    		 for (int i=0; i<t.length; i++)
		    			 if (t[i][cat]==0) airportDisplay.taxiway_key.add(i*10+cat);
		    	}
				airportDisplay.repaint();
				
                // Return focus to the airport scroller to enable key listeners
                scroller.requestFocusInWindow();
		} });
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		//JMenu helpMenu = new JMenu("Help");
		JMenuItem loadItem = new JMenuItem("Load new airport");
		JMenuItem quality = new JMenuItem("Toggle lighting quality");
		//JMenuItem decorateItem = new JMenuItem("Decorate airport");
		//JMenuItem aboutItem = new JMenuItem("About");


		menuBar.add(fileMenu);
		//menuBar.add(helpMenu);
		fileMenu.add(loadItem);
		fileMenu.add(quality);
		//fileMenu.add(decorateItem);
		//helpMenu.add(aboutItem);

		JPanel airportNamePanel = new JPanel();
		airportNamePanel.add(airportNameLabel);
		airportNamePanel.setBorder(etchedBorder);
		airportPanel.add(scroller, BorderLayout.CENTER);
		airportPanel.add(airportNamePanel, BorderLayout.NORTH);


		mainPanel.setBorder(border);
		mainPanel.setBackground(Color.BLACK);

		airportPanel.setBackground(Color.BLACK);
		optionsLabelPanel.setBorder(etchedBorder);
		optionListPanel.setBorder(border);
		optionPanel.setBorder(border);
		group2Panel.setBorder(etchedBorder);

		optionPanel.add(optionsLabelPanel, BorderLayout.NORTH);
		optionPanel.add(optionListPanel, BorderLayout.CENTER);
		//optionPanel.add(group2Panel, BorderLayout.SOUTH);

		mainPanel.add(airportPanel, BorderLayout.CENTER);
		mainPanel.add(optionPanel, BorderLayout.EAST);

		loadItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int returnval = fc.showOpenDialog(GUI.this);
				if(returnval == JFileChooser.APPROVE_OPTION){
					File file = fc.getSelectedFile();
					String fileName = file.getName();
					//scroller.remove(airportDisplay);
					airportDisplay.setAirport(fileName);
					//scroller.add(airportDisplay);
					scroller.validate();

					requiredRadioButton.setSelected(true);
					airportNameLabel.setText(airportDisplay.getAirport().getAirportName());
					getApproachDirection();
					//mainPanel.add(scroller, BorderLayout.CENTER);
					//System.out.println("done");
					airportDisplay.repaint();
				}
                // Return focus to the airport scroller to enable key listeners
                scroller.requestFocusInWindow();
			}});
		quality.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				airportDisplay.toggleQuality();
				airportDisplay.repaint();
			}
		});
		this.setJMenuBar(menuBar);
		this.setMinimumSize(new Dimension(1024,780));
		this.setContentPane(mainPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		scroller.requestFocus();
	}

		public void getApproachDirection(){
			runways = new String[airportDisplay.airport.getRunway().size()];
			run = new Runway[airportDisplay.airport.getRunway().size()];
			for (int i = 0; i<airportDisplay.airport.getRunway().size(); i++){
				run[i] = airportDisplay.airport.getRunway().get(i);
				runways[i] = "Runway "+(i+1);}
			cbm = new DefaultComboBoxModel(runways);
			cb2.setModel(cbm);
		}

		private Point newViewpoint(Point viewpoint, double oldScale, double newScale){
			double oldCenterX = viewpoint.x + 0.5*viewport.getWidth();
			double oldCenterY = viewpoint.y + 0.5*viewport.getHeight();
			double centerXRatio = oldCenterX / (airportDisplay.getAirport().getBoundaries().getWidth()*oldScale);
			double centerYRatio = oldCenterY / (airportDisplay.getAirport().getBoundaries().getHeight()*oldScale);
			double newCenterX = centerXRatio*airportDisplay.getAirport().getBoundaries().getWidth()*newScale;
			double newCenterY = centerYRatio*airportDisplay.getAirport().getBoundaries().getHeight()*newScale;
			int xOffset = (int) (newCenterX - oldCenterX);
			int yOffset = (int) (newCenterY - oldCenterY);
			viewpoint.translate(xOffset, yOffset);
			return viewpoint;
		}

		class MyMouseListener extends MouseAdapter{
			private final Cursor defultCursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
			private final Cursor handCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
			private final Point point = new Point();

			public void mouseDragged(final MouseEvent e) {
				Point viewpoint = scroller.getViewport().getViewPosition();
				viewpoint.translate(point.x-e.getPoint().x, point.y-e.getPoint().y);
				//set drag boarder
				if(viewpoint.x<0) viewpoint.x=0;
				if(viewpoint.x>airportDisplay.getWidth()-viewport.getWidth()) 
					viewpoint.x = airportDisplay.getWidth()-viewport.getWidth();
				if(viewpoint.y<0) viewpoint.y=0;
				if(viewpoint.y>airportDisplay.getHeight()-viewport.getHeight()) 
					viewpoint.y = airportDisplay.getHeight()-viewport.getHeight();

				viewport.setViewPosition(viewpoint);
				point.setLocation(e.getPoint());
			}

			public void mousePressed(MouseEvent e) {
				airportDisplay.setCursor(handCursor);
				point.setLocation(e.getPoint());
			}

			public void mouseReleased(MouseEvent e) {
				airportDisplay.setCursor(defultCursor);
				//airportDisplay.repaint();
			}
		}

		class MyKeyListener extends KeyAdapter{
			private final int offset = 30;	

			public void keyPressed(KeyEvent e){

				Point viewpoint = scroller.getViewport().getViewPosition();
				double oldScale = airportDisplay.getScale();
				double newScale = oldScale;
				
				airportDisplay.setVisible(false);

				switch(e.getKeyCode()){

				case KeyEvent.VK_MINUS: case 109:
					airportDisplay.setScale(newScale = oldScale*0.8);
					viewpoint = newViewpoint(viewpoint, oldScale, newScale);			
					break;
				case KeyEvent.VK_EQUALS: case 107: 
					if(oldScale>MAXSIZE) break;
					airportDisplay.setScale(newScale = oldScale*1.2);
					viewpoint = newViewpoint(viewpoint, oldScale, newScale);
					break;

				case KeyEvent.VK_UP:
					viewpoint.translate(0, -offset);
					if(viewpoint.y<0) viewpoint.y = 0;
					break;
				case KeyEvent.VK_DOWN:
					viewpoint.translate(0, offset);
					if(viewpoint.y>airportDisplay.getHeight()-viewport.getHeight())
						viewpoint.y = airportDisplay.getHeight()-viewport.getHeight();
					break;
				case KeyEvent.VK_LEFT:
					viewpoint.translate(-offset, 0);
					if(viewpoint.x<0) viewpoint.x = 0;
					break;
				case KeyEvent.VK_RIGHT:
					viewpoint.translate(offset, 0);
					if(viewpoint.x>airportDisplay.getWidth()-viewport.getWidth()) 
						viewpoint.x = airportDisplay.getWidth()-viewport.getWidth();
					break;
				}

				//update the scroll pane
				airportDisplay.setPreferredSize(new Dimension(
						(int)(airportDisplay.getAirport().getBoundaries().getWidth()*newScale), 
						(int)(airportDisplay.getAirport().getBoundaries().getHeight()*newScale)));
				airportDisplay.revalidate();
				viewport.setViewPosition(viewpoint);
				viewport.setViewPosition(viewpoint);
				scroller.setViewport(viewport);
				airportDisplay.setVisible(true);
			}
		}

		class MyWheelListener implements MouseWheelListener{

			public void mouseWheelMoved(MouseWheelEvent e) {
				double oldScale = airportDisplay.getScale();
				double newScale;
				if(e.getWheelRotation()<0 && oldScale>MAXSIZE) return;

				airportDisplay.setVisible(false);
				newScale = oldScale*(1+e.getWheelRotation()*-0.2);
				airportDisplay.setScale(newScale);
				//update the scroll pane
				airportDisplay.setPreferredSize(new Dimension(
						(int)(airportDisplay.getAirport().getBoundaries().getWidth()*newScale),
						(int)(airportDisplay.getAirport().getBoundaries().getHeight()*newScale)));
				airportDisplay.revalidate();

				Point viewpoint = scroller.getViewport().getViewPosition();		
				viewpoint = newViewpoint(viewpoint, oldScale, newScale);
				viewport.setViewPosition(viewpoint);
				viewport.setViewPosition(viewpoint);
				scroller.setViewport(viewport);
				airportDisplay.setVisible(true);
			}
		}
	}
