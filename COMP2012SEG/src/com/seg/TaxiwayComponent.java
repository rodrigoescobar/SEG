package com.seg;
import java.awt.Graphics2D;

import com.seg.AirportVisualisation;
import com.seg.TaxiwaySection;


public interface TaxiwayComponent {

	public void draw(Graphics2D g, TaxiwaySection taxiway, AirportVisualisation a);
}
