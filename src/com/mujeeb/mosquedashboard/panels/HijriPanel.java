package com.mujeeb.mosquedashboard.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.Date;

import javax.swing.BorderFactory;
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
		
		dateLabel.setText("8 Jumada II 1443");
		dateLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/27));
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setHorizontalAlignment(JLabel.CENTER);
		dateLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		moonImageLabel.setIcon(new ImageIcon("res/moonphases/16.png"));
		moonImageLabel.setHorizontalAlignment(JLabel.CENTER);
		moonImageLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, Main.windowWidth/80, 0));
		
		setLayout(new BorderLayout());
		add(dateLabel, BorderLayout.NORTH);
		add(moonImageLabel, BorderLayout.CENTER);
	}
}
