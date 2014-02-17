/**
 * @author SEGg9
 * 
 * This class is used to generate and show a visualisation for an airport. It creates an @link Airport object, and then
 * displays it on a JPanel.
 */

package com.seg; 

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.seg.lights.*;
import com.seg.markings.*;

public class AirportVisualisation extends JPanel
{
    private static final long serialVersionUID = 1L;
    public Airport airport;
    private double scale;
    boolean init = true;
    public ArrayList<ParallelRunwayGroup> parallelGroups;
    
    public static Image digit_zero;
    public static Image digit_one;
    public static Image digit_two;
    public static Image digit_three;
    public static Image digit_four;
    public static Image digit_five;
    public static Image digit_six;
    public static Image digit_seven;
    public static Image digit_eight;
    public static Image digit_nine;
    public static Image digit_left;
    public static Image digit_center;
    public static Image digit_right;
    public boolean day = true;
    public boolean quality = true;
    
    Map <Integer, AirportComponent> mapping;
    Map <Integer, TaxiwayComponent> taxiwaymapping;
   // int[] key = { 14, 24, 34, 44, 54, 64, 74, 84, 94, 104, 114, 124, 134, 144, 154, 164 } ; //array containg the key of the hasmap objects that need to be drawn;
    														// first time when the aiport is loaded display cat3;
    ArrayList<Integer> key;
    ArrayList<Integer> taxiway_key;
    
    BufferedImage backimage;
    BufferedImage nightbackimage;
    BufferedImage concrete;
    
