package com.seg.markings;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.seg.*;

public class TouchdownZone implements AirportComponent{
	Graphics2D g;
	Runway runway;
	Configuration config;
	
	double distFromThreshold;
	double distFromCentreLine;
	double width;
	double length;
	
	private void setup(Graphics2D g, Runway runway)
	{
		this.g=g;
		this.runway=runway;
		
		if (runway.width >= 45){
			distFromCentreLine = 9;
			width=3;
		}else if (runway.width >= 30){
			distFromCentreLine = 3;
			width = 3;
		}else if (runway.width >= 23){
			distFromCentreLine = 5;
			width = 1.5;
		}else{
			distFromCentreLine = 3;
			width = 1.5;
		}
		
		length = 22.5;
	}
	
	public TouchdownZone(Configuration config)
	{
		this.config = config;
	}
	
	public void draw(Graphics2D g, Runway runway, AirportVisualisation a)
	{
		setup(g, runway);
		
		if(a.day)
			g.setColor(Color.WHITE);
		else
			g.setColor(Color.white.darker().darker().darker());
		
		drawTouchdownZone(g, runway, a);
		
		//draw on the other side
    	Coord runwayCentre = a.mapAxes(new Coord(runway.centerX, runway.centerY));
    	g.rotate(Math.toRadians(180), a.getScale() * runwayCentre.x, a.getScale() * runwayCentre.y);
    	
    	drawTouchdownZone(g, runway, a);
    	
    	g.rotate(Math.toRadians(180), a.getScale() * runwayCentre.x, a.getScale() * runwayCentre.y);
		
	}
	
	private void drawTouchdownZone(Graphics2D g, Runway runway, AirportVisualisation a)
	{
		if (runway.height < 900)
		{
			//left rect
			drawComponentRect(new Coord(
					runway.centerX - distFromCentreLine - width,
					runway.topLeftCorner().y - 300), a);
			//right rect
			drawComponentRect(new Coord(
					runway.centerX + distFromCentreLine,
					runway.topLeftCorner().y - 300), a);
		}
		else
		{
			//left rect
			drawComponentRect(new Coord(
					runway.centerX - distFromCentreLine - width,
					runway.topLeftCorner().y - 150), a);
			//right rect
			drawComponentRect(new Coord(
					runway.centerX + distFromCentreLine,
					runway.topLeftCorner().y - 150), a);
			
			if (runway.height <= 2400)
			{
			//left rect
			drawComponentRect(new Coord(
					runway.centerX - distFromCentreLine - width,
					runway.topLeftCorner().y - 450), a);
			//right rect
			drawComponentRect(new Coord(
					runway.centerX + distFromCentreLine,
					runway.topLeftCorner().y - 450), a);
			}
			
			if (runway.height >= 1200)
			{
				drawComponentRect(new Coord(
    					runway.centerX - distFromCentreLine - width,
    					runway.topLeftCorner().y - 600), a);
				drawComponentRect(new Coord(
    					runway.centerX + distFromCentreLine,
    					runway.topLeftCorner().y - 600), a);
				if (runway.height >= 1500)
				{
					drawComponentRect(new Coord(
        					runway.centerX - distFromCentreLine - width,
        					runway.topLeftCorner().y - 750), a);
    				drawComponentRect(new Coord(
        					runway.centerX + distFromCentreLine,
        					runway.topLeftCorner().y - 750), a);
    				if (runway.height > 2400)
    				{
    					//left rect
    	    			drawComponentRect(new Coord(
    	    					runway.centerX - distFromCentreLine - width,
    	    					runway.topLeftCorner().y - 300), a);
    	    			//right rect
    	    			drawComponentRect(new Coord(
    	    					runway.centerX + distFromCentreLine,
    	    					runway.topLeftCorner().y - 300), a);
    					
    					drawComponentRect(new Coord(
            					runway.centerX - distFromCentreLine - width,
            					runway.topLeftCorner().y - 900), a);
        				drawComponentRect(new Coord(
            					runway.centerX + distFromCentreLine,
            					runway.topLeftCorner().y - 900), a);
    				}
				}
			}
		}
	}
	
	//draws a component rectangle of the whole aiming point marking
	private void drawComponentRect(Coord drawingPoint, AirportVisualisation a)
	{
		Coord convDrawingPoint = a.mapAxes(drawingPoint);
		Rectangle2D touchdownComp = new Rectangle2D.Double(a.getScale()*convDrawingPoint.x, a.getScale()*convDrawingPoint.y, a.getScale()*width, a.getScale()*length);
		g.fill(touchdownComp);
	}
}