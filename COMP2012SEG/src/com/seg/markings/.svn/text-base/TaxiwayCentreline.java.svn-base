package com.seg.markings;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import com.seg.*;

public class TaxiwayCentreline implements TaxiwayComponent{
	
	Graphics2D g;
	TaxiwaySection taxiway;
	Configuration config;
	private final double lightWidth = 3;
	boolean quality = true;
	
	public TaxiwayCentreline(Configuration config){
		this.config = config;
	}
	
	public void draw(Graphics2D g, TaxiwaySection taxiway, AirportVisualisation a){
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
		 
		 /*
		  * Actual drawing of the markings
		  */
		 
		 if(a.day)
		 {
	    	g.setColor(Color.YELLOW);
		 }
		 else
		 {
			 g.setColor(Color.yellow.darker().darker().darker());
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
			 for(Runway runway : a.airport.getRunway()) //find the runway and get its width
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
			 for(Runway runway : a.airport.getRunway()) //find the runway and get its width
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
		 g.fill(new Rectangle2D.Double((a.getScale()*(topLeft.x + width/2 - centrelineWidth/2)), 
				 (a.getScale()*topLeft.y), 
				 (a.getScale()*centrelineWidth), 
				 (a.getScale()*(clearance - startGapWidth/2 + startRunwayWidth/2))));
		 //middle line
		 g.fill(new Rectangle2D.Double((a.getScale()*(topLeft.x + width/2 - centrelineWidth/2)), 
				 (a.getScale()*(topLeft.y + clearance + startGapWidth/2 + startRunwayWidth/2)), 
				 (a.getScale()*centrelineWidth), 
				 (a.getScale()*(length - clearance*2 - startGapWidth/2 - endGapWidth/2 - startRunwayWidth/2 - endRunwayWidth/2))));
		 //second holding line to end
		 g.fill(new Rectangle2D.Double((a.getScale()*(topLeft.x + width/2 - centrelineWidth/2)), 
				 (a.getScale()*(topLeft.y + length - (clearance - endGapWidth/2 + endRunwayWidth/2))), 
				 (a.getScale()*centrelineWidth), 
				 (a.getScale()*(clearance - endGapWidth/2 + endRunwayWidth/2))));

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
				 g.fill(new Rectangle2D.Double((a.getScale()*(topLeft.x + i*lineLength*2 + offset)), 
						 (a.getScale()*(topLeft.y + startRunwayWidth/2 + clearance - startGapWidth/2 + lineLength)), 
						 (a.getScale()*lineLength), 
						 (a.getScale()*finalLineWidth)));
				 g.fill(new Rectangle2D.Double((a.getScale()*(topLeft.x + i*lineLength*2 + offset)), 
						 (a.getScale()*(topLeft.y + startRunwayWidth/2 + clearance - startGapWidth/2 + lineLength + 2*finalLineWidth)), 
						 (a.getScale()*lineLength), 
						 (a.getScale()*finalLineWidth)));
			 }
			 //draw the two solid lines
			 g.fill(new Rectangle2D.Double((a.getScale()*(topLeft.x)), 
					 (a.getScale()*(topLeft.y + startRunwayWidth/2 + clearance - startGapWidth/2 + lineLength + 4*finalLineWidth)), 
					 (a.getScale()*width),
					 (a.getScale()*finalLineWidth)));
			 g.fill(new Rectangle2D.Double((a.getScale()*(topLeft.x)), 
					 (a.getScale()*(topLeft.y + startRunwayWidth/2 + clearance - startGapWidth/2 + lineLength + 6*finalLineWidth)), 
					 (a.getScale()*width),
					 (a.getScale()*finalLineWidth)));
		 }
		 else //if the start joins to another taxiway
		 {
			 for(int i = 0; i < noOfLines ; i++)
			 {
				 //draw dotted line
				 g.fill(new Rectangle2D.Double((a.getScale()*(topLeft.x + i*lineLength*2 + offset)), 
						 (a.getScale()*(topLeft.y + clearance - intermediateLineWidth/2)), 
						 (a.getScale()*lineLength), 
						 (a.getScale()*intermediateLineWidth)));
			 }
		 }
		 if(end instanceof TaxiwayRunwayJoin) //if the end joins to a runway
		 {
			 //draw two solid lines
			 g.fill(new Rectangle2D.Double((a.getScale()*(topLeft.x)), 
					 (a.getScale()*(topLeft.y + length - (endRunwayWidth/2 + clearance + endGapWidth/2 - lineLength))), 
					 (a.getScale()*width),
					 (a.getScale()*finalLineWidth)));
			 g.fill(new Rectangle2D.Double((a.getScale()*(topLeft.x)), 
					 (a.getScale()*(topLeft.y + length - (endRunwayWidth/2 + clearance + endGapWidth/2 - lineLength - 2*finalLineWidth))), 
					 (a.getScale()*width),
					 (a.getScale()*finalLineWidth)));
			 for(int i = 0; i < noOfLines ; i++)
			 {
				 //draw two dotted lines
				 g.fill(new Rectangle2D.Double((a.getScale()*(topLeft.x + i*lineLength*2 + offset)), 
						 (a.getScale()*(topLeft.y + length - (endRunwayWidth/2 + clearance + endGapWidth/2 - lineLength - 4*finalLineWidth))), 
						 (a.getScale()*lineLength), 
						 (a.getScale()*finalLineWidth)));
				 g.fill(new Rectangle2D.Double((a.getScale()*(topLeft.x + i*lineLength*2 + offset)), 
						 (a.getScale()*(topLeft.y + length - (endRunwayWidth/2 + clearance + endGapWidth/2 - lineLength - 6*finalLineWidth))), 
						 (a.getScale()*lineLength), 
						 (a.getScale()*finalLineWidth)));
			 }
		 }
		 else //if end joins to another taxiway
		 {
			 for(int i = 0; i < noOfLines ; i++)
			 {
				 //draw dotted line
				 g.fill(new Rectangle2D.Double((a.getScale()*(topLeft.x + i*lineLength*2 + offset)), 
						 (a.getScale()*(topLeft.y + length - clearance - intermediateLineWidth/2)), 
						 (a.getScale()*lineLength), 
						 (a.getScale()*intermediateLineWidth)));	 
			 }
		 }
		 
		 /*Curves*/
		 
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
//			 g.drawArc((int)(a.getScale()*leftArcBox.x), (int)(a.getScale()*leftArcBox.y), (int)(a.getScale()*5),  (int)(a.getScale()*5), 0, 90);
//			 g.drawArc((int)(a.getScale()*rightArcBox.x), (int)(a.getScale()*rightArcBox.y),  (int)(a.getScale()*5),  (int)(a.getScale()*5), 90, 90);
			 
		 }
		 
		 g.rotate(orientation, a.getScale()*convStart.x, a.getScale()*convStart.y);
	}	
}