    public AirportVisualisation (String XMLFilename)
    {   try {
		digit_zero = ImageIO.read(new File("0.png"));
        digit_one = ImageIO.read(new File("1.png"));
        digit_two = ImageIO.read(new File("2.png"));
        digit_three = ImageIO.read(new File("3.png"));
        digit_four = ImageIO.read(new File("4.png"));
        digit_five = ImageIO.read(new File("5.png"));
        digit_six = ImageIO.read(new File("6.png"));
        digit_seven = ImageIO.read(new File("7.png"));
        digit_eight = ImageIO.read(new File("8.png"));
        digit_nine = ImageIO.read(new File("9.png"));
        digit_left = ImageIO.read(new File("l.png"));
        digit_center = ImageIO.read(new File("c.png"));
        digit_right = ImageIO.read(new File("r.png"));
        
    	backimage = ImageIO.read(new File("grass.jpg"));
    	nightbackimage = ImageIO.read(new File("grassnight.jpg"));
    	concrete = ImageIO.read(new File("concrete.png"));
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	airport = new Airport(XMLFilename);
        scale = getScale(airport.getBoundaries(), this.getSize());
//        for(Runway runway : airport.getRunway()){
//        	runway.toggleApproachDirection();
//        }
        
        key = new ArrayList<Integer>();
        taxiway_key = new ArrayList<Integer>();
        initMap();
    }
    
    public void initMap() {
    	mapping = new HashMap <Integer, AirportComponent> ();
    	taxiwaymapping = new HashMap <Integer, TaxiwayComponent> ();
    	
    	mapping.put(new Integer(0), new ApproachSimple());
    	mapping.put(new Integer(1), new ApproachSimple());
    	mapping.put(new Integer(12), new Calvert(0));
    	mapping.put(new Integer(13), new Calvert(1));
    	mapping.put(new Integer(14), new Calvert(1)); 
    	mapping.put(new Integer(21), new Papi(37));
    	mapping.put(new Integer(22), new Papi(37));
    	mapping.put(new Integer(23), new Papi(37));
    	mapping.put(new Integer(24), new Papi(37));
    	mapping.put(new Integer(32), new CentreLight(1)); 
    	mapping.put(new Integer(33), new CentreLight(2));
    	mapping.put(new Integer(34), new CentreLight(3));
    	mapping.put(new Integer(40), new EdgeLight(1));
    	mapping.put(new Integer(41), new EdgeLight(1));
    	mapping.put(new Integer(42), new EdgeLight(1));
    	mapping.put(new Integer(43), new EdgeLight(2));
    	mapping.put(new Integer(44), new EdgeLight(3));
    	mapping.put(new Integer(50), new EndLight(1));
    	mapping.put(new Integer(51), new EndLight(1));
    	mapping.put(new Integer(52), new EndLight(1));
    	mapping.put(new Integer(53), new EndLight(1));
    	mapping.put(new Integer(54), new EndLight(1));
    	mapping.put(new Integer(60), new StarterExtensionLight(1));
    	mapping.put(new Integer(61), new StarterExtensionLight(1));
    	mapping.put(new Integer(62), new StarterExtensionLight(1));
    	mapping.put(new Integer(63), new StarterExtensionLight(1));
    	mapping.put(new Integer(64), new StarterExtensionLight(1));
    	mapping.put(new Integer(70), new StopwayLighting(1));
    	mapping.put(new Integer(71), new StopwayLighting(1));
    	mapping.put(new Integer(72), new StopwayLighting(1));
    	mapping.put(new Integer(73), new StopwayLighting(1));
    	mapping.put(new Integer(74), new StopwayLighting(1));
    	mapping.put(new Integer(80), new ThresholdLight(1));
    	mapping.put(new Integer(81), new ThresholdLight(1));
    	mapping.put(new Integer(82), new ThresholdLight(1));
    	mapping.put(new Integer(83), new ThresholdLight(1));
    	mapping.put(new Integer(84), new ThresholdLight(1));
    	mapping.put(new Integer(92), new TouchdownLight(1));
    	mapping.put(new Integer(93), new TouchdownLight(1));
    	mapping.put(new Integer(94), new TouchdownLight(1)); 
    	mapping.put(new Integer(102), new AimingPoint(Configuration.CATI_REQUIRED));
    	mapping.put(new Integer(103), new AimingPoint(Configuration.CATII_REQUIRED));
    	mapping.put(new Integer(104), new AimingPoint(Configuration.CATIIIA_REQUIRED));
    	mapping.put(new Integer(110), new Edges(Configuration.CATI_REQUIRED));
    	mapping.put(new Integer(111), new Edges(Configuration.CATII_REQUIRED));
    	mapping.put(new Integer(112), new Edges(Configuration.CATIIIA_REQUIRED));
    	mapping.put(new Integer(113), new Edges(Configuration.CATIIIB_REQUIRED));
    	mapping.put(new Integer(114), new Edges(Configuration.CATIIIC_REQUIRED));
    	mapping.put(new Integer(120), new Threshold(Configuration.VISUAL_REQUIRED));
    	mapping.put(new Integer(121), new Threshold(Configuration.NONPRECISION_REQUIRED));
    	mapping.put(new Integer(122), new Threshold(Configuration.CATI_REQUIRED));
    	mapping.put(new Integer(123), new Threshold(Configuration.CATII_REQUIRED));
    	mapping.put(new Integer(124), new Threshold(Configuration.CATIIIA_REQUIRED));
    	mapping.put(new Integer(130), new PreThresholdMarking(Configuration.VISUAL_REQUIRED));
    	mapping.put(new Integer(131), new PreThresholdMarking(Configuration.NONPRECISION_REQUIRED));
    	mapping.put(new Integer(132), new PreThresholdMarking(Configuration.CATI_REQUIRED));
    	mapping.put(new Integer(133), new PreThresholdMarking(Configuration.CATII_REQUIRED));
    	mapping.put(new Integer(134), new PreThresholdMarking(Configuration.CATIIIA_REQUIRED));
    	mapping.put(new Integer(142), new TouchdownZone(Configuration.CATI_REQUIRED));
    	mapping.put(new Integer(143), new TouchdownZone(Configuration.CATII_REQUIRED));
    	mapping.put(new Integer(144), new TouchdownZone(Configuration.CATIIIA_REQUIRED));
    	mapping.put(new Integer(150), new Centreline(Configuration.VISUAL_REQUIRED));
    	mapping.put(new Integer(151), new Centreline(Configuration.NONPRECISION_REQUIRED));
    	mapping.put(new Integer(152), new Centreline(Configuration.CATI_REQUIRED));
    	mapping.put(new Integer(153), new Centreline(Configuration.CATII_REQUIRED));
    	mapping.put(new Integer(154), new Centreline(Configuration.CATIIIA_REQUIRED));
    	mapping.put(new Integer(160), new Designator(Configuration.VISUAL_REQUIRED));
    	mapping.put(new Integer(161), new Designator(Configuration.NONPRECISION_REQUIRED));
    	mapping.put(new Integer(162), new Designator(Configuration.CATI_REQUIRED));
    	mapping.put(new Integer(163), new Designator(Configuration.CATII_REQUIRED));
    	mapping.put(new Integer(164), new Designator(Configuration.CATIIIA_REQUIRED));
    	
    	taxiwaymapping.put(new Integer(0), new TaxiwayCentreline(Configuration.VISUAL_REQUIRED));
    	taxiwaymapping.put(new Integer(1), new TaxiwayCentreline(Configuration.NONPRECISION_REQUIRED));
    	taxiwaymapping.put(new Integer(2), new TaxiwayCentreline(Configuration.CATI_REQUIRED));
    	taxiwaymapping.put(new Integer(3), new TaxiwayCentreline(Configuration.CATII_REQUIRED));
    	taxiwaymapping.put(new Integer(4), new TaxiwayCentreline(Configuration.CATIIIC_REQUIRED));
    	taxiwaymapping.put(new Integer(12), new TaxiwayCentreLight(Configuration.CATI_REQUIRED));
    	taxiwaymapping.put(new Integer(13), new TaxiwayCentreLight(Configuration.CATII_REQUIRED));
    	taxiwaymapping.put(new Integer(14), new TaxiwayCentreLight(Configuration.CATIIIC_REQUIRED));
    	taxiwaymapping.put(new Integer(20), new TaxiwayEdgeLight(Configuration.VISUAL_REQUIRED));
    	taxiwaymapping.put(new Integer(21), new TaxiwayEdgeLight(Configuration.NONPRECISION_REQUIRED));
    	taxiwaymapping.put(new Integer(22), new TaxiwayEdgeLight(Configuration.CATI_REQUIRED));
    	taxiwaymapping.put(new Integer(31), new TaxiwayWigwag(Configuration.NONPRECISION_REQUIRED));
    	taxiwaymapping.put(new Integer(32), new TaxiwayWigwag(Configuration.CATI_REQUIRED));
    	taxiwaymapping.put(new Integer(33), new TaxiwayWigwag(Configuration.CATII_REQUIRED));
    	taxiwaymapping.put(new Integer(34), new TaxiwayWigwag(Configuration.CATIIIC_REQUIRED));
    	
    	//set up wigwag animation
    	new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					while(true)
					{
						Thread.sleep(500);
						((TaxiwayWigwag)(taxiwaymapping.get(new Integer(31)))).switchLights();
						((TaxiwayWigwag)(taxiwaymapping.get(new Integer(32)))).switchLights();
						((TaxiwayWigwag)(taxiwaymapping.get(new Integer(33)))).switchLights();
						((TaxiwayWigwag)(taxiwaymapping.get(new Integer(34)))).switchLights();
						//System.out.println("change");
						thisAirportVisualisation().repaint();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
    		
    	}).start();
    }
    
