package com.seg.lights;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Lighting{
	protected final double lightWidth = 3;
	int type;
	Graphics2D g;
	private final float[] dist = {0f, 1f};
	protected boolean quality = true;
	
	protected void toggleQuality(boolean quality){
		this.quality = quality;
	}
	
	protected void drawLight(double x, double y, Color colour, Graphics2D g, double scale)
    {   
		if(!quality){
			g.setColor(colour);
			g.fillOval((int)(x*scale), (int)(y*scale),(int)(lightWidth*scale), (int)(lightWidth*scale));
		}else{
			Point2D point = new Point2D.Double((x+lightWidth/2)*scale,(y+lightWidth/2)*scale);
	    	Color transparent = new Color(colour.getRed(), colour.getGreen(), colour.getBlue(), 0);
	    	Color[] colours = {colour, transparent};
	    	RadialGradientPaint grad = new RadialGradientPaint(point, (float)((lightWidth*scale)/2), dist, colours);
	    	g.setPaint(grad);
	    	Ellipse2D lightDrawing = new Ellipse2D.Double(scale*x, scale*y, scale*lightWidth, scale*lightWidth);
	    	g.fill(lightDrawing);
	    	g.setPaint(null);
		}
    }
}