package com.mujeeb.mosquedashboard.panels;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import com.mujeeb.mosquedashboard.main.Main;
import com.mujeeb.mosquedashboard.util.JPanelWithRoundedBorder;

public class AdvertisementPanel extends JPanelWithRoundedBorder {

	private static final long serialVersionUID = 1L;
	
	protected JLabel phoneLabel = new JLabel();
	protected JLabel nameLabel = new JLabel();
	protected JLabel emailLabel = new JLabel();

	public AdvertisementPanel() {
		
		setOpaque(false);
		setPreferredSize(new Dimension((int)(Main.windowWidth), (int)(Main.windowHeight/24)));
		
		Color textColor = Color.WHITE;
		
		phoneLabel.setText("9880506766");
		phoneLabel.setFont(Main.getFontUtil().getCalibriFont().deriveFont(Font.BOLD, Main.windowWidth/60));
		phoneLabel.setForeground(textColor);
		phoneLabel.setHorizontalAlignment(JLabel.CENTER);
		phoneLabel.setBorder(BorderFactory.createEmptyBorder(Main.windowHeight/80, 0, 0, 0));
		
		nameLabel.setText("Mujeeb Mohammad");
		nameLabel.setFont(Main.getFontUtil().getCalibriFont().deriveFont(Font.BOLD, Main.windowWidth/60));
		nameLabel.setForeground(textColor);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setBorder(BorderFactory.createEmptyBorder(Main.windowHeight/80, 0, 0, 0));
		
		emailLabel.setText("mohammad.mujeeb@gmail.com");
		emailLabel.setFont(Main.getFontUtil().getCalibriFont().deriveFont(Font.BOLD, Main.windowWidth/60));
		emailLabel.setForeground(textColor);
		emailLabel.setHorizontalAlignment(JLabel.CENTER);
		emailLabel.setBorder(BorderFactory.createEmptyBorder(Main.windowHeight/80, 0, 0, 0));
		
		setLayout(new GridLayout(1,3));
		add(phoneLabel);
		add(nameLabel);
		add(emailLabel);
	}
}