    private AirportVisualisation thisAirportVisualisation()
    {
    	return this;
    }
    
    public void paint (Graphics g)
    {
    	//super.paint(g);
    	//.out.println("paint");
    	scale = getScale(airport.getBoundaries(), this.getSize());
    	
    	//Lighting lighting = new Lighting(this);
    	
    	//clear the previous graphics
    	//g.setColor(daynightcolour); 
    	Graphics2D g2 = (Graphics2D) g;
    	
    	/*Grass texture*/
    	if(day){
	    	Graphics2D imageGraphics = backimage.createGraphics();
	    	imageGraphics.drawImage(backimage, null, null);
	    	Rectangle2D tile = new Rectangle2D.Double(0, 0, backimage.getWidth()/2, backimage.getHeight()/2);
	    	g2.setPaint(new TexturePaint(backimage, tile));
	    	Rectangle2D background = new Rectangle2D.Double(0, 0, this.getSize().width, this.getSize().height);
	    	g2.fill(background);
    	}
    	else
    	{
    		Graphics2D imageGraphics = nightbackimage.createGraphics();
	    	imageGraphics.drawImage(nightbackimage, null, null);
	    	Rectangle2D tile = new Rectangle2D.Double(0, 0, nightbackimage.getWidth()/2, nightbackimage.getHeight()/2);
	    	g2.setPaint(new TexturePaint(nightbackimage, tile));
	    	Rectangle2D background = new Rectangle2D.Double(0, 0, this.getSize().width, this.getSize().height);
	    	g2.fill(background);
    	}
    	
    	//g.fillRect(0,0,getSize().width,getSize().height); 
    	
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Coord centrePoint = mapAxes(airport.getBoundaries(), new Coord(0,0));
        //g2.rotate(Math.toRadians(180), scale*centrePoint.x, scale*centrePoint.y);
        try{
        	ArrayList<TaxiwaySection> taxiwaySections = airport.getTaxiwaySection();
        	for(TaxiwaySection section : taxiwaySections)
        		drawTaxiway(g2, section);
        	for(TaxiwaySection section : taxiwaySections)
            {
            	for (int i=taxiway_key.size()-1; i>=0; i--)
          		{  if (taxiwaymapping.containsValue(taxiwaymapping.get(new Integer(taxiway_key.get(i)))))
          						taxiwaymapping.get(new Integer(taxiway_key.get(i))).draw(g2, section, this); 
          		}
            }
            drawRunways(g2);
            //for(TaxiwaySection section : taxiwaySections)
        		//drawTaxiwayMarkings(g2, section);
			//lighting.draw(g2, scale);
            
            for (Runway runway : airport.getRunway())
            { 
                g2.setColor(Color.WHITE);
                Coord convCenter = mapAxes(new Coord(runway.centerX, runway.centerY));
                g2.rotate(Math.toRadians(runway.orientation), scale*convCenter.x, scale*convCenter.y);
                
                for (int i=key.size()-1; i>=0; i--)
	          		{  if (mapping.containsValue(mapping.get(new Integer(key.get(i)))))
	          						mapping.get(new Integer(key.get(i))).draw(g2, runway, this); 
	          		}
                /*
                AimingPoint aimingPoint = new AimingPoint(4);
                aimingPoint.draw(g2, runway, this);
                TouchdownZone touchdownZone = new TouchdownZone(4);
                touchdownZone.draw(g2, runway, this);
                Edges edges = new Edges(4);
                edges.draw(g2, runway, this);
                Threshold threshold = new Threshold(4);
                threshold.draw(g2, runway, this);
                g2.rotate(Math.toRadians(180), scale*convCenter.x, scale*convCenter.y);
                Designator designator = new Designator(4);
                designator.draw(g2, runway, this);
                g2.rotate(Math.toRadians(180), scale*convCenter.x, scale*convCenter.y);
                
                Centreline centreline = new Centreline(4);
                centreline.draw(g2, runway, this);
                
                new CentreLight(1).draw(g2, runway, this);
    			new ThresholdLight(1).draw(g2, runway, this);
    			new TouchdownLight(1).draw(g2, runway, this);
    			new EndLight(1).draw(g2, runway, this);
    			new EdgeLight(1).draw(g2, runway, this);
    			// each class has a draw method that actually draws every light 
    			// simple approach lights are used only for CAT I, so I didn't draw them for now
    			//ApproachSimple as = new ApproachSimple(g, scale, runway);
    			//as.draw();
    			new Calvert(1).draw(g2, runway, this);
    			new Papi(19).draw(g2, runway, this);
                g2.setColor(Color.gray);
                PreThresholdMarking prethreshold = new PreThresholdMarking();
                prethreshold.draw(g2, runway, this);
                
                new StarterExtensionLight(1).draw(g2, runway, this);
    			new StopwayLighting(1).draw(g2, runway, this); */
                
                g2.rotate(-Math.toRadians(runway.orientation), scale*convCenter.x, scale*convCenter.y);
            }
            
			
		}catch (UIDNotFoundException e){
            e.printStackTrace();
        } catch (InvalidExtensionTypeException e) {
			e.printStackTrace();
		}
    }

