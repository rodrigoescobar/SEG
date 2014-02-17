package com.seg.markings;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.seg.AirportVisualisation;
import com.seg.Coord;
import com.seg.Runway;

class Crosses {
	Graphics2D g;
	Runway.Extension extension;
	
	int noOfCrosses;
	double length;
	double width = 1.3;
	double angle;
	double spacing = 36;
	double offset = 0;
	
	public Crosses()
	{
		
	}
	
	private void setup(Graphics2D g, Runway.Extension extension)
	{
		this.g=g;
		this.extension=extension;
		
		noOfCrosses = (int)((int)(extension.height/spacing))/2;
		length = Math.sqrt(Math.pow(spacing, 2) + Math.pow(extension.width/3, 2));
		angle = Math.atan((extension.width/3)/spacing);
		
		if(extension instanceof Runway.BottomExtension)
		{
			offset = spacing;
		}
	}
	
	public void draw(Graphics2D g, Runway.Extension extension, AirportVisualisation a)
	{
		setup(g, extension);
		
		if(a.day)
			g.setColor(Color.WHITE);
		else
			g.setColor(Color.white.darker().darker().darker());
		
		for(int i=0;i<noOfCrosses;i++)
		{
			Coord leftRectPos = new Coord(
					extension.center().x - extension.getWidth()/6,
					extension.extTopLeftCorner().y - (i*2*spacing + offset));
			Coord rightRectPos = new Coord(
					extension.center().x + extension.getWidth()/6,
					extension.extTopLeftCorner().y - (i*2*spacing + offset));
			
			Coord convLeftRectPos = a.mapAxes(leftRectPos);
			Coord convRightRectPos = a.mapAxes(rightRectPos);
			
			g.rotate(-angle, a.getScale()*convLeftRectPos.x, a.getScale()*convLeftRectPos.y);
			drawComponentRect(leftRectPos, a);
			g.rotate(angle, a.getScale()*convLeftRectPos.x, a.getScale()*convLeftRectPos.y);
			g.rotate(angle, a.getScale()*convRightRectPos.x, a.getScale()*convRightRectPos.y);
			drawComponentRect(rightRectPos, a);
			g.rotate(-angle, a.getScale()*convRightRectPos.x, a.getScale()*convRightRectPos.y);
		}
	}
	
	//draws a component rectangle of the whole cross
	private void drawComponentRect(Coord drawingPoint, AirportVisualisation a)
	{
		Coord convDrawingPoint = a.mapAxes(drawingPoint);
		Rectangle2D crossComp = new Rectangle2D.Double(a.getScale()*convDrawingPoint.x, a.getScale()*convDrawingPoint.y, a.getScale()*width, a.getScale()*length);
		g.fill(crossComp);
	}
}