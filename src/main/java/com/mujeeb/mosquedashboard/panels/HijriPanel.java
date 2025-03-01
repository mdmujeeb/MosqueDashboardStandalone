package com.mujeeb.mosquedashboard.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.mujeeb.mosquedashboard.main.Main;
import com.mujeeb.mosquedashboard.util.Constants;
import com.mujeeb.mosquedashboard.util.IslamicUtil;
import com.mujeeb.mosquedashboard.util.JPanelWithBackgroundImage;

public class HijriPanel extends JPanelWithBackgroundImage {

	private static final long serialVersionUID = 1L;
	
	protected JLabel dateLabel = new JLabel();
	protected JLabel moonImageLabel = new JLabel();
	
	protected static Image backgroundImage = new ImageIcon("resources/sky.jpg").getImage();
	
	public HijriPanel() {
		super(backgroundImage);
		setOpaque(false);
		setPreferredSize(new Dimension((int)(Main.windowWidth/3), (int)(Main.windowHeight/3)));
		
		dateLabel.setText("00 Unknown 0000");
		dateLabel.setFont(new Font("Calibri", Font.PLAIN, Main.windowWidth/27));
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setHorizontalAlignment(JLabel.CENTER);
		dateLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		moonImageLabel.setIcon(new ImageIcon("resources/moonphases/16.png"));
		moonImageLabel.setHorizontalAlignment(JLabel.CENTER);
		moonImageLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, Main.windowWidth/80, 0));
		
		setLayout(new BorderLayout());
		add(dateLabel, BorderLayout.NORTH);
		add(moonImageLabel, BorderLayout.CENTER);
	}
	
	public void refreshData() {
		
		dateLabel.setText(IslamicUtil.getHijriDateString());
		String hijriDate = IslamicUtil.getHijriDate((Integer) Main.getData().get(Constants.KEY_HIJRI_ADJUSTMENT)).getDate();
		moonImageLabel.setIcon(new ImageIcon("resources/moonphases/" + hijriDate + ".png"));
	}
}
