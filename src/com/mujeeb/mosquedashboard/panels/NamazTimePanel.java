package com.mujeeb.mosquedashboard.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mujeeb.mosquedashboard.main.Main;
import com.mujeeb.mosquedashboard.util.JPanelWithRoundedBorder;

public class NamazTimePanel extends JPanelWithRoundedBorder {

	private static final long serialVersionUID = 1L;
	
	protected JLabel englishNameLabel = new JLabel();
	protected JLabel arabicNameLabel = new JLabel();
	protected JLabel timeLabel = new JLabel();
	
	protected String englishName;
	protected String arabicName;
	protected String time;
	
	protected boolean isMaghrib = false;

	public NamazTimePanel(boolean isMaghrib, String englishName, String arabicName, String time) {
		
		this.isMaghrib = isMaghrib;
		this.englishName = englishName;
		this.arabicName = arabicName;
		this.time = time;
		
		setOpaque(false);
		setPreferredSize(new Dimension((int)(Main.windowWidth/4), (int)(Main.windowHeight/3.2)));
		
		englishNameLabel.setText(englishName);
		englishNameLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/22));
		englishNameLabel.setForeground(Color.WHITE);
		englishNameLabel.setHorizontalAlignment(JLabel.LEFT);
		englishNameLabel.setBorder(BorderFactory.createEmptyBorder(0, isMaghrib ? Main.windowHeight/78 : Main.windowHeight/15, 0, 0));
		englishNameLabel.setOpaque(false);
		
		arabicNameLabel.setText(arabicName);
		arabicNameLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/22));
		arabicNameLabel.setForeground(Color.WHITE);
		arabicNameLabel.setHorizontalAlignment(JLabel.RIGHT);
		arabicNameLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, isMaghrib ? Main.windowHeight/78 : Main.windowHeight/15));
		arabicNameLabel.setOpaque(false);
		
		timeLabel.setText(time);
		timeLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/9));
		timeLabel.setForeground(Color.GREEN);
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setOpaque(false);
		timeLabel.setBorder(BorderFactory.createEmptyBorder(Main.windowHeight/30, 0, 0, 0));
		
		JPanel namesPanel = new JPanel();
		namesPanel.setBorder(BorderFactory.createEmptyBorder(Main.windowHeight/30, 0, 0, 0));
		namesPanel.setOpaque(false);
		namesPanel.setLayout(new GridLayout(1, 2));
		namesPanel.add(englishNameLabel);
		namesPanel.add(arabicNameLabel);
		add(namesPanel);
		
		setLayout(new BorderLayout());
		add(namesPanel, BorderLayout.NORTH);
		add(timeLabel, BorderLayout.CENTER);
	}
}
