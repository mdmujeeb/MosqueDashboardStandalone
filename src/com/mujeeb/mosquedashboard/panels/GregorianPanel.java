package com.mujeeb.mosquedashboard.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mujeeb.mosquedashboard.main.Main;
import com.mujeeb.mosquedashboard.util.JPanelWithBackgroundImage;

public class GregorianPanel extends JPanelWithBackgroundImage {

	private static final long serialVersionUID = 1L;
	
	protected Date currentTime = new Date();
	protected JLabel dateLabel = new JLabel();
	protected JLabel dayLabel = new JLabel();
	protected JLabel seheriNameLabel = new JLabel();
	protected JLabel seheriTimeLabel = new JLabel();
	protected JLabel iftarNameLabel = new JLabel();
	protected JLabel iftarTimeLabel = new JLabel();
	protected JLabel ishraqNameLabel = new JLabel();
	protected JLabel ishraqTimeLabel = new JLabel();
	protected JLabel duhaNameLabel = new JLabel();
	protected JLabel duhaTimeLabel = new JLabel();
	
	protected static Image backgroundImage = new ImageIcon("res/sky.jpg").getImage();

	public GregorianPanel() {
		
		super(backgroundImage);
		
		dateLabel.setText("26 February 2025");
		dateLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/22));
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setHorizontalAlignment(JLabel.CENTER);
		
		dayLabel.setText("Wednesday");
		dayLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/25));
		dayLabel.setForeground(Color.YELLOW);
		dayLabel.setHorizontalAlignment(JLabel.CENTER);
		
		int fontSize = 32;
		String arabicFontName = "KFGQPC Uthmanic Script HAFS";
		seheriNameLabel.setText("سحور");
		seheriNameLabel.setFont(new Font(arabicFontName, Font.PLAIN, Main.windowWidth/fontSize));
		seheriNameLabel.setForeground(Color.CYAN);
		seheriNameLabel.setHorizontalAlignment(JLabel.CENTER);
		seheriNameLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, Main.windowHeight/50, 0));
		
		seheriTimeLabel.setText("5:16");
		seheriTimeLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/fontSize));
		seheriTimeLabel.setForeground(Color.CYAN);
		seheriTimeLabel.setHorizontalAlignment(JLabel.CENTER);
		
		iftarNameLabel.setText("افطار");
		iftarNameLabel.setFont(new Font(arabicFontName, Font.PLAIN, Main.windowWidth/fontSize));
		iftarNameLabel.setForeground(Color.CYAN);
		iftarNameLabel.setHorizontalAlignment(JLabel.CENTER);
		iftarNameLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, Main.windowHeight/50, 0));
		
		iftarTimeLabel.setText("5:54");
		iftarTimeLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/fontSize));
		iftarTimeLabel.setForeground(Color.CYAN);
		iftarTimeLabel.setHorizontalAlignment(JLabel.CENTER);
		
		ishraqNameLabel.setText("اشراق");
		ishraqNameLabel.setFont(new Font(arabicFontName, Font.PLAIN, Main.windowWidth/fontSize));
		ishraqNameLabel.setForeground(Color.CYAN);
		ishraqNameLabel.setHorizontalAlignment(JLabel.CENTER);
		ishraqNameLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, Main.windowHeight/50, 0));
		
		ishraqTimeLabel.setText("6:51");
		ishraqTimeLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/fontSize));
		ishraqTimeLabel.setForeground(Color.CYAN);
		ishraqTimeLabel.setHorizontalAlignment(JLabel.CENTER);
		
		duhaNameLabel.setText("الضحى");
		duhaNameLabel.setFont(new Font(arabicFontName, Font.PLAIN, Main.windowWidth/fontSize));
		duhaNameLabel.setForeground(Color.CYAN);
		duhaNameLabel.setHorizontalAlignment(JLabel.CENTER);
		duhaNameLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, Main.windowHeight/50, 0));
		
		duhaTimeLabel.setText("9:30");
		duhaTimeLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/fontSize));
		duhaTimeLabel.setForeground(Color.CYAN);
		duhaTimeLabel.setHorizontalAlignment(JLabel.CENTER);
//		duhaTimeLabel.setBorder(BorderFactory.createEmptyBorder(Main.windowHeight/80, 0, 0, 0));
		
		setOpaque(false);
		setPreferredSize(new Dimension((int)(Main.windowWidth/3), (int)(Main.windowHeight/3)));
		
		setLayout(new GridLayout(3, 1));
		
		add(dateLabel);
		add(dayLabel);
		
		JPanel timesPanel = new JPanel();
		timesPanel.setOpaque(false);
		timesPanel.setLayout(new GridLayout(2, 4));
		
		timesPanel.add(ishraqTimeLabel);
		timesPanel.add(ishraqNameLabel);
		timesPanel.add(seheriTimeLabel);
		timesPanel.add(seheriNameLabel);
		timesPanel.add(duhaTimeLabel);
		timesPanel.add(duhaNameLabel);
		timesPanel.add(iftarTimeLabel);
		timesPanel.add(iftarNameLabel);
		
		add(timesPanel);
	}
}