	public void drawRunways (Graphics2D g2) throws InvalidExtensionTypeException
    {
        ArrayList<Runway> runways = airport.getRunway();
        parallelGroups = findParallelRunways(airport.getRunway());

        for (Runway runway : runways)
        {
        	Coord convTopLeftCorner;
			convTopLeftCorner = mapAxes(runway.topLeftCorner());
			Coord convCenter = mapAxes(new Coord(runway.centerX, runway.centerY));
            g2.rotate(Math.toRadians(runway.orientation), scale*convCenter.x, scale*convCenter.y);
            Rectangle2D run = new Rectangle2D.Double(
                    scale*convTopLeftCorner.x, scale*convTopLeftCorner.y,
                    scale*runway.width, scale*runway.height);
            
            Rectangle2D topEx = new Rectangle2D.Double(
            		scale*convTopLeftCorner.x+scale*(runway.width-runway.topExtension.width)/2.0, 
            		scale*(convTopLeftCorner.y-runway.topExtension.height),
            		scale*runway.topExtension.width, 
            		scale*runway.topExtension.height);
            
            Rectangle2D botEx = new Rectangle2D.Double(
            		scale*convTopLeftCorner.x+scale*(runway.width-runway.bottomExtension.width)/2.0, 
            		scale*(convTopLeftCorner.y+runway.height),
            		scale*runway.bottomExtension.width, 
            		scale*runway.bottomExtension.height);

            /*Set concrete texture*/
            Graphics2D imageGraphics = concrete.createGraphics();
	    	imageGraphics.drawImage(concrete, null, null);
	    	Rectangle2D tile = new Rectangle2D.Double(0, 0, concrete.getWidth()/2, concrete.getHeight()/2);
	    	g2.setPaint(new TexturePaint(concrete, tile));
	    	
            g2.fill(run);
            g2.fill(topEx);
            g2.fill(botEx);
            
            if(!day)
	    	{
	    		g2.setColor(new Color(0f,0f,0f,0.7f));
	    		g2.fill(run);
	    		g2.fill(topEx);
	            g2.fill(botEx);
	    	}
            
            g2.setColor(Color.WHITE);
            g2.rotate(-Math.toRadians(runway.orientation), scale*convCenter.x, scale*convCenter.y);
        }
    }

    public void drawTaxiway (Graphics2D g2, TaxiwaySection taxiway) throws UIDNotFoundException
    {
    	TaxiwayJoin start = null;
    	TaxiwayJoin end = null;

    	/*
    	 * First we need to find the taxiwayJoin (and taxiwayRunwayJoin) objects that
    	 * the ID values in the taxiwaySections refer to, so we can retrieve their
    	 * co-ordinates.
    	 */

    	start = findTaxiwayStartJoin(taxiway);
    	end = findTaxiwayEndJoin(taxiway);
    	/*
    	 * If one of the IDs does not match up to an object, an exception is thrown. This would
    	 * suggest an error in the definition of an airport in the XML file.
    	 */
    	 if (start == null || end == null)
    	 {
    		 throw new UIDNotFoundException();
    	 }
    	 else
    	 {
    		 //First convert the start and end points of the section to JPanel friendly co-ordinates.
    		 Coord convStart = mapAxes(new Coord(start.joinX, start.joinY));
    		 Coord convEnd = mapAxes(new Coord(end.joinX, end.joinY));

    		 /*
    		  * Once we have the points, in order to draw the rectangle we need the length, width,
    		  * orientation, top left corner and rotation point of the taxiway, so that it can be
    		  * drawn.
    		  */
    		 Coord topLeft = mapAxes(taxiwayTopLeft(taxiway, new Coord(start.joinX, start.joinY)));
    		 double length = taxiwayLength(start, end);
    		 double orientation = taxiwayOrientation(convStart, convEnd);
    		 double width = taxiway.sectionWidth;

    		 /*
    		  * The actual drawing of a taxiway is similar to that of a runway. We rotate the axes by
    		  * the orientation found from the start point of the taxiway, draw the taxiway, then rotate
    		  * the axes back again.
    		  */
    		 g2.rotate(-orientation, scale*convStart.x, scale*convStart.y);
    		 Rectangle2D taxi = new Rectangle2D.Double(
    				 scale*topLeft.x, scale*topLeft.y,
    				 scale*width, scale*length);
    		 Ellipse2D roundCorner = new Ellipse2D.Double(
    				 scale*topLeft.x, scale*(topLeft.y+length-width/2),
    				 scale*width, scale*width);
    		 Ellipse2D roundCornerEnd = new Ellipse2D.Double(
    				 scale*topLeft.x, scale*(topLeft.y-width/2),
    				 scale*width, scale*width);

    		 /*Set concrete texture*/
             Graphics2D imageGraphics = concrete.createGraphics();
	 	     imageGraphics.drawImage(concrete, null, null);
	 	     Rectangle2D tile = new Rectangle2D.Double(0, 0, concrete.getWidth()/2, concrete.getHeight()/2);
	 	     g2.setPaint(new TexturePaint(concrete, tile));
 	    	
    		 g2.fill(taxi); 
    		 if(!(end instanceof TaxiwayRunwayJoin))
    		 {
    			 g2.fill(roundCorner);
    		 }
    		 if(!(start instanceof TaxiwayRunwayJoin))
    		 {
    			 g2.fill(roundCornerEnd);
    		 }
    		 
    		 if(!day)
 	    	{
 	    		g2.setColor(new Color(0f,0f,0f,0.7f));
 	    		g2.fill(taxi);
 	    			g2.fill(new Arc2D.Double(scale*topLeft.x, scale*(topLeft.y-width/2),
 	    					scale*width, scale*width, 0, 180, Arc2D.OPEN));
 	    			g2.fill(new Arc2D.Double(scale*(topLeft.x), scale*(topLeft.y+length-width/2),
 	    					scale*width, scale*width, 180, 180, Arc2D.OPEN));
 	    		
 	    	}
    		 g2.rotate(orientation, scale*convStart.x, scale*convStart.y);
    	 }
    }
    
