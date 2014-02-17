package com.seg.lights;

import java.awt.Color;
import java.awt.Graphics2D;

import com.seg.*;

public class TaxiwayWigwag extends Lighting implements TaxiwayComponent{

	Configuration config;
	boolean leftOn = true;
	
	public TaxiwayWigwag(Configuration config) {
		this.config = config;
	}

	@Override
	public void draw(Graphics2D g, TaxiwaySection taxiway,
			AirportVisualisation a) {
		TaxiwayJoin start = null;
    	TaxiwayJoin end = null;
    	quality = a.quality;
    	
    	start = a.findTaxiwayStartJoin(taxiway);
    	end = a.findTaxiwayEndJoin(taxiway);
    	
    	//First convert the start and end points of the section to JPanel friendly co-ordinates.
		 Coord convStart = a.mapAxes(new Coord(start.joinX, start.joinY));
		 Coord convEnd = a.mapAxes(new Coord(end.joinX, end.joinY));

		 /*
		  * Once we have the points, in order to draw the rectangle we need the length, width,
		  * orientation, top left corner and rotation point of the taxiway, so that it can be
		  * drawn.
		  */
		 Coord topLeft = a.mapAxes(a.taxiwayTopLeft(taxiway, new Coord(start.joinX, start.joinY)));
		 double length = a.taxiwayLength(start, end);
		 double orientation = a.taxiwayOrientation(convStart, convEnd);
		 double width = taxiway.sectionWidth;

		 g.rotate(-orientation, a.getScale()*convStart.x, a.getScale()*convStart.y);
		 
		// Lights
		    Color c = Color.YELLOW; 
		 	if(start instanceof TaxiwayRunwayJoin)
		 	{
		 		double runwayWidth = 0;
		 		for(Runway runway : a.airport.getRunway()) //find the runway and get its width
				{
					 if(runway.UID == ((TaxiwayRunwayJoin)start).joinRunway)
					 {
						 runwayWidth = runway.runwayWidth;
					 }
				}
		 		//left wigwag
		 		if(leftOn)
		 		{
			 		drawLight((convStart.x-width-lightWidth*2),
			 				  (convStart.y+runwayWidth/2+50),
			 				  c, g, a.getScale());
			 		drawLight((convStart.x+width+lightWidth),
			 				  (convStart.y+runwayWidth/2+50),
			 				  c, g, a.getScale());
		 		}
		 		else
		 		{
			 		drawLight((convStart.x-width-lightWidth),
			 				  (convStart.y+runwayWidth/2+50),
			 				  c, g, a.getScale());
			 		//right wigwag
			 		drawLight((convStart.x+width+lightWidth*2),
			 				  (convStart.y+runwayWidth/2+50),
			 				  c, g, a.getScale());
			 		
		 		}
		 	}
		 	if(end instanceof TaxiwayRunwayJoin)
		 	{
		 		double runwayWidth = 0;
		 		for(Runway runway : a.airport.getRunway()) //find the runway and get its width
				{
					 if(runway.UID == ((TaxiwayRunwayJoin)end).joinRunway)
					 {
						 runwayWidth = runway.runwayWidth;
					 }
				}
		 		//left wigwag
		 		if(leftOn)
		 		{
		 		drawLight((convStart.x-width-lightWidth*2),
		 				  (convStart.y+length-(runwayWidth/2+50)),
		 				  c, g, a.getScale());
		 		drawLight((convStart.x+width+lightWidth),
		 				  (convStart.y+length-(runwayWidth/2+50)),
		 				  c, g, a.getScale());
		 		}
		 		else
		 		{
		 		drawLight((convStart.x-width-lightWidth),
		 				  (convStart.y+length-(runwayWidth/2+50)),
		 				  c, g, a.getScale());
		 		//right wigwag
		 		drawLight((convStart.x+width+lightWidth*2),
		 				  (convStart.y+length-(runwayWidth/2+50)),
		 				  c, g, a.getScale());
		 		
		 		}
		 	}
		 //endLights
		 	
		 g.rotate(orientation, a.getScale()*convStart.x, a.getScale()*convStart.y);
	}
	
	public void switchLights()
	{
		leftOn = !leftOn;
	}

}
