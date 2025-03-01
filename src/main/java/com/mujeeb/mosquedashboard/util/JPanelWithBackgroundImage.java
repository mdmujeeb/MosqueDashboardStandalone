package com.mujeeb.mosquedashboard.util;

import java.awt.Graphics;
import java.awt.Image;

public class JPanelWithBackgroundImage extends JPanelWithRoundedBorder {

	private static final long serialVersionUID = 1L;
	
	protected Image bgImage;
	
	public JPanelWithBackgroundImage(Image bgImage) {
		this.bgImage = bgImage;
	}

	@Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(bgImage, 0, 0, null);
	}
}
