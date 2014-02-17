package com.seg.lights;

import java.awt.Color;
import java.awt.Graphics2D;

import com.seg.AirportComponent;
import com.seg.AirportVisualisation;
import com.seg.Coord;
import com.seg.Runway;

public class CentreLight extends Lighting implements AirportComponent{
	
	public CentreLight(int myType) { type = myType; }
	
	public void setup(Runway runway,  AirportVisualisation a)  {
		
		
	}
	
	public void draw(Graphics2D g, Runway runway, AirportVisualisation a){
		//setup(runway, a);
		this.g = g;
		super.toggleQuality(a.quality);
		
		Coord convCenter = a.mapAxes(new Coord(runway.centerX, runway.centerY));
		if(!runway.approachDirectionIsFromTop())
        {
        	g.rotate(Math.toRadians(180), a.getScale()*convCenter.x, a.getScale()*convCenter.y);
        }
		
		double y;
		int flag;
		Coord convTopleft = a.mapAxes(runway.topLeftCorner());
		double x = convTopleft.x+runway.width/2-lightWidth/2;
		
		//for CAT3
		if(type >= 3){
    		y = convTopleft.y+10;
    		flag = 1;
    		for(; y<convTopleft.y+runway.height; y+=15){
    			if(convTopleft.y+runway.height - y>900)
    				drawLight(x,y,Color.WHITE,g,a.getScale());
    				//lights.add(new Light(x, y, lightWidth, Color.WHITE));
    			else if(convTopleft.y+runway.height - y>300){
    				if(flag%2==0) drawLight(x,y,Color.WHITE,g,a.getScale()); //lights.add(new Light(x, y, lightWidth, Color.WHITE));
    				else drawLight(x,y,Color.RED,g,a.getScale()); //lights.add(new Light(x, y, lightWidth, Color.RED));
    				flag++;
    			}
    			else drawLight(x,y,Color.RED,g,a.getScale());//lights.add(new Light(x, y, lightWidth, Color.RED));
    		}
		}
		//for CAT2 and lower categories
		else{
    		y = convTopleft.y+10;
    		flag = 1;
    		for(; y<convTopleft.y+runway.height; y+=30){
    			if(convTopleft.y+runway.height - y>900)
    				drawLight(x,y,Color.WHITE,g,a.getScale());
    				//lights.add(new Light(x, y, lightWidth, Color.WHITE));
    			else if(convTopleft.y+runway.height - y>300){
    				if(flag%2==0) drawLight(x,y,Color.WHITE,g,a.getScale());//lights.add(new Light(x, y, lightWidth, Color.WHITE));
    				else drawLight(x,y,Color.RED,g,a.getScale());//lights.add(new Light(x, y, lightWidth, Color.RED));
    				flag++;
    			}
    			else drawLight(x,y,Color.RED,g,a.getScale());//lights.add(new Light(x, y, lightWidth, Color.RED)); 
    		}
		}
		
		if(!runway.approachDirectionIsFromTop())
        {
        	g.rotate(Math.toRadians(180), a.getScale()*convCenter.x, a.getScale()*convCenter.y);
        }
	}
}