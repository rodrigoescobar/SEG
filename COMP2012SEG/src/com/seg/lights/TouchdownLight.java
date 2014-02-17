package com.seg.lights;

import java.awt.Color;
import java.awt.Graphics2D;

import com.seg.AirportComponent;
import com.seg.AirportVisualisation;
import com.seg.Coord;
import com.seg.Runway;

public class TouchdownLight extends Lighting implements AirportComponent{
	
	public TouchdownLight (int myType){ type = myType; }
	
	public void draw(Graphics2D g, Runway runway, AirportVisualisation a){
		double scale = a.getScale();
		
		super.toggleQuality(a.quality);
		
		Coord convCenter = a.mapAxes(new Coord(runway.centerX, runway.centerY));
		if(!runway.approachDirectionIsFromTop())
        {
        	g.rotate(Math.toRadians(180), scale*convCenter.x, scale*convCenter.y);
        }
		
		Coord convTopleft = a.mapAxes(runway.topLeftCorner());
		double y = convTopleft.y+60;
		double x = convTopleft.x+runway.width/2-lightWidth/2;
		double offset = 9;
		double space = 1.5+lightWidth;
		
		//dont draw touchdown light if the runway is too narrow.
		if(x+offset+space*1+lightWidth > convTopleft.x+runway.width){
			return;
		}
		
		if(runway.height/2 < 900){
			for(; y < runway.height/2 + convTopleft.y; y+=60){
				drawLight(x+offset+space*0,y,Color.white,g,a.getScale());
				drawLight(x-offset-space*0,y,Color.white,g,a.getScale());
				drawLight(x+offset+space*1,y,Color.white,g,a.getScale());
				drawLight(x-offset-space*1,y,Color.white,g,a.getScale());
				if(x+offset+space*2+lightWidth < convTopleft.x+runway.width){
					drawLight(x+offset+space*2,y,Color.white,g,a.getScale());
					drawLight(x-offset-space*2,y,Color.white,g,a.getScale());
				}
				if(x+offset+space*3+lightWidth < convTopleft.x+runway.width){
					drawLight(x+offset+space*3,y,Color.white,g,a.getScale());
					drawLight(x-offset-space*3,y,Color.white,g,a.getScale());
				}
			}
		}else{
			for(; y < 900 + convTopleft.y; y+=60){
				drawLight(x+offset+space*0,y,Color.white,g,a.getScale());
				drawLight(x-offset-space*0,y,Color.white,g,a.getScale());
				drawLight(x+offset+space*1,y,Color.white,g,a.getScale());
				drawLight(x-offset-space*1,y,Color.white,g,a.getScale());
				if(x+offset+space*2+lightWidth < convTopleft.x+runway.width){
					drawLight(x+offset+space*2,y,Color.white,g,a.getScale());
					drawLight(x-offset-space*2,y,Color.white,g,a.getScale());
				}
				if(x+offset+space*3+lightWidth < convTopleft.x+runway.width){
					drawLight(x+offset+space*3,y,Color.white,g,a.getScale());
					drawLight(x-offset-space*3,y,Color.white,g,a.getScale());
				}
			}
		}
		
		
		if(!runway.approachDirectionIsFromTop())
        {
        	g.rotate(Math.toRadians(180), scale*convCenter.x, scale*convCenter.y);
        }
	}
	
}
