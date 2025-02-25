package com.mujeeb.mosquedashboard.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mujeeb.mosquedashboard.main.Main;

public class NamazTimePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected JLabel englishNameLabel = new JLabel();
	protected JLabel arabicNameLabel = new JLabel();
	protected JLabel timeLabel = new JLabel();
	
	protected String englishName;
	protected String arabicName;
	protected String time; 

	public NamazTimePanel(String englishName, String arabicName, String time) {
		
		this.englishName = englishName;
		this.arabicName = arabicName;
		this.time = time;
		
		setBackground(Color.BLACK);
		setBorder(BorderFactory.createLineBorder(Color.red));
		setPreferredSize(new Dimension((int)(Main.windowWidth/4), (int)(Main.windowHeight/3)));
		
		englishNameLabel.setText(englishName);
		englishNameLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/22));
		englishNameLabel.setForeground(Color.GRAY);
		englishNameLabel.setHorizontalAlignment(JLabel.CENTER);
		englishNameLabel.setOpaque(false);
		
		arabicNameLabel.setText(arabicName);
		arabicNameLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/22));
		arabicNameLabel.setForeground(Color.GRAY);
		arabicNameLabel.setHorizontalAlignment(JLabel.CENTER);
		arabicNameLabel.setOpaque(false);
		
		timeLabel.setText(time);
		timeLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/9));
		timeLabel.setForeground(Color.GREEN);
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setOpaque(false);
		
		JPanel namesPanel = new JPanel();
		namesPanel.setBackground(Color.BLACK);
		namesPanel.setLayout(new GridLayout(1, 2));
		namesPanel.add(englishNameLabel);
		namesPanel.add(arabicNameLabel);
		add(namesPanel);
		
		setLayout(new GridLayout(2, 1));
		add(namesPanel);
		add(timeLabel);
	}
}
