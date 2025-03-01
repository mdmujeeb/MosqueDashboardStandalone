package com.mujeeb.mosquedashboard.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class JPanelWithRoundedBorder extends JPanel {

	private static final long serialVersionUID = 1L;
	
	@Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    
	    Dimension arcs = new Dimension(20,20);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(Color.CYAN);
        graphics.drawRoundRect(5, 5, width-10, height-10, arcs.width, arcs.height);//paint border
	}
}
