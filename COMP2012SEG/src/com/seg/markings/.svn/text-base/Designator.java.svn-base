package com.seg.markings;

import java.awt.Graphics2D;
import java.awt.Image;

import com.seg.*;


public class Designator  implements AirportComponent {
    Graphics2D g;
    Runway runway;
    Configuration config;
    
    int digits;
    int digitOne;
    int digitTwo;
    Image digitOneImage = null;
    Image digitTwoImage = null;
    Image letterImage = null;
    
    int other_digits;
    int other_digitOne;
    int other_digitTwo;
    Image other_digitOneImage = null;
    Image other_digitTwoImage = null;
    Image other_letterImage = null;
    
    int designatorOffset = 6;
    int numberOffset = 0;
    int characterHeight = 0;
    double characterSpacing = 5;
    int letterOffset = 6;
    double scale;

    private void setup(Graphics2D g, Runway runway, AirportVisualisation a)
    {
    	this.g = g;
        this.runway = runway;
        this.scale = a.getScale();
        
     // Determine the numeric part of the designator
    	
    	other_digits = (int) Math.round(runway.orientation / 10);
    	digits = (int) Math.round((runway.orientation + 180) / 10);
        
        if (digits >= 10)
        {
            digitOne = (int) Math.floor(digits / 10);
            digitTwo = digits - (digitOne * 10);
        }
        else
        {
            digitOne = 0;
            digitTwo = digits;
        }
        
        if (other_digits >= 10)
        {
            other_digitOne = (int) Math.floor(other_digits / 10);
            other_digitTwo = other_digits - (other_digitOne * 10);
        }
        else
        {
        	other_digitOne = 0;
        	other_digitTwo = other_digits;
        }
        
        // Read in the numeric part of the designator images
        
        switch (digitOne)
        {
        case 0 : digitOneImage = a.digit_zero; break;
        case 1 : digitOneImage = a.digit_one; break;
        case 2 : digitOneImage = a.digit_two; break;
        case 3 : digitOneImage = a.digit_three; break;
        case 4 : digitOneImage = a.digit_four; break;
        case 5 : digitOneImage = a.digit_five; break;
        case 6 : digitOneImage = a.digit_six; break;
        case 7 : digitOneImage = a.digit_seven; break;
        case 8 : digitOneImage = a.digit_eight; break;
        case 9 : digitOneImage = a.digit_nine;
        }
        switch (digitTwo)
        {
        case 0 : digitTwoImage = a.digit_zero; break;
        case 1 : digitTwoImage = a.digit_one; break;
        case 2 : digitTwoImage = a.digit_two; break;
        case 3 : digitTwoImage = a.digit_three; break;
        case 4 : digitTwoImage = a.digit_four; break;
        case 5 : digitTwoImage = a.digit_five; break;
        case 6 : digitTwoImage = a.digit_six; break;
        case 7 : digitTwoImage = a.digit_seven; break;
        case 8 : digitTwoImage = a.digit_eight; break;
        case 9 : digitTwoImage = a.digit_nine;
        }
        switch (other_digitOne)
        {
        case 0 : other_digitOneImage = a.digit_zero; break;
        case 1 : other_digitOneImage = a.digit_one; break;
        case 2 : other_digitOneImage = a.digit_two; break;
        case 3 : other_digitOneImage = a.digit_three; break;
        case 4 : other_digitOneImage = a.digit_four; break;
        case 5 : other_digitOneImage = a.digit_five; break;
        case 6 : other_digitOneImage = a.digit_six; break;
        case 7 : other_digitOneImage = a.digit_seven; break;
        case 8 : other_digitOneImage = a.digit_eight; break;
        case 9 : other_digitOneImage = a.digit_nine;
        }
        switch (other_digitTwo)
        {
        case 0 : other_digitTwoImage = a.digit_zero; break;
        case 1 : other_digitTwoImage = a.digit_one; break;
        case 2 : other_digitTwoImage = a.digit_two; break;
        case 3 : other_digitTwoImage = a.digit_three; break;
        case 4 : other_digitTwoImage = a.digit_four; break;
        case 5 : other_digitTwoImage = a.digit_five; break;
        case 6 : other_digitTwoImage = a.digit_six; break;
        case 7 : other_digitTwoImage = a.digit_seven; break;
        case 8 : other_digitTwoImage = a.digit_eight; break;
        case 9 : other_digitTwoImage = a.digit_nine;
        }
        
        // Calculate the offset of the numeric part of the designator digits (not taking into account the letter part) and calculate the character height
        if (config == Configuration.VISUAL_REQUIRED || 
				config == Configuration.VISUAL_DESIRABLE || 
				config == Configuration.NONPRECISION_REQUIRED || 
				config == Configuration.NONPRECISION_DESIRABLE)
        {
            // Confused about runway widths. When it says 45, 30, etc. in the table, does it mean >= 45? then >=30 (<45)?
            if (runway.width >= 45)
            {
                characterHeight = 15;
            }
            else if (runway.width >= 30)
            {
                characterHeight = 12;
            }
            else
            {
                characterHeight = 9;
            }
        }
        else
        {
            if (runway.width >= 30)
            {
                characterHeight = 15;
            }
            else
            {
                characterHeight = 12;
            }   
        }
        
        // See whether a letter is necessary, and adjust the offset accordingly
        for(ParallelRunwayGroup parallelGroup : a.parallelGroups)
        {
        	if(parallelGroup.left.UID == runway.UID)
        	{
        		numberOffset = characterHeight + 6;
        		letterImage = a.digit_left;
        		other_letterImage = a.digit_right;
        	}
        	else if(parallelGroup.right.UID == runway.UID)
        	{
        		numberOffset = characterHeight + 6;
        		letterImage = a.digit_right;
        		other_letterImage = a.digit_left;
        	}
        	else if(parallelGroup.centre != null)
        	{
        		if(parallelGroup.centre.UID == runway.UID)
            	{
            		numberOffset = characterHeight + 6;
            		letterImage = a.digit_center;
            		other_letterImage = a.digit_center;
            	}
        	}
        } 
        
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
            int lineLength;
            if (runway.width >= 30)
            {
                lineLength = 30;
            }
            else
            {
                lineLength = 24;
            }
            letterOffset = 6 + lineLength + 12;
            
        }
        
