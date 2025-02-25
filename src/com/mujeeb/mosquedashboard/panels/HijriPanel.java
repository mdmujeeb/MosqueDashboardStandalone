package com.mujeeb.mosquedashboard.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.mujeeb.mosquedashboard.main.Main;
import com.mujeeb.mosquedashboard.util.JPanelWithBackgroundImage;

public class HijriPanel extends JPanelWithBackgroundImage {

	private static final long serialVersionUID = 1L;
	
	protected Date currentTime = new Date();
	protected JLabel dateLabel = new JLabel();
	protected JLabel moonImageLabel = new JLabel();
	
	protected static Image backgroundImage = new ImageIcon("res/sky.jpg").getImage();
	
	public HijriPanel() {
		super(backgroundImage);
		
		setOpaque(false);
		setPreferredSize(new Dimension((int)(Main.windowWidth/3), (int)(Main.windowHeight/3)));
		
		setLayout(new GridLayout(2, 1));
		
		dateLabel.setText("8 Jumada II 1443");
		dateLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/22));
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setHorizontalAlignment(JLabel.CENTER);
		
		moonImageLabel.setText("Moon");
		moonImageLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/22));
		moonImageLabel.setForeground(Color.WHITE);
		moonImageLabel.setHorizontalAlignment(JLabel.CENTER);
		
		add(dateLabel);
		add(moonImageLabel);
	}
}