    public TaxiwayJoin findTaxiwayStartJoin(TaxiwaySection section)
    {
    	int startID = section.sectionStartID;
    	
    	for (TaxiwayJoin taxiwayJoin : airport.getTaxiwayJoin())
    	{
    		if (taxiwayJoin.UID == startID)
    		{
    			return taxiwayJoin;
    		}
    	}

    	for (TaxiwayRunwayJoin taxiwayRunwayJoin : airport.getTaxiwayRunwayJoin())
    	{
    		if (taxiwayRunwayJoin.UID == startID)
    		{
    			return taxiwayRunwayJoin;
    		}
    	}
    	
    	return null;
    }
    
    public TaxiwayJoin findTaxiwayEndJoin(TaxiwaySection section)
    {
    	int endID = section.sectionEndID;
    	
    	for (TaxiwayJoin taxiwayJoin : airport.getTaxiwayJoin())
    	{
    		if(taxiwayJoin.UID == endID)
    		{
    			return taxiwayJoin;
    		}
    	}

    	for (TaxiwayRunwayJoin taxiwayRunwayJoin : airport.getTaxiwayRunwayJoin())
    	{
    		if (taxiwayRunwayJoin.UID == endID)
    		{
    			return taxiwayRunwayJoin;
    		}
    	}
    	
    	return null;
    }
    
