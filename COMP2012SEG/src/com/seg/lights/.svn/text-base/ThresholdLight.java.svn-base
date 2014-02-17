package com.seg.lights;

import java.awt.Color;
import java.awt.Graphics2D;

import com.seg.AirportComponent;
import com.seg.AirportVisualisation;
import com.seg.Coord;
import com.seg.Runway;

public class ThresholdLight extends Lighting implements AirportComponent{
	
	public ThresholdLight(int myType){ type = myType; }
	
	public void draw(Graphics2D g, Runway runway, AirportVisualisation a){
		double scale = a.getScale();
		
		super.toggleQuality(a.quality);
		
		Coord convCenter = a.mapAxes(new Coord(runway.centerX, runway.centerY));
		if(!runway.approachDirectionIsFromTop())
        {
        	g.rotate(Math.toRadians(180), scale*convCenter.x, scale*convCenter.y);
        }
		
		Coord convTopleft = a.mapAxes(runway.topLeftCorner());
		double y = convTopleft.y; 
		double x = convTopleft.x-15-4*lightWidth;
		
		for(; x<convTopleft.x+runway.width+15+4*lightWidth; x+=lightWidth+3){
			drawLight(x,y,Color.GREEN,g,a.getScale());
			//lights.add(new Light(x,y,lightWidth,Color.GREEN));
		}
		
		if(!runway.approachDirectionIsFromTop())
        {
        	g.rotate(Math.toRadians(180), scale*convCenter.x, scale*convCenter.y);
        }
	}
}