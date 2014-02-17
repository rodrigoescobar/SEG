package com.seg.markings;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.seg.AirportComponent;
import com.seg.AirportVisualisation;
import com.seg.Configuration;
import com.seg.Coord;
import com.seg.Runway;
import com.seg.ParallelRunwayGroup;


public class Threshold implements AirportComponent{
    // Making the assumption that precision runways are >=2... Is this correct?
    Graphics2D g;
    Runway runway;
    Configuration config;
    double lineWidth;
    double lineLength;
    double numberStripes;
    double centreWidth;
    double LDALength;

    private void setup(Graphics2D g, Runway runway, AirportVisualisation a)
    {
    	this.g = g;
        this.runway = runway;
        if (config == Configuration.VISUAL_REQUIRED || 
				config == Configuration.VISUAL_DESIRABLE || 
				config == Configuration.NONPRECISION_REQUIRED || 
				config == Configuration.NONPRECISION_DESIRABLE)
        {
        	// Confused about runway widths. When it says 45, 30, etc. in the table, does it mean >= 45? then >=30 (<45)?
            if (runway.width >= 45)
            {
                lineLength = 30;
                lineWidth = 1.8;
                numberStripes = 6;
                centreWidth = 22.5;
            }
            else if (runway.width >= 30)
            {
                lineLength = 30;
                lineWidth = 0.9;
                numberStripes = 6;
                centreWidth = 20.0;
            }
            else if (runway.width >= 23)
            {
                lineLength = 24;
                lineWidth = 0.6;
                numberStripes = 6;
                centreWidth = 16.0;
            }
            else
            {
                lineLength = 24;
                lineWidth = 0.3;
                numberStripes = 4;
                centreWidth = 15.0;
            }
            //the threshold needs to be lengthened to include a letter if it exists.
            for(ParallelRunwayGroup parallelGroup : a.parallelGroups)
            {
            	if(parallelGroup.left.UID == runway.UID || parallelGroup.right.UID == runway.UID || parallelGroup.centre.UID == runway.UID)
            	{
            		lineLength += 6;
            	}
            }
        }
        else
        {
            lineWidth = 1.8;
            centreWidth = 3.6;
            if (runway.width >= 45)
            {
                lineLength = 30;
                numberStripes = 12;
            }
            else if (runway.width >= 30)
            {
                lineLength = 30;
                numberStripes = 8;
            }
            else if (runway.width >= 23)
            {
                lineLength = 24;
                numberStripes = 6;
            }
            else
            {  
                lineLength = 24;
                numberStripes = 4;
            }   
        }
    }
    
    public Threshold (Configuration config)
    {
        this.config = config;
    }
    
    public void draw(Graphics2D g, Runway runway, AirportVisualisation a)
    {
        setup(g, runway, a);
    	
    	// LDA = runway length + starter extension (unless threshold is displaced?)
        double starterExtensionLength = 0;
        if (runway.topExtension.UID != 0) //If the top extension exists
        {
            if (runway.topExtension.type.equals("STARTER_EXTENSION")){
                starterExtensionLength = runway.topExtension.height;
            }
        }
        if (runway.bottomExtension.UID != 0) //If the bottom extension exists
        {
            if (runway.bottomExtension.type.equals("STARTER_EXTENSION")){
                starterExtensionLength = runway.topExtension.height;
            }
        }
        LDALength = starterExtensionLength + runway.height;
        if (((config == Configuration.VISUAL_REQUIRED ||
        		config == Configuration.VISUAL_DESIRABLE)
        		&& LDALength < 1200) != true)
        {
        	if(a.day)
    			g.setColor(Color.WHITE);
    		else
    			g.setColor(Color.white.darker().darker().darker());
            Coord bottomleft = a.mapAxes(new Coord(
                                runway.centerX - (centreWidth / 2) - ((numberStripes - 1) * lineWidth),
                                runway.centerY + (runway.height / 2) - 6)
                        );
            Coord bottomright = a.mapAxes(new Coord(
                                runway.centerX + (centreWidth / 2),
                                runway.centerY + (runway.height / 2) - 6)
                        );
            for (int i = 0; i < numberStripes / 2; i++)
            {
            	//draw on one side
            	g.fill(new Rectangle2D.Double((a.getScale() * bottomleft.x + a.getScale() * (lineWidth * i * 2)), (a.getScale() * bottomleft.y), (a.getScale() * lineWidth), (a.getScale() * lineLength)));
            	g.fill(new Rectangle2D.Double((a.getScale() * bottomright.x + a.getScale() * (lineWidth * i * 2)), (a.getScale() * bottomright.y), (a.getScale() * lineWidth), (a.getScale() * lineLength)));
            	
            	//draw on the other side
            	Coord runwayCentre = a.mapAxes(new Coord(runway.centerX, runway.centerY));
            	g.rotate(Math.toRadians(180), a.getScale() * runwayCentre.x, a.getScale() * runwayCentre.y);
            	g.fill(new Rectangle2D.Double((a.getScale() * bottomleft.x + a.getScale() * (lineWidth * i * 2)), (a.getScale() * bottomleft.y), (a.getScale() * lineWidth), (a.getScale() * lineLength)));
            	g.fill(new Rectangle2D.Double((a.getScale() * bottomright.x + a.getScale() * (lineWidth * i * 2)), (a.getScale() * bottomright.y), (a.getScale() * lineWidth), (a.getScale() * lineLength)));
            	g.rotate(Math.toRadians(180), a.getScale() * runwayCentre.x, a.getScale() * runwayCentre.y);
            }
            
            /*End of runway line*/
            bottomleft = a.mapAxes(new Coord(
                    runway.centerX - (runway.width / 2),// + 2,
                    runway.centerY + (runway.height / 2))
            );
            bottomright = a.mapAxes( 
            new Coord(
                    runway.centerX + (runway.width / 2) - lineWidth,// - 2,
                    runway.centerY + (runway.height / 2))
            );
            
            if(runway.topExtension.UID != 0)
            {
            	g.rotate(-Math.toRadians(90), a.getScale()*bottomleft.x, a.getScale()*bottomleft.y);
            	g.fill(new Rectangle2D.Double((a.getScale() * bottomleft.x), (a.getScale() * bottomleft.y), (a.getScale() * 3), (a.getScale() * runway.runwayWidth)));
            	g.rotate(Math.toRadians(90), a.getScale()*bottomleft.x, a.getScale()*bottomleft.y);
            }
            if(runway.bottomExtension.UID != 0)
            {
            	Coord convCenter = a.mapAxes(new Coord(runway.centerX, runway.centerY));
            	g.rotate(Math.toRadians(180), a.getScale()*convCenter.x, a.getScale()*convCenter.y);
            	g.rotate(-Math.toRadians(90), a.getScale()*bottomleft.x, a.getScale()*bottomleft.y);
            	g.fill(new Rectangle2D.Double((a.getScale() * bottomleft.x), (a.getScale() * bottomleft.y), (a.getScale() * 3), (a.getScale() * runway.runwayWidth)));
            	g.rotate(Math.toRadians(90), a.getScale()*bottomleft.x, a.getScale()*bottomleft.y);
            	g.rotate(Math.toRadians(180), a.getScale()*convCenter.x, a.getScale()*convCenter.y);
            }
        }
    }
}
