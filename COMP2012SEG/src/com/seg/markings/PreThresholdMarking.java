package com.seg.markings;

import java.awt.Graphics2D;

import com.seg.*;

/*This class represents all of the possible markings that can appear on an extension. It decides which
 * to draw based on the 'type' attribute of the extension.*/
public class PreThresholdMarking implements AirportComponent{
	
	Graphics2D g;
	Runway runway;
	Configuration config;
	
	private void setup(Graphics2D g, Runway runway)
	{
		this.g=g;
		this.runway=runway;
	}
	
	public PreThresholdMarking(Configuration config)
	{
		this.config = config;
	}
	
	public void draw(Graphics2D g, Runway runway, AirportVisualisation a)
	{
		setup(g, runway);
		
		if (runway.topExtension.UID != 0) //If the top extension exists
		{
			if (runway.topExtension.type.equals("UNFIT_FOR_USE")){
				new Crosses().draw(g,  runway.topExtension, a);
			}else if (runway.topExtension.type.equals("STOPWAY")){
				new Chevrons().draw(g,  runway.topExtension, a);
			}else{
				new Arrows().draw(g,  runway.topExtension, a);
			}
		}
		if (runway.bottomExtension.UID != 0) //If the bottom extension exists
		{
			if (runway.bottomExtension.type.equals("UNFIT_FOR_USE")){
				new Crosses().draw(g,  runway.bottomExtension, a);
			}else if (runway.bottomExtension.type.equals("STOPWAY")){
				new Chevrons().draw(g,  runway.bottomExtension, a);
			}else{
				new Arrows().draw(g,  runway.bottomExtension, a);
			}
		}
	}
}
