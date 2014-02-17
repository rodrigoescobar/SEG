package com.seg.lights;

import java.awt.Color;
import java.awt.Graphics2D;

import com.seg.AirportComponent;
import com.seg.AirportVisualisation;
import com.seg.Coord;
import com.seg.Runway;

public class EdgeLight extends Lighting implements AirportComponent{
	
	public EdgeLight(int myType){ type = myType; }
	
	public void setup(Runway runway, AirportVisualisation a) {
		
	}
	
	public void draw(Graphics2D g, Runway runway, AirportVisualisation a){
		setup(runway, a);
		super.toggleQuality(a.quality);
		
		Coord convCenter = a.mapAxes(new Coord(runway.centerX, runway.centerY));
		if(!runway.approachDirectionIsFromTop())
        {
        	g.rotate(Math.toRadians(180), a.getScale()*convCenter.x, a.getScale()*convCenter.y);
        }
		
		Coord convTopleft = a.mapAxes(runway.topLeftCorner());
		
		double x = convTopleft.x;
		double y = convTopleft.y+60;
		double offset = runway.width-lightWidth;
		
		if(type >= 2){
    		if(runway.width<=50){
	    		for(; y<convTopleft.y+runway.height; y+=60){
	    			drawLight(x,y,Color.WHITE,g,a.getScale());
	    			drawLight(x+offset,y,Color.WHITE,g,a.getScale());
	    			//lights.add(new Light(x+offset,y,lightWidth,Color.WHITE));
	    		}
    		}else{
    			for(; y<convTopleft.y+runway.height; y+=40){
    				drawLight(x,y,Color.WHITE,g,a.getScale());
	    			drawLight(x+offset,y,Color.WHITE,g,a.getScale());
    				//lights.add(new Light(x,y,lightWidth,Color.WHITE));
    				//lights.add(new Light(x+offset,y,lightWidth,Color.WHITE));
	    		}
    		}
		}
		
    	//for edge lights without centre lights
		else{
    		//if 1/3 of the runway is less than 600m, 
    		//only draw yellow lights for the last 1/3 part
    		if(600.0/runway.height < 1.0/3.0){
	    		for(; y<convTopleft.y+runway.height-600; y+=60){
	    			drawLight(x,y,Color.WHITE,g,a.getScale());
	    			drawLight(x+offset,y,Color.WHITE,g,a.getScale());
	    			//lights.add(new Light(x,y,lightWidth,Color.WHITE));
	    			//lights.add(new Light(x+offset,y,lightWidth,Color.WHITE));
	    		}
    		}else{
    			for(; y<convTopleft.y+runway.height*(2.0/3.0); y+=60){
    				drawLight(x,y,Color.WHITE,g,a.getScale());
	    			drawLight(x+offset,y,Color.WHITE,g,a.getScale());
    				//lights.add(new Light(x,y,lightWidth,Color.WHITE));
    				//lights.add(new Light(x+offset,y,lightWidth,Color.WHITE));
	    		}
    		}
    		for(; y<convTopleft.y+runway.height; y+=60){
    			drawLight(x,y,Color.YELLOW,g,a.getScale());
    			drawLight(x+offset,y,Color.YELLOW,g,a.getScale());
    			//lights.add(new Light(x,y,lightWidth,Color.YELLOW));
    			//lights.add(new Light(x+offset,y,lightWidth,Color.YELLOW));
    		}
    	}
		
		if(!runway.approachDirectionIsFromTop())
        {
        	g.rotate(Math.toRadians(180), a.getScale()*convCenter.x, a.getScale()*convCenter.y);
        }
	}
}