    private void drawTaxiwayMarkings(Graphics2D g2, TaxiwaySection section) {
		
    	TaxiwayJoin start = null;
    	TaxiwayJoin end = null;
    	
    	start = findTaxiwayStartJoin(section);
    	end = findTaxiwayEndJoin(section);
    	
    	//First convert the start and end points of the section to JPanel friendly co-ordinates.
		 Coord convStart = mapAxes(new Coord(start.joinX, start.joinY));
		 Coord convEnd = mapAxes(new Coord(end.joinX, end.joinY));

		 /*
		  * Once we have the points, in order to draw the rectangle we need the length, width,
		  * orientation, top left corner and rotation point of the taxiway, so that it can be
		  * drawn.
		  */
		 Coord topLeft = mapAxes(taxiwayTopLeft(section, new Coord(start.joinX, start.joinY)));
		 double length = taxiwayLength(start, end);
		 double orientation = taxiwayOrientation(convStart, convEnd);
		 double width = section.sectionWidth;

		 g2.rotate(-orientation, scale*convStart.x, scale*convStart.y);
		 
		 /*
		  * Actual drawing of the markings
		  */
		 
		 if(day)
		 {
	    	g2.setColor(Color.YELLOW);
		 }
		 else
		 {
			 g2.setColor(Color.yellow.darker().darker().darker());
		 }

		 /*Centreline*/
		 final double centrelineWidth = 0.15; //the width of the centreline
		 final double clearance = 30; //the distance away the holding lines are from the joins
		 double startGapWidth; //the gap needed in the centreline at the start of the taxiway
		 double endGapWidth; //the gap needed in the centreline at the end of the taxiway
		 double startRunwayWidth = 0; //the width of the runway at the start of the taxiway
		 double endRunwayWidth = 0; //the width of the runway at the end of the taxiway
		 double curveDistance = 1;
		 if(start instanceof TaxiwayRunwayJoin) //if the start joins to a runway
		 {
			 startGapWidth = 2.85;
			 for(Runway runway : airport.getRunway()) //find the runway and get its width
			 {
				 if(runway.UID == ((TaxiwayRunwayJoin)start).joinRunway)
				 {
					 startRunwayWidth = runway.runwayWidth;
				 }
			 }
		 }
		 else //if the start joins to another taxiway
		 {
			 startGapWidth = 2.1;
		 }
		 if(end instanceof TaxiwayRunwayJoin) //if the end joins to a runway
		 {
			 endGapWidth = 2.85;
			 for(Runway runway : airport.getRunway()) //find the runway and get its width
			 {
				 if(runway.UID == ((TaxiwayRunwayJoin)end).joinRunway)
				 {
					 endRunwayWidth = runway.runwayWidth;
				 }
			 }
		 }
		 else //if the end joins to another taxiway
		 {
			 endGapWidth = 2.1;
		 }
		 
		 //There are three components of the centreline, since gaps are needed for the holding lines.
		 //start to first holding line
		 g2.fill(new Rectangle2D.Double((scale*(topLeft.x + width/2 - centrelineWidth/2)), 
				 (scale*topLeft.y), 
				 (scale*centrelineWidth), 
				 (scale*(clearance - startGapWidth/2 + startRunwayWidth/2))));
		 //middle line
		 g2.fill(new Rectangle2D.Double((scale*(topLeft.x + width/2 - centrelineWidth/2)), 
				 (scale*(topLeft.y + clearance + startGapWidth/2 + startRunwayWidth/2)), 
				 (scale*centrelineWidth), 
				 (scale*(length - clearance*2 - startGapWidth/2 - endGapWidth/2 - startRunwayWidth/2 - endRunwayWidth/2))));
		 //second holding line to end
		 g2.fill(new Rectangle2D.Double((scale*(topLeft.x + width/2 - centrelineWidth/2)), 
				 (scale*(topLeft.y + length - (clearance - endGapWidth/2 + endRunwayWidth/2))), 
				 (scale*centrelineWidth), 
				 (scale*(clearance - endGapWidth/2 + endRunwayWidth/2))));

		 /*holding lines*/
		 final double intermediateLineWidth = 0.3; //width of intermediate holding line marking
		 final double finalLineWidth = 0.15; //width of 'pattern A' holding line marking
		 final double lineLength = 0.9; //length of dotted lines
		 int noOfLines = ((int)(width/lineLength)/2); //amount of lines needed to cover width of taxiway
		 
		 //these two variables help to centre the marking over the width of the runway
		 final double totalLength = (noOfLines*2-1)*lineLength;
		 final double offset = (width - totalLength) / 2;

		 if(start instanceof TaxiwayRunwayJoin) //if the start joins to a runway
		 {
			 //see Chapter 7 Page 33 of CAP168 to see these markings
			 for(int i = 0; i < noOfLines ; i++)
			 {
				 //draw the two dotted lines
				 g2.fill(new Rectangle2D.Double((scale*(topLeft.x + i*lineLength*2 + offset)), 
						 (scale*(topLeft.y + startRunwayWidth/2 + clearance - startGapWidth/2 + lineLength)), 
						 (scale*lineLength), 
						 (scale*finalLineWidth)));
				 g2.fill(new Rectangle2D.Double((scale*(topLeft.x + i*lineLength*2 + offset)), 
						 (int)(scale*(topLeft.y + startRunwayWidth/2 + clearance - startGapWidth/2 + lineLength + 2*finalLineWidth)), 
						 (int)(scale*lineLength), 
						 (int)(scale*finalLineWidth)));
			 }
			 //draw the two solid lines
			 g2.fill(new Rectangle2D.Double((scale*(topLeft.x)), 
					 (int)(scale*(topLeft.y + startRunwayWidth/2 + clearance - startGapWidth/2 + lineLength + 4*finalLineWidth)), 
					 (int)(scale*width),
					 (int)(scale*finalLineWidth)));
			 g2.fill(new Rectangle2D.Double((scale*(topLeft.x)), 
					 (int)(scale*(topLeft.y + startRunwayWidth/2 + clearance - startGapWidth/2 + lineLength + 6*finalLineWidth)), 
					 (int)(scale*width),
					 (int)(scale*finalLineWidth)));
		 }
		 else //if the start joins to another taxiway
		 {
			 for(int i = 0; i < noOfLines ; i++)
			 {
				 //draw dotted line
				 g2.fill(new Rectangle2D.Double((scale*(topLeft.x + i*lineLength*2 + offset)), 
						 (scale*(topLeft.y + clearance - intermediateLineWidth/2)), 
						 (scale*lineLength), 
						 (scale*intermediateLineWidth)));
			 }
		 }
		 if(end instanceof TaxiwayRunwayJoin) //if the end joins to a runway
		 {
			 //draw two solid lines
			 g2.fill(new Rectangle2D.Double((scale*(topLeft.x)), 
					 (scale*(topLeft.y + length - (endRunwayWidth/2 + clearance + endGapWidth/2 - lineLength))), 
					 (scale*width),
					 (scale*finalLineWidth)));
			 g2.fill(new Rectangle2D.Double((scale*(topLeft.x)), 
					 (scale*(topLeft.y + length - (endRunwayWidth/2 + clearance + endGapWidth/2 - lineLength - 2*finalLineWidth))), 
					 (scale*width),
					 (scale*finalLineWidth)));
			 for(int i = 0; i < noOfLines ; i++)
			 {
				 //draw two dotted lines
				 g2.fill(new Rectangle2D.Double((scale*(topLeft.x + i*lineLength*2 + offset)), 
						 (scale*(topLeft.y + length - (endRunwayWidth/2 + clearance + endGapWidth/2 - lineLength - 4*finalLineWidth))), 
						 (scale*lineLength), 
						 (scale*finalLineWidth)));
				 g2.fill(new Rectangle2D.Double((scale*(topLeft.x + i*lineLength*2 + offset)), 
						 (scale*(topLeft.y + length - (endRunwayWidth/2 + clearance + endGapWidth/2 - lineLength - 6*finalLineWidth))), 
						 (scale*lineLength), 
						 (scale*finalLineWidth)));
			 }
		 }
		 else //if end joins to another taxiway
		 {
			 for(int i = 0; i < noOfLines ; i++)
			 {
				 //draw dotted line
				 g2.fill(new Rectangle2D.Double((scale*(topLeft.x + i*lineLength*2 + offset)), 
						 (scale*(topLeft.y + length - clearance - intermediateLineWidth/2)), 
						 (scale*lineLength), 
						 (scale*intermediateLineWidth)));	 
			 }
		 }
		 
		 /*Curves*/
		 
		 g2.setStroke(new BasicStroke(1));
		 
		 if(start instanceof TaxiwayRunwayJoin)
		 {
		 }
		 if(end instanceof TaxiwayRunwayJoin)
		 {
//			 Coord leftArcBox = new Coord(start.joinX - 5, start.joinY - curveDistance);
//			 Coord rightArcBox = new Coord(start.joinX, start.joinY - curveDistance);
//			 
//			 leftArcBox = mapAxes(leftArcBox);
//			 rightArcBox = mapAxes(rightArcBox);
//			 
//			 g2.drawArc((int)(scale*leftArcBox.x), (int)(scale*leftArcBox.y), (int)(scale*5),  (int)(scale*5), 0, 90);
//			 g2.drawArc((int)(scale*rightArcBox.x), (int)(scale*rightArcBox.y),  (int)(scale*5),  (int)(scale*5), 90, 90);
			 
		 }

		 g2.rotate(orientation, scale*convStart.x, scale*convStart.y);
	}
    
