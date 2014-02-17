package com.seg.markings;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;

import com.seg.AirportVisualisation;
import com.seg.Coord;
import com.seg.Runway;

class Arrows {
	Graphics2D g;
	Runway.Extension extension;
	
	int noOfArrows;
	double rectLength = 21;
	double triLength = 9;
	double triWidth = 3;
	double width = 0.45;
	double spacing = 30;
	double offset = 0;
	
	private void setup(Graphics2D g, Runway.Extension extension)
	{
		this.g=g;
		this.extension=extension;
		
		noOfArrows = (int)((int)(extension.height/spacing))/2;
		
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
		
		for(int i=0;i<noOfArrows;i++)
		{
			/*Drawing the rectangle part*/
			
			Coord rectPos = new Coord(
					extension.center().x - width/2,
					extension.extTopLeftCorner().y - (i*2*spacing + offset));
			Coord convRectPos = a.mapAxes(rectPos);
    		Rectangle2D arrowComp = new Rectangle2D.Double(a.getScale()*convRectPos.x, a.getScale()*convRectPos.y, a.getScale()*width, a.getScale()*rectLength);
    		g.fill(arrowComp);
    		
    		/*Drawing the triangle part*/
    		
    		if (extension instanceof Runway.TopExtension) //draw triangles pointing down
    		{
    			double rectBottomY = rectPos.y - rectLength;
    			Coord leftVertex = new Coord(extension.center().x - triWidth/2, rectBottomY);
    			Coord rightVertex = new Coord(extension.center().x + triWidth/2, rectBottomY);
    			Coord apex = new Coord(extension.center().x, rectBottomY - triLength);
    			
    			Coord convLeftVertex = a.mapAxes(leftVertex);
    			Coord convRightVertex = a.mapAxes(rightVertex);
    			Coord convApex = a.mapAxes(apex);
    			
    			int[] xCoords = 
    			{
    					(int)(a.getScale()*convLeftVertex.x), //left point
    					(int)(a.getScale()*convRightVertex.x), //right point
    					(int)(a.getScale()*convApex.x) //apex
    			};
    			int[] yCoords =
    			{
    					(int)(a.getScale()*convLeftVertex.y), //left point
    					(int)(a.getScale()*convRightVertex.y), //right point
    					(int)(a.getScale()*convApex.y) //apex
    			};
    			Polygon triangle = new Polygon(xCoords, yCoords, 3);
    			g.fill(triangle);
    		}
    		else //draw triangles pointing up
    		{
    			double rectTopY = rectPos.y;
    			Coord leftVertex = new Coord(extension.center().x - triWidth/2, rectTopY);
    			Coord rightVertex = new Coord(extension.center().x + triWidth/2, rectTopY);
    			Coord apex = new Coord(extension.center().x, rectTopY + triLength);
    			
    			Coord convLeftVertex = a.mapAxes(leftVertex);
    			Coord convRightVertex = a.mapAxes(rightVertex);
    			Coord convApex = a.mapAxes(apex);
    			
    			int[] xCoords = 
    			{
    					(int)(a.getScale()*convLeftVertex.x), //left point
    					(int)(a.getScale()*convRightVertex.x), //right point
    					(int)(a.getScale()*convApex.x) //apex
    			};
    			int[] yCoords =
    			{
    					(int)(a.getScale()*convLeftVertex.y), //left point
    					(int)(a.getScale()*convRightVertex.y), //right point
    					(int)(a.getScale()*convApex.y) //apex
    			};
    			Polygon triangle = new Polygon(xCoords, yCoords, 3);
    			g.fill(triangle);
    		}
		}
	}
}