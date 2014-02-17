package com.seg.lights;

import java.awt.Color;
import java.awt.Graphics2D;

import com.seg.AirportComponent;
import com.seg.AirportVisualisation;
import com.seg.Coord;
import com.seg.Runway;

public class ApproachSimple extends Lighting implements AirportComponent{ 
	double x,y;
	Runway runway;
	
	public ApproachSimple() {  }
	
	public void draw(Graphics2D g, Runway runway, AirportVisualisation a) {
		Coord convCenter = a.mapAxes(new Coord(runway.centerX, runway.centerY));
		
		super.toggleQuality(a.quality);
		
		if(!runway.approachDirectionIsFromTop())
        {
        	g.rotate(Math.toRadians(180), a.getScale()*convCenter.x, a.getScale()*convCenter.y);
        }
		
		Coord convTopleft = a.mapAxes(runway.topLeftCorner());
		double x = convTopleft.x+runway.width/2-lightWidth/2+0.5;
		double y = convTopleft.y-2;
		
		//g.setColor(Color.WHITE);
		Color c = Color.WHITE;
		
		double i;
		for (i=y; i>=y-420; i-=60)
		     drawLight(x, i, c, g, a.getScale());
			//g.fillOval((int)(x*scale), (int)(i*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));

		y=y-300; x-=16;
		for (i=x; i<=x+30; i+=2.7)
			drawLight(i, y, c, g, a.getScale());
			//g.fillOval((int)(i*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
		
		if(!runway.approachDirectionIsFromTop())
        {
        	g.rotate(Math.toRadians(180), a.getScale()*convCenter.x, a.getScale()*convCenter.y);
        }
	}
}