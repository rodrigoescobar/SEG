/**
 * @author SEGg9
 * 
 * This class takes an XML file representation of an airport, and creates an {@link Airport} object with it.
 */
package com.seg;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class XMLConverter
{ 
    
    public static void convert (String XMLFilename, Airport airport)
    {
        try
        {
            BufferedReader file = new BufferedReader(new FileReader(XMLFilename));
            String line = "init";
            
            while (true)
            {
                line = file.readLine();
                if(line == null) break;

                if (XMLConverter.getAttribute(line).equals("airportName")) 
                    airport.setAirportName(XMLConverter.getString(line));
                
                if (XMLConverter.getAttribute(line).equals("airportCreated"))
                    airport.setAirportCreated(XMLConverter.getString(line));

                // If this is the line that a block begins(i.e. a parent node)
                if (!(line.contains("?xml")) && (line.charAt(line.indexOf('<')+1)!='/') &&
                        (line.indexOf('<', line.indexOf('>'))==-1))
                {
                    // Save the attribute between '<>'
                    String attribute = XMLConverter.getAttribute(line);
                    if(attribute.equals("Airport")) continue; // Skip if it's 'Airport'
                    // This is used to save the whole block which is currently reading
                    ArrayList<String> block = new ArrayList<String>();

                    // Read the block and add as lines into the ArrayList
                    while (!line.contains("/"+attribute))
                    {
                        block.add(line);
                        line=file.readLine();
                    }

                    // Call the respective add function according to the attribute type
                    if (attribute.equals("runway"))
                    {
                        XMLConverter.addRunway(block, airport);
                    }
                    else if (attribute.equals("taxiwayJoin"))
                    {
                        XMLConverter.addTaxiwayJoin(block, airport);
                    }
                    else if (attribute.equals("taxiwayRunwayJoin"))
                    {
                        XMLConverter.addTaxiwayRunwayJoin(block, airport);
                    }
                    else if (attribute.equals("taxiwaySection"))
                    {
                        XMLConverter.addTaxiwaySection(block, airport);
                    }
                    else System.err.println("Unknown attribute");
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    private static void addTaxiwayJoin (ArrayList<String> list, Airport airport)
    {
        int UID = Integer.parseInt(list.get(0).substring(list.get(0).indexOf("\"")+1, list.get(0).lastIndexOf("\"")));
        double x = XMLConverter.getNum(list.get(1));
        double y = XMLConverter.getNum(list.get(2));
        airport.getTaxiwayJoin().add(new TaxiwayJoin(UID,x,y));
    }

    private static void addTaxiwayRunwayJoin (ArrayList<String> list, Airport airport)
    {
        int UID = Integer.parseInt(list.get(0).substring(list.get(0).indexOf("\"")+1, list.get(0).lastIndexOf("\"")));
        double x = XMLConverter.getNum(list.get(1));
        double y = XMLConverter.getNum(list.get(2));
        int rID = (int) XMLConverter.getNum(list.get(3));
        airport.getTaxiwayRunwayJoin().add(new TaxiwayRunwayJoin(UID,x,y,rID));
    }

    private static void addTaxiwaySection (ArrayList<String> list, Airport airport)
    {
        int UID = Integer.parseInt(list.get(0).substring(list.get(0).indexOf("\"")+1, list.get(0).lastIndexOf("\"")));
        int sID = (int) XMLConverter.getNum(list.get(1));
        int eID = (int) XMLConverter.getNum(list.get(2));
        int w = (int) XMLConverter.getNum(list.get(3));
        airport.getTaxiwaySection().add(new TaxiwaySection(UID,sID,eID,w));
    }

    private static void addRunway (ArrayList<String> list, Airport airport)
    {
        int UID = Integer.parseInt(list.get(0).substring(list.get(0).indexOf("\"")+1, list.get(0).lastIndexOf("\"")));
        double x = XMLConverter.getNum(list.get(1));
        double y = XMLConverter.getNum(list.get(2));
        double ori = XMLConverter.getNum(list.get(3));
        double l = XMLConverter.getNum(list.get(4));
        double w = XMLConverter.getNum(list.get(5));
        Runway rw = new Runway(UID,x,y,ori,w,l);
        airport.getRunway().add(rw);
        int size = list.size();
        // Determine the existence of TE and BE, if so store the positions of their first line
        int whereTopExtension = -1;
        int whereBottomExtension = -1;
        
        for (int i=6; i<size; i++)
        {
            if (list.get(i).contains("<topExtension"))
            {
                whereTopExtension = i;
            }
            else if (list.get(i).contains("<bottomExtension"))
            {
                whereBottomExtension = i;
            }
        }

        // If TE exists, read its attributes and initiate the TE instance in its corresponding Runway object
        if (whereTopExtension != -1)
        {
        	double topl = XMLConverter.getNum(list.get(whereTopExtension+1));
            String topt = XMLConverter.getString(list.get(whereTopExtension+2));
            double topw = 0;
            
            if (XMLConverter.getAttribute(list.get(whereTopExtension+3)).equals("width"))
            {
                topw = XMLConverter.getNum(list.get(whereTopExtension+3));
            }
            int topUID = Integer.parseInt(list.get(whereTopExtension).substring(
                    list.get(whereTopExtension).indexOf("\"")+1, 
                    list.get(whereTopExtension).lastIndexOf("\"")));
            rw.topExtension(topUID, topt, topw, topl);
        }

        // Same as above, but for BE
        if (whereBottomExtension != -1)
        {
        	double botl = XMLConverter.getNum(list.get(whereBottomExtension+1));
            String bott = XMLConverter.getString(list.get(whereBottomExtension+2));
            double botw = 0;
            if (XMLConverter.getAttribute(list.get(whereBottomExtension+3)).equals("width"))
            {
                botw = XMLConverter.getNum(list.get(whereBottomExtension+3));
            }
            int botUID = Integer.parseInt(list.get(whereBottomExtension).substring(
                    list.get(whereBottomExtension).indexOf("\"")+1, 
                    list.get(whereBottomExtension).lastIndexOf("\"")));
            rw.bottomExtension(botUID, bott, botw, botl);
        }
    }
    
    // Return the string (which is the attribute) in the line given
    public static String getAttribute (String line)
    {
        if (line.contains("="))
        {
            return line.substring(line.indexOf('<')+1, line.indexOf(' ', line.indexOf('<')));
        }
        else
        {
            return line.substring(line.indexOf('<')+1, line.indexOf('>'));
        }
    }
    
    // Return the value of the attribute as a double float in the line given
    public static double getNum (String line)
    {
        return Double.parseDouble(line.substring(line.indexOf('>')+1, line.lastIndexOf('<')));
    }
    
    public static String getString (String line)
    {
        return line.substring(line.indexOf('>')+1, line.lastIndexOf('<'));
    }
}