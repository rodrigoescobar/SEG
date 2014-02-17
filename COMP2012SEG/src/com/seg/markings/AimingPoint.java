package com.seg.markings;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.seg.*;


public class AimingPoint implements AirportComponent{
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
		
		//calculating the distance from the threshold
		if (runway.height > 2400)
			distFromThreshold = 400;
		else if (runway.height > 1500)
			distFromThreshold = 300;
		else if (runway.height > 900)
			distFromThreshold = 250;
		else 
			distFromThreshold = 150;
		
		//calculating other dimensions of the aiming point
		if (runway.width >= 45){
			distFromCentreLine = 9;
			width = 5.5;
		}else if (runway.width >= 30){
			distFromCentreLine = 3;
			width = 5.0;
		}else if (runway.width >= 23){
			distFromCentreLine = 5;
			width = 2.5;
		}else{
			distFromCentreLine = 3;
			width = 2.5;
		}
		
		length = 15;
	}
	
	public AimingPoint(Configuration config)
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
		
		//draw on one side
		drawAimingPoint(g, runway, a);
		
		//draw on the other side
    	Coord runwayCentre = a.mapAxes(new Coord(runway.centerX, runway.centerY));
    	g.rotate(Math.toRadians(180), a.getScale() * runwayCentre.x, a.getScale() * runwayCentre.y);
    	
    	drawAimingPoint(g, runway, a);
    	
    	g.rotate(Math.toRadians(180), a.getScale() * runwayCentre.x, a.getScale() * runwayCentre.y);
	}
	
	private void drawAimingPoint(Graphics2D g, Runway runway, AirportVisualisation a)
	{
		//top left rectangle
		drawComponentRect(new Coord(
				runway.centerX - distFromCentreLine - width,
				runway.topLeftCorner().y - distFromThreshold), a);
		//middle left rectangle
		drawComponentRect(new Coord(
				runway.centerX - distFromCentreLine - width*2,
				runway.topLeftCorner().y - distFromThreshold - length), a);
		//bottom left rectangle
		drawComponentRect(new Coord(
				runway.centerX - distFromCentreLine - width,
				runway.topLeftCorner().y - distFromThreshold - length*2), a);
		//top right rectangle
		drawComponentRect(new Coord(
				runway.centerX + distFromCentreLine,
				runway.topLeftCorner().y - distFromThreshold), a);
		//middle right rectangle
		drawComponentRect(new Coord(
				runway.centerX + distFromCentreLine + width,
				runway.topLeftCorner().y - distFromThreshold - length), a);
		//bottom right rectangle
		drawComponentRect(new Coord(
				runway.centerX + distFromCentreLine,
				runway.topLeftCorner().y - distFromThreshold - length*2), a);
	}
	
	//draws a component rectangle of the whole aiming point marking
	private void drawComponentRect(Coord drawingPoint, AirportVisualisation a)
	{
		Coord convDrawingPoint = a.mapAxes(drawingPoint);
		Rectangle2D aimingPointComp = new Rectangle2D.Double(a.getScale()*convDrawingPoint.x, a.getScale()*convDrawingPoint.y, a.getScale()*width, a.getScale()*length);
		g.fill(aimingPointComp);
	}
}