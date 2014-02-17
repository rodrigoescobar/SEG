package com.seg.lights;

import java.awt.Color;
import java.awt.Graphics2D;

import com.seg.AirportComponent;
import com.seg.AirportVisualisation;
import com.seg.Coord;
import com.seg.Runway;

public class Calvert extends Lighting implements AirportComponent{
	
	public Calvert(int myType) { type=myType; }
	
	public void draw(Graphics2D g, Runway runway, AirportVisualisation a) {
		double scale=a.getScale();
		super.toggleQuality(a.quality);
		
		Coord convCenter = a.mapAxes(new Coord(runway.centerX, runway.centerY));
		if(!runway.approachDirectionIsFromTop())
        {
        	g.rotate(Math.toRadians(180), scale*convCenter.x, scale*convCenter.y);
        }
		
		//g.setColor(Color.WHITE);
		Color c = Color.WHITE;
		
		Coord convTopleft = a.mapAxes(runway.topLeftCorner());
		double x = convTopleft.x+runway.width/2-lightWidth/2+0.5;
		double y = convTopleft.y-2;
		
		double i;
		// 900m line of white lights on the extended centreline of the runway
		for (i=y; i>=y-300; i-=2.5)
			drawLight(x, i, c, g, scale);
			//g.fillOval((int)(x*scale), (int)(i*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
		for (;i>=y-600; i-=2.5)
			{  //g.fillOval((int)((x-1.2)*scale), (int)(i*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
			   //g.fillOval((int)((x+1.2)*scale), (int)(i*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
				drawLight(x-1.2, i, c, g, scale);
				drawLight(x+1.2, i, c, g, scale);
			}
	    for (;i>=y-900; i-=2.5)
    		{ //g.fillOval((int)((x-2.2)*scale), (int)(i*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
    		  //g.fillOval((int)(x*scale), (int)(i*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
    		  //g.fillOval((int)((x+2.2)*scale), (int)(i*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
	    		drawLight(x-2.2, i, c, g, scale);
	    		drawLight(x, i, c, g, scale);
	    		drawLight(x+2.2, i, c, g, scale);
    		}
	    // 5 crossbars at 150m intervals
    	y-=150; 
    	for (i=1; i<=4; i++)
    		//g.fillOval((int)((x+2.7*i)*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
    		drawLight(x+2.7*i, y, c, g, scale);
    	for (i=1; i<=4; i++)
    		//g.fillOval((int)((x-2.7*i)*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
    		drawLight(x-2.7*i, y, c, g, scale);
    	y-=150; 
    	for (i=1; i<=5; i++)
    		//g.fillOval((int)((x+2.7*i)*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
    		drawLight(x+2.7*i, y, c, g, scale);
    	for (i=1; i<=5; i++)
    		//g.fillOval((int)((x-2.7*i)*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
    		drawLight(x-2.7*i, y, c, g, scale);
    	y-=150; 
    	for (i=1, x+=1.5; i<=6; i++)
    		//g.fillOval((int)((x+2.7*i)*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
    		drawLight(x+2.7*i, y, c, g, scale);
    	for (i=1, x-=3; i<=6; i++)
    		//g.fillOval((int)((x-2.7*i)*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
    		drawLight(x-2.7*i, y, c, g, scale);
    	y-=150; 
    	for (i=1, x+=4; i<=7; i++)
    		//g.fillOval((int)((x+2.7*i)*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
    		drawLight(x+2.7*i, y, c, g, scale);
    	for (i=1, x-=5; i<=7; i++)
    		//g.fillOval((int)((x-2.7*i)*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
    		drawLight(x-2.7*i, y, c, g, scale);
    	y-=150; 
    	for (i=2, x+=4.5; i<=9; i++)
    		//g.fillOval((int)((x+2.7*i)*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
    		drawLight(x+2.7*i, y, c, g, scale);
    	for (i=2, x-=4; i<=9; i++)
    		//g.fillOval((int)((x-2.7*i)*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
    		drawLight(x-2.7*i, y, c, g, scale);
    	
    	// if type=1 (catII and catIII ) we have to add Supplementary Lights 
    	if (type==1) {
    		y+=750; x+=2;
    		for (i=y; i>=y-300; i-=2.5)
    			{ //g.setColor(Color.WHITE);
    				Color c1 = Color.WHITE;
    			  //g.fillOval((int)((x+2.7)*scale), (int)(i*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
    				drawLight(x+2.7, i, c1, g, scale);
    			  //g.fillOval((int)((x+5.4)*scale), (int)(i*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
    				drawLight(x+5.4, i, c1, g, scale);
    			  //g.fillOval((int)((x-2.7)*scale), (int)(i*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
    				drawLight(x-2.7, i, c1, g, scale);
    			  //g.fillOval((int)((x-5.4)*scale), (int)(i*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
    				drawLight(x-5.4, i, c1, g, scale);
    		      if (i!=y-300)
	        		   {  //g.setColor(Color.RED);
    		    	  		Color c2 = Color.RED;
	        			  float j=(float) (x+10.5);
	        			  for (int k=1; k<=4; k++)
	        				  //g.fillOval((int)((j+2.5*k)*scale), (int)(i*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
	        				  drawLight(j+2.5*k, i, c2, g, scale);
	        			  j=(float) (x-10.5);
	        			  for (int k=1; k<=4; k++)
	        				  //g.fillOval((int)((j-2.5*k)*scale), (int)(i*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
	        				  drawLight(j-2.5*k, i, c2, g, scale);
	        			}
    			}
    	}
		if(!runway.approachDirectionIsFromTop())
        {
        	g.rotate(Math.toRadians(180), scale*convCenter.x, scale*convCenter.y);
        }
	}
}