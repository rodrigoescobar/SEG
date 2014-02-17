package com.seg.lights;

import java.awt.Color;
import java.awt.Graphics2D;

import com.seg.AirportComponent;
import com.seg.AirportVisualisation;
import com.seg.Coord;
import com.seg.Runway;

public class StarterExtensionLight extends Lighting implements AirportComponent{
	
	public StarterExtensionLight(int myType){ type = myType; }
	
	public void setup(Runway runway, AirportVisualisation a) {
		
	}
	
	public void draw(Graphics2D g, Runway runway, AirportVisualisation a){
		setup(runway, a);
		Coord convTopleft = a.mapAxes(runway.topLeftCorner());
		double x;
		double y;
		
		super.toggleQuality(a.quality);
		
		//if TE is a starter extension
		if(runway.topExtension.type != null && runway.topExtension.type.equals("STARTER_EXTENSION")){
			Color color;
			if(runway.topExtension.width < runway.width) color = Color.blue;
			else color = Color.white;
			x = convTopleft.x + (runway.width - runway.topExtension.width)/2;
			y = convTopleft.y;
			double offset = runway.topExtension.width-lightWidth;
			
			if(runway.width<=50){
	    		for(; y>convTopleft.y - runway.topExtension.height; y-=60){
	    			drawLight(x,y,color,g,a.getScale());
	    			drawLight(x+offset,y,color,g,a.getScale());
	    			//lights.add(new Light(x,y,lightWidth,color));
	    			//lights.add(new Light(x+offset,y,lightWidth,color));
	    		}
    		}else{
    			for(; y>convTopleft.y - runway.topExtension.height; y-=40){
    				drawLight(x,y,color,g,a.getScale());
	    			drawLight(x+offset,y,color,g,a.getScale());
    				//lights.add(new Light(x,y,lightWidth,color));
    				//lights.add(new Light(x+offset,y,lightWidth,color));
	    		}
    		}
		}
		
		//if BE is a starter extension
		if(runway.bottomExtension.type != null && runway.bottomExtension.type.equals("STARTER_EXTENSION")){
			Color color;
			if(runway.bottomExtension.width < runway.width) color = Color.blue;
			else color = Color.white;
			x = convTopleft.x + (runway.width - runway.bottomExtension.width)/2;
			y = convTopleft.y + runway.height;
			double offset = runway.bottomExtension.width-lightWidth;
			
			if(runway.width<=50){
	    		for(; y<convTopleft.y + runway.height + runway.bottomExtension.height; y+=60){
	    			drawLight(x,y,color,g,a.getScale());
	    			drawLight(x+offset,y,color,g,a.getScale());
	    			//lights.add(new Light(x,y,lightWidth,color));
	    			//lights.add(new Light(x+offset,y,lightWidth,color));
	    		}
    		}else{
    			for(; y<convTopleft.y + runway.height + runway.bottomExtension.height; y+=40){
    				drawLight(x,y,color,g,a.getScale());
	    			drawLight(x+offset,y,color,g,a.getScale());
    				//lights.add(new Light(x,y,lightWidth,color));
	    			//lights.add(new Light(x+offset,y,lightWidth,color));
	    		}
    		}
		}
	}
}