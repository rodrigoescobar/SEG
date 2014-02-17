package com.seg.markings;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.seg.*;

public class Edges implements AirportComponent{
    // Making the assumption that precision runways are >=2... Is this correct?
    Graphics2D g;
    Runway runway;
    Configuration config;
    double lineWidth;
    double lineLength;

    private void setup(Graphics2D g, Runway runway)
    {
    	this.g = g;
        this.runway = runway;
        lineLength = runway.height;
        if (runway.width >= 30)
            lineWidth = 0.9;
        else
            lineWidth = 0.45;
    }
    
    public Edges (Configuration config)
    {
    	this.config = config;
    }
    
    public void draw(Graphics2D g, Runway runway, AirportVisualisation a)
    {
        setup(g, runway);
    	
    	if (config == Configuration.CATI_REQUIRED || 
				config == Configuration.CATI_DESIRABLE || 
				config == Configuration.CATII_REQUIRED || 
				config == Configuration.CATII_DESIRABLE ||
				config == Configuration.CATIIIA_REQUIRED || 
				config == Configuration.CATIIIA_DESIRABLE || 
				config == Configuration.CATIIIB_REQUIRED || 
				config == Configuration.CATIIIB_DESIRABLE ||
				config == Configuration.CATIIIC_REQUIRED || 
				config == Configuration.CATIIIC_DESIRABLE)
        {
            // Only draw edge markings on precision runways
            // Light widths = 2
    		if(a.day)
    			g.setColor(Color.WHITE);
    		else
    			g.setColor(Color.white.darker().darker().darker());
            Coord bottomleft = a.mapAxes(new Coord(
                                runway.centerX - (runway.width / 2),// + 2,
                                runway.centerY + (runway.height / 2))
                        );
            Coord bottomright = a.mapAxes( 
                        new Coord(
                                runway.centerX + (runway.width / 2) - lineWidth,// - 2,
                                runway.centerY + (runway.height / 2))
                        );
            g.fill(new Rectangle2D.Double((a.getScale() * bottomleft.x), (a.getScale() * bottomleft.y), (a.getScale() * lineWidth), (a.getScale() * lineLength)));
            g.fill(new Rectangle2D.Double((a.getScale() * bottomright.x), (a.getScale() * bottomright.y), (a.getScale() * lineWidth), (a.getScale() * lineLength)));
        }
    }
}