    //works out the top left corner of the taxiway
    public Coord taxiwayTopLeft(TaxiwaySection ts, Coord start)
    {
    	return new Coord(start.x - (ts.sectionWidth/2), start.y);
    }
    
    //works out the length of the taxiway using pythagoras
    public double taxiwayLength(TaxiwayJoin start, TaxiwayJoin end)
    {
    	return Math.sqrt(Math.pow(start.joinX-end.joinX,2) + Math.pow(start.joinY-end.joinY, 2));
    }
    
    //works out the orientation of the taxiway from the line pointing south.
    public double taxiwayOrientation(Coord s, Coord e)
    {
    	if (e.x > s.x && s.y >= e.y)
        {
        	return Math.atan((s.y-e.y)/(e.x-s.x)) + Math.toRadians(90);
        }
        else if (e.x >= s.x && s.y < e.y)
        {
        	return Math.atan((e.x-s.x)/(e.y-s.y));
        }
        else if (e.x < s.x && s.y <= e.y)
        {
        	return Math.atan((e.y-s.y)/(s.x-e.x)) + Math.toRadians(270);
        }
        else
        {
        	return Math.atan((s.x-e.x)/(s.y-e.y)) + Math.toRadians(180);
        }
    }

    private double findBearing(Coord s, Coord e) //working with cartesian coordinates (as opposed to java)
    {
    	double x = e.x - s.x;
		double y = e.y - s.y;
    	if (e.x > s.x && e.y >= s.y) //quadrant 1 (0 - 90)
        {
    		return Math.toRadians(90) - Math.atan2(y, x);
        }
        else if (e.x >= s.x && e.y < s.y) //quadrant 2 (90 - 180)
        {
        	return Math.toRadians(90) + Math.abs(Math.atan2(y, x));
        }
        else if (e.x < s.x && s.y >= e.y) //quadrant 3 (180 - 270)
        {
        	return Math.toRadians(90) + Math.abs(Math.atan2(y, x));
        }
        else //quadrant 4 (270 - 360)
        {
        	return Math.toRadians(360) - (Math.atan2(y, x) - Math.toRadians(90));
        }
    }