        designatorOffset = letterOffset + numberOffset;
        
        // Calculate space between digits one and two
        if (digitOne == 0 && digitTwo == 1)
        { 
            if (characterHeight == 15)
            { 
                characterSpacing = 3.25; 
            }
            else if (characterHeight == 12)
            { 
                characterSpacing = 2.6;
            }
            else
            {
                characterSpacing = 1.95;
            }
        }
        else if (digitOne == 0 && digitTwo != 1)
        {
            if (characterHeight == 15)
            { 
                characterSpacing = 3.5; 
            }
            else if (characterHeight == 12)
            { 
                characterSpacing = 2.8;
            }
            else
            {
                characterSpacing = 2.1;
            }
        }
        else if (digitOne == 1 && digitTwo == 1)
        {
            if (characterHeight == 15)
            { 
                characterSpacing = 6.25; 
            }
            else if (characterHeight == 12)
            { 
                characterSpacing = 5;
            }
            else
            {
                characterSpacing = 3.75;
            }
        }
        else if (digitOne == 1 && digitTwo != 1)
        {
            if (characterHeight == 15)
            { 
                characterSpacing = 3.75; 
            }
            else if (characterHeight == 12)
            { 
                characterSpacing = 3;
            }
            else
            {
                characterSpacing = 2.25;
            }
        }
        else if (digitOne == 2 && digitTwo == 1)
        {
            if (characterHeight == 15)
            { 
                characterSpacing = 3.25; 
            }
            else if (characterHeight == 12)
            { 
                characterSpacing = 2.6;
            }
            else
            {
                characterSpacing = 1.95;
            }
        }
        else if (digitOne == 2 && digitTwo != 1)
        {
            if (characterHeight == 15)
            { 
                characterSpacing = 3.5; 
            }
            else if (characterHeight == 12)
            { 
                characterSpacing = 2.8;
            }
            else
            {
                characterSpacing = 2.1;
            }
        }
        else if (digitOne == 3 && digitTwo == 1)
        {
            if (characterHeight == 15)
            { 
                characterSpacing = 3.25; 
            }
            else if (characterHeight == 12)
            { 
                characterSpacing = 2.6;
            }
            else
            {
                characterSpacing = 1.95;
            }
        }
        else
        {
            if (characterHeight == 15)
            { 
                characterSpacing = 3.5; 
            }
            else if (characterHeight == 12)
            { 
                characterSpacing = 2.8;
            }
            else 
            {
                characterSpacing = 2.1;
            }
        }
    }
    
    public Designator (Configuration config)
    {
        this.config = config;
    }
    
    public void draw(Graphics2D g, Runway runway, AirportVisualisation a)
    {
        setup(g, runway, a);
    	
        Coord runwayCentre = a.mapAxes(new Coord(runway.centerX, runway.centerY));
    	g.rotate(Math.toRadians(180), a.getScale() * runwayCentre.x, a.getScale() * runwayCentre.y);
        
    	// Calculate the height/width ratios
        double digitOneXYRatio = ((double) digitOneImage.getWidth(null)) / ((double) digitOneImage.getHeight(null));
        double digitTwoXYRatio = ((double) digitTwoImage.getWidth(null)) / ((double) digitTwoImage.getHeight(null));
        double other_digitOneXYRatio = ((double) other_digitOneImage.getWidth(null)) / ((double) other_digitOneImage.getHeight(null));
        double other_digitTwoXYRatio = ((double) other_digitTwoImage.getWidth(null)) / ((double) other_digitTwoImage.getHeight(null));
        // Create the coordinates for digits one and two
        Coord topLeftDigitOne = a.mapAxes(new Coord(
                runway.centerX - (characterHeight * digitOneXYRatio) - (characterSpacing / 2),
                runway.centerY - (runway.height / 2) + characterHeight + designatorOffset));
        Coord topLeftDigitTwo = a.mapAxes(new Coord(
                runway.centerX + (characterSpacing / 2),
                runway.centerY - (runway.height / 2) + characterHeight + designatorOffset));
        // Draw the numeric part of the designator (not taking into account the letter part)
        g.drawImage(digitOneImage, (int) (a.getScale() * topLeftDigitOne.x), (int) (a.getScale() * topLeftDigitOne.y), 
                (int) (a.getScale() * characterHeight * digitOneXYRatio), (int) (a.getScale() * characterHeight), null);
        g.drawImage(digitTwoImage, (int) (a.getScale() * topLeftDigitTwo.x), (int) (a.getScale() * topLeftDigitTwo.y), 
                (int) (a.getScale() * characterHeight * digitTwoXYRatio), (int) (a.getScale() * characterHeight), null);
        /* (SHOULD POSSIBLY FACTOR IN WHETHER THAT NOT ALL CHARACTERS ARE THE SAME HEIGHT AND THAT PERHAPS CHARACTER 
            HEIGHT IS MIN CHARACTER HEIGHT (i.e. 6 and 9 are 9.5 when others are 9)?) */
        
        /*Drawing the letter part (if required)*/
        if(letterImage != null)
        {
        	double letterXYRatio = ((double) letterImage.getWidth(null)) / ((double) letterImage.getHeight(null));
        	
        	Coord topLeftLetter = a.mapAxes(new Coord(
                    runway.centerX - (characterHeight * letterXYRatio / 2),
                    runway.centerY - (runway.height / 2) + characterHeight + letterOffset));
        	
        	g.drawImage(letterImage, (int) (a.getScale() * topLeftLetter.x), (int) (a.getScale() * topLeftLetter.y), 
                    (int) (a.getScale() * characterHeight * letterXYRatio), (int) (a.getScale() * characterHeight), null);
        }
        
        /*Drawing the designator on the other side*/
        g.rotate(Math.toRadians(180), a.getScale() * runwayCentre.x, a.getScale() * runwayCentre.y);
    	
        // Draw the numeric part of the designator (not taking into account the letter part)
        g.drawImage(other_digitOneImage, (int) (a.getScale() * topLeftDigitOne.x), (int) (a.getScale() * topLeftDigitOne.y), 
                (int) (a.getScale() * characterHeight * other_digitOneXYRatio), (int) (a.getScale() * characterHeight), null);
        g.drawImage(other_digitTwoImage, (int) (a.getScale() * topLeftDigitTwo.x), (int) (a.getScale() * topLeftDigitTwo.y), 
                (int) (a.getScale() * characterHeight * other_digitTwoXYRatio), (int) (a.getScale() * characterHeight), null);
        /* (SHOULD POSSIBLY FACTOR IN WHETHER THAT NOT ALL CHARACTERS ARE THE SAME HEIGHT AND THAT PERHAPS CHARACTER 
            HEIGHT IS MIN CHARACTER HEIGHT (i.e. 6 and 9 are 9.5 when others are 9)?) */

        /*Drawing the letter part (if required)*/
        if(other_letterImage != null)
        {
        	double letterXYRatio = ((double) other_letterImage.getWidth(null)) / ((double) other_letterImage.getHeight(null));
        	
        	Coord topLeftLetter = a.mapAxes(new Coord(
                    runway.centerX - (characterHeight * letterXYRatio / 2),
                    runway.centerY - (runway.height / 2) + characterHeight + letterOffset));
        	
        	g.drawImage(other_letterImage, (int) (a.getScale() * topLeftLetter.x), (int) (a.getScale() * topLeftLetter.y), 
                    (int) (a.getScale() * characterHeight * letterXYRatio), (int) (a.getScale() * characterHeight), null);
        }
    }
    
    public int length()
    {
    	if(letterImage != null)
    	{
    		return 2*characterHeight + 6;
    	}
    	else
    	{
    		return characterHeight;
    	}
    }
}