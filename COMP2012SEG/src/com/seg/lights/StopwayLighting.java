package com.seg.lights;

import java.awt.Color;
import java.awt.Graphics2D;

import com.seg.AirportComponent;
import com.seg.AirportVisualisation;
import com.seg.Coord;
import com.seg.Runway;

public class StopwayLighting extends Lighting implements AirportComponent{
	
	public StopwayLighting(int myType) { type = myType; }
	
	public void setup(Runway runway, AirportVisualisation a) {
		
	}
	
	public void draw(Graphics2D g, Runway runway, AirportVisualisation a){
		setup(runway, a);
		double offset = runway.width-lightWidth;
		Coord convTopleft = a.mapAxes(runway.topLeftCorner());
		double x;
		double y;
		
		super.toggleQuality(a.quality);
		
		//if TE is a stopway and should be visible (according to approach direction)
		if(runway.topExtension.type != null && runway.topExtension.type.equals("STOPWAY") && !runway.approachDirectionIsFromTop()){
			x = convTopleft.x;
    		y = convTopleft.y;
			for(; y>convTopleft.y - runway.topExtension.height; y-=50){
    			drawLight(x,y,Color.RED, g, a.getScale());
    			drawLight(x+offset,y,Color.RED, g, a.getScale());
				//lights.add(new Light(x,y,lightWidth,Color.red));
    			//lights.add(new Light(x+offset,y,lightWidth,Color.red));
    		}
			y = convTopleft.y - runway.topExtension.height;
			for(int i = 0; i < 4; i++){
				drawLight(x+i*((runway.width-lightWidth)/3),y,Color.RED, g, a.getScale());
				//lights.add(new Light(x+i*((runway.width-lightWidth)/3),y,lightWidth,Color.red));
			}
		}
		
		//if BE is a stopway and should be visible (according to approach direction)
		if(runway.bottomExtension.type != null && runway.bottomExtension.type.equals("STOPWAY") && runway.approachDirectionIsFromTop()){
			x = convTopleft.x;
    		y = convTopleft.y + runway.height;
			for(; y<convTopleft.y + runway.height + runway.bottomExtension.height; y+=50){
				drawLight(x,y,Color.RED, g, a.getScale());
    			drawLight(x+offset,y,Color.RED, g, a.getScale());
				//lights.add(new Light(x,y,lightWidth,Color.red));
    			//lights.add(new Light(x+offset,y,lightWidth,Color.red));
    		}
			y = convTopleft.y + runway.height + runway.bottomExtension.height;
			for(int i = 0; i < 4; i++){
				//lights.add(new Light(x+i*((runway.width-lightWidth)/3),y,lightWidth,Color.red));
				drawLight(x+i*((runway.width-lightWidth)/3),y,Color.RED, g, a.getScale());
			}
		}
  }
}