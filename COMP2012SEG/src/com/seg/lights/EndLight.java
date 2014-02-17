package com.seg.lights;

import java.awt.Color;
import java.awt.Graphics2D;

import com.seg.AirportComponent;
import com.seg.AirportVisualisation;
import com.seg.Coord;
import com.seg.Runway;

public class EndLight extends Lighting implements AirportComponent{
	
	public EndLight ( int myType){ type = myType; }
	
	public void draw( Graphics2D g, Runway runway, AirportVisualisation a ){
		this.g = g;
		double scale = a.getScale();
		super.toggleQuality(a.quality);
		
		Coord convCenter = a.mapAxes(new Coord(runway.centerX, runway.centerY));
		if(!runway.approachDirectionIsFromTop())
        {
        	g.rotate(Math.toRadians(180), scale*convCenter.x, scale*convCenter.y);
        }
		
		Coord convTopleft = a.mapAxes(runway.topLeftCorner());
		double y = convTopleft.y+runway.height;
		double x = convTopleft.x;
		for(; x<convTopleft.x+runway.width; x+=lightWidth+3){
			drawLight(x,y,Color.RED,g,a.getScale());
			//lights.add(new Light(x,y,lightWidth,Color.RED));
		}
		
		if(!runway.approachDirectionIsFromTop())
        {
        	g.rotate(Math.toRadians(180), scale*convCenter.x, scale*convCenter.y);
        }
	}
}