package com.seg.lights;

import com.seg.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Papi implements AirportComponent{
	private final double lightWidth = 4;
	double angle,x,y,scale;
	Graphics2D g;
	Runway runway;
	
	public Papi(int myAngle) {  angle=myAngle; }
	
	// draw lights according the given angle
	public void draw(Graphics2D g, Runway r, AirportVisualisation a){
		this.g=g; this.scale=a.getScale(); runway=r;
		int i;
		
		Coord convCenter = a.mapAxes(new Coord(runway.centerX, runway.centerY));
		if(!runway.approachDirectionIsFromTop())
        {
        	g.rotate(Math.toRadians(180), scale*convCenter.x, scale*convCenter.y);
        }
		
		Coord convTopleft = a.mapAxes(runway.topLeftCorner());
		x = convTopleft.x+runway.width+15;
		y = convTopleft.y+runway.height/4;
		
		if (angle<25)
		   { g.setColor(Color.RED);
    		 for (i=0; i<=3; i++) 
    			g.fill(new Rectangle2D.Double(((x+i*9)*scale), (y*scale), (lightWidth*scale), (lightWidth*scale)));
    			 //g.fillRect((int)((x+i*9)*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
		   }
		else if (angle>=25 && angle<40)
    	   { g.setColor(Color.RED);
   		 	 for (i=0; i<=2; i++) 
   		 		g.fill(new Rectangle2D.Double(((x+i*9)*scale), (y*scale), (lightWidth*scale), (lightWidth*scale)));
   		 		 //g.fillRect((int)((x+i*9)*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
   		 	 g.setColor(Color.WHITE);
   		 	 	g.fill(new Rectangle2D.Double(((x+3*9)*scale), (y*scale), (lightWidth*scale), (lightWidth*scale)));
   		 	 	//g.fillRect((int)((x+3*9)*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
		   }
    		else if (angle>=40 && angle<55)
	    	   { g.setColor(Color.RED);
	   		 	 for (i=0; i<=1; i++) 
	   		 		g.fill(new Rectangle2D.Double(((x+i*9)*scale), (y*scale), (lightWidth*scale), (lightWidth*scale)));
	   		 		 //g.fillRect((int)((x+i*9)*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
	   		 	 g.setColor(Color.WHITE);
	   		 	 for (i=2; i<=3; i++) 
	   		 		g.fill(new Rectangle2D.Double(((x+i*9)*scale), (y*scale), (lightWidth*scale), (lightWidth*scale)));
	   		 		 //g.fillRect((int)((x+i*9)*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
			   }
	    		else if (angle>=55 && angle<70)
		    	   { g.setColor(Color.RED);
		    	   g.fill(new Rectangle2D.Double(((x)*scale), (y*scale), (lightWidth*scale), (lightWidth*scale)));
		    	   //g.fillRect((int)(x*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
		   		 	 g.setColor(Color.WHITE);
		   		 	 for (i=1; i<=3; i++) 
		   		 		g.fill(new Rectangle2D.Double(((x+i*9)*scale), (y*scale), (lightWidth*scale), (lightWidth*scale)));
		   		 		 //g.fillRect((int)((x+i*9)*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
				   }
		    		else if (angle>=70)
			    	   { g.setColor(Color.WHITE);
			   		 	 for (i=0; i<=3; i++) 
			   		 		g.fill(new Rectangle2D.Double(((x+i*9)*scale), (y*scale), (lightWidth*scale), (lightWidth*scale)));
			   		 		 //g.fillRect((int)((x+i*9)*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
					   }	
		if(!runway.approachDirectionIsFromTop())
        {
        	g.rotate(Math.toRadians(180), scale*convCenter.x, scale*convCenter.y);
        }
	}
}
