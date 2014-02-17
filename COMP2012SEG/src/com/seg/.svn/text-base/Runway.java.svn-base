package com.seg;

import java.awt.geom.Rectangle2D;

/**
 * @author SEGg9
 * 
 * This class is used to store all the necessary information about a runway.
 */
public class Runway extends Rectangle2D.Double
{
    public final int UID;
    public final double centerX;
    public final double centerY;
    public final double orientation;
    public Extension topExtension;
    public Extension bottomExtension;
    public double runwayWidth;
    public boolean topIsApproachDirection = true;
    public double runwayHeight;

    public abstract class Extension extends Rectangle2D.Double
    {
    	public final int UID;
        public final String type;
        
        Extension (int uid, String t,  double w, double h)
        {
            UID = uid;
            height = h;
            type = t;
            if(w==0) width=runwayWidth; else width = w;
        }
        
        public abstract Coord extTopLeftCorner();
        
        public Coord center()
        {
        	return new Coord(centerX, centerY);
        }
        
        public double runwayWidth()
        {
        	return runwayWidth;
        }
    }
    
    public class TopExtension extends Extension
    {
        TopExtension (int uid, String t,  double w, double h)
        {
            super(uid,t,w,h);
        }
        
        public Coord extTopLeftCorner()
        {
        	Coord corner = new Coord(
        			centerX - width/2,
        			topLeftCorner().y + height);
        	return corner;
        }
    }

    public class BottomExtension extends Extension
    {
        BottomExtension (int uid, String t,  double w, double h)
        {
            super(uid,t,w,h);
        }
        
        public Coord extTopLeftCorner()
        {
        	Coord corner = new Coord(
        			centerX - width/2,
        			topLeftCorner().y - runwayHeight);
        	return corner;
        }
    }   
	
    Runway (int uid, double x, double y, double o,  double w, double h)
    {
        UID = uid;
        centerX = x;
        centerY = y;
        orientation = o;
        width = w;
        height = h;
        runwayWidth = width;
        runwayHeight = height;
        topExtension = new TopExtension(0,null,0,0);
        bottomExtension = new BottomExtension(0,null,0,0);
    }

    void topExtension (int uid, String t, double w, double h)
    {
        topExtension = new TopExtension(uid, t, w, h);
    }

    void bottomExtension (int uid, String t, double w, double h)
    {
        bottomExtension = new BottomExtension(uid, t, w, h);
    }
    
    public Boundaries getBoundaries ()
    {  
        double topRun, bottomRun, leftRun, rightRun;

        if (orientation<45)
        { 
            topRun=centerY+height/2+topExtension.height;
            bottomRun=centerY-height/2-bottomExtension.height;
            leftRun=centerX-((width+height)/2+bottomExtension.height)/Math.sqrt(2);
            rightRun=centerX+((width+height)/2+topExtension.height)/Math.sqrt(2);              
        }
        else 
        { 
            topRun=centerY+((width+height)/2+topExtension.height)/Math.sqrt(2);
            bottomRun=centerY-((width+height)/2+bottomExtension.height)/Math.sqrt(2);
            leftRun=centerX-height/2-bottomExtension.height;
            rightRun=centerX+height/2+topExtension.height;        
        }
        return new Boundaries(topRun, bottomRun, leftRun, rightRun);
    }
    
    public Coord topLeftCorner ()
    { 
        Coord p=new Coord(centerX-width/2, centerY+height/2);
        return p;
    }
    
    public boolean approachDirectionIsFromTop()
    {
    	return topIsApproachDirection;
    }
    
    public void toggleApproachDirection()
    {
    	topIsApproachDirection = !topIsApproachDirection;
    }
}