    /*This function deals with checking if there are any parallel runways and
     returning them*/
    private ArrayList<ParallelRunwayGroup> findParallelRunways(ArrayList<Runway> runways)
    {
        ArrayList<ParallelRunwayGroup> parallel_groups = new ArrayList<ParallelRunwayGroup>();
        HashMap<Integer, ArrayList<Runway>> runwayOrientations = new HashMap<Integer, ArrayList<Runway>>();

        /*Since orientation is also based on approach direction, we need to check for any
         runways which are flipped so that these are considered a different orientation.*/
        int[] orientations = new int[runways.size()];
        /*for(int i = 0 ; i < runways.size() ; i++)
        {
            if(runways.get(i).approachDirectionIsFromTop())
                orientations[i] = (int) Math.round(runways.get(i).orientation/10) * 10;
            else
                orientations[i] = (int) Math.round((runways.get(i).orientation + 180) / 10) * 10;
        }*/

        /*Cycle through all the runways and group ones with the same orientation*/
        for(int i = 0; i < runways.size(); i++)
        {
            int orientation = orientations[i];
            if(runwayOrientations.get(orientation) == null)
            {
                ArrayList<Runway> listForOrientation = new ArrayList<Runway>();
                listForOrientation.add(runways.get(i));
                runwayOrientations.put(orientation, listForOrientation);
            }
            else
            {
                runwayOrientations.get(orientation).add(runways.get(i));
            }
        }

        /*Next cycle through all the groups and create ParallelRunwayGroup objects which
         represent which runways are the left, centre and right runways in this group*/
        for(Entry<Integer, ArrayList<Runway>> group : runwayOrientations.entrySet())
        {
        	double orientation_radians = Math.toRadians(group.getKey());
            if(group.getValue().size() > 1)
            {
                ArrayList<Runway> parallel_group = group.getValue();
                ParallelRunwayGroup currentGroup = new ParallelRunwayGroup();
                if(parallel_group.size() == 2) //if there are only two parallel runways in this group
                {
                    if(orderRunways(orientation_radians, parallel_group.get(0), parallel_group.get(1)))
                    {
                        currentGroup.addLeft(parallel_group.get(0));
                        currentGroup.addRight(parallel_group.get(1));
                    }
                    else
                    {
                        currentGroup.addLeft(parallel_group.get(1));
                        currentGroup.addRight(parallel_group.get(0));
                    }
                }
                else //any more parallel runways than three are unsupported for now
                {
                    Runway r1 = parallel_group.get(0);
                    Runway r2 = parallel_group.get(1);
                    Runway r3 = parallel_group.get(2);
                    if(orderRunways(orientation_radians, r1, r2))
                    {
                        if(orderRunways(orientation_radians, r2, r3))
                        {
                            currentGroup.addLeft(r1);
                            currentGroup.addCentre(r2);
                            currentGroup.addRight(r3);
                        }
                        else
                        {
                            if(orderRunways(orientation_radians, r1, r3))
                            {
                                currentGroup.addLeft(r1);
                                currentGroup.addCentre(r3);
                                currentGroup.addRight(r2);
                            }
                            else
                            {
                                currentGroup.addLeft(r3);
                                currentGroup.addCentre(r1);
                                currentGroup.addRight(r2);
                            }
                        }
                    }
                    else
                    {
                        if(orderRunways(orientation_radians, r2, r3))
                        {
                            if(orderRunways(orientation_radians, r1, r3))
                            {
                                currentGroup.addLeft(r2);
                                currentGroup.addCentre(r1);
                                currentGroup.addRight(r3);
                            }
                            else
                            {
                                currentGroup.addLeft(r2);
                                currentGroup.addCentre(r3);
                                currentGroup.addRight(r1);
                            }
                        }
                        else
                        {
                            currentGroup.addLeft(r3);
                            currentGroup.addCentre(r2);
                            currentGroup.addRight(r1);
                        }
                    }
                }
                parallel_groups.add(currentGroup);
            }
        }
        return parallel_groups;
    }

    /*returns true if first argument runway is to the left of the second runway*/
    private boolean orderRunways(double orientation, Runway r1, Runway r2)
    {
        Coord runway1Centre = new Coord(r1.centerX, r1.centerY);
        Coord runway2Centre = new Coord(r2.centerX, r2.centerY);
        double bearing = findBearing(runway1Centre, runway2Centre);
        double anglebound1 = bearing;
        double anglebound2 = bearing - Math.toRadians(180);
        if(anglebound2 < 0)
        {
	        if(orientation < anglebound1 || orientation >= Math.toRadians(360) + anglebound2)
	        {
	        	return false;
	        }
	        else
	        {
	        	return true;
	        }
        }
        else
        {
        	if(orientation < anglebound1 && orientation >= anglebound2)
        	{
        		return false;
        	}
        	else
        	{
        		return true;
        	}
        }
    }
    
    public void setScale(double arg){
    	scale = arg;
    }
    
    public Airport getAirport()
    {
    	return airport;
    }
    
    public double getScale(){
    	return scale;
    }
    
    public void setAirport(String filename)
    {
    	this.airport = new Airport(filename);
    	this.repaint();
    }
    
    public void toggleQuality(){
		quality = !quality;
	}
    
    /**
     * Maps the airport coordinates retrieved from file to coordinates compatible with Java Graphics.
     * @throws OutOfBoundariesException 
     */
    public Coord mapAxes(Coord point)
    {
    	Coord mappedCoords;
        double x = Math.abs(airport.getBoundaries().left) + point.x;
        double y = airport.getBoundaries().top - point.y;
        mappedCoords = new Coord(x,y);
        return mappedCoords;
    }
    
    /**
     * Decides the scale of the visualisation based on the size of the JPanel (so it all fits inside the window).
     */
    public static double getScale(Boundaries b, Dimension d){
        return Math.min(d.getWidth() / b.getWidth(), 
        		d.getHeight() / b.getHeight());
    }
}