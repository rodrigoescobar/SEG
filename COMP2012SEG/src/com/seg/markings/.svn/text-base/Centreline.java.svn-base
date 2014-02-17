package com.seg.markings;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.seg.*;

public class Centreline implements AirportComponent{
	
	Graphics2D g;
	Runway runway;
	Configuration config;
	double lineWidth;
	double lineLength;
	int offset;
	AirportVisualisation airportVisualisation;
	
	public Centreline(Configuration config)
	{
		this.config = config;
	}
	
	private void setup(Graphics2D g, Runway runway, AirportVisualisation airportVisualisation)
	{
		this.g=g;
		this.runway=runway;
		
		this.airportVisualisation = airportVisualisation;
		
		int designatorLength = 0;
		for(ParallelRunwayGroup parallelGroup : airportVisualisation.parallelGroups)
        {
        	if(parallelGroup.left.UID == runway.UID)
        	{
        		designatorLength = 12 + 15 + 15 + 6 + 12;
        	}
        	else if(parallelGroup.right.UID == runway.UID)
        	{
        		designatorLength = 12 + 15 + 15 + 6 + 12;
        	}
        	else if(parallelGroup.centre != null)
        	{
        		if(parallelGroup.centre.UID == runway.UID)
            	{
        			designatorLength = 12 + 15 + 15 + 6 + 12;
            	}
        	}
        	else
        	{
        		designatorLength = 12 + 15 + 12;
        	}
        } 
		
		lineLength = 30;
		if(config == Configuration.VISUAL_REQUIRED || 
				config == Configuration.VISUAL_DESIRABLE || 
				config == Configuration.NONPRECISION_REQUIRED || 
				config == Configuration.NONPRECISION_DESIRABLE)
		{
			if (runway.width <= 18)
			{
				lineWidth=0.3;
				offset = designatorLength + 6 + 30;
			}
			else if (runway.width <= 23)
			{
				lineWidth=0.3;
				offset = designatorLength + 6 + 30;
			}
			else if (runway.width <= 30)
			{
				lineWidth=0.45;
				offset = designatorLength + 6 + 30;
			}
			else
			{
				lineWidth=0.45;
				offset = designatorLength + 6 + 30;
			}
		}
		else
		{
			if (runway.width <= 18)
			{
				lineWidth=0.45;
				offset=24 + designatorLength + 2*12;
			}
			else if (runway.width <= 23)
			{
				lineWidth=0.45;
				offset=24 + designatorLength + 2*12;
			}
			else if (runway.width <= 30)
			{
				lineWidth=0.9;
				offset=30 + designatorLength + 2*12;
			}
			else
			{
				lineWidth=0.9;
				offset=30 + designatorLength + 2*12;
			}
		}
	}
	
	private void drawCentreLineHalf(Graphics2D g, Runway runway, AirportVisualisation airportVisualisation)
	{
		int noOfLines = (int)((runway.height - offset)/2/lineLength)/2;
		
		if(airportVisualisation.day)
			g.setColor(Color.WHITE);
		else
			g.setColor(Color.white.darker().darker().darker());
		
		for(int i=0; i<noOfLines; i++)
		{
			Coord topleft;
			topleft =  airportVisualisation.mapAxes(new Coord(
					runway.centerX-lineWidth/2, (runway.centerY + lineLength/2) - (i*2*lineLength))
					);
		Rectangle2D.Double centrelineMarking = new Rectangle2D.Double(
				 airportVisualisation.getScale()*topleft.x,
				 airportVisualisation.getScale()*topleft.y,
				 airportVisualisation.getScale()*lineWidth,
				 airportVisualisation.getScale()*lineLength		
		);
			g.fill(centrelineMarking);
		}
	}
	
	public void draw(Graphics2D g, Runway runway, AirportVisualisation airportVisualisation)
	{
		setup(g, runway, airportVisualisation);
		
		drawCentreLineHalf(g, runway, airportVisualisation);
		
		//draw on the other side
    	Coord runwayCentre = airportVisualisation.mapAxes(new Coord(runway.centerX, runway.centerY));
    	g.rotate(Math.toRadians(180), airportVisualisation.getScale() * runwayCentre.x, airportVisualisation.getScale() * runwayCentre.y);
    	
    	drawCentreLineHalf(g, runway, airportVisualisation);
    	
    	g.rotate(Math.toRadians(180), airportVisualisation.getScale() * runwayCentre.x, airportVisualisation.getScale() * runwayCentre.y);
	}
}