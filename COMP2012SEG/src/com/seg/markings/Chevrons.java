package com.seg.markings;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.seg.AirportVisualisation;
import com.seg.Coord;
import com.seg.Runway;

class Chevrons
{
    Graphics2D g;
    Runway.Extension extension;
    
    int noOfChevrons;
    double length;
    double width = 0.9;
    double angle = Math.toRadians(135);
    double spacing = 30;
    double offset = 0;
    
    public Chevrons()
    {
        
    }
    
    private void setup(Graphics2D g, Runway.Extension extension)
    {
        this.g=g;
        this.extension=extension;
        
        noOfChevrons = (int)((int)(extension.height/spacing));
        length = ((extension.width / 2) - 7.5) / Math.sin(Math.toRadians(45));
        
        //offset = 1.5 + Math.cos(Math.toRadians(45)) * width;
    }
    
    public void draw(Graphics2D g, Runway.Extension extension, AirportVisualisation a)
    {
        setup(g, extension);
        
        if(a.day)
            g.setColor(Color.YELLOW);
        else
            g.setColor(Color.yellow.darker().darker().darker());
        
        for(int i=0;i<noOfChevrons;i++)
        {
            Coord leftRectPos = new Coord(
                    extension.center().x,
                    extension.extTopLeftCorner().y - extension.height + (i*spacing) - offset);
            Coord rightRectPos = new Coord(
                    extension.center().x,
                    extension.extTopLeftCorner().y - extension.height + (i*spacing) - offset);
            
            Coord convLeftRectPos = a.mapAxes(leftRectPos);
            Coord convRightRectPos = a.mapAxes(rightRectPos);
            
            g.rotate(-angle, a.getScale()*convLeftRectPos.x, a.getScale()*convLeftRectPos.y);
            drawComponentRect(leftRectPos, a);
            g.rotate(angle, a.getScale()*convLeftRectPos.x, a.getScale()*convLeftRectPos.y);
            g.rotate(angle, a.getScale()*convRightRectPos.x, a.getScale()*convRightRectPos.y);
            g.translate(a.getScale()*width*-1, 0);
            drawComponentRect(rightRectPos, a);
            g.translate(a.getScale()*width, 0);
            g.rotate(-angle, a.getScale()*convRightRectPos.x, a.getScale()*convRightRectPos.y);
        }
    }
    
    // Draws a component rectangle of the whole chevron
    private void drawComponentRect(Coord drawingPoint, AirportVisualisation a)
    {
        Coord convDrawingPoint = a.mapAxes(drawingPoint);
        Rectangle2D crossComp = new Rectangle2D.Double(a.getScale()*convDrawingPoint.x, a.getScale()*convDrawingPoint.y, a.getScale()*width, a.getScale()*length);
        g.fill(crossComp);
    }
}