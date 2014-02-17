/**
 * @author SEGg9
 * 
 * The Airport class stores information about an airport, such as it's name, an ArrayList of it's runways, etc.
 */

package com.seg;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;


public class Airport 
{
    private static final long serialVersionUID = 1L;
    private String airportName;
    private String airportCreated;
    private ArrayList<Runway> runways = new ArrayList<Runway>();
    private ArrayList<TaxiwayJoin> taxiwayJoins = new ArrayList<TaxiwayJoin>();
    private ArrayList<TaxiwayRunwayJoin> taxiwayRunwayJoins = new ArrayList<TaxiwayRunwayJoin>();
    private ArrayList<TaxiwaySection> taxiwaySections = new ArrayList<TaxiwaySection>();
    private Boundaries boundaries;

    public Airport (String XMLFilename)
    {
        XMLConverter.convert(XMLFilename, this);
        boundaries = calculateBoundaries();
    }

    public ArrayList<Runway> getRunway ()
    {
        return runways;
    }

    public ArrayList<TaxiwayJoin> getTaxiwayJoin ()
    {
        return taxiwayJoins;
    }

    public ArrayList<TaxiwayRunwayJoin> getTaxiwayRunwayJoin ()
    {
        return taxiwayRunwayJoins;
    }

    public ArrayList<TaxiwaySection> getTaxiwaySection ()
    {
        return taxiwaySections;
    }

    public String getAirportName()
    {
        return airportName;
    }

    public void setAirportName (String airportName)
    {
        this.airportName = airportName;
    }
    
    public String getAirportCreated ()
    {
        return airportCreated;
    }
    
    public void setAirportCreated (String airportCreated)
    {
        this.airportCreated = airportCreated;
    }
    
    public Boundaries getBoundaries ()
    {
        return boundaries;
    }
    
    /**
     * Gets the boundaries of the airport.
     */
    private Boundaries calculateBoundaries ()
    {
        Boundaries newBoundaries = new Boundaries(0,0,0,0);
        Boundaries overallBoundaries = new Boundaries(0,0,0,0);
        
        for (Runway r: runways)
        {
            newBoundaries = r.getBoundaries();
            if (overallBoundaries.top<newBoundaries.top) overallBoundaries.top=newBoundaries.top;
            if (overallBoundaries.bottom>newBoundaries.bottom) overallBoundaries.bottom=newBoundaries.bottom;
            if (overallBoundaries.left>newBoundaries.left) overallBoundaries.left=newBoundaries.left;
            if (overallBoundaries.right<newBoundaries.right) overallBoundaries.right=newBoundaries.right;
        }
       
        for (TaxiwayJoin tj: taxiwayJoins)
        {
            if (overallBoundaries.top<tj.joinY) overallBoundaries.top=tj.joinY;
            if (overallBoundaries.bottom>tj.joinY) overallBoundaries.bottom=tj.joinY;
            if (overallBoundaries.left>tj.joinX) overallBoundaries.left=tj.joinX;
            if (overallBoundaries.right<tj.joinX) overallBoundaries.right=tj.joinX; 
        }
        
        // boundries must be modified in order to see the approach lighting (goes at the front of a runway)
        overallBoundaries.top+=950;
        overallBoundaries.right+=950;
        
        overallBoundaries.top+=1000;
        overallBoundaries.bottom-=1000;
        overallBoundaries.left-=1000;
        overallBoundaries.right+=1000;
        
        return overallBoundaries;
    }
}
