package com.mujeeb.mosquedashboard.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import com.mujeeb.mosquedashboard.main.Main;
import com.mujeeb.mosquedashboard.util.DateTimeUtil;
import com.mujeeb.mosquedashboard.util.JPanelWithRoundedBorder;

public class TimePanel extends JPanelWithRoundedBorder {

	private static final long serialVersionUID = 1L;
	
	protected Date currentTime = new Date();
	protected JLabel timeLabel = new JLabel();
	protected JLabel secondsLabel = new JLabel();

	public TimePanel() {
		
		setOpaque(false);
//		setBorder(BorderFactory.createLineBorder(Color.red));
		setPreferredSize(new Dimension((int)(Main.windowWidth/3), (int)(Main.windowHeight/3)));
		
		timeLabel.setText(DateTimeUtil.formatDate("hh:MM", currentTime));
		timeLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/9));
		timeLabel.setForeground(Color.RED);
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setBorder(BorderFactory.createEmptyBorder(Main.windowHeight/15, 0, 0, 0));
		
		secondsLabel.setText("59");
		secondsLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/15));
		secondsLabel.setForeground(Color.RED);
		secondsLabel.setHorizontalAlignment(JLabel.CENTER);
		
		setLayout(new BorderLayout());
		add(timeLabel, BorderLayout.CENTER);
		add(secondsLabel, BorderLayout.SOUTH);
	}
}
