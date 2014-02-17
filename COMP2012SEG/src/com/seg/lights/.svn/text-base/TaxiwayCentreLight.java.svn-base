package com.seg.lights;

import java.awt.Color;
import java.awt.Graphics2D;

import com.seg.AirportVisualisation;
import com.seg.Configuration;
import com.seg.Coord;
import com.seg.TaxiwayComponent;
import com.seg.TaxiwayJoin;
import com.seg.TaxiwaySection;

public class TaxiwayCentreLight extends Lighting implements TaxiwayComponent{

	Graphics2D g;
	TaxiwaySection taxiway;
	Configuration config;
	private final double lightWidth = 3;
	boolean quality = true;
	
	public TaxiwayCentreLight(Configuration config){
		this.config = config;
	}
	
	public void draw(Graphics2D g, TaxiwaySection taxiway, AirportVisualisation a){
		TaxiwayJoin start = null;
    	TaxiwayJoin end = null;
    	super.toggleQuality(a.quality);
    	
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
		    Color c = Color.GREEN; 
		 	//drawLight(convStart.x-1.5, convStart.y, c, g, a.getScale()); 
		 	for (double i=convStart.y+10; i<=convStart.y+length-10; i+=10)
		 		{ c = Color.GREEN;
		 		  drawLight(convStart.x-1, i, c, g, a.getScale());  // centrelights
		 		  //c = Color.BLUE;
		 		  //drawLight(convStart.x-1-width/2, i, c, g, a.getScale());  //edgelights
		 		  //drawLight(convStart.x-1+width/2, i, c, g, a.getScale());  //edgelights
		 		}
		 //endLights
		 	
		 g.rotate(orientation, a.getScale()*convStart.x, a.getScale()*convStart.y);
	}